package sk.cegin.fantasybuilder.entity;


import lombok.Data;

import java.util.Date;

@Data
public class CharacterFantasy {

    private String name;
    private Date birthDate;
    private String description;
}
