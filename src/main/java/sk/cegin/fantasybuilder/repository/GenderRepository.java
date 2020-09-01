package sk.cegin.fantasybuilder.repository;

import org.springframework.data.repository.CrudRepository;
import sk.cegin.fantasybuilder.entity.Gender;

import java.util.Optional;

public interface GenderRepository extends CrudRepository<Gender, String> {
    Optional<Gender> findById(String id);
}
