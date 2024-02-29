package hu.bendeguz.management.repository;

import hu.bendeguz.management.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
