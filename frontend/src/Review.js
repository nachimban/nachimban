import React from 'react';
import Tree from './Tree';

function Review() {
  return (
    <section id="review">
      <h1>후기</h1>
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
    </section>
  );
}

export default Review;