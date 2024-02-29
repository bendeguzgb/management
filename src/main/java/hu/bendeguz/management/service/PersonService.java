package hu.bendeguz.management.service;

import hu.bendeguz.management.model.Person;
import hu.bendeguz.management.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        Person existingPerson = personRepository.findById(id).orElse(null);

        if (existingPerson == null) {
            return null;
        }

        existingPerson.setFullName(updatedPerson.getFullName());
        existingPerson.setPermanentAddress(updatedPerson.getPermanentAddress());
        existingPerson.setTemporaryAddress(updatedPerson.getTemporaryAddress());

        return personRepository.save(existingPerson);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
