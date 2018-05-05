package models;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class Assignment implements Serializable {

	private Long assignmentUid;
    private String name;
    private String deadline;
    private String description;
    private Long laboratoryId;

    public Assignment() {
    }

    public Assignment(Long assignmentUid, String name, String deadline, String description) {
        this.assignmentUid = assignmentUid;
    	this.name = name;
        this.deadline = deadline;
        this.description = description;
    }
    

    public Long getAssignmentUid() {
		return assignmentUid;
	}

	public void setAssignmentUid(Long assignmentUid) {
		this.assignmentUid = assignmentUid;
	}

	public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Assigment{" +
        		"id = " + assignmentUid + '\'' + 
                "name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
