package hu.bendeguz.management.service;

import hu.bendeguz.management.model.Contact;
import hu.bendeguz.management.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact updatedContact) {
        Contact existingContact = contactRepository.findById(id).orElse(null);

        if (existingContact == null) {
            return null;
        }

        existingContact.setEmail(updatedContact.getEmail());
        existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
        return contactRepository.save(existingContact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
