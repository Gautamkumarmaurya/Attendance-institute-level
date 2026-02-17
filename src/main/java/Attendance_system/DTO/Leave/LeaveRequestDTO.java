package Attendance_system.DTO.Leave;

import lombok.Data;

@Data
public class LeaveRequestDTO {

    private Long studentId;
    private String reason;
}
