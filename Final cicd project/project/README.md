# AI-Powered Smart Study & Note Platform

**GitHub Repo:** `note-sphere`

---

## Project Overview

Students and professionals often struggle to **organize notes, manage files, and convert handwritten content into digital text efficiently**. This project is a **single-login, AI-powered study and note management platform** that allows users to:

* Take and organize notes
* Upload and store files, including documents, PDFs, images, and videos
* Convert handwritten notes to text
* Generate AI-powered summaries
* Search and filter content semantically
* Access a mini video streaming module for educational content
* Use infinite scroll for notes, files, and videos

This **full-stack, cloud-deployable platform** demonstrates practical **AI integration, modern web development, and productivity-enhancing features**, making it **high-impact for a final-year project and resume-worthy**.

---

## Problem Statement

Students and learners often face challenges in:

* Converting handwritten notes to digital text
* Summarizing large amounts of study material
* Searching and filtering notes, files, and videos effectively
* Managing study content efficiently in one workspace

This platform solves these issues by providing a **single-login, AI-integrated personal learning workspace** that combines **note-taking, file management, AI summarization, semantic search, infinite scroll, and mini video streaming**, creating a **smarter and more organized study environment**.

---

## Features

### Core Features

1. **User Authentication**

   * Secure login/signup (JWT or session-based)
   * Profile management with avatar and basic info

2. **Notes Management**

   * Create, edit, delete notes
   * Markdown formatting support
   * Organize notes with tags and categories

3. **File Upload & Management**

   * Upload PDFs, images, documents, and videos
   * Organize files into folders or categories
   * Archive / old storage system for historical content

4. **AI-Powered Handwriting-to-Text**

   * Upload handwritten notes and convert them to editable text
   * Confidence score and highlighted uncertain words

5. **AI Summaries**

   * Generate summaries for notes, files, or combined content
   * Options: short, long, or bullet-point summaries

6. **Search & Filtering**

   * Semantic search across notes, files, and videos
   * Filter by tags, date, type, or category

7. **Infinite Scroll / Pagination**

   * Seamlessly load older notes, files, and video content

8. **Dashboard & Profile Overview**

   * Quick stats: notes count, files uploaded, AI summaries generated
   * Recent activity feed

9. **UI / UX Features**

   * Responsive design for desktop and mobile
   * Dark mode toggle
   * Clean card/grid layouts for content

### Additional / Optional Features (Wow Factor)

10. **Mini Video Streaming Module**

    * Upload, stream, like/dislike, and comment on videos
    * Search and filter by category and tags

11. **Realtime Collaboration (Optional)**

    * Share notes or updates in realtime via Socket.io

12. **File Versioning / History**

    * Track changes for notes and uploaded files

13. **AI Study Recommendations**

    * Suggest notes or files to review based on user activity
    * Optional “study plan generator” using AI

14. **Export / Download Options**

    * Export notes, summaries, or files as PDF or ZIP

15. **Notifications (Optional)**

    * Alerts for new uploads, AI suggestions, or recent activity

---

## Tech Stack

| Layer       | Framework / Tool                       | Purpose                                         |
| ----------- | -------------------------------------- | ----------------------------------------------- |
| Frontend    | React + Vite + Tailwind CSS            | Modern responsive UI                            |
| Backend     | Node.js + Express                      | REST APIs, file handling, AI integration        |
| Database    | MongoDB (Atlas Free)                   | Store users, notes, files, and videos           |
| Realtime    | Socket.io                              | Optional real-time updates / chat               |
| AI / ML     | OpenAI API / Hugging Face / Gemini API | Summaries, handwriting-to-text, semantic search |
| File Upload | Cloudinary / Firebase                  | Store and retrieve files                        |
| Deployment  | Vercel (frontend) + Render (backend)   | Free full-stack cloud hosting                   |

---

## Folder Structure (Suggested)

```
client/                 # React frontend
  ├─ src/
  │   ├─ components/    # Navbar, Sidebar, Notes, AI Tools, Video Player
  │   ├─ pages/         # Dashboard, Notes, Files, Videos, AI Tools, Profile
  │   ├─ utils/         # API calls, helper functions
  │   └─ App.tsx
server/                 # Node.js backend
  ├─ controllers/       # NoteController, FileController, AIController
  ├─ models/            # User, Note, File, Video
  ├─ routes/            # AuthRoutes, NoteRoutes, FileRoutes, VideoRoutes
  └─ index.js           # Express server entry
```

---

## Future Enhancements

* Add multi-user collaboration rooms
* Integrate voice-to-text for notes
* Advanced AI study plan generator
* Analytics dashboard for learning progress
* Mobile app version using React Native

---

## Getting Started

1. Clone the repo:

```bash
git clone https://github.com/yourusername/note-sphere.git
```

2. Install frontend dependencies:

```bash
cd client
npm install
```

3. Start frontend server:

```bash
npm run dev
```

4. Install backend dependencies:

```bash
cd ../server
npm install
```

5. Start backend server:

```bash
npm run start
```

6. Open `http://localhost:5173` to see the application running.

---

**Project developed by:** GURIVI REDDY YASASWINI
**Department:** CSE HTE
**Specialization:** CLOUD NATIVE SOFTWARE ENGINEERING
**Expected Completion:** DECE
