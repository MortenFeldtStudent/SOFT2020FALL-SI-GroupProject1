package dk.si.groupproject1.rest.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private long yearOfBirth;
    private long age;
    private long zipCode;
    private String town;
    private String country;
}
