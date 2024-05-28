# app.py
from flask import Flask, request, jsonify
from catboost import CatBoostRegressor
import pandas as pd

model = CatBoostRegressor()
model.load_model('region_recommendation.cbm')

app = Flask(__name__)

@app.route('/')
def home():
    return "welcome to flask api"

### route 경로 확인 필요
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

    regions = pd.read_csv('regions.csv').dropna(subset=['SIDO_NM'])
    predicts = pd.DataFrame([], columns=['REGION', 'SCORE'])

    # 예측
    for region in regions['SIDO_NM']:
        if region == 'NaN':
            continue

        input = list(data.values())
        input.append(region)

        score = model.predict(input)

        predicts = pd.concat([predicts, pd.DataFrame([[region, score]], columns=['REGION', 'SCORE'])])

    # 상위 10개 결과만 선택
    top_10_results = predicts.head(10)

    # JSON 응답 반환
    return jsonify(top_10_results.to_dict(orient='records'))


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)
