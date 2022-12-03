package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudentToDB(Student student){
        studentRepository.addStudentInDB(student);
    }

    public void addTeacherToDB(Teacher teacher){
        studentRepository.addTeacherInDB(teacher);
    }

    public void addStudentTeacherPairToDB(String studentName, String teacherName){
        studentRepository.addStudentTeacherPairInDB(studentName, teacherName);
    }

    public Student getStudentObject(String studentName){
        return studentRepository.getStudentObjectFromDB(studentName);
    }

    public Teacher getTeacherObject(String teacherName){
        return studentRepository.getTeacherObjectFromDB(teacherName);
    }

    public List<String> getListOfStudents(String teacherName){
        return new ArrayList<>(studentRepository.getStudentListFromDB(teacherName));
    }

    public List<String> getListOfAllStudents(){
        return new ArrayList<>(studentRepository.getListOfAllStudentFromDB());
    }

    public void deleteStudenTeacherPair(String teacherName){
        studentRepository.deleteTeacherStudentPairFromDB(teacherName);
    }

    public void deleteAllStudentTeacher(){
        studentRepository.deleteAllStudentTeacher();
    }
}
