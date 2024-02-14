package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Course {
    @Id
    @GeneratedValue(generator = "courses_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "courses_gen",
            sequenceName = "course_seq",
            allocationSize = 1,
            initialValue = 2

    )

    public Long id;
    private  String courseName;
    @Column(length = 500)
    private  String description;
    @Column(length = 1000,name = "image_link")
    private String  imageLink;
    private int prise;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Company company;
}
