import React from 'react';
import styled from 'styled-components';

function Board() {
  const BoardPage = styled.div`
    margin-bottom: 70px;
  `;

  const BoardTab = styled.ul`
    display: flex;
    flex-wrap: wrap; 
    padding: 0;
    margin: 0;
    list-style: none;
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

  const post = {
    "id" : 1,
    "title" : "게시글 1번",
    "writer" : "작성자1",
    "updatedAt" : "2024-04-23T20:01:03.586461138",
    "thumbnail" : 'img/background.png',
  };

  return (
    <section id="board">
      <BoardPage>
        <BoardTab>
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
          <Content>
            <Text>
              <Title>{post.title}</Title>
              <Writer>{post.writer}</Writer>
              <UpdatedAt>{post.updatedAt}</UpdatedAt>
            </Text>                             
            <Thumbnail src={post.thumbnail} alt="Thumbnail"/>
          </Content>
        </BoardTab>
      </BoardPage>      
    </section>
  );
}

export default Board;