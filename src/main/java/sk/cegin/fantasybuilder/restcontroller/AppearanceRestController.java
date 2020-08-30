package sk.cegin.fantasybuilder.restcontroller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.cegin.fantasybuilder.dto.AppearanceDto;
import sk.cegin.fantasybuilder.dto.CharacterFantasyDto;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.service.api.AppearanceService;
import sk.cegin.fantasybuilder.service.api.CharacterFantasyService;

import javax.validation.Valid;

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
}
