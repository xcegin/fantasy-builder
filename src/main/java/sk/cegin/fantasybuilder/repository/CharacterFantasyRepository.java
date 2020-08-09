package sk.cegin.fantasybuilder.repository;

import org.springframework.data.repository.CrudRepository;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;

import java.util.List;

public interface CharacterFantasyRepository extends CrudRepository<CharacterFantasy, Long> {

    List<CharacterFantasy> findByCharName(String charName);

    CharacterFantasy findById(long id);
}
