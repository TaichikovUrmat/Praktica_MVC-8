package peaksoft.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.repo.CourseRepo;
import peaksoft.service.CourseService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    @Override
    public String save(Long companyID, Course course) {
        return courseRepo.save(companyID,course);
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepo.findCourseById(id);
    }

    @Override
    public String update(Long id, Course course) {
        return courseRepo.update(id,course);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepo.findAllCourse();
    }

    @Override
    public void delete(Long id) {
         courseRepo.delete(id);
    }
}
