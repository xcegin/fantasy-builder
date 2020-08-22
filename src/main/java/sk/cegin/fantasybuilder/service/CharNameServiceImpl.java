package sk.cegin.fantasybuilder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.dto.CharNameDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.entity.CharName;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;
import sk.cegin.fantasybuilder.exception.CharNameNotFoundException;
import sk.cegin.fantasybuilder.repository.CharNameRepository;
import sk.cegin.fantasybuilder.service.api.CharNameService;

import java.util.ArrayList;
import java.util.List;

@Service
public class
CharNameServiceImpl implements CharNameService {

    @Autowired
    private CharNameRepository charNameRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public CharNameDto getCharNameById(Long id) {
        return convertToDto(charNameRepository.findById(id)
                .orElseThrow(() -> new CharNameNotFoundException(id)));
    }

    @Override
    @Transactional
    public CharNameDto createCharName(CharNameDto charNameDto, CharacterFantasyDto characterFantasyDto) {
        CharName charName = convertToEntity(charNameDto);
        CharacterFantasy characterFantasy = modelMapper.map(characterFantasyDto, CharacterFantasy.class);
        charName.setCharacterFantasy(characterFantasy);
        charName = charNameRepository.save(charName);
        return convertToDto(charName);
    }

    @Override
    @Transactional
    public List<CharNameDto> getAll(CharacterFantasyDto characterFantasyDto) {
        List<CharNameDto> charNames = new ArrayList<>();
        CharacterFantasy characterFantasy = modelMapper.map(characterFantasyDto, CharacterFantasy.class);
        for (CharName charName : charNameRepository.findByCharacterFantasy(characterFantasy)) {
            charNames.add(convertToDto(charName));
        }
        return charNames;
    }

    @Override
    public CharNameDto update(CharNameDto charNameDto, Long id) {
        return convertToDto(charNameRepository.findById(id)
                .map(charName -> {
                    charName.setCharName(charNameDto.getCharName());
                    charName.setDescription(charNameDto.getDescription());
                    charName.setIsAlias(charNameDto.getIsAlias());
                    return charNameRepository.save(charName);
                })
                .orElseThrow(() -> new CharNameNotFoundException(id)));
    }

    public void delete(Long id) {
        if (!charNameRepository.existsById(id)){
            throw new CharNameNotFoundException(id);
        }
        charNameRepository.deleteById(id);
    }

    private CharNameDto convertToDto(CharName charName) {
        return modelMapper.map(charName, CharNameDto.class);
    }

    private CharName convertToEntity(CharNameDto charNameDto) {
        return modelMapper.map(charNameDto, CharName.class);
    }
}
