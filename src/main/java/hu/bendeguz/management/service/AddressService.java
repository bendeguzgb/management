package hu.bendeguz.management.service;

import hu.bendeguz.management.model.Address;
import hu.bendeguz.management.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        Address existingAddress = addressRepository.findById(id).orElse(null);

        if (existingAddress == null) {
            return null;
        }

        existingAddress.setTown(updatedAddress.getTown());
        existingAddress.setStreet(updatedAddress.getStreet());
        existingAddress.setHouseNumber(updatedAddress.getHouseNumber());
        existingAddress.setContacts(updatedAddress.getContacts());

        return addressRepository.save(existingAddress);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
