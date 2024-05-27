import React from 'react';

const NotificationModal = ({ isOpen, position, closeModal }) => {
  return (
    <div >
      {isOpen && (
        <div className="Nmodal">
          <div className="Nmodal-content" style={{ position: 'absolute', top: position.y, left: position.x, transform: 'translate(-100%, 0)', background: 'white', zIndex: 1000 }}>
            <span className="NmodalClose" onClick={closeModal}>&times;</span>
            <h2>Modal Title</h2>
            <p>This is the modal content.</p>
          </div>
        </div>
      )}
    </div>
  );
};

export default NotificationModal;
