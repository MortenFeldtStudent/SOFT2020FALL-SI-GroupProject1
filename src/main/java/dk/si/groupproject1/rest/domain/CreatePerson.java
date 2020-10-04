package dk.si.groupproject1.rest.domain;

import lombok.Data;

@Data
public class CreatePerson {
    private String fullName;
    private Long yearOfBirth;
    private Long zipCode;
}
