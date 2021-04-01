package qc.colval.demothymleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demothymleaf.models.entities.Actor;

import java.sql.Date;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByLastName(String lastName);

    List<Actor> findByFirstName(String firstName);

    List<Actor> findByLastUpdate(Date lastUpdate);

    List<Actor> findAllActorIdAsc();
}
