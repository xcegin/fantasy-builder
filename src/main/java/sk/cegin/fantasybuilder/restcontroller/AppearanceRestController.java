package sk.cegin.fantasybuilder.restcontroller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.cegin.fantasybuilder.dto.AppearanceDto;
import sk.cegin.fantasybuilder.dto.CharNameDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.service.api.AppearanceService;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;

import javax.validation.Valid;

import java.util.List;

import static sk.cegin.fantasybuilder.config.RestConstants.*;

@RestController
public class AppearanceRestController {
    @Autowired
    private AppearanceService appearanceService;

    @Autowired
    private CharacterFantasyService characterFantasyService;

    @PostMapping(produces = JSON_CONTENT_TYPE, consumes = JSON_CONTENT_TYPE, value = CHARACTERS_FANTASY_MAPPING_PATH + CHARACTER_FANTASY_ID_PLACEHOLDER_PATH + APPEARANCE_MAPPING_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "CharacterFantasy not found with id: {id}")
    })
    public AppearanceDto create(@PathVariable(CHARACTER_FANTASY_ID_PLACEHOLDER) Long id, @Valid @RequestBody AppearanceDto resource) throws EntityNotFoundException {
        CharacterFantasyDto characterFantasy = characterFantasyService.getCharacterById(id);
        return appearanceService.createAppearance(resource, characterFantasy);
    }

    @RequestMapping(method = RequestMethod.OPTIONS, value = CHARACTERS_FANTASY_MAPPING_PATH + CHARACTER_FANTASY_ID_PLACEHOLDER_PATH + APPEARANCE_MAPPING_PATH)
    public ResponseEntity<?> collectionOptionsCharactersWithAppearance() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
                .build();
    }

    @RequestMapping(method = RequestMethod.OPTIONS, value = APPEARANCE_MAPPING_PATH + ID_PLACEHOLDER_PATH)
    public ResponseEntity<?> collectionOptionsAppearance() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.OPTIONS)
                .build();
    }

    @PatchMapping(value = APPEARANCE_MAPPING_PATH + ID_PLACEHOLDER_PATH, consumes = JSON_CONTENT_TYPE)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Appearance not found with id: {id}")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> update(@PathVariable(ID_PLACEHOLDER) Long id, @Valid @RequestBody AppearanceDto resource) throws EntityNotFoundException {
        appearanceService.update(resource, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = JSON_CONTENT_TYPE, value = CHARACTERS_FANTASY_MAPPING_PATH + CHARACTER_FANTASY_ID_PLACEHOLDER_PATH + APPEARANCE_MAPPING_PATH)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Could not find character with id: {id}")
    })
    public AppearanceDto find(@PathVariable(CHARACTER_FANTASY_ID_PLACEHOLDER) Long id) throws EntityNotFoundException {
        CharacterFantasyDto characterFantasy = characterFantasyService.getCharacterById(id);
        return appearanceService.get(characterFantasy);
    }

    @GetMapping(produces = JSON_CONTENT_TYPE, value = APPEARANCE_MAPPING_PATH + ID_PLACEHOLDER_PATH)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Appearance not found with id: {id}")
    })
    public AppearanceDto findById(@PathVariable(ID_PLACEHOLDER) Long id) throws EntityNotFoundException {
        return appearanceService.getAppearanceById(id);
    }

    @DeleteMapping(value = APPEARANCE_MAPPING_PATH + ID_PLACEHOLDER_PATH)
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Appearance not found with id: {id}")
    })
    public ResponseEntity<Void> delete(@PathVariable(ID_PLACEHOLDER) Long id) throws EntityNotFoundException {
        appearanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
