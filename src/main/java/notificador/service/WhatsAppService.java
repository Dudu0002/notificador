package notificador.service;

import notificador.model.Task;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WhatsAppService {

    private final String TOKEN = "AE1078FF9A133EE7F416D99A";
    private final String INSTANCE = "3F20855B43F1D1DA89CB9A962EE6827F";
    private final String CLIENT_TOKEN = "F396f2b9b7de742aaa37650dd2456f497S";

    public void enviarMensagem(Task task) {

        String url = "https://api.z-api.io/instances/" + INSTANCE + "/token/" + TOKEN + "/send-text";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> body = new HashMap<>();
        body.put("phone", task.getTelefone());
        body.put("message", "🔔 Lembrete: " + task.getTitulo());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Client-Token", CLIENT_TOKEN);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        try {
            restTemplate.postForEntity(url, request, String.class);
            System.out.println("✅ WhatsApp enviado com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao enviar WhatsApp");
            e.printStackTrace();
        }
    }
}