package com.async.pdf.controller.pdf;

import com.async.pdf.events.consumer.OrderConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PdfController {

    private final OrderConsumer orderConsumer;

    public PdfController(OrderConsumer orderConsumer) {
        this.orderConsumer = orderConsumer;
    }

    @GetMapping("public/informations")
    public String bookstoreChat(@RequestBody String message) throws IOException {
        return orderConsumer.processOrder(message);
    }
}
