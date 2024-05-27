import React from 'react';

function BoardTab() {
    const board = {
        writer: '작성자',
        writtentime: '2024.01.01 23:12',
        title: '글 제목',
        thumbnail: 'img/background.png',
    };

  return (
    <div>
        <div className='boardtab'>
            <img src={board.thumbnail} alt="Thumbnail" className="thumbnail" />
            <h3>{board.title}</h3>
            <p>{board.writer}</p>
            <p>{board.writtentime}</p>            
        </div>
        <div className='boardtab'>
            <img src={board.thumbnail} alt="Thumbnail" className="thumbnail" />
            <h3>{board.title}</h3>
            <p>{board.writer}</p>
            <p>{board.writtentime}</p>            
        </div>
        <div className='boardtab'>
            <img src={board.thumbnail} alt="Thumbnail" className="thumbnail" />
            <h3>{board.title}</h3>
            <p>{board.writer}</p>
            <p>{board.writtentime}</p>            
        </div>
        <div className='boardtab'>
            <img src={board.thumbnail} alt="Thumbnail" className="thumbnail" />
            <h3>{board.title}</h3>
            <p>{board.writer}</p>
            <p>{board.writtentime}</p>            
        </div>
        <div className='boardtab'>
            <img src={board.thumbnail} alt="Thumbnail" className="thumbnail" />
            <h3>{board.title}</h3>
            <p>{board.writer}</p>
            <p>{board.writtentime}</p>            
        </div>
        <div className='boardtab'>
            <img src={board.thumbnail} alt="Thumbnail" className="thumbnail" />
            <h3>{board.title}</h3>
            <p>{board.writer}</p>
            <p>{board.writtentime}</p>            
        </div>
    </div>
    
  );
}

export default BoardTab;
