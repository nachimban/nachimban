import React from 'react';
import CloseButton from 'react-bootstrap/CloseButton';
import 'bootstrap/dist/css/bootstrap.min.css';
import styled from 'styled-components';

const NotificationModal = ({ isOpen, position, closeModal }) => {
  const Modal = styled.div`
    width: auto;
    white-space: nowrap;
    position: absolute;
    background-color: white;
    border: 1px solid black;
    z-index: 1000;
  `;

  const Content = styled.div`
    top: ${position.y};
    left: ${position.x};
    position: absolute;
    background: white;
    zIndex: 1000;
    width: 200px;
    border-radius: 10px;
    float: right;
    transform: translate(-40%, 15%);
  `;

  const Title = styled.span`
    font-size: 25px;
  `;

  const Alert = styled.div`
    border-radius: 10px;
    margin: 5px;
    background-color: lightblue;
  `;

  return (
    <div>
      {isOpen && (
        <Modal>
          <Content>
            <Title>알림</Title>
            <CloseButton 
              onClick={closeModal}
              style={{
                position: 'absolute',
                top: '10px',
                left: '10px',
                cursor: 'pointer'
              }}
            />
            <hr/>
            <Alert>This is the alert content</Alert>
            <Alert>This is the alert content</Alert>
            <Alert>This is the alert content</Alert>
            <Alert>This is the alert content</Alert>
          </Content>
        </Modal>
      )}
    </div>
  );
};

export default NotificationModal;
