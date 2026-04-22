package notificador.scheduler;

import notificador.model.Task;
import notificador.repository.TaskRepository;
import notificador.service.WhatsAppService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class TaskAgendador {

    private final TaskRepository repository;
    private final WhatsAppService whatsappService;

    public TaskAgendador(TaskRepository repository, WhatsAppService whatsappService) {
        this.repository = repository;
        this.whatsappService = whatsappService;
    }

    @Scheduled(fixedRate = 60000)
    public void verificarTarefas() {

        LocalDate hoje = LocalDate.now();
        LocalTime agora = LocalTime.now().withSecond(0).withNano(0);

        List<Task> tarefas =
                repository.findByDataAndHoraAndNotificacaoEnviadaFalse(hoje, agora);

        for (Task task : tarefas) {
            whatsappService.enviarMensagem(task);
            task.setNotificacaoEnviada(true);
            repository.save(task);
        }
    }
}