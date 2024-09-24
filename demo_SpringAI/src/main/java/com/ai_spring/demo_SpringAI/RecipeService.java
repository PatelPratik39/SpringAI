package com.ai_spring.demo_SpringAI;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {

    private final ChatModel chatModel;

    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients,
                               String cuisine,
                               String dietaryRestrictions){

//        creating a template with dynamic variables
        var template = """
                    I want to create a recipe using the following ingredients : {ingredients}.
                    The Cuisine type I prefer is : {cuisine}.
                    Please consider the following dietaryRestrictions : {dietaryRestrictions}.
                    Please Provide me detailed Recipe including Title, list of ingredients, and cooking instructions."
                """;
//  using map.of method replacing the values
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
                "ingredients", ingredients,
                "cuisine", cuisine,
                "dietaryRestrictions", dietaryRestrictions
        );

//        Now create Prompt
        Prompt prompt = promptTemplate.create(params);
        System.out.println(prompt);
        return chatModel.call(prompt).getResult().getOutput().getContent();
    }
}
