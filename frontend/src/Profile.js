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

  const user = {
    name: '닉네임',
    avatar: 'img/profile.jpg',
    background: 'img/background.png',
  };

  return (
    <section className='profile-page'>
      <div className="profile-container">
        <img src={user.background} alt="Background" className="profile-background" />         
        <img src={user.avatar} alt="Profile" className="profile-avatar" />        
        <h3 className="username">{user.name}</h3>                
      </div>
      <div className="Tab">
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