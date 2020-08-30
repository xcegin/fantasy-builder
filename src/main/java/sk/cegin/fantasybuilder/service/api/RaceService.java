package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.RaceDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;

import java.util.List;

public interface RaceService {
    RaceDto getRaceById(Long id) throws EntityNotFoundException;

    RaceDto createRace(RaceDto raceDto);

    List<RaceDto> getAll();

    RaceDto update(RaceDto raceDto, Long id) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;
}
