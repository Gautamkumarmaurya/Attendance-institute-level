package Attendance_system.Service;

import Attendance_system.Entity.ApprovalHistory;
import Attendance_system.Entity.LeaveRequest;
import Attendance_system.Entity.User;
import Attendance_system.Repository.ApprovalRepository;
import Attendance_system.Repository.LeaveRequestRepository;
import Attendance_system.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final UserRepository userRepository;
    private final LeaveRequestRepository leaveRepository;

    public ApprovalService(ApprovalRepository approvalRepository, UserRepository userRepository, LeaveRequestRepository leaveRepository) {
        this.approvalRepository = approvalRepository;
        this.userRepository = userRepository;
        this.leaveRepository = leaveRepository;
    }

    public String approveLeave(Long leaveId, Long approverUserId, String action, String remarks) {

        LeaveRequest leave = leaveRepository.findById(leaveId).orElseThrow(() -> new RuntimeException("Leave not found"));

        User approver = userRepository.findById(approverUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String role = approver.getRole();

        if (action.equalsIgnoreCase("REJECTED")) {
            leave.setStatus("REJECTED");
        } else {

            switch (role) {
                case "FACULTY":
                    leave.setStatus("FACULTY_APPROVED");
                    break;
                case "HOD":
                    leave.setStatus("HOD_APPROVED");
                    break;
                case "ADMIN":
                    leave.setStatus("FINAL_APPROVED");
                    break;
                default:
                    throw new RuntimeException("Invalid Role");
            }
        }

        leaveRepository.save(leave);

        ApprovalHistory history = ApprovalHistory.builder()
                .leaveRequest(leave)
                .approvedBy(approver)
                .approvedByRole(role)
                .action(action)
                .remarks(remarks)
                .actionTime(LocalDateTime.now())
                .build();

        approvalRepository.save(history);

        return "Leave Updated to: " + leave.getStatus();
    }


}
