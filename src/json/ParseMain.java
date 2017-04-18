package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseMain {

	public static void main(String[] args) {
		//JSON은 자바 스크립트의 표기법이기 때문에 자바로 옮길 때는 자바에 맞게 바꿔줘야한다.
		//아래의 문자열은 현재까지는 그냥 문자열일 뿐, 아무런 의미가 없는 데이터일뿐이다.
		//하지만 추후에 JSON으로 인식시켜 사용해보자. 즉 파싱해보자
		/*
		{
			"name" : "이긍열"
		}
		*/
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"name\" : \"김밥천국\",");	
		sb.append("\"loc\" : \"서울시 마포구 연희동 45-133\",");
		sb.append("\"menus\" : [");
		sb.append("{");
		sb.append("\"name\" : \"김치볶음밥\",");
		sb.append("\"price\" : 6000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" : \"돈까스\",");
		sb.append("\"price\" : 8000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" : \"떡볶이\",");
		sb.append("\"price\" : 6000");
		sb.append("}");
		sb.append("]");
		sb.append("}");
		
		//System.out.println(sb.toString());
		
		//위의 문자열을 자바언어가 JSON으로 처리하도록 해석해보자
		//이 작업을 위해서는 JSON을 이해하는 프로그램이 필요하다. 
		//javaEE에는 JSON파서가 포함되어 있지 않기 때문에 외부의 라이브러리를 이용해본다.
		
		JSONParser parser = new JSONParser();
		try {
			//파싱한 결과물을 반환받자
			//파싱한 이후부터는 위의 json문자열을 마치 객체처럼 사용할 수 있다.
			JSONObject obj = (JSONObject)parser.parse(sb.toString());	//StringBuffer이기 때문에 toString을 통해 string형으로 바꿔준다.
			String name = (String)obj.get("name");
			System.out.println(name);
			
			System.out.println((String)obj.get("loc"));
			
			
			//JSON표기법이 배열일 경우, 그 반환되는 값을 JSONArray로 받을 수 있다.
			JSONArray array = (JSONArray)obj.get("menus");
			
			for(int i=0; i<array.size(); i++){
				JSONObject json= (JSONObject)array.get(i);		//get(index)이기 때문에 바로 배열의 열을 넣어버림. 이걸 다시 오브젝트형으로 받는다?
				System.out.println(json.get("name")+","+json.get("price"));
			}
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
	}
}
