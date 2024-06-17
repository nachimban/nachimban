import React from 'react';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import 'bootstrap/dist/css/bootstrap.min.css';
import styled from 'styled-components';
import BoardTab from './BoardTab';
import ReviewTab from './ReviewTab';

function Profile({ isLoggedIn }) {
  const ProfileContainer = styled.div`
    position: relative;
  `;

  const ProfileBackground = styled.img`
    width: 100%;
    height: 300px;
    background-size: cover;
    background-position: center;
    border-radius: 5px;
  `;

  const ProfileAvatar = styled.img`
    width: 150px;
    height: 150px;
    border-radius: 50%;
    border: 2px solid white;
    position: absolute;
    bottom: -30%;
    left: 2%;
    z-index: 1;
  `;

  const Nickname = styled.h3`
    font-size: 24px;
    color: #333;
    position: absolute;
    bottom: -50%; 
    left: 8%; 
    transform: translateX(-50%); 
  `;

  const TabContainer = styled.div`
    margin: 2%;
    position: relative;
    top: 150px;
  `;

  const user = {
    "id" : 1,
    "nickName" : "member",
    "email" : "member@naver.com",
    "imageUrl" : "img/profile.jpg",
    "backgroundImage" : 'img/background.png'
  };

  return (
    <section id="profile">
      <ProfileContainer>
        <ProfileBackground src={user.backgroundImage} alt="Background"/>         
        <ProfileAvatar src={user.imageUrl} alt="Profile"/>        
        <Nickname>{user.nickName}</Nickname>                
      </ProfileContainer>
      <TabContainer>
        <Tabs defaultActiveKey="profile" id="uncontrolled-tab-example" className="mb-3">      
          <Tab eventKey="board" title="Board">
            <BoardTab/>
          </Tab>
          <Tab eventKey="review" title="Review">
            <ReviewTab/>
          </Tab>
        </Tabs>
      </TabContainer>
    </section>
  );
}

export default Profile;