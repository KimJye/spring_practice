
var params;
function getXMLHttpRequest() {        //  XMLHttpRequest ��ü�� ������ �ִ� getXMLHttpRequest() �Լ�
      if (window.ActiveXObject) {
               try {
                      return new ActiveXObject("Xsxml2.XMLHTTP");
               } catch(e) {
                      try {
                             return new ActiveXObject("Microsoft.XMLHTTP");
                       } catch(e1) { return null; }
                  }
              } else if (window.XMLHttpRequest) {
                     return new XMLHttpRequest();
              } else {
                     return null;
              }
       }
var httpRequest = null; // ������ XMLHttpRequest ��ü�� ������ ��������
// XMLHttpRequest ��ü�� ����ؼ� ������ ���(GET, POST), ������ URL, ÷���� �Ķ���� ���� ����Ͽ� �� ������ ��û�� ����
function sendRequest(url, params, callback, method) {
    httpRequest = getXMLHttpRequest();
    var httpMethod = method ? method : 'GET';
    if (httpMethod != 'GET' && httpMethod != 'POST') {
          httpMethod = 'GET';
    }
    var httpParams = (params == null || params == '') ? null : params;
    var httpUrl = url;
    if (httpMethod == 'GET' && httpParams != null) { // HTTP ��û����� 'GET'�̸�
          httpUrl = httpUrl + "?" + httpParams;                      // URL �ڿ� �Ķ���͸� ����
    }
 httpRequest.open(httpMethod, httpUrl, true); // �����Ŀ��� ������ �� ���̰� �߻��ϹǷ�, ũ�ν� �������� ���� �׻� �񵿱������ XMLHttpRequest ��ü ���
	
 // �� ������ ������ ����Ʈ Ÿ�� ����
 httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 	
 httpRequest.onreadystatechange = callback; // readyState ���� �ٲ� �� ȣ��� �ݹ��Լ� ����

 // HTTP ��û����� 'POST'�̸� send() �Լ��� ���� �Ķ���� ����
	 httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}
