package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Company {
    @Id
    @GeneratedValue(generator = "company_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "company_gen",
            sequenceName = "company_seq",
            allocationSize = 1,
            initialValue = 2
    )
    private Long id;
    private String name;
    private  String description;
    private  String address;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "company",
            fetch = FetchType.EAGER)
    private List<Course> courses;
}
