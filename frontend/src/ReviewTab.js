import React from 'react';
import Accordion from 'react-bootstrap/Accordion';
import Card from 'react-bootstrap/Card';
import 'bootstrap/dist/css/bootstrap.min.css';

function ReviewTab() {
  const review = {
    "id" : 1,
    "title" : "게시글 1번",
    "writer" : "작성자1",
    "updatedAt" : "2024-04-23 20:01",
    "thumbnail" : 'img/background.png',
  };

  return (
    <section id="review" style={{display: 'inline-flex', flexWrap: 'wrap', marginBottom: '80px'}}>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
      <Accordion defaultActiveKey="0" style={{width: '22rem', margin: '10px'}}>
        <Accordion.Item eventKey="0">
          <Accordion.Header>Accordion Item #1</Accordion.Header>
          <Accordion.Body style={{display: 'inline-flex', flexWrap: 'wrap'}}>
            <Card style={{ width: '18rem', margin: '10px'}}>
              <Card.Img variant="top" src="img/background.png" />
              <Card.Body>
                <Card.Title>{review.title}</Card.Title>
                <Card.Text>{review.writer}</Card.Text>
                <Card.Text>{review.updatedAt}</Card.Text>                
              </Card.Body>
            </Card>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
    </section>
  );
}

export default ReviewTab;