import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
//import "./index.css";
import { Route, Routes, BrowserRouter } from "react-router-dom";
import Header from "./components/reusable/header/Header.jsx";
import Footer from "./components/reusable/footer/Footer.jsx";
import LoginPage from "./components/pages/LoginPage.jsx";
import Homepage from "./components/pages/Homepage.jsx";
import UserPage from "./components/pages/UserPage.jsx";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
      <Header />
    <BrowserRouter>
      <Routes>
        <Route path="/userpage" element={<UserPage />}/>
        <Route path="/register" element={<LoginPage />}/>
        <Route path="/login" element={<LoginPage />}/>
        <Route index element={<Homepage/>}/>       
      </Routes>
    </BrowserRouter>
    <Footer />
  </React.StrictMode>
);
