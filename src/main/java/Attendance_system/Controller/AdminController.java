package Attendance_system.Controller;


import Attendance_system.Service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ApprovalService approvalService;

    @PreAuthorize("hasAnyRole('FACULTY','HOD','ADMIN')")
    @PutMapping("/approve/{leaveId}")
    public String approveLeave(
            @PathVariable Long leaveId,
            @RequestParam Long approverUserId,
            @RequestParam String action,
            @RequestParam(required = false) String remarks) {

        return approvalService.approveLeave(
                leaveId,
                approverUserId,
                action,
                remarks
        );
    }


}
