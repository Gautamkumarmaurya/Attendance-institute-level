package Attendance_system.Repository;

import Attendance_system.Entity.ApprovalHistory;
import Attendance_system.Entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprovalRepository extends JpaRepository<ApprovalHistory, Long> {

    List<ApprovalHistory> findByLeaveRequest(LeaveRequest leaveRequest);

}
