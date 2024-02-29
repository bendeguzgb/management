package hu.bendeguz.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "person_seq", allocationSize = 1)
    private Long id;

    private String fullName;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Address permanentAddress;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Address temporaryAddress;
}
