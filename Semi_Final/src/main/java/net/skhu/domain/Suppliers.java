package net.skhu.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Suppliers {
	//공급자

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String company;//회사

	@Column(name="last_name")
	String lastName;//이름

	@Column(name="first_name")
	String firstName;//성

	@Column(name="email_address")
	String emailAddress;//이메일 주소

	@Column(name="job_title")
	String jobTitle;

	@Column(name="business_phone")
	String businessPhone;//회사 전화번호

	@Column(name="home_phone")
	String homePhone;// 집 전화번호

	@Column(name="mobile_phone")
	String mobilePhone;// 휴대폰 번호

	@Column(name="fax_number")
	String faxNumber;// fax 번호

	String address; //주소
	String city; //도시

	@Column(name="state_province")
	String stateProvince;//행정구역 단위

	@Column(name="zip_postal_code")
	String zipPostalCode;//우편번호

	@Column(name="country_region")
	String countryRegion;//나라

	@Column(name="web_page")
	String webPage;//웹주소

	String notes;//메모

	@Basic(fetch=FetchType.LAZY)
	@Lob
	byte[] attachments;//첨부파일

	@OneToMany(mappedBy="suppliers")
	List<PurchaseOrder> PurchaseOrders;

}
