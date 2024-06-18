# app.py
import logging

from flask import Flask, request, jsonify
from catboost import CatBoostRegressor
import pandas as pd

# 로깅 설정
logging.basicConfig(level=logging.DEBUG,
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

app = Flask(__name__)

@app.route('/')
def home():
    return "welcome to flask api"

# 지역 추천
@app.route('/predict', methods=['POST'])
def predict_api():
    # JSON 요청 파싱
    data = request.json

    if data is None:
        return jsonify({'error': 'Invalid request. JSON payload is missing.'}), 400

    columns = ['GENDER', 'AGE_GRP', 'TRAVEL_STYL_1', 'TRAVEL_STYL_2', 'TRAVEL_STYL_3',
           'TRAVEL_STYL_4', 'TRAVEL_STYL_5', 'TRAVEL_STYL_6', 'TRAVEL_STYL_7',
           'TRAVEL_STYL_8', 'TRAVEL_MOTIVE_1', 'TRAVEL_COMPANIONS_NUM',
           'TRAVEL_MISSION_INT']

    predicts = pd.DataFrame([], columns=['region', 'score'])

    # 예측
    for region in regions['SIDO_NM']:
        if region == 'NaN':
            continue

        input = list(data.values())
        input.append(region)

        try:
            score = region_model.predict(input)
            predicts = pd.concat([predicts, pd.DataFrame([[region, score]], columns=['region', 'score'])])
        except Exception as e:
            logging.debug(f"Error predicting for {region}: {e}")

    # 상위 10개 결과만 선택
    top_10_results = predicts.sort_values('score', ascending=False)[:10]

    # JSON 응답 반환
    return jsonify(top_10_results.to_dict(orient='records'))


# 관광지 추천
@app.route('/predict/<region_nm>', methods=['POST'])
def predict_places_api(region_nm):
    # Json 요청 파싱
    data = request.json
    if data is None:
        return jsonify({'error': 'Invalid request. JSON payload is missing.'}), 400

    columns = ['GENDER', 'AGE_GRP', 'TRAVEL_STYL_1', 'TRAVEL_STYL_2', 'TRAVEL_STYL_3',
           'TRAVEL_STYL_4', 'TRAVEL_STYL_5', 'TRAVEL_STYL_6', 'TRAVEL_STYL_7',
           'TRAVEL_STYL_8', 'TRAVEL_MOTIVE_1', 'TRAVEL_COMPANIONS_NUM',
           'TRAVEL_MISSION_INT']

    predicts = pd.DataFrame([], columns=['place', 'score'])
    filtered_places = places[places['SIDO_NM'] == region_nm].drop_duplicates(subset=['VISIT_AREA_NM'])

    if region_nm not in regions['SIDO_NM'].values:
        return jsonify({'error': 'Invalid request. Region does not exist.'}), 400

    # 예측

    for idx, place in filtered_places.iterrows():
        if place['VISIT_AREA_NM'] == 'NaN':
            continue

        input = list(data.values())
        input.append(place['VISIT_AREA_TYPE_CD'])
        input.append(place['VISIT_AREA_NM'])
        input.append(region_nm)

        try:
            score = place_model.predict(input)
            predicts = pd.concat([predicts, pd.DataFrame([[place['VISIT_AREA_NM'], score]], columns=['place', 'score'])])
        except Exception as e:
            logging.debug(f"Error predicting for {place['VISIT_AREA_NM']} with type_cd {place['VISIT_AREA_TYPE_CD']}: {e}")

    # 상위 10개 결과만 선택
    top_10_results = predicts.sort_values('score', ascending=False)[:10]

    # JSON 응답 반환
    return jsonify(top_10_results.to_dict(orient='records'))

if __name__ == '__main__':

    # 모델 불러오기
    print(("* Loading Keras model and Flask starting server..."
        "please wait until server has fully started"))
    region_model = CatBoostRegressor()
    region_model.load_model('region_recommendation.cbm')
    place_model = CatBoostRegressor()
    place_model.load_model('place_recommendation.cbm')

    # CSV 파일 불러오기
    csv_data = pd.read_csv('places.csv', encoding='utf-8')
    regions = csv_data.dropna(subset=['SIDO_NM']).drop_duplicates(subset=['SIDO_NM'])
    places = csv_data.dropna(subset=['SIDO_NM', 'VISIT_AREA_TYPE_CD', 'VISIT_AREA_NM']).drop_duplicates()
    valid_types = [1, 2, 3, 6, 7, 13]
    places = places[places['VISIT_AREA_TYPE_CD'].isin(valid_types)]

    app.run('0.0.0.0', port=5000, debug=True)
