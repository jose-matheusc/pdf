package com.async.pdf.controller.pdf;

import com.async.pdf.events.producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

    private final OrderProducer orderProducer;

    public PdfController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/public/pdf/generate")
    public String getPdfInformation(@RequestBody String message) {
        return orderProducer.generatePdf(message);
    }
}
