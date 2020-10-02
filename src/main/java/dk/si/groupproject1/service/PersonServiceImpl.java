package dk.si.groupproject1.service;

import dk.si.groupproject1.rest.domain.PersonDetails;
import dk.si.groupproject1.rest.domain.PersonSummary;
import dk.si.groupproject1.rest.model.Person;
import dk.si.groupproject1.rest.repository.PersonRepository;
import dk.si.groupproject1.rmi.Methods;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository repo;

    Person findPersonById(long id){
        Person p = null;

        Optional<Person> personOptional = repo.findById(id);
        if(personOptional.isPresent()){
            p = personOptional.get();
        } else {
            System.out.println("TEST ERROR");
        }

        return p;
    }

    @Override
    public long calculateAge(long yearOfBirth) throws Exception{
        // name =  rmi:// + ServerIP +  /EngineName;
        String remoteEngine = "rmi://localhost/CalculationService";

        // Create local stub, lookup in the registry searching for the remote engine - the interface with the methods we want to use remotely
        Methods obj = (Methods) Naming.lookup(remoteEngine);

        return obj.calculateYourAge(yearOfBirth);
    }

    @Override
    public PersonSummary summaryOfPerson(long id) {

        Person p = findPersonById(id);

        PersonSummary summaryOfPerson = new PersonSummary(
                p.getId(),
                p.getFullName(),
                p.getYearOfBirth(),
                p.getZipCode()
        );
        return summaryOfPerson;
    }

    @Override
    public List<PersonSummary> summaryOfPersons() {
        ArrayList<PersonSummary> summaryOfPersons = new ArrayList();

        for (Person p : repo.findAll()){
            summaryOfPersons.add(
                    new PersonSummary(
                            p.getId(),
                            p.getFullName(),
                            p.getYearOfBirth(),
                            p.getZipCode()
                    )
            );
        }

        return summaryOfPersons;
    }

    @Override
    public PersonDetails detailsOfPerson(long id) throws Exception {
        Person p = findPersonById(id);

        PersonDetails detailsOfPerson = new PersonDetails(
                p.getId(),
                p.getFullName(),
                p.getYearOfBirth(),
                p.getAge(),
                p.getZipCode(),
                p.getTown(),
                p.getCountry()
        );
        return detailsOfPerson;
    }

    @Override
    public PersonDetails createPerson(Person p) throws Exception {
        p.setAge(calculateAge(p.getYearOfBirth()));
        Person savedEntity = repo.save(p);
        PersonDetails detailsOfPerson = new PersonDetails(
                savedEntity.getId(),
                savedEntity.getFullName(),
                savedEntity.getYearOfBirth(),
                savedEntity.getAge(),
                savedEntity.getZipCode(),
                savedEntity.getTown(),
                savedEntity.getCountry()
        );
        return detailsOfPerson;
    }
}
