package notificador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LembreteController {

    @PostMapping("/task")
    public ResponseEntity<String> criarTask(@RequestBody String payload) {

        System.out.println("🌐 TASK do site Mind-Tasker:");
        System.out.println(payload);

        return ResponseEntity.ok("Task recebida");
    }
}