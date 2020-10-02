package dk.si.groupproject1.service;

import dk.si.groupproject1.rest.domain.PersonDetails;
import dk.si.groupproject1.rest.domain.PersonSummary;
import dk.si.groupproject1.rest.model.Person;

import java.util.List;

public interface PersonService {
    long calculateAge(long yearOfBirth) throws Exception;
    PersonSummary summaryOfPerson(long id);
    List<PersonSummary> summaryOfPersons();
    PersonDetails detailsOfPerson(long id) throws Exception;
    PersonDetails createPerson(Person p) throws Exception;
}
