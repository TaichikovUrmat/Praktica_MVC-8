package peaksoft.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repo.CourseRepo;

import java.util.List;
import java.util.stream.Stream;


@Repository
@RequiredArgsConstructor
@Transactional
public class CourseRepository implements CourseRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public String save(Long companyID, Course course) {
        Company company = entityManager.find(Company.class, companyID);
        course.setCompany(company);
        company.getCourses().add(course);
        entityManager.persist(course);
        return "Course saved!";

    }

    @Override
    public Course findCourseById(Long id) {

//        return entityManager.createQuery("select c from Company c where c.id = ?1", Company.class)
//                .getParameter(1,id);
        return entityManager.find(Course.class, id);
    }

    @Override
    public String update(Long id, Course course) {
        return null;
    }

    @Override
    public List<Course> findAllCourse() {
        return null;
    }

    @Override
    public void delete(Long id) {
        System.out.println("COURSE " + entityManager.find(Course.class, id).getId());

//        entityManager.remove(entityManager.find(Course.class, id));
            entityManager.createQuery("DELETE FROM Course WHERE id = :courseId").setParameter("courseId",id).executeUpdate();
//        "DELETE FROM YourEntityName WHERE id = :courseId"


       
         


    }
}
