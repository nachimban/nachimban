import React from 'react';
import Card from 'react-bootstrap/Card';
import 'bootstrap/dist/css/bootstrap.min.css';
import styled from 'styled-components';

function TestResult({ isLoggedIn }) {
    const Recommendation = [
        { Region: "인천광역시", Score: 4.44 },
        { Region: "수원시", Score: 4.40 },
        { Region: "고양시", Score: 4.39 },
        { Region: "양평군", Score: 4.35 },
        { Region: "서울특별시", Score: 4.45 },
        { Region: "포천시", Score: 4.37 },
        { Region: "가평군", Score: 4.39 },
        { Region: "성남시", Score: 4.40 },
        { Region: "용인시", Score: 4.41 },
        { Region: "부천시", Score: 4.40 }
    ];

    const ResultContainer = styled.ul`
        list-style: none;
        display: inline-flex;
        flex-wrap: wrap;
    `;

    const Result = styled.li`
        list-style: none;
        margin: 10px;
    `;
  
    return (
        <section id="testresult" style={{marginBottom: '60px'}}>
            <h1 style={{margin: '20px'}}>테스트 결과</h1>
            <ResultContainer>
                {Recommendation.map((item, index) => (
                    <Result key={index}>
                        <Card style={{ width: '12rem', margin: '10px'}}>
                            <Card.Img variant="top" src="img/background.png" />
                            <Card.Body>
                                <Card.Title>{item.Region}</Card.Title>
                                <Card.Text>{item.Score}</Card.Text>              
                            </Card.Body>
                        </Card>
                    </Result>
                ))}
            </ResultContainer>
        </section>
    );
}

export default TestResult;