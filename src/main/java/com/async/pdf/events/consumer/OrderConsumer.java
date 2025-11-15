package com.async.pdf.events.consumer;

import com.async.pdf.config.RabbitConfig;
import com.async.pdf.service.ollama.OllamaService;
import com.async.pdf.service.pdf.PdfService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class OrderConsumer {

    private final PdfService pdfService;
    private final OllamaService ollamaService;

    @Value("${pdf.storage.path}")
    private String pdfStoragePath;

    public OrderConsumer(PdfService pdfService, OllamaService ollamaService) {
        this.ollamaService = ollamaService;
        this.pdfService = pdfService;
    }

    /**
     * Main processing method for orders coming from RabbitMQ.
     * Uses the chat service, generates a styled PDF containing the AI response,
     * and returns the same response as the method result.
     */
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void processOrder(String message) throws IOException {
        String response = ollamaService.chat("Make me a one-page summary of the important points of the"
                + message + "in PTBR and with direct response. Bluntly.");

        String path = pdfStoragePath + System.currentTimeMillis() + ".pdf";
        new File(path).getParentFile().mkdirs();

        pdfService.createPdf(response, path);
    }
}
