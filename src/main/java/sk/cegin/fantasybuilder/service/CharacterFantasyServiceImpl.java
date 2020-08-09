package sk.cegin.fantasybuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;
import sk.cegin.fantasybuilder.exception.CharacterFantasyNotFoundException;
import sk.cegin.fantasybuilder.repository.CharacterFantasyRepository;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;

import java.util.List;

@Service
public class CharacterFantasyServiceImpl implements CharacterFantasyService {

    @Autowired
    private CharacterFantasyRepository characterFantasyRepository;

    @Transactional
    public CharacterFantasy getUserById(Long id){
        return characterFantasyRepository.findById(id)
                .orElseThrow(() -> new CharacterFantasyNotFoundException(id));
    }

    @Transactional
    public CharacterFantasy registerCharacterFantasy(CharacterFantasy characterFantasy){
        return characterFantasyRepository.save(characterFantasy);
    }

    @Transactional
    public List<CharacterFantasy> getAll(){
        return (List<CharacterFantasy>) characterFantasyRepository.findAll();
    }

    public CharacterFantasy update(CharacterFantasy newCharacter, Long id) {
        return characterFantasyRepository.findById(id)
                .map(character -> {
                    character.setCharName(newCharacter.getCharName());
                    return characterFantasyRepository.save(character);
                })
                .orElseThrow(() -> new CharacterFantasyNotFoundException(id));
    }

    public void delete(Long id){
        characterFantasyRepository.deleteById(id);
    }
}
