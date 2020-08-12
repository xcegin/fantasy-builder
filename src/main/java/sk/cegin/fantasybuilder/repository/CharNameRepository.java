package sk.cegin.fantasybuilder.repository;

import org.springframework.data.repository.CrudRepository;
import sk.cegin.fantasybuilder.entity.CharName;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;

import java.util.List;

public interface CharNameRepository extends CrudRepository<CharName, Long> {
    CharName findById(long id);

    List<CharName> findByCharacterFantasy(CharacterFantasy characterFantasy);
}
