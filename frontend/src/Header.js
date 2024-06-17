import React, {useState} from 'react';
import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';
import styled from 'styled-components';
import NotificationModal from './NotificationModal.js'
import ProfileContextMenu from './ProfileContextMenu.js'

function Header({ isLoggedIn, handleLogin }) {
    const [contextMenuPosition, setContextMenuPosition] = useState({ x: 0, y: 0 });
    const [isContextMenuVisible, setIsContextMenuVisible] = useState(false);
    const [isNModalVisible, setIsNModalVisible] = useState(false);
    const [NModalPosition, setNModalPosition] = useState({ x: 0, y: 0 });

    const user = {
        avatar: 'img/profile.jpg',
        notification: 'img/notification.png'
    };

    const HeaderRight = styled.div`
        float: right;
    `;

    const Notification = styled.img`        
        width: 50px;
        height: 50px;
        margin: 10px;
    `;

    const ProfileAvatar = styled.img`
        width: 50px;
        height: 50px;
        border-radius: 50%;
        margin: 10px;
        cursor: pointer;
    `;

    const CloseContextMenu = styled.div`
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        zIndex: 999;
    `;

    const SiteName = styled.h1`
        font-weight: bold;
        text-decoration: none;
        margin: 20px;
        color: #333;
    `;

    const Menu = styled.ul`
        list-style: none;
        text-decoration: none;
        display: flex;
        justify-content: space-between;
    `;

    const MenuComponent = styled.li`
        list-style: none;
        text-decoration: none;
        margin: 10px;
        font-size: 18px;
        color: #333;
    `;

    function handleProfileClick(e) {
        const { clientX, clientY } = e;
        setContextMenuPosition({ x: clientX, y: clientY });
        setIsContextMenuVisible(true);
    }

    function handleNoficationClick(e) {
        const { clientX, clientY } = e;
        setNModalPosition({ x: clientX, y: clientY });
        setIsNModalVisible(true);
    }

    function handleCloseContextMenu() {
        setIsContextMenuVisible(false);
    }

    function handleCloseNModal() {
        setIsNModalVisible(false);
    }    

    return(
        <section id='header' style={{width: '100%', height: '80px', display: 'flex', alignItems: 'center', justifyContent: 'space-between', backgroundColor: '#f8f8f8'}}>
            <SiteName><Link to="/main" style={{color: '#333', textDecoration: 'none'}}>나침반</Link></SiteName>
            <Menu>
                <MenuComponent><Link to="/board" style={{color: '#333', textDecoration: 'none'}}>게시판</Link></MenuComponent>
                <MenuComponent><Link to="/review" style={{color: '#333', textDecoration: 'none'}}>후기</Link></MenuComponent>
                <MenuComponent><Link to="/test" style={{color: '#333', textDecoration: 'none'}}>테스트</Link></MenuComponent>
            </Menu>
            <HeaderRight>
                {isContextMenuVisible && (
                    <div>
                        <ProfileContextMenu position={contextMenuPosition} onClose={handleCloseContextMenu} isLoggedIn={isLoggedIn} handleLogin={handleLogin}/>
                        <CloseContextMenu onClick={handleCloseContextMenu}></CloseContextMenu>
                    </div>
                )}
                <NotificationModal isOpen={isNModalVisible} position={NModalPosition} closeModal={handleCloseNModal}/>
                {isLoggedIn ? (
                    <div>
                        <Notification src={user.notification} onClick={handleNoficationClick}/>                                    
                        <ProfileAvatar src={user.avatar} onClick={handleProfileClick}/>
                    </div>                                                                                                      
                ) : (
                    <Button onClick={handleLogin} as="input" type="button" value="로그인" style={{margin: '20px'}}/>
                )}
            </HeaderRight> 
        </section>
    );
}

export default Header;