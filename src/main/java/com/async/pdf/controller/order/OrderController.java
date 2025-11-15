package com.async.pdf.controller.order;

import com.async.pdf.events.producer.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/public/send")
    public ResponseEntity<String> sendOrder() {
        orderProducer.enviarPedido();
        return ResponseEntity.ok("Order sent successfully!");
    }
}
