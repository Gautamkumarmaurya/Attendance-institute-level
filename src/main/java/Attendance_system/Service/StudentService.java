package Attendance_system.Service;

import Attendance_system.DTO.Student.StudentRequestDTO;
import Attendance_system.Entity.Student;
import Attendance_system.Entity.User;
import Attendance_system.Repository.StudentRepository;
import Attendance_system.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public Student createStudent(StudentRequestDTO dto){

        User user = userRepository.findById(dto.getUserId()).orElseThrow(()->new RuntimeException("User not found"));

        Student student = Student.builder()
                .name(dto.getName())
                .user(user)
                .build();

        return studentRepository.save(student);
    }


    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
