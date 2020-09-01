package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.CharNameDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;

import java.util.List;

public interface CharNameService {
    CharNameDto getCharNameById(Long id) throws EntityNotFoundException;

    CharNameDto createCharName(CharNameDto charNameDto, CharacterFantasyDto characterFantasyDto);

    List<CharNameDto> getAll(CharacterFantasyDto characterFantasyDto);

    CharNameDto update(CharNameDto charNameDto, Long id) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;
}
