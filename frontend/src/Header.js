import React, {useState} from 'react';
import { Link, useNavigate } from 'react-router-dom';
import NotificationModal from './NotificationModal.js'
import ProfileContextMenu from './ProfileContextMenu.js'

function Header({ isLoggedIn, handleLogin }) {
  const [isContextMenuVisible, setIsContextMenuVisible] = useState(false);
  const [contextMenuPosition, setContextMenuPosition] = useState({ x: 0, y: 0 });
  const [isNModalVisible, setIsNModalVisible] = useState(false);
  const [NModalPosition, setNModalPosition] = useState({ x: 0, y: 0 });

  const user = {
    avatar: 'img/profile.jpg',
    notification: 'img/notification.png'
  };

  const navigate = useNavigate();

  function handleClickToM() {
    navigate("/main");
  }

  function handleProfileClick(e) {
    const { clientX, clientY } = e;
    setContextMenuPosition({ x: clientX, y: clientY });
    setIsContextMenuVisible(true);
  }

  function handleCloseContextMenu() {
    setIsContextMenuVisible(false);
  }

  function handleNoficationClick(e) {
    const { clientX, clientY } = e;
    setNModalPosition({ x: clientX, y: clientY });
    setIsNModalVisible(true);
  }

  function handleCloseNModal() {
    setIsNModalVisible(false);
  }

  return (
    <header>
      <h1 className='siteName' onClick={handleClickToM}>나침반</h1>
      <nav>
        <ul>
          <li><Link to="/main">홈</Link></li>
          <li><Link to="/board">게시판</Link></li>
          <li><Link to="/review">후기</Link></li>
        </ul>
      </nav>
      <div>
        {isContextMenuVisible && (
          <>
            <ProfileContextMenu position={contextMenuPosition} onClose={handleCloseContextMenu} isLoggedIn={isLoggedIn} handleLogin={handleLogin}/>
            <div 
              style={{ position: 'fixed', top: 0, left: 0, width: '100%', height: '100%', zIndex: 999 }} 
              onClick={handleCloseContextMenu} 
            ></div>
          </>
        )}
        <NotificationModal isOpen={isNModalVisible} position={NModalPosition} closeModal={handleCloseNModal} />
      </div>      
      {isLoggedIn ? (
        <div style={{float: 'right'}}>
          <img src={user.notification} alt="Notification" className="header-profile-notification" onClick={handleNoficationClick}/>
          <img
            src={user.avatar} 
            alt="Profile" 
            className="header-profile-avatar" 
            onClick={handleProfileClick}
            style={{ cursor: 'pointer' }}
            /> 
        </div>      
      ) : (
        <button onClick={handleLogin} className='loginButton'>
          로그인
        </button>
      )}
      
    </header>
  );
}

export default Header;