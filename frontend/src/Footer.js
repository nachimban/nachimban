import React from 'react';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';

function Footer() {
  return (
    <section id="footer">
        <Navbar bg="light" data-bs-theme="light" fixed="bottom">
            <Container>
                <p>&copy; 2024 나침반. All rights reserved.</p>
            </Container>
        </Navbar>
    </section>
  );
}

export default Footer;