package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.GenderDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;

import java.util.List;

public interface GenderService {
    GenderDto getGenderById(String id) throws EntityNotFoundException;

    List<GenderDto> getAll();
}
