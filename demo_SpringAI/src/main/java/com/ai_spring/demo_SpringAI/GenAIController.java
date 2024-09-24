package com.ai_spring.demo_SpringAI;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenAIController {

    private final ChatService chatService;
    private final ImageService imageService;

    public GenAIController(ChatService chatService, ImageService imageService) {
        this.chatService = chatService;
        this.imageService = imageService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

    /**
     *  Image Genaration controller
     * @param prompt
     * @return
     */
//    @GetMapping("generate-image")
//    public void generateImages(HttpServletResponse response, @RequestParam String prompt) throws IOException {
//        ImageResponse imageResponse = imageService.generateImage(prompt);
//        String imageUrl = imageResponse.getResult().getOutput().getUrl();
//        response.sendRedirect(imageUrl);
//    }


    @GetMapping("generate-image")
    public List<String> generateImages(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse imageResponse = imageService.generateImage(prompt);
//        String imageUrl = imageResponse.getResult().getOutput().getUrl();
//        response.sendRedirect(imageUrl);

        /* to get links of Url then I need to use stream() from Java8 */

       List<String> imageUrls =  imageResponse.getResults()
                .stream()
                .map(result -> result.getOutput().getUrl())
                .collect(Collectors.toList());
        return imageUrls;
    }
}
