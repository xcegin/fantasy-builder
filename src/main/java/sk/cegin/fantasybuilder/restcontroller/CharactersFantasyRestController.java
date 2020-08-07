package sk.cegin.fantasybuilder.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.cegin.fantasybuilder.entity.CharacterFantasy;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharactersFantasyRestController {

    @GetMapping
    public List<CharacterFantasy> findAll() {
        return null;
    }

    @GetMapping(value = "/{id}")
    public CharacterFantasy findById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody CharacterFantasy resource) {
        return null;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody CharacterFantasy resource) {
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
    }
}
