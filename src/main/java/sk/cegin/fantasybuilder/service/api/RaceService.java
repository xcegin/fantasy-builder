package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.dto.RaceDto;

import java.util.List;

public interface RaceService {
    RaceDto getRaceById(Long id);

    RaceDto createRace(RaceDto raceDto);

    List<RaceDto> getAll();

    RaceDto update(RaceDto raceDto, Long id);

    void delete(Long id);
}
