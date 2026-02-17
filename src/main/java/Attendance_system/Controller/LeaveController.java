package Attendance_system.Controller;


import Attendance_system.DTO.Leave.LeaveRequestDTO;
import Attendance_system.Service.LeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
@RequiredArgsConstructor
public class LeaveController {


    private final LeaveRequestService leaveService;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/apply")
    public String applyLeave(@RequestBody LeaveRequestDTO dto) {
        return leaveService.applyLeave(dto);
    }

    @PreAuthorize("hasAnyRole('FACULTY','HOD','ADMIN')")
    @GetMapping("/pending")
    public Object getPendingLeaves() {
        return leaveService.getPendingLeaves();
    }
}
