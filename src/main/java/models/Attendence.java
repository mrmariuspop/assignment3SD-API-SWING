package models;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class Attendence implements Serializable {

	private Long attendenceId;
    private Long laboratoryId;

    public Attendence() {
    }

    public Attendence(Long attendenceId, Long laboratoryId) {
    	this.attendenceId = attendenceId;
        this.laboratoryId = laboratoryId;
    }

    
    public Long getAttendenceId() {
		return attendenceId;
	}

	public void setAttendenceId(Long attendenceId) {
		this.attendenceId = attendenceId;
	}

	public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    @Override
    public String toString() {
        return "Attendence{" +
        		"id = " + attendenceId + '\''+
                "laboratoryId='" + laboratoryId + '\'' +
                '}';
    }
}
