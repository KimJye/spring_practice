package net.skhu.model;

import lombok.Data;

@Data
public class MySubject {
	String userId;//학번
	String takeYear;//수업 들은 년도
	String takeSemester;//수업 학기
	String subjectCode;// 수업 코드
	String subjectName;// 수업 이름
	String credit;//수업 학점
	String score;// 내가 얻은 학점
	String changeComplete;//change
	int id;//AI
	String completionDivision;//이수구분

	public MySubject(String userId, String takeYear, String takeSemester, String subjectCode, String subjectName,
			String credit, String score, String changeComplete, int id, String completionDivision) {
		super();
		this.userId = userId;
		this.takeYear = takeYear;
		this.takeSemester = takeSemester;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
		this.score = score;
		this.changeComplete = changeComplete;
		this.id = id;
		this.completionDivision = completionDivision;
	}

	//엑셀업로드
	public MySubject(String takeYear, String takeSemester, String subjectCode, String subjectName,
			String completionDivision, String credit, String score, String userId) {
		this.takeYear = takeYear;
		this.takeSemester = takeSemester;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.completionDivision = completionDivision;
		this.credit = credit;
		this.score = score;
		this.userId = userId;
	}


}
