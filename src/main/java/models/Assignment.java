package models;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class Assignment implements Serializable {

	private Long assignmentId;
    private String name;
    private String deadline;
    private String description;
    private Long laboratoryId;

    public Assignment() {
    }

    public Assignment(Long assignmentId, String name, String deadline, String description) {
        this.assignmentId = assignmentId;
    	this.name = name;
        this.deadline = deadline;
        this.description = description;
    }
    

    public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
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
        		"id = " + assignmentId + '\'' + 
                "name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
