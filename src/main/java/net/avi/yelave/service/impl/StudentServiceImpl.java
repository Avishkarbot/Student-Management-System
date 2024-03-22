package net.avi.yelave.service.impl;

import lombok.AllArgsConstructor;
import net.avi.yelave.dto.StudentDto;
import net.avi.yelave.entity.Student;
import net.avi.yelave.mapper.StudentMapper;
import net.avi.yelave.repository.StudentRespository;
import net.avi.yelave.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService
{
    private StudentRespository studentRespository;


    @Override
    public List<StudentDto> getAllStudents()
    {
        List<Student> students = studentRespository.findAll();
        List<StudentDto> studentDtos = students.stream().map((student)->StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto)
    {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRespository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId)
    {
        Student student = studentRespository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto)
    {
        studentRespository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long studentId)
    {
        studentRespository.deleteById(studentId);
    }
}
