package sk.cegin.fantasybuilder.restcontroller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.cegin.fantasybuilder.config.RestConstants;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;

import javax.validation.Valid;
import java.util.List;

import static sk.cegin.fantasybuilder.config.RestConstants.*;

@RestController
@RequestMapping(CHARACTERS_FANTASY_MAPPING_PATH)
public class CharactersFantasyRestController {

    @Autowired
    private CharacterFantasyService characterFantasyService;

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> collectionOptions() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS, HttpMethod.DELETE, HttpMethod.PUT)
                .build();
    }


    @GetMapping(produces = JSON_CONTENT_TYPE)
    public List<CharacterFantasyDto> findAll() {
        return characterFantasyService.getAll();
    }


    @GetMapping(value = RestConstants.ID_PLACEHOLDER_PATH, produces = JSON_CONTENT_TYPE)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Could not find character {id}")
    })
    public CharacterFantasyDto findById(@PathVariable(ID_PLACEHOLDER) Long id) throws EntityNotFoundException {
        return characterFantasyService.getCharacterById(id);
    }

    @PostMapping(produces = JSON_CONTENT_TYPE, consumes = JSON_CONTENT_TYPE)
    @ResponseStatus(HttpStatus.CREATED)
    public CharacterFantasyDto create(@Valid @RequestBody CharacterFantasyDto resource) throws EntityNotFoundException {
        return characterFantasyService.createCharacterFantasy(resource);
    }

    @PatchMapping(value = RestConstants.ID_PLACEHOLDER_PATH, consumes = JSON_CONTENT_TYPE)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Could not find character {id}")
    })
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(ID_PLACEHOLDER) Long id, @Valid @RequestBody CharacterFantasyDto resource) throws EntityNotFoundException {
        characterFantasyService.update(resource, id);
    }

    @DeleteMapping(value = RestConstants.ID_PLACEHOLDER_PATH)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> delete(@PathVariable(ID_PLACEHOLDER) Long id) throws EntityNotFoundException {
        characterFantasyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
