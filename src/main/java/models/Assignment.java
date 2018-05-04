package models;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class Assignment implements Serializable {

	private Long assigmentUid;
    private String name;
    private String deadline;
    private String description;
    private Long laboratoryId;

    public Assignment() {
    }

    public Assignment(Long assigmentUid, String name, String deadline, String description) {
        this.assigmentUid = assigmentUid;
    	this.name = name;
        this.deadline = deadline;
        this.description = description;
    }
    

    public Long getAssignmentUid() {
		return assigmentUid;
	}

	public void setAssignmentUid(Long assigmentUid) {
		this.assigmentUid = assigmentUid;
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
        		"id = " + assigmentUid + '\'' + 
                "name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
