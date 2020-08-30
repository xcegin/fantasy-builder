package sk.cegin.fantasybuilder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.dto.GenderDto;
import sk.cegin.fantasybuilder.entity.Gender;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.repository.GenderRepository;
import sk.cegin.fantasybuilder.service.api.GenderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public GenderDto getGenderById(String id) throws EntityNotFoundException {
        return convertToDto(genderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Gender.class, id)));
    }

    @Override
    @Transactional
    public List<GenderDto> getAll() {
        List<GenderDto> genders = new ArrayList<>();
        for (Gender gender : genderRepository.findAll()) {
            genders.add(convertToDto(gender));
        }
        return genders;
    }

    private GenderDto convertToDto(Gender gender) {
        return modelMapper.map(gender, GenderDto.class);
    }
}
