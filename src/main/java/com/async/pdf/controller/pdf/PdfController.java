package com.async.pdf.controller.pdf;

import com.async.pdf.service.PedidoConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PdfController {

    private final PedidoConsumer pedidoConsumer;

    public PdfController(PedidoConsumer pedidoConsumer) {
        this.pedidoConsumer = pedidoConsumer;
    }

    @GetMapping("public/informations")
    public String bookstoreChat(@RequestBody String message) throws IOException {
        return pedidoConsumer.processOrder(message);
    }
}
