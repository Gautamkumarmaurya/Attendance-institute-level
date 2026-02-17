package Attendance_system.Controller;

import Attendance_system.DTO.Attendance.AttendanceRequestDTO;
import Attendance_system.DTO.Student.StudentRequestDTO;
import Attendance_system.Entity.Student;
import Attendance_system.Service.AttendanceService;
import Attendance_system.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PreAuthorize("hasRole('FACULTY')")
    @PostMapping("/mark")
    public String markAttendance(@RequestBody AttendanceRequestDTO dto) {
        return attendanceService.markAttendance(dto);
    }

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @GetMapping("/percentage/{studentId}")
    public double getAttendancePercentage(@PathVariable Long studentId) {
        return attendanceService.calculateAttendancePercentage(studentId);
    }
}
