package demo.spring_cxf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import org.springframework.stereotype.Component;

@WebService
@Component
public class HelloServiceImpl implements HelloService {

	public List<String> test1(String arg1, String arg2, String arg3) {
		List<String> list = new ArrayList<String>();
		list.add(arg1);
		list.add(arg2);
		list.add(arg3);
		return list;
	}

	public String test2(String from, String to) {
		return from+":I miss u,"+to;
	}

	public String test3(List<String> list) {
		String result = "";
		if(list!=null){
			for(String str:list){
				result += str;
			}	
		}else{
			return "";
		}
		return result;
	}

	public String test4(Map<String,String > map) {
		if(map!=null){
			String result = map.toString();
			return result;
		}else{			
			return "";
		}
	}

}
