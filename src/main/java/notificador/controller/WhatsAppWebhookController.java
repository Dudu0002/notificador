package notificador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

	@PostMapping("/webhook/whatsapp")
	public ResponseEntity<String> receber(@RequestBody String payload) {

	    System.out.println("\n🔥 ===== NOVA MENSAGEM =====");
	    System.out.println(payload);
	    System.out.println("================================\n");

	    return ResponseEntity.ok("OK");
	}
}