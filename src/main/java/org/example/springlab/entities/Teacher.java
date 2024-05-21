package org.example.springlab.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Min(1)
    private long id;

    @Size(min = 3, max = 32)
    private String firstName;

    @Size(min = 3, max = 32)
    private String surname;

    @Size(min = 3, max = 32)
    private String secondName;
}
