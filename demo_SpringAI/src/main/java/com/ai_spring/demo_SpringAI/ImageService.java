package com.ai_spring.demo_SpringAI;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final OpenAiImageModel openAiImageModel;

    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    //   this method will generate new Image using prompt and openAI
    public ImageResponse generateImage(String prompt, String quality, int n, int width, int height ) {
//        ImageResponse imageResponse = openAiImageModel.call(
//                new ImagePrompt(prompt));

//        ImageResponse imageResponse = openAiImageModel.call(
//                new ImagePrompt(prompt,
//                        OpenAiImageOptions.builder()
//                                .withModel("dall-e-2")
//                                .withQuality("hd")
//                                .withN(3)
//                                .withHeight(1024)
//                                .withWidth(1024).build())
//        );

        ImageResponse imageResponse = openAiImageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .withModel("dall-e-2")
                                .withQuality(quality)
                                .withN(n)
                                .withHeight(height)
                                .withWidth(width).build())
        );
        System.out.println("Your Prompt is : " + prompt);
        return imageResponse;
    }


}
