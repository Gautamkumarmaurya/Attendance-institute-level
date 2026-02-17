package Attendance_system.DTO.Attendance;

import lombok.Data;

@Data
public class AttendanceRequestDTO {

    private Long studentId;
    private String status; // PRESENT / ABSENT
}
