package sk.cegin.fantasybuilder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.dto.RaceDto;
import sk.cegin.fantasybuilder.entity.Race;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.repository.RaceRepository;
import sk.cegin.fantasybuilder.service.api.RaceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public RaceDto getRaceById(Long id) throws EntityNotFoundException {
        return convertToDto(raceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Race.class, id)));
    }

    @Override
    @Transactional
    public RaceDto createRace(RaceDto raceDto) {
        Race newRace = convertToEntity(raceDto);
        newRace = raceRepository.save(newRace);
        return convertToDto(newRace);
    }

    @Override
    @Transactional
    public List<RaceDto> getAll() {
        List<RaceDto> races = new ArrayList<>();
        for (Race race : raceRepository.findAll()) {
            races.add(convertToDto(race));
        }
        return races;
    }

    @Override
    @Transactional
    public RaceDto update(RaceDto raceDto, Long id) throws EntityNotFoundException {
        return convertToDto(raceRepository.findById(id)
                .map(race -> {
                    race.setName(raceDto.getName());
                    race.setDescription(raceDto.getDescription());
                    race.setDistinctions(raceDto.getDistinctions());
                    race.setHeight(raceDto.getHeight());
                    race.setWeight(raceDto.getWeight());
                    race.setLifespan(raceDto.getLifespan());
                    return raceRepository.save(race);
                })
                .orElseThrow(() -> new EntityNotFoundException(Race.class, id)));
    }

    @Override
    @Transactional
    public void delete(Long id) throws EntityNotFoundException {
        if (!raceRepository.existsById(id)) {
            throw new EntityNotFoundException(Race.class, id);
        }
        raceRepository.deleteById(id);
    }

    private RaceDto convertToDto(Race race) {
        return modelMapper.map(race, RaceDto.class);
    }

    private Race convertToEntity(RaceDto raceDto) {
        return modelMapper.map(raceDto, Race.class);
    }
}
