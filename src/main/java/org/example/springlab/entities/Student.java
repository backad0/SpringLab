package org.example.springlab.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.springlab.enums.StudentStatus;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Min(1)
    private long id;

    @Size(min = 3, max = 32)
    private String firstName;

    @Size(min = 3, max = 32)
    private String surname;

    @Size(min = 3, max = 32)
    private String secondName;

    @Size(min = 3, max = 32)
    private StudentStatus status;

    @Min(1)
    private long groupId;
}
