package com.async.pdf.controller.pdf;

import com.async.pdf.service.OllamaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

private final OllamaService chatClient;

    public PdfController(OllamaService chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("public/informations")
    public String bookstoreChat(@RequestParam(value = "message",
            defaultValue = "Quais são os livros best sellers dos ultimos anos?") String message){
        return chatClient.conversar(message);
    }

}
