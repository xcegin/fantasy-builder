package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.CharNameDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;

import java.util.List;

public interface CharNameService {
    CharNameDto getCharNameById(Long id);

    CharNameDto createCharName(CharNameDto charNameDto, CharacterFantasyDto characterFantasyDto);

    List<CharNameDto> getAll(CharacterFantasyDto characterFantasyDto);

    CharNameDto update(CharNameDto charNameDto, Long id);

    void delete(Long id);
}
