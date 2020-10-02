package dk.si.groupproject1.rest.repository;

import dk.si.groupproject1.rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //No methods here, but still access to all build-in methods (findAll() - save() - etc..)
}
