package net.avi.yelave.repository;

import net.avi.yelave.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student,Long>
{
}
