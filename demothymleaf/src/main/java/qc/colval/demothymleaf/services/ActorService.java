package qc.colval.demothymleaf.services;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Actor;
import qc.colval.demothymleaf.repos.IActorRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService{
    private final IActorRepository actorRepository;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    public Optional<Actor> readOne(Long actorId) {
        return actorRepository.findById(actorId);
    }

    public List<Actor> readAll() {
        return actorRepository.findAll();
    }

    public void delete(Long actorId) {
        actorRepository.deleteById(actorId);
    }

    public List<Actor> getActorByFirstName(String firstName) {
        return actorRepository.findByFirstName(firstName);
    }

    public List<Actor> getActorByLastName(String lastName) {
        return actorRepository.findByLastName(lastName);
    }

    public List<Actor> getActorByLastUpdate(Date lastUpdate) {
        return actorRepository.findByLastUpdate(lastUpdate);

    }

    public Long countAllActor() {
        return actorRepository.count();
    }

    public List<Actor> findAllActorIdAscAndLimitTen() {
        return actorRepository.findAllActorIdAsc()
                .stream().limit(10)
                .collect(Collectors.toList());
    }
}