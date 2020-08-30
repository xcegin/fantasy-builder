package sk.cegin.fantasybuilder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.dto.AppearanceDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.entity.*;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.repository.AppearanceRepository;
import sk.cegin.fantasybuilder.repository.GenderRepository;
import sk.cegin.fantasybuilder.service.api.AppearanceService;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;
import sk.cegin.fantasybuilder.service.api.GenderService;

import java.util.List;

@Service
public class AppearanceServiceImpl implements AppearanceService {

    @Autowired
    private AppearanceRepository appearanceRepository;

    @Autowired
    private CharacterFantasyService characterFantasyService;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public AppearanceDto getAppearanceById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public AppearanceDto createAppearance(AppearanceDto appearanceDto, CharacterFantasyDto characterFantasyDto) throws EntityNotFoundException {
        Appearance appearance = convertToEntity(appearanceDto);
        CharacterFantasy characterFantasy = modelMapper.map(characterFantasyDto, CharacterFantasy.class);
        appearance.setCharacterFantasy(characterFantasy);
        appearance = appearanceRepository.save(appearance);
        return convertToDto(appearance);
    }

    @Override
    @Transactional
    public List<AppearanceDto> getAll(CharacterFantasyDto characterFantasyDto) {
        return null;
    }

    @Override
    @Transactional
    public AppearanceDto update(AppearanceDto charNameDto, Long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    private AppearanceDto convertToDto(Appearance appearance) {
        AppearanceDto appearanceDto = modelMapper.map(appearance, AppearanceDto.class);
        if (appearance.getGender() != null) {
            appearanceDto.setGenderId(appearance.getGender().getId());
        }
        appearanceDto.setShapeOfFaceId(appearance.getShapeOfFace().toString());
        appearanceDto.setTypeOfBodyId(appearance.getTypeOfBody().toString());
        return appearanceDto;
    }

    private Appearance convertToEntity(AppearanceDto appearanceDto) throws EntityNotFoundException {
        Appearance appearance = modelMapper.map(appearanceDto, Appearance.class);
        if (appearanceDto.getGenderId() != null) {
            Gender gender = genderRepository.findById(appearanceDto.getGenderId())
                    .orElseThrow(() -> new EntityNotFoundException(Gender.class, appearanceDto.getGenderId()));
            appearance.setGender(gender);
        }
        return appearance;
    }
}
