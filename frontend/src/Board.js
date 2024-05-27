import React from 'react';

function Board() {
  const board = {
    writer: '작성자',
    writtentime: '2024.01.01 23:12',
    title: '글 제목',
    thumbnail: 'img/background.png',
};

  return (
    <section id="board">
      <h1>게시판</h1>
      <ul className='boardtab'>
            <li>
                <div className='text'>
                    <h3 className="title">{board.title}</h3>
                    <p className="writer">{board.writer}</p>
                    <p className="written-time">{board.writtentime}</p>
                </div>                             
                <img src={board.thumbnail} alt="Thumbnail" className="board-thumbnail" />
            </li>
            <li>
                <div className='text'>
                    <h3 className="title">{board.title}</h3>
                    <p className="writer">{board.writer}</p>
                    <p className="written-time">{board.writtentime}</p>
                </div>                             
                <img src={board.thumbnail} alt="Thumbnail" className="board-thumbnail" />
            </li>
            <li>
                <div className='text'>
                    <h3 className="title">{board.title}</h3>
                    <p className="writer">{board.writer}</p>
                    <p className="written-time">{board.writtentime}</p>
                </div>                             
                <img src={board.thumbnail} alt="Thumbnail" className="board-thumbnail" />
            </li>
            <li>
                <div className='text'>
                    <h3 className="title">{board.title}</h3>
                    <p className="writer">{board.writer}</p>
                    <p className="written-time">{board.writtentime}</p>
                </div>                             
                <img src={board.thumbnail} alt="Thumbnail" className="board-thumbnail" />
            </li>
            <li>
                <div className='text'>
                    <h3 className="title">{board.title}</h3>
                    <p className="writer">{board.writer}</p>
                    <p className="written-time">{board.writtentime}</p>
                </div>                             
                <img src={board.thumbnail} alt="Thumbnail" className="board-thumbnail" />
            </li>
            <li>
                <div className='text'>
                    <h3 className="title">{board.title}</h3>
                    <p className="writer">{board.writer}</p>
                    <p className="written-time">{board.writtentime}</p>
                </div>                             
                <img src={board.thumbnail} alt="Thumbnail" className="board-thumbnail" />
            </li>
        </ul>
    </section>
  );
}

export default Board;