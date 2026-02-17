package Attendance_system.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApprovalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String approvedByRole;   // FACULTY / HOD / ADMIN

    private String action;           // APPROVED / REJECTED

    private String remarks;

    private LocalDateTime actionTime;

    @ManyToOne
    @JoinColumn(name = "leave_id", nullable = false)
    private LeaveRequest leaveRequest;

    @ManyToOne
    @JoinColumn(name = "approved_by_user_id", nullable = false)
    private User approvedBy;
}
