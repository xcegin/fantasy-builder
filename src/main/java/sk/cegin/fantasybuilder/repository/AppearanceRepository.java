package sk.cegin.fantasybuilder.repository;

import org.springframework.data.repository.CrudRepository;
import sk.cegin.fantasybuilder.entity.Appearance;

public interface AppearanceRepository extends CrudRepository<Appearance, Long> {
    Appearance findById(long id);
}
