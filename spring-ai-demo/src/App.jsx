import "./App.css";
import React, { useState } from "react";
import ImageGenerator from "./components/ImageGenerator";
import Recipegenerator from "./components/Recipegenerator";
import Chat from "./components/Chat";

function App() {
  const [activeTab, setActiveTab] = useState("image-generator");

  const handleTabChange = (tab) => {
    // alert(tab);
    setActiveTab(tab);
  };
  return (
    <>
      <div className="App">
        <button
          className={activeTab === "image-generator" ? "active" : " "}
          onClick={() => handleTabChange("image-generator")}
        >
          Image Gnerator
        </button>{" "}
        <button
          className={activeTab === "chat" ? "active" : " "}
          onClick={() => handleTabChange("chat")}
        >
          Chat Gnerator
        </button>{" "}
        <button
          className={activeTab === "recipe-generator" ? "active" : " "}
          onClick={() => handleTabChange("recipe-generator")}
        >
          Recipe Gnerator
        </button>
        <div>
          {activeTab === "image-generator" && <ImageGenerator />}
          {activeTab === "chat" && <Chat/>}
          {activeTab === "recipe-generator" && <Recipegenerator />}
        </div>
      </div>
    </>
  );
}

export default App;
