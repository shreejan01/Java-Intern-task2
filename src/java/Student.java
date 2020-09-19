
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Shreejan Lohar
 */

@ManagedBean(name="obj")
@SessionScoped
public class Student implements Serializable{
   
    private String firstName;
    private String middleName;
    private String lastName;
    private String faculty;
    private String program;
    
    private Map<String,Map<String,String>> data = new HashMap<>();
    
    private Map<String,String> facultyList;
    private Map<String,String> programList;
    
    private ArrayList<Student> studentList;
    
    public Student() {    
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }
  
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getFaculty() {
        return faculty;
    }

   
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getProgram() {
        return program;
    }

 
    public void setProgram(String program) {
        this.program = program;
    }


    public Map<String,Map<String,String>> getData() {
        return data;
    }

 
    public void setData(Map<String,Map<String,String>> data) {
        this.data = data;
    }

    public Map<String,String> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(Map<String,String> facultyList) {
        this.facultyList = facultyList;
    }

    public Map<String,String> getProgramList() {
        return programList;
    }

    public void setProgramList(Map<String,String> programList) {
        this.programList = programList;
    }
  
       public ArrayList<Student> getStudentList() {
        return studentList;
    }

  
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    
    @PostConstruct
    public void init() {
        
        studentList = new ArrayList<>();
        
        facultyList = new HashMap<>();
        facultyList.put("Management", "Management");
        facultyList.put("Science And Technology", "Science And Technology");
         
        Map<String,String> map = new HashMap<>();
        map.put("BBA", "BBA");
        map.put("BBS", "BBS");
        data.put("Management", map);
         
        map = new HashMap<>();
        map.put("BE Comp", "BE Comp");
        map.put("BCA", "BCA");
        data.put("Science And Technology", map);
    }
   
    public void onFacultyChange() {
       if(faculty !=null && !faculty.equals(""))
            programList = data.get(faculty);
        else
            programList= new HashMap<>();
    }
  
    public void save() {
        
           Student student = new Student();
   
              student.setFirstName(firstName);
              student.setMiddleName(middleName);
               student.setLastName(lastName);
               student.setFaculty(faculty);
               student.setProgram(program);
                studentList.add(student);  
   }
    
    public void delete(Student student) {   
          studentList.remove(student);
     }
 
   public void update(Student student) {
       firstName = student.firstName;
       middleName = student.middleName;
       lastName = student.lastName;
       faculty = student.faculty;
       program = student.program;
       delete(student);
   } 
    
    
}

