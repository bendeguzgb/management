package hu.bendeguz.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_generator")
    @SequenceGenerator(name = "contact_generator", sequenceName = "contact_seq", allocationSize = 1)
    private Long id;

    @Pattern(regexp = "^(.+)@(.+)\\.(.+)$")
    private String email;

    @Pattern(regexp = "[0-9]{8,15}")
    private String phoneNumber;
}

