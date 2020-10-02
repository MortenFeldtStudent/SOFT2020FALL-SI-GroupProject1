package dk.si.groupproject1.rest.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSummary extends PersonIdentifier{
    private String fullName;
    private Long yearOfBirth;
    private Long zipCode;

    //@Builder
    public PersonSummary(Long id, String fullName, Long yearOfBirth, Long zipCode){
        super(id);
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.zipCode = zipCode;
    }


}
