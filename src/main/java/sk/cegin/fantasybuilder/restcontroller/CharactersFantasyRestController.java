package sk.cegin.fantasybuilder.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharactersFantasyRestController {

    @Autowired
    private CharacterFantasyService characterFantasyService;

    @GetMapping
    public List<CharacterFantasy> findAll() {
        return characterFantasyService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CharacterFantasy findById(@PathVariable("id") Long id) {
        return characterFantasyService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterFantasy create(@RequestBody CharacterFantasy resource) {
        return characterFantasyService.registerCharacterFantasy(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody CharacterFantasy resource) {
        characterFantasyService.update(resource, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        characterFantasyService.delete(id);
    }
}
