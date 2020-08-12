package sk.cegin.fantasybuilder.repository;

import org.springframework.data.repository.CrudRepository;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;

public interface CharacterFantasyRepository extends CrudRepository<CharacterFantasy, Long> {
    CharacterFantasy findById(long id);
}
