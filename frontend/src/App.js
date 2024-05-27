import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './Header';
import Main from './Main';
import Board from './Board';
import Review from './Review';
import Profile from './Profile';
import Setting from './Setting';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(!isLoggedIn);
  };

  return (
    <Router>
      <div className="App">
        <Header isLoggedIn={isLoggedIn} handleLogin={handleLogin} />
        <main>
          <Routes>
            <Route path="/main" element={<Main />} />
            <Route path="/board" element={<Board />} />
            <Route path="/review" element={<Review />} />
            <Route path="/profile" element={<Profile isLoggedIn={isLoggedIn} />} />
            <Route path="/setting" element={<Setting isLoggedIn={isLoggedIn} />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
