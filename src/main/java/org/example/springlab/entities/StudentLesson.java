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
public class StudentLesson {

    @Min(1)
    private long id;

    @Min(1)
    private long studentId;

    @Min(1)
    private long lessonId;
}
