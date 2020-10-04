package dk.si.groupproject1.service;

import dk.si.groupproject1.exceptions.PersonNotFoundException;
import dk.si.groupproject1.rest.domain.*;
import dk.si.groupproject1.rest.model.Person;
import dk.si.groupproject1.rest.repository.PersonRepository;
import dk.si.groupproject1.rmi.Methods;
import dk.si.groupproject1.soap.consume.TownClient;
import localhost._8080.GetTownResponse;
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

    @Autowired
    TownClient townClient;

    Person findPersonById(long id) throws PersonNotFoundException{
        Person p = null;

        Optional<Person> personOptional = repo.findById(id);
        if(personOptional.isPresent()){
            p = personOptional.get();
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
    public TownAndCity townAndCityForPerson(long zipCode) {

        //TownClient townClient = new TownClient();
        GetTownResponse getTownResponse = townClient.getTown((int) zipCode);
        return new TownAndCity(
                getTownResponse.getTown().getName(),
                getTownResponse.getTown().getCountry()
        );
    }

    @Override
    public PersonSummary summaryOfPerson(long id) throws PersonNotFoundException {

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
        TownAndCity townAndCity = townAndCityForPerson(p.getZipCode());

        PersonDetails detailsOfPerson = new PersonDetails(
                p.getId(),
                p.getFullName(),
                p.getYearOfBirth(),
                calculateAge(p.getYearOfBirth()),
                p.getZipCode(),
                townAndCity.getTown(),
                townAndCity.getCountry()
        );
        return detailsOfPerson;
    }

    @Override
    public String createPerson(CreatePerson p) {
        Person newEntity = new Person();
        newEntity.setFullName(p.getFullName());
        newEntity.setYearOfBirth(p.getYearOfBirth());
        newEntity.setZipCode(p.getZipCode());
        Person savedEntity = repo.save(newEntity);
        return "Record saved with ID: " + savedEntity.getId();
    }

    @Override
    public PersonSummary updatePerson(UpdatePerson p, long id) {
        Person updateEntity = new Person(
                id,
                p.getFullName(),
                p.getYearOfBirth(),
                p.getZipCode()
        );
        Person savedEntity = repo.save(updateEntity);
        PersonSummary summaryOfUpdatedPerson = new PersonSummary(
                savedEntity.getId(),
                savedEntity.getFullName(),
                savedEntity.getYearOfBirth(),
                savedEntity.getZipCode()
        );
        return summaryOfUpdatedPerson;
    }

    @Override
    public String deletePerson(long id) {
        repo.deleteById(id);
        return "Record deleted with ID: " + id;
    }


}
