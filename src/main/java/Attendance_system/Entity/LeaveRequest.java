package Attendance_system.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    private String status;   // // PENDING, FACULTY_APPROVED, HOD_APPROVED, REJECTED

    @ManyToOne
    private Student student;

}
