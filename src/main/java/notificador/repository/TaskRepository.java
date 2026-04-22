package notificador.repository;

import notificador.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDataAndHoraAndNotificacaoEnviadaFalse(
            LocalDate data,
            LocalTime hora
    );
}