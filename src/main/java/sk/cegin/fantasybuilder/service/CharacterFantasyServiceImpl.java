package sk.cegin.fantasybuilder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;
import sk.cegin.fantasybuilder.entity.Race;
import sk.cegin.fantasybuilder.exception.CharacterFantasyNotFoundException;
import sk.cegin.fantasybuilder.exception.RaceNotFoundException;
import sk.cegin.fantasybuilder.repository.CharacterFantasyRepository;
import sk.cegin.fantasybuilder.repository.RaceRepository;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterFantasyServiceImpl implements CharacterFantasyService {

    @Autowired
    private CharacterFantasyRepository characterFantasyRepository;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CharacterFantasyDto getCharacterById(Long id) {
        return convertToDto(characterFantasyRepository.findById(id)
                .orElseThrow(() -> new CharacterFantasyNotFoundException(id)));
    }

    @Transactional
    public CharacterFantasyDto createCharacterFantasy(CharacterFantasyDto newCharacterDto) {
        CharacterFantasy newCharacter = convertToEntity(newCharacterDto);
        newCharacter = characterFantasyRepository.save(newCharacter);
        return convertToDto(newCharacter);
    }

    @Transactional
    public List<CharacterFantasyDto> getAll() {
        List<CharacterFantasyDto> characters = new ArrayList<>();
        for (CharacterFantasy characterFantasy : characterFantasyRepository.findAll()) {
            characters.add(convertToDto(characterFantasy));
        }
        return characters;
    }

    @Transactional
    public CharacterFantasyDto update(CharacterFantasyDto characterFantasyDto, Long id) {
        CharacterFantasy newCharacter = convertToEntity(characterFantasyDto);
        return convertToDto(characterFantasyRepository.findById(id)
                .map(character -> {
                    character.setCodename(newCharacter.getCodename());
                    character.setRace(newCharacter.getRace());
                    return characterFantasyRepository.save(character);
                })
                .orElseThrow(() -> new CharacterFantasyNotFoundException(id)));
    }

    @Transactional
    public void delete(Long id) {
        if (!characterFantasyRepository.existsById(id)) {
            throw new CharacterFantasyNotFoundException(id);
        }
        characterFantasyRepository.deleteById(id);
    }

    private CharacterFantasyDto convertToDto(CharacterFantasy characterFantasy) {
        CharacterFantasyDto characterFantasyDto = modelMapper.map(characterFantasy, CharacterFantasyDto.class);
        if (characterFantasy.getRace() != null) {
            characterFantasyDto.setRaceId(characterFantasy.getRace().getId());
        }
        return characterFantasyDto;
    }

    private CharacterFantasy convertToEntity(CharacterFantasyDto characterFantasyDto) {
        CharacterFantasy characterFantasy = modelMapper.map(characterFantasyDto, CharacterFantasy.class);
        if (characterFantasyDto.getRaceId() != null) {
            Race race = raceRepository.findById(characterFantasyDto.getRaceId())
                    .orElseThrow(() -> new RaceNotFoundException(characterFantasyDto.getRaceId()));
            characterFantasy.setRace(race);
        }
        return characterFantasy;
    }
}
