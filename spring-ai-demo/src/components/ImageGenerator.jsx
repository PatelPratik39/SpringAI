import React, { useState } from "react";

const ImageGenerator = () => {
  const [prompt, setPrompt] = useState("");
  const [imageUrl, setImageUrl] = useState([]);

  const genrateImage = async () => {
    try {
      const resposne = await fetch(
        `http://localhost:8080/generate-image?prompt=${prompt}`
      );
      console.log(prompt);

      const urls = await resposne.json();
      console.log(urls);
      setImageUrl(urls);
    } catch (error) {
      console.error("Error in Generating Image : ", error);
    }
  };

  return (
    <>
      <div className="tab-content">
        <h2>Image Generator </h2>
        <input
          type="text"
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
          placeholder="Enter Prompt here... 💬"
        />
        <button onClick={genrateImage}>Generate Image</button>

        {/* Display the Image Grid */}

        <div className="image-grid">
          {imageUrl.map((url, index) => (
            <img key={index} src={url} alt={`Generated ${index}`} />
          ))}
          {[...Array(5 - imageUrl.length)].map((_, index) => (
            <div
              key={index + imageUrl.length}
              className="empty-image-slot"
            ></div>
          ))}
        </div>
      </div>
    </>
  );
};

export default ImageGenerator;
