import React from 'react';
import { useNavigate } from 'react-router-dom';
import Dropdown from 'react-bootstrap/Dropdown';
import 'bootstrap/dist/css/bootstrap.min.css';
import styled from 'styled-components';

function ProfileContextMenu({ position, onClose, isLoggedIn, handleLogin }) {
  const navigate = useNavigate();

  const ContextMenu = styled.div`
    top: ${position.y};
    left: ${position.x};
    width: auto;
    white-space: nowrap;
    position: absolute;
    background-color: white;
    border: 1px solid black;
    z-index: 1000;
  `;

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
    navigate("/main");
  };

  return (
    <ContextMenu>
      <Dropdown.Menu show>
        <Dropdown.Item eventKey="1" onClick={handleClickToProfile}>마이페이지</Dropdown.Item>
        <Dropdown.Item eventKey="2" onClick={handleClickToSetting}>설정</Dropdown.Item>
        {isLoggedIn && (<Dropdown.Item eventKey="3" onClick={handleLogout}>로그아웃</Dropdown.Item>)}
      </Dropdown.Menu>
    </ContextMenu>
  );
};

export default ProfileContextMenu;