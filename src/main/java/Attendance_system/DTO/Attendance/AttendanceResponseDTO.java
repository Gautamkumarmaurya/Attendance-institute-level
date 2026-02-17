package Attendance_system.DTO.Attendance;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AttendanceResponseDTO {

    private Long studentId;
    private String studentName;
    private LocalDate date;
    private String status;
}
