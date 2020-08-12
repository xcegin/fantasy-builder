package sk.cegin.fantasybuilder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;
import sk.cegin.fantasybuilder.exception.CharNameNotFoundException;
import sk.cegin.fantasybuilder.exception.CharacterFantasyNotFoundException;
import sk.cegin.fantasybuilder.repository.CharacterFantasyRepository;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterFantasyServiceImpl implements CharacterFantasyService {

    @Autowired
    private CharacterFantasyRepository characterFantasyRepository;

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

    public CharacterFantasyDto update(CharacterFantasyDto characterFantasyDto, Long id) {
        return convertToDto(characterFantasyRepository.findById(id)
                .map(character -> {
                    //character.setCharName(newCharacter.getCharName());
                    return characterFantasyRepository.save(character);
                })
                .orElseThrow(() -> new CharacterFantasyNotFoundException(id)));
    }

    public void delete(Long id) {
        if (!characterFantasyRepository.existsById(id)){
            throw new CharacterFantasyNotFoundException(id);
        }
        characterFantasyRepository.deleteById(id);
    }

    private CharacterFantasyDto convertToDto(CharacterFantasy characterFantasy) {
        return modelMapper.map(characterFantasy, CharacterFantasyDto.class);
    }

    private CharacterFantasy convertToEntity(CharacterFantasyDto characterFantasyDto) {
        return modelMapper.map(characterFantasyDto, CharacterFantasy.class);
    }
}
