import React from 'react';
import styled from 'styled-components';
import Card from 'react-bootstrap/Card';
import 'bootstrap/dist/css/bootstrap.min.css';

function Main() {
  const MainPage = styled.div`
    display: flex;
    flex-direction: column;
  `;

  const TopSection = styled.div`
    flex: 1;
    display: inline-flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    margin: 10px;
  `;

  const BottomContainer = styled.div`
    display: flex;
    flex: 1;
  `;

  const LeftSection = styled.div`
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 10px 10px 60px 10px;
  `;

  const RightSection = styled.div`
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 10px 10px 60px 10px;
  `;

  const Content = styled.li`
    background-color: #fff;
    border: 1px solid #ddd;
    padding: 10px;
    display: flex;
    align-items: center;
    width: 100%;
    box-sizing: border-box;
    margin: 10px;
    border-radius: 20px; 
  `;

  const Text = styled.div`
    flex-grow: 1;
    display: flex;
    flex-direction: column;
  `;

  const Title = styled.p`
    font-size: 18px;
    margin-bottom: 10px;
  `;

  const Writer = styled.p`
    font-size: 14px;
    color: #666;
    margin-bottom: 5px;
  `;

  const UpdatedAt = styled.p`
    font-size: 14px;
    color: #888;
  `;

  const Thumbnail = styled.img`
    width: 130px;
    height: 100%;
    object-fit: cover;
    margin-left: 20px;
    border-radius: 10px;
  `;

  const review = {
    "id" : 1,
    "title" : "게시글 1번",
    "writer" : "작성자1",
    "updatedAt" : "2024-04-23 20:01",
    "thumbnail" : 'img/background.png',
  };

  const post = {
    "id" : 1,
    "title" : "게시글 1번",
    "writer" : "작성자1",
    "updatedAt" : "2024-04-23 20:01",
    "thumbnail" : 'img/background.png',
  };
  
  return (
    <section id="main">
      <MainPage>
        <TopSection>
          <Card style={{ width: '18rem', margin: '10px'}}>
            <Card.Img variant="top" src="img/background.png" />
            <Card.Body>
              <Card.Title>{review.title}</Card.Title>
              <Card.Text>{review.writer}</Card.Text>
              <Card.Text>{review.updatedAt}</Card.Text>                
            </Card.Body>
          </Card>
          <Card style={{ width: '18rem', margin: '10px'}}>
            <Card.Img variant="top" src="img/background.png" />
            <Card.Body>
              <Card.Title>{review.title}</Card.Title>
              <Card.Text>{review.writer}</Card.Text>
              <Card.Text>{review.updatedAt}</Card.Text>                
            </Card.Body>
          </Card>
          <Card style={{ width: '18rem', margin: '10px'}}>
            <Card.Img variant="top" src="img/background.png" />
            <Card.Body>
              <Card.Title>{review.title}</Card.Title>
              <Card.Text>{review.writer}</Card.Text>
              <Card.Text>{review.updatedAt}</Card.Text>                
            </Card.Body>
          </Card>
          <Card style={{ width: '18rem', margin: '10px'}}>
            <Card.Img variant="top" src="img/background.png" />
            <Card.Body>
              <Card.Title>{review.title}</Card.Title>
              <Card.Text>{review.writer}</Card.Text>
              <Card.Text>{review.updatedAt}</Card.Text>                
            </Card.Body>
          </Card>
        </TopSection>
        <BottomContainer>
          <LeftSection>
            <Content>
              <Text>
                <Title>{post.title}</Title>
                <Writer>{post.writer}</Writer>
                <UpdatedAt>{post.updatedAt}</UpdatedAt>
              </Text>                             
              <Thumbnail src={post.thumbnail} alt="Thumbnail"/>
            </Content>
            <Content>
              <Text>
                <Title>{post.title}</Title>
                <Writer>{post.writer}</Writer>
                <UpdatedAt>{post.updatedAt}</UpdatedAt>
              </Text>                             
              <Thumbnail src={post.thumbnail} alt="Thumbnail"/>
            </Content>
            <Content>
              <Text>
                <Title>{post.title}</Title>
                <Writer>{post.writer}</Writer>
                <UpdatedAt>{post.updatedAt}</UpdatedAt>
              </Text>                             
              <Thumbnail src={post.thumbnail} alt="Thumbnail"/>
            </Content>
          </LeftSection>
          <RightSection>
            <Content>
              <Text>
                <Title>{post.title}</Title>
                <Writer>{post.writer}</Writer>
                <UpdatedAt>{post.updatedAt}</UpdatedAt>
              </Text>                             
              <Thumbnail src={post.thumbnail} alt="Thumbnail"/>
            </Content>
            <Content>
              <Text>
                <Title>{post.title}</Title>
                <Writer>{post.writer}</Writer>
                <UpdatedAt>{post.updatedAt}</UpdatedAt>
              </Text>                             
              <Thumbnail src={post.thumbnail} alt="Thumbnail"/>
            </Content>
            <Content>
              <Text>
                <Title>{post.title}</Title>
                <Writer>{post.writer}</Writer>
                <UpdatedAt>{post.updatedAt}</UpdatedAt>
              </Text>                             
              <Thumbnail src={post.thumbnail} alt="Thumbnail"/>
            </Content>
          </RightSection>
        </BottomContainer>
      </MainPage>      
    </section>
  );
}

export default Main;