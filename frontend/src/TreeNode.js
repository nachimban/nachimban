import React, { useState } from 'react';
import './Tree.css';

const Tree = ({ node }) => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="tree-box">
      <div className="tree-node">
        <div onClick={toggle} className="tree-node-label">
        {node.children && (isOpen ? '-' : '+')} {node.name}
        </div>
        {isOpen && node.children && (
          <div className="tree-children">
            {node.children.map((child) => (
              <div key={child.id} className="tree-child">
                <img src={child.thumbnail} alt="Thumbnail" className="review-thumbnail" />
                {child.name}
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
};

export default Tree;
