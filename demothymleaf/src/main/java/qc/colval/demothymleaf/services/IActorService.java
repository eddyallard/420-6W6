package qc.colval.demothymleaf.services;

import qc.colval.demothymleaf.models.entities.Actor;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IActorService {
    Actor create(Actor actor);

    Optional<Actor> readOne(Long actorId);

    List<Actor> readAll();

    void delete(Long actorId);

    List<Actor> getActorByFirstName(String firstName);

    List<Actor> getActorByLastName(String lastName);

    List<Actor> getActorByLastUpdate(Date lastUpdate);

    Long countAllActor();

    List<Actor> findAllActorIdAscAndLimitTen();

}
