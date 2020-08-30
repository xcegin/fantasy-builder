package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.AppearanceDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;

import java.util.List;

public interface AppearanceService {
    AppearanceDto getAppearanceById(Long id);

    AppearanceDto createAppearance(AppearanceDto charNameDto, CharacterFantasyDto characterFantasyDto) throws EntityNotFoundException;

    List<AppearanceDto> getAll(CharacterFantasyDto characterFantasyDto);

    AppearanceDto update(AppearanceDto charNameDto, Long id);

    void delete(Long id);
}
