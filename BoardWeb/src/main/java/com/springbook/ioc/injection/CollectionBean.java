package com.springbook.ioc.injection;

import java.util.List;
import java.util.Set;//Set Ÿ�� ���� - �ߺ� ���� ������� �ʴ� ���� ��ü ����� ��
import java.util.Map;//Ư�� key�� �����͸� ����ϰ� ����Ҷ�
import java.util.Properties;//key=value ������ �����͸� ����ϰ� ����� ��
public class CollectionBean {
	private List<String> addressList;
	
	//private Map<String, Controller> addressList; - Map Ÿ�� ����
	//private Properties addressList; - Properties Ÿ�� ����
	public void setAddressList(List<String> addressList) {
		this.addressList=addressList;
	}
	
	public List<String> getAddressList(){
		return addressList;
	}
}
