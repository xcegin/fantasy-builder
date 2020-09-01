package sk.cegin.fantasybuilder.service.impl;

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
    public AppearanceDto getAppearanceById(Long id) throws EntityNotFoundException {
        Appearance appearance = appearanceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Appearance.class, id));
        return convertToDto(appearance);
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
    public AppearanceDto get(CharacterFantasyDto characterFantasyDto) {
        CharacterFantasy characterFantasy = modelMapper.map(characterFantasyDto, CharacterFantasy.class);
        return convertToDto(appearanceRepository.findByCharacterFantasy(characterFantasy));
    }

    @Override
    @Transactional
    public AppearanceDto update(AppearanceDto appearanceDto, Long id) throws EntityNotFoundException {
        Appearance appearance = convertToEntity(appearanceDto);
        return convertToDto(appearanceRepository.findById(id)
                .map(appearanceNew -> {
                    appearanceNew.setAge(appearance.getAge());
                    appearanceNew.setTypeOfBody(appearance.getTypeOfBody());
                    appearanceNew.setShapeOfFace(appearance.getShapeOfFace());
                    appearanceNew.setGender(appearance.getGender());
                    appearanceNew.setAgeOfAppearance(appearance.getAgeOfAppearance());
                    appearanceNew.setDescription(appearance.getDescription());
                    appearanceNew.setEyeColor(appearance.getEyeColor());
                    appearanceNew.setGlasses(appearance.getGlasses());
                    appearanceNew.setHeight(appearance.getHeight());
                    appearanceNew.setWeight(appearance.getWeight());
                    appearanceNew.setPosture(appearance.getPosture());
                    appearanceNew.setDescription(appearance.getDescription());
                    appearanceNew.setSkinColor(appearance.getSkinColor());
                    return appearanceRepository.save(appearanceNew);
                }).orElseThrow(() -> new EntityNotFoundException(Appearance.class, id)));
    }

    @Override
    @Transactional
    public void delete(Long id) throws EntityNotFoundException {
        if (!appearanceRepository.existsById(id)) {
            throw new EntityNotFoundException(Appearance.class, id);
        }
        appearanceRepository.deleteById(id);
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
        appearance.setShapeOfFace(ShapeOfFace.valueOf(appearanceDto.getShapeOfFaceId()));
        appearance.setTypeOfBody(TypeOfBody.valueOf(appearanceDto.getTypeOfBodyId()));
        return appearance;
    }
}
