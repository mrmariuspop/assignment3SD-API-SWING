package models;

import java.util.Date;

public class Submission {

	private Long submissionId;
	private Long student;
    private Long assignment;
    private String date;
    private Long grade;
    
    public Submission() {}
    
	public Submission(Long submissionId, Long student, Long assignment, String date, Long grade) {
		super();
		this.submissionId = submissionId;
		this.student = student;
		this.assignment = assignment;
		this.date = date;
		this.grade = grade;
	}

	public Long getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Long submissionId) {
		this.submissionId = submissionId;
	}

	public Long getStudent() {
		return student;
	}

	public void setStudent(Long student) {
		this.student = student;
	}

	public Long getAssignment() {
		return assignment;
	}

	public void setAssignment(Long assignment) {
		this.assignment = assignment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}
    
	@Override
    public String toString() {
        return "Submission{" +
                "submissionUid=" + submissionId +
                ", student='" + student + '\'' +
                ", assignment='" + assignment + '\'' +
                ", date='" + date + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
    
}
