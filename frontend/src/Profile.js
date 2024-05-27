import React from 'react';
import { Navigate } from 'react-router-dom';
import './Profile.css';
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import 'react-tabs/style/react-tabs.css';
import ReviewTab from './ReviewTab';
import BoardTab from './BoardTab';

function Profile({ isLoggedIn }) {

  if (!isLoggedIn) {
    return <Navigate to="/" />;
  }

  // 예제 사용자 데이터
  const user = {
    name: '홍길동',
    avatar: 'img/profile.jpg', // 프로필 사진 URL
    background: 'img/background.png', // 배경 사진 URL
  };

  return (
    <section id="profile" className="profile-container">
      <div className="profile-card">
        <img src={user.background} alt="Background" className="profile-background" />
        <div className="profile-info">          
          <img src={user.avatar} alt="Profile" className="profile-avatar" />        
          <h3>{user.name}</h3>                   
        </div>
      </div>
      <div>
        <Tabs>
            <TabList>
                <Tab>게시판</Tab>
                <Tab>후기</Tab>
            </TabList>

            <TabPanel>
                <BoardTab className="boardtab"/>
            </TabPanel>
            <TabPanel>                
                <ReviewTab className="reviewtab"/>
            </TabPanel>
        </Tabs>
      </div>
      
    </section>
  );
}

export default Profile;