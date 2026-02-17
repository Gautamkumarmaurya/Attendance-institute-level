package Attendance_system.Controller;

import Attendance_system.Entity.Faculty;
import Attendance_system.Service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Faculty createFaculty(
            @RequestParam String name,
            @RequestParam String department,
            @RequestParam String designation,
            @RequestParam Long userId) {

        return facultyService.createFaculty(name, department, designation, userId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FACULTY')")
    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        return facultyService.getFaculty(id);
    }
}
