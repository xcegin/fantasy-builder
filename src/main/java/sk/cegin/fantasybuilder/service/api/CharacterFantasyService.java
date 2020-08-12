package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;

import java.util.List;

public interface CharacterFantasyService {

    CharacterFantasyDto getCharacterById(Long id);

    CharacterFantasyDto createCharacterFantasy(CharacterFantasyDto characterFantasyDto);

    List<CharacterFantasyDto> getAll();

    CharacterFantasyDto update(CharacterFantasyDto newCharacterDto, Long id);

    void delete(Long id);
}
