package Attendance_system.Service;

import Attendance_system.DTO.Leave.LeaveRequestDTO;
import Attendance_system.Entity.LeaveRequest;
import Attendance_system.Entity.Student;
import Attendance_system.Repository.LeaveRequestRepository;
import Attendance_system.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRepository;
    private final StudentRepository studentRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRepository, StudentRepository studentRepository) {
        this.leaveRepository = leaveRepository;
        this.studentRepository = studentRepository;
    }

    public String applyLeave(LeaveRequestDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        LeaveRequest leave = LeaveRequest.builder()
                .student(student)
                .reason(dto.getReason())
                .status("PENDING")
                .build();

        leaveRepository.save(leave);

        return "Leave Applied Successfully";
    }

    public List<LeaveRequest> getPendingLeaves() {
        return leaveRepository.findByStatus("PENDING");
    }


}
