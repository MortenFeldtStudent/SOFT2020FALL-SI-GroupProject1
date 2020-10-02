package dk.si.groupproject1.rest.controller;

import dk.si.groupproject1.rest.domain.PersonDetails;
import dk.si.groupproject1.rest.domain.PersonSummary;
import dk.si.groupproject1.rest.model.Person;
import dk.si.groupproject1.rest.repository.PersonRepository;
import dk.si.groupproject1.service.PersonService;
import dk.si.groupproject1.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonRestController {

    @Autowired
    PersonService service;

    @GetMapping("/summary")
    public List<PersonSummary> retrieveAllPersonList()
    {
        return service.summaryOfPersons();
    }

    @GetMapping("/{id}/summary")
    public PersonSummary retrievePersonSummary(@PathVariable long id)
    {
        return service.summaryOfPerson(id);
    }

    @GetMapping("/{id}/details")
    public PersonDetails retrievePersonDetails(@PathVariable long id) throws Exception {
        return service.detailsOfPerson(id);
    }

    @PutMapping("/{id}")
    public PersonDetails editPerson(@RequestBody Person p, @PathVariable long id) throws Exception {
        return service.createPerson(p);
    }

}
