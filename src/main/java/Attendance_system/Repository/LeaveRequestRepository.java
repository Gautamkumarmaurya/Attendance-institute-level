package Attendance_system.Repository;

import Attendance_system.Entity.LeaveRequest;
import Attendance_system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByStudent(Student student);

    List<LeaveRequest> findByStatus(String status);
}
