package hu.bendeguz.management.repository;

import hu.bendeguz.management.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
