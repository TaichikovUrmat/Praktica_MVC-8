package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    String save(Long companyID, Course course);

    Course findCourseById(Long id);
    String update(Long id, Course course);

    List<Course> findAllCourse();
    void  delete(Long id);
}
