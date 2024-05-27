import React from 'react';
import { useNavigate } from 'react-router-dom';

function ProfileContextMenu({ position, onClose, isLoggedIn, handleLogin }) {
  const navigate = useNavigate();

  function handleClickToProfile() {
    navigate("/profile");
    onClose();
  }

  function handleClickToSetting() {
    navigate("/setting");
    onClose();
  }

  function handleLogout() {
    handleLogin();
    onClose();
    navigate('/main');
  };

  return (
    <div className='ProfileContextMenu' style={{ top: position.y, left: position.x, transform: 'translate(-50%, 0)' }}>
      <ul>
        <li onClick={handleClickToProfile}>마이페이지</li>
        <li onClick={handleClickToSetting}>설정</li>
        {isLoggedIn && (<li onClick={handleLogout}>로그아웃</li>)}
      </ul>
    </div>
  );
};

export default ProfileContextMenu;