import React from "react";
import "../css/NavBar.css";

const NavBar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-left">
        <h1 className="logo">NoteSphere</h1>
      </div>

      <div className="navbar-center">
        <input
          type="text"
          placeholder="Search notes, files..."
          className="search-bar"
        />
      </div>

      <div className="navbar-right">
        <button className="nav-btn">Sign In</button>
        <button className="nav-btn signup">Sign Up</button>
      </div>
    </nav>
  );
};

export default NavBar;
