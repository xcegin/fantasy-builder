package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.CharNameDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;

import java.util.List;

public interface CharNameService {
    CharNameDto getCharNameById(Long id);

    CharNameDto createCharName(CharNameDto charNameDto, CharacterFantasyDto characterFantasyDto);

    List<CharNameDto> getAll(CharacterFantasyDto characterFantasyDto);

    //CharacterFantasyDto update(CharacterFantasyDto newCharacterDto, Long id);

    void delete(Long id);
}
