import React from "react";
import NavBar from "./NavBar";
import "./css/HomePage.css";

function HomePage() {
  return (
    <div className="homepage-container">
      <NavBar />

      <div className="main-content">
        <header className="header-section">
          <h1>Effective Smart Learning</h1>
          <p>Transforming the Way You Learn</p>
        </header>

        <section className="about-section">
          <h2>About Our Platform</h2>
          <p>
            Our platform offers a highly efficient study and note management
            system that provides users with tools for taking notes, organizing
            files, translating handwritten materials to text, and generating
            AI-driven summaries. With features such as semantic search and
            access to educational videos, we ensure a seamless and enriched
            learning experience.
          </p>
        </section>
      </div>
    </div>
  );
}

export default HomePage;
