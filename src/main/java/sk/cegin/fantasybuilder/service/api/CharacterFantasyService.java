package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;

import java.util.List;

public interface CharacterFantasyService {

    CharacterFantasyDto getCharacterById(Long id) throws EntityNotFoundException;

    CharacterFantasyDto createCharacterFantasy(CharacterFantasyDto characterFantasyDto) throws EntityNotFoundException;

    List<CharacterFantasyDto> getAll();

    CharacterFantasyDto update(CharacterFantasyDto newCharacterDto, Long id) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;
}
