package dynamicClientTest;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import demo.spring_cxf.HelloService;
import demo.spring_cxf.Test4.Arg0;

public class DynamicClient {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/spring_cxf/ws/soap/hello?wsdl");
			QName serviceName = new QName("http://spring_cxf.demo/","HelloServiceImplService");
			QName portName = new QName("http://spring_cxf.demo/","HelloServiceImplPort");
			//����������
			Service service = Service.create(url,serviceName);
			//��ȡʵ��
			HelloService helloService = service.getPort(portName,HelloService.class);
			List<String> list = new ArrayList<String>();
			list.add("1");
			list.add("2");
			list.add("3");
			System.out.println(helloService.test3(list));
			Map<String, String> map = new HashMap<String, String>();
			map.put("1", "2");
			map.put("2", "2");
			map.put("3", "2");
			//���Ӷ�������û�ҵ����η���
			helloService.test4((Arg0) map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
