import React from 'react';
import Tree from './Tree';

function ReviewTab() {
  return (
    <div>
      <ul className='reviewtab'>
        <li>
          <div className='review'>
            <Tree />
          </div>
        </li>
        <li>
          <div className='review'>
            <Tree />
          </div>
        </li>
        <li>
          <div className='review'>
            <Tree />
          </div>
        </li>
        <li>
          <div className='review'>
            <Tree />
          </div>
        </li>
        <li>
          <div className='review'>
            <Tree />
          </div>
        </li>
        <li>
          <div className='review'>
            <Tree />
          </div>
        </li>
      </ul>
    </div>
  );
}

export default ReviewTab;