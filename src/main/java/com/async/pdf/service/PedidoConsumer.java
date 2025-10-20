package com.async.pdf.service;

import com.async.pdf.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
@Service
public class PedidoConsumer {

    private final PdfService pdfService;

    public PedidoConsumer(PdfService pdfService){
        this.pdfService = pdfService;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void processarPedido(String mensagem) throws IOException {
        System.out.println("Mensagem recebida: " + mensagem);

        String caminho = "C:\\Users\\Maria Angela\\Documents\\aa\\pedido_" + System.currentTimeMillis() + ".pdf";
        new File(caminho).getParentFile().mkdirs();

        pdfService.criarPdf(caminho);
        System.out.println("PDF criado em: " + caminho);
    }
}


