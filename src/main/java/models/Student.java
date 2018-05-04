package models;

import java.util.HashSet;
import java.util.Set;

import Services.Tokenizer;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class Student  {

	private Long studentId;
    private String email;
    private String password;
    private String fullname;
    private Long grupa;
    private String hobby;
    private String token;
    private Set<Submission> assigmentStudent;
    private Set<Attendence> attendances=new HashSet<>();
    private Long studentUid;
    
    public Student() {
    }

    public Student(Long studentId, String email, String password, String fullname, Long grupa, String hobby,
			String token, Set<Submission> assigmentStudent, Set<Attendence> attendances, Long studentUid) {
		super();
		this.studentId = studentId;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.grupa = grupa;
		this.hobby = hobby;
		this.token = token;
		this.assigmentStudent = assigmentStudent;
		this.attendances = attendances;
		this.studentUid = studentUid;
	}

	public Set<Submission> getAssigmentStudent() {
		return assigmentStudent;
	}

	public void setAssigmentStudent(Set<Submission> assigmentStudent) {
		this.assigmentStudent = assigmentStudent;
	}

	public Set<Attendence> getAttendances() {
		return attendances;
	}

	public void setAttendances(Set<Attendence> attendances) {
		this.attendances = attendances;
	}

	public Long getStudentUid() {
		return studentUid;
	}

	public void setStudentUid(Long studentUid) {
		this.studentUid = studentUid;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getGrupa() {
        return grupa;
    }

    public void setGrupa(Long grupa) {
        this.grupa = grupa;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
        		"id = " + studentId + '\''+
                "email='" + email + '\'' +
                "password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", grupa='" + grupa + '\'' +
                ", hobby='" + hobby + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
