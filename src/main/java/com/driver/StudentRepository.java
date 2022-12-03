package com.driver;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class StudentRepository {


    Map<String, Student> students = new HashMap<>();
    Map<String, Teacher> teachers = new HashMap<>();
    Map<String, String> studentTeacherPair = new HashMap<>();

//    Adding new Student object in Map
    public void addStudentInDB(Student student){
        students.put(student.getName(), student);
    }

//    Adding new Teacher object in Map
    public void addTeacherInDB(Teacher teacher){
        teachers.put(teacher.getName(), teacher);
    }

//    Adding new Teacher-student pair in Map
    public void addStudentTeacherPairInDB(String studentName, String teacherName){
        studentTeacherPair.put(studentName, teacherName);
    }

//    get student object from student Name
    public Student getStudentObjectFromDB(String studentName){
        return students.get(studentName);
    }

//    get teacher object from student Name
    public Teacher getTeacherObjectFromDB(String teacherName){
        return teachers.get(teacherName);
    }

//    get list of student for a given teacher
    public List<String> getStudentListFromDB(String teacherName){
        List<String> studentList = new ArrayList<>();
        for(String student:studentTeacherPair.keySet()){
            if(studentTeacherPair.get(student).equals(teacherName)){
                studentList.add(student);
            }
        }

        return studentList;
    }

//    get list of all students from DB
    public List<String> getListOfAllStudentFromDB(){

        return new ArrayList<>(students.keySet());
    }

//    delete list of students for a given teacher
    public void deleteTeacherStudentPairFromDB(String teacherName){
        for(String studentName:studentTeacherPair.keySet()){
            if(studentTeacherPair.get(studentName).equals(teacherName)){
                students.remove(studentName);
                teachers.remove(teacherName);
                studentTeacherPair.remove(studentName);
            }
        }
    }

//    delete all the records of students and teachers
    public void deleteAllStudentTeacher(){
        for(String student: students.keySet()){
            students.remove(student);
        }
        for(String teacher: teachers.keySet()){
            students.remove(teacher);
        }

    }
}
