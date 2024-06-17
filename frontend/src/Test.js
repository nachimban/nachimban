import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import ToggleButton from 'react-bootstrap/ToggleButton';
import 'bootstrap/dist/css/bootstrap.min.css';
import styled from 'styled-components';

function Test({ isLoggedIn }) {
    const navigate = useNavigate();

    const [selectedAnswers, setSelectedAnswers] = useState(Array(8).fill(null));
    const [pageIndex, setPageIndex] = useState(0);
    const [radioValue, setRadioValue] = useState('1');

    const Title = styled.h1`
        text-align: center;
        margin: 50px;
    `;

    const QuestionContainer = styled.div`    
        height: 130px;
    `;

    const ButtonContainer = styled.div`
        display: flex;
        align-items: center;
        justify-content: center;
        flex-wrap: wrap;
        gap: 10px;
    `;

    const Selection = styled.span`
        font-size: 16px;
        margin: 0 10px;
    `;

    const NavigationButton = styled.div`
        display: flex;
        justify-content: space-between;
        margin: 20px;
    `;

    const CircleButton = styled.button`
        border: 2px solid;
        border-radius: 50%;
        cursor: pointer;
        transition: background-color 0.3s;
        background-color: ${props => props.selected ? (props.green ? '#3BB273' : '#4D9DE0') : 'white'};
        border-color: ${props => props.green ? '#3BB273' : '#4D9DE0'};

        width: ${props => props.size}px;
        height: ${props => props.size}px;

        &:hover {
            background-color: ${props => props.green ? '#57C78B' : '#74B3E7'};;
        }
    `;

    const handleClick = (questionIndex, value) => {
        const newSelectedAnswers = [...selectedAnswers];
        newSelectedAnswers[questionIndex] = value;
        setSelectedAnswers(newSelectedAnswers);
    };

    const handleNext = () => {
        if (pageIndex < 2) {
        setPageIndex(pageIndex + 1);
        } else {
            handleClickToResult();
        }
    };

    const handlePrev = () => {
        if (pageIndex > 0) {
        setPageIndex(pageIndex - 1);
        }
    };

    function handleClickToResult() {
        navigate("/testresult");
    }

    const Preference = [
        { left: "자연", right: "도시" },
        { left: "숙박", right: "당일" },
        { left: "새로운 지역", right: "익숙한 지역" },
        { left: "편하지만 비싼 숙소", right: "불편하지만 저렴한 숙소" },
        { left: "휴양/휴식", right: "체험활동" },
        { left: "잘 알려지지 않은 방문지", right: "알려진 방문지" },
        { left: "계획에 따른 여행", right: "상황에 따른 여행" },
        { left: "사진촬영 중요하지 않음", right: "사진촬영 중요" }
    ];

    const TravelMotivation = [
        { name: '일상적인 환경에서의 탈출', value: '0' },
        { name: '육체적, 정신적 휴식', value: '1' },
        { name: '여행 동반자와의 친밀감 증진', value: '2' },
        { name: '자아 찾기', value: '3' }
      ];
    
    const sizes = {
        1: 60,
        2: 50,
        3: 40,
        4: 30,
        5: 20,
        6: 20,
        7: 30,
        8: 40,
        9: 50,
        10: 60,
    };

    if (pageIndex === 0) {
        return (
            <section id="test">
                <div>
                    <Title>어떤 여행을 더 선호하나요?</Title>
                    {Preference.slice(0, 4).map((question, questionIndex) => (
                        <QuestionContainer key={questionIndex}>
                            <ButtonContainer>
                                <Selection>{question.left}</Selection>
                                {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10].map((value) => (
                                    <CircleButton
                                        key={value}
                                        size={sizes[value]}
                                        green={value <= 5}
                                        selected={selectedAnswers[0 + questionIndex] === value}
                                        onClick={() => handleClick(0 + questionIndex, value)}
                                    />
                                ))}
                                <Selection>{question.right}</Selection>
                            </ButtonContainer>
                        </QuestionContainer>
                    ))}
                </div>
                <NavigationButton>
                    <Button onClick={handlePrev} as="input" type="button" value="<이전" disabled/>
                    <span>1/3</span>
                    <Button onClick={handleNext} as="input" type="button" value="다음>" />
                </NavigationButton>
            </section>
        );
    } else if (pageIndex === 1) {
        return (
            <section id="test">
                <div>
                    <Title>어떤 여행을 더 선호하나요?</Title>
                    {Preference.slice(4, 8).map((question, questionIndex) => (
                        <QuestionContainer key={questionIndex}>
                            <ButtonContainer>
                                <Selection>{question.left}</Selection>
                                {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10].map((value) => (
                                    <CircleButton
                                        key={value}
                                        size={sizes[value]}
                                        green={value <= 5}
                                        selected={selectedAnswers[4 + questionIndex] === value}
                                        onClick={() => handleClick(4 + questionIndex, value)}
                                    />
                                ))}
                                <Selection>{question.right}</Selection>
                            </ButtonContainer>
                        </QuestionContainer>
                    ))}
                </div>
                <NavigationButton>
                    <Button onClick={handlePrev} as="input" type="button" value="<이전" />
                    <span>2/3</span>
                    <Button onClick={handleNext} as="input" type="button" value="다음>" />
                </NavigationButton>
            </section>
        );
    } else if (pageIndex === 2) {
        return (
            <section id="test">
                <div>
                    <Title>여행 동기는 이 중 무엇인가요?</Title>
                    <ButtonGroup size='lg' vertical style={{marginBottom: '160px'}}>
                        {TravelMotivation.map((radio, idx) => (
                        <ToggleButton
                            key={idx}
                            id={`radio-${idx}`}
                            type="radio"
                            name="radio"
                            value={radio.value}
                            checked={radioValue === radio.value}
                            onChange={(e) => setRadioValue(e.currentTarget.value)}
                            style={{margin: '20px', borderRadius: '10px', height: '50px'}}
                        >
                            {radio.name}
                        </ToggleButton>
                        ))}
                    </ButtonGroup>
                </div>
                <NavigationButton>
                    <Button onClick={handlePrev} as="input" type="button" value="<이전" />
                    <span>3/3</span>
                    <Button onClick={handleNext} as="input" type="button" value="결과보기" />
                </NavigationButton>
            </section>
        );
    } 
}

export default Test;