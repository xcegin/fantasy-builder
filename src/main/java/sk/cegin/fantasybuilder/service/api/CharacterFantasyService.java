package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.entity.CharacterFantasy;

import java.util.List;

public interface CharacterFantasyService {

    CharacterFantasy getUserById(Long id);

    CharacterFantasy registerCharacterFantasy(CharacterFantasy characterFantasy);

    List<CharacterFantasy> getAll();

    CharacterFantasy update(CharacterFantasy newCharacter, Long id);

    void delete(Long id);
}
