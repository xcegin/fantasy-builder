package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.AppearanceDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;

public interface AppearanceService {
    AppearanceDto getAppearanceById(Long id) throws EntityNotFoundException;

    AppearanceDto createAppearance(AppearanceDto appearanceDto, CharacterFantasyDto characterFantasyDto) throws EntityNotFoundException;

    AppearanceDto get(CharacterFantasyDto characterFantasyDto);

    AppearanceDto update(AppearanceDto appearanceDto, Long id) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;
}
