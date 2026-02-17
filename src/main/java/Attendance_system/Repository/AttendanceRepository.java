package Attendance_system.Repository;

import Attendance_system.Entity.Attendance;
import Attendance_system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

    List<Attendance> findByStudent(Student student);

    List<Attendance> findByStudentAndDate(Student student, LocalDate date);
}
