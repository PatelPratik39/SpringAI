import React, { useState } from "react";

const Chat = () => {
  const [prompt, setPrompt] = useState("");
  const [chatResponse, setChatResposne] = useState("");

  const askAI = async () => {
    try {
      const resposne = await fetch(
        `http://localhost:8080/ask-ai?prompt=${prompt}`
      );
      console.log(prompt);
      const data = await resposne.text();
      console.log(data);
      setChatResposne(data);
      setPrompt("");
    } catch (error) {
      console.error("Error in Generating Response : ", error);
    }
  };

  return (
    <>
      <div>
        <h2>Talk to AI ....</h2>
        <input
          type="text"
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
          placeholder="Enter your Prompt to talk to AI"
        />
        <button onClick={askAI}>Ask AI 🤖</button>

        <div className="output">
          <p>{chatResponse}</p>
        </div>
      </div>
    </>
  );
};

export default Chat;
