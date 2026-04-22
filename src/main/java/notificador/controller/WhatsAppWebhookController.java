package notificador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @PostMapping("/whatsapp")
    public ResponseEntity<String> receberMensagem(@RequestBody String payload) {

        System.out.println("🔥 Mensagem recebida da Z-API:");
        System.out.println(payload);

        return ResponseEntity.ok("OK");
    }
}