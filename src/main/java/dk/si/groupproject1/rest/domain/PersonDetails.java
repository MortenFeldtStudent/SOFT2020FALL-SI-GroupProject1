package dk.si.groupproject1.rest.domain;

import lombok.*;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails extends PersonSummary{
    private Long age;
    private String town;
    private String country;

    public PersonDetails(Long id, String fullName, Long yearOfbirth, Long age, Long zipCode, String town, String country){
        super(id, fullName, yearOfbirth, zipCode);
        this.age = age;
        this.town = town;
        this.country = country;
    }
}
