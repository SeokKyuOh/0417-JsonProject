package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseMain {

	public static void main(String[] args) {
		//JSON�� �ڹ� ��ũ��Ʈ�� ǥ����̱� ������ �ڹٷ� �ű� ���� �ڹٿ� �°� �ٲ�����Ѵ�.
		//�Ʒ��� ���ڿ��� ��������� �׳� ���ڿ��� ��, �ƹ��� �ǹ̰� ���� �������ϻ��̴�.
		//������ ���Ŀ� JSON���� �νĽ��� ����غ���. �� �Ľ��غ���
		/*
		{
			"name" : "�̱࿭"
		}
		*/
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"name\" : \"���õ��\",");	
		sb.append("\"loc\" : \"����� ������ ���� 45-133\",");
		sb.append("\"menus\" : [");
		sb.append("{");
		sb.append("\"name\" : \"��ġ������\",");
		sb.append("\"price\" : 6000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" : \"���\",");
		sb.append("\"price\" : 8000");
		sb.append("},");
		sb.append("{");
		sb.append("\"name\" : \"������\",");
		sb.append("\"price\" : 6000");
		sb.append("}");
		sb.append("]");
		sb.append("}");
		
		//System.out.println(sb.toString());
		
		//���� ���ڿ��� �ڹپ� JSON���� ó���ϵ��� �ؼ��غ���
		//�� �۾��� ���ؼ��� JSON�� �����ϴ� ���α׷��� �ʿ��ϴ�. 
		//javaEE���� JSON�ļ��� ���ԵǾ� ���� �ʱ� ������ �ܺ��� ���̺귯���� �̿��غ���.
		
		JSONParser parser = new JSONParser();
		try {
			//�Ľ��� ������� ��ȯ����
			//�Ľ��� ���ĺ��ʹ� ���� json���ڿ��� ��ġ ��üó�� ����� �� �ִ�.
			JSONObject obj = (JSONObject)parser.parse(sb.toString());	//StringBuffer�̱� ������ toString�� ���� string������ �ٲ��ش�.
			String name = (String)obj.get("name");
			System.out.println(name);
			
			System.out.println((String)obj.get("loc"));
			
			
			//JSONǥ����� �迭�� ���, �� ��ȯ�Ǵ� ���� JSONArray�� ���� �� �ִ�.
			JSONArray array = (JSONArray)obj.get("menus");
			
			for(int i=0; i<array.size(); i++){
				JSONObject json= (JSONObject)array.get(i);		//get(index)�̱� ������ �ٷ� �迭�� ���� �־����. �̰� �ٽ� ������Ʈ������ �޴´�?
				System.out.println(json.get("name")+","+json.get("price"));
			}
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
	}
}
