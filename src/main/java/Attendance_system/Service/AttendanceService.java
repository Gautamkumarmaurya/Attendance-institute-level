package Attendance_system.Service;

import Attendance_system.DTO.Attendance.AttendanceRequestDTO;
import Attendance_system.Entity.Attendance;
import Attendance_system.Entity.Student;
import Attendance_system.Repository.AttendanceRepository;
import Attendance_system.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }

    public String markAttendance(AttendanceRequestDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Attendance attendance = Attendance.builder()
                .student(student)
                .date(LocalDate.now())
                .status(dto.getStatus())
                .build();

        attendanceRepository.save(attendance);

        return "Attendance Marked Successfully";
    }

    public double calculateAttendancePercentage(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Attendance> records = attendanceRepository.findByStudent(student);

        long presentCount = records.stream()
                .filter(a -> a.getStatus().equalsIgnoreCase("PRESENT"))
                .count();

        return records.isEmpty() ? 0 :
                (presentCount * 100.0) / records.size();
    }
}
