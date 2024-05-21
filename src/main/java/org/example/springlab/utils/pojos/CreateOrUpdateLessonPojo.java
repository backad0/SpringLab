package org.example.springlab.utils.pojos;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateLessonPojo {
    private Date date;
    private Time time;
    private long teacherId;
    private long groupId;
    private long subjectId;
}
