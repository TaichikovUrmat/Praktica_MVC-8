package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.service.CourseService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/new/{companyID}")
    public String addCourse(@PathVariable Long companyID, Model model) {
        model.addAttribute("companyID", companyID);
        model.addAttribute("newCourse", new Course());
        return "new-course";
    }
    @PostMapping("/save/{companyId}")
    public String saveCourse(@ModelAttribute("newCourse") Course course,
                             @PathVariable("companyId") Long companyId) {
        courseService.save(companyId,course);
        return "redirect:/companies";
    }
    @GetMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") Long courseId) {
       Long companyId = courseService.findCourseById(courseId).getCompany().getId();
        courseService.delete(courseId);
        return "redirect:/companies/find/" + companyId;
    }

//    @GetMapping("/find/{coursesId}")
//    public String getById(Model model,@PathVariable("coursesId") Long id){
//        Company company = courseService.findCourseById(id);
//        model.addAttribute("companyID", id);
//        model.addAttribute("companyInfo", company.getCourses());
//        return "companyInnerPage";
//    }

//    @GetMapping("/editCourse/{id}/{companyId}")
//    public String editCourse(Model model, @PathVariable("id") Long id,
//                             @PathVariable("companyId") Long companyId) {
//        model.addAttribute("course", courseService.getCourseById(id));
//        return "/courses/updateCourse";
//    }
//
//    @PostMapping("/{id}/{companyId}/updateCourse")
//    public String updateCourse(@PathVariable("id") Long id,
//                               @PathVariable("companyId") Long companyId,
//                               @ModelAttribute Course course) {
//        courseService.updateCourseById(id, course);
//        return "redirect:/allCourses/ " + companyId;
//    }
//

//
//    @PostMapping("/{courseId}/{companyId}/assignInstructor")
//    public String assignInstructorToCourse(@PathVariable("courseId")Long courseId,
//                                           @PathVariable("companyId")Long companyId,
//                                           @ModelAttribute("instructor")Instructor instructor){
//        instructorService.assignInstructorToCourse(instructor.getId(),courseId);
//        return "redirect:/allCourses/ "+companyId;
//    }





}
