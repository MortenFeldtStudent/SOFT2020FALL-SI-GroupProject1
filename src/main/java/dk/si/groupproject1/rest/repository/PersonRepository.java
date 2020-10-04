package dk.si.groupproject1.rest.repository;

import dk.si.groupproject1.rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
