package notificador.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LembreteController {

	@PostMapping("/task")
	public ResponseEntity<String> criarTask(@RequestBody Map<String, Object> data) {

	    System.out.println("🌐 Task recebida:");
	    System.out.println(data);

	    String title = (String) data.get("title");


	    enviarWhatsApp(
	        "5519999273962",
	        "📝 Nova tarefa criada: " + title
	    );

	    return ResponseEntity.ok("Task recebida e enviada ao WhatsApp");
	}

	public void enviarWhatsApp(String title, String priority) {

	    String url = "https://api.z-api.io/instances/SEU_INSTANCE/token/SEU_TOKEN/send-text";

	    Map<String, Object> body = new HashMap<>();
	    body.put("phone", "5511999999999");
	    body.put("message", "📝 Nova tarefa: " + title + " | Prioridade: " + priority);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.set("Client-Token", "SEU_CLIENT_TOKEN");

	    HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.postForObject(url, request, String.class);
	}
}

