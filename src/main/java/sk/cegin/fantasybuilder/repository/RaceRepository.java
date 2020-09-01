package sk.cegin.fantasybuilder.repository;

import org.springframework.data.repository.CrudRepository;
import sk.cegin.fantasybuilder.entity.Race;

public interface RaceRepository extends CrudRepository<Race, Long> {
    Race findById(long id);
}
