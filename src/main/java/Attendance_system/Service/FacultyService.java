package Attendance_system.Service;

import Attendance_system.Entity.Faculty;
import Attendance_system.Entity.User;
import Attendance_system.Repository.FacultyRepository;
import Attendance_system.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final UserRepository userRepository;

    public FacultyService(FacultyRepository facultyRepository, UserRepository userRepository) {
        this.facultyRepository = facultyRepository;
        this.userRepository = userRepository;
    }

    public Faculty createFaculty(String name, String department,
                                 String designation, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Faculty faculty = Faculty.builder()
                .name(name)
                .department(department)
                .designation(designation)
                .user(user)
                .build();

        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }
}
