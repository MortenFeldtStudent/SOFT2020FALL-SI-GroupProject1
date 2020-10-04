package dk.si.groupproject1.rest.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSummary extends PersonIdentifier{
    private String fullName;
    private Long yearOfBirth;
    private Long zipCode;

    public PersonSummary(Long id, String fullName, Long yearOfBirth, Long zipCode){
        super(id);
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.zipCode = zipCode;
    }


}
