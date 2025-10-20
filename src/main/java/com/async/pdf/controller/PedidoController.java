package com.async.pdf.controller;

import com.async.pdf.service.PedidoProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoProducer pedidoProducer;

    public PedidoController(PedidoProducer pedidoProducer) {
        this.pedidoProducer = pedidoProducer;
    }

    @PostMapping("/public/enviar")
    public ResponseEntity<String> enviarPedido() {
        pedidoProducer.enviarPedido();
        return ResponseEntity.ok("Pedido enviado com sucesso!");
    }
}
