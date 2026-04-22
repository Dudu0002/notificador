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

	@PostMapping("/api/task")
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

	public void enviarWhatsApp(String phone, String message) {

	    String url = "https://api.z-api.io/3F20855B43F1D1DA89CB9A962EE6827F/token/AE1078FF9A133EE7F416D99A/send-text";


	    Map<String, Object> body = new HashMap<>();
	    body.put("phone", phone);
	    body.put("message", message);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.set("Client-Token", "F396f2b9b7de742aaa37650dd2456f497S");

	    HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.postForObject(url, request, String.class);
	}
}

