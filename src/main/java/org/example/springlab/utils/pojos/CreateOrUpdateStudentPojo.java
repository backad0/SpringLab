package org.example.springlab.utils.pojos;

import lombok.*;
import org.example.springlab.enums.StudentStatus;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateStudentPojo {
    private String firstName;
    private String surname;
    private String secondName;
    private StudentStatus status;
    private long groupId;
}
