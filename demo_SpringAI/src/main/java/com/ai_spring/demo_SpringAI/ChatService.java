package com.ai_spring.demo_SpringAI;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt){
        System.out.println("Your Prompt is : " + prompt);
        return chatModel.call(prompt);
    }

    public String getResponseOptions(String prompt){
        System.out.println("Your Prompt is : " + prompt);
        ChatResponse response =  chatModel.call(
                new Prompt(
                        prompt,
                        OpenAiChatOptions.builder()
                                .withModel("gpt-4o")
                                .withTemperature(0.4F)
                                .build()
                ));
        return response.getResult().getOutput().getContent();
    }

}