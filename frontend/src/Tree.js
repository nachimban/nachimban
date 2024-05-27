import React from 'react';
import TreeNode from './TreeNode';
import './Tree.css';

const treeData = {
  id: 1,
  name: '라벨명',
  children: [
    { id: 2, 
      name: '후기1',
      thumbnail: 'img/background.png',
    },
    { id: 3, 
      name: '후기2',
      thumbnail: 'img/background.png',
    },
  ],
};

const Tree = () => {
  return (
    <div>
        <TreeNode node={treeData} />
    </div>
  );
};

export default Tree;
