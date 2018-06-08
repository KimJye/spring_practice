package com.springbook.ioc.injection;

import java.util.List;
import java.util.Set;//Set 타입 매핑 - 중복 값을 허용하지 않는 집합 객체 사용할 때
import java.util.Map;//특정 key로 데이터를 등록하고 사용할때
import java.util.Properties;//key=value 형태의 데이터를 등록하고 사용할 때
public class CollectionBean {
	private List<String> addressList;
	
	//private Map<String, Controller> addressList; - Map 타입 매핑
	//private Properties addressList; - Properties 타입 매핑
	public void setAddressList(List<String> addressList) {
		this.addressList=addressList;
	}
	
	public List<String> getAddressList(){
		return addressList;
	}
}
