package net.skhu.dto;

public class Professor {
	int id;
	int departmentId;
	String ProfessorName;
	String departmentName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



}
