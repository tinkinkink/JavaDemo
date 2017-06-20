package demo.spring_cxf;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;
@WebService
public interface HelloService {

	List<String> test1(String arg1,String arg2,String arg3);
	
	String test2(String from,String to);
	
	String test3(List<String> list);
	
	String test4(Map<String, String> map);
}
