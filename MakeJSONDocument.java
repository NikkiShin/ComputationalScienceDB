package makeJSONDoc;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/* ver.1
public class MakeJSONDocument {
	
	public static void main(String[] args){
		JSONObject obj = new JSONObject();
		obj.put("simulator", "KFLOW");
		
		JSONArray input_list = new JSONArray();
		input_list.add(args[0]);
		input_list.add(args[1]);
		input_list.add(args[2]);
		input_list.add(args[3]);
		input_list.add(args[4]);
		
		obj.put("input", input_list);
		
		JSONArray output_list = new JSONArray();
		output_list.add(args[5]);
		output_list.add(args[6]);
		output_list.add(args[7]);
		output_list.add(args[8]);
		output_list.add(args[9]);
		
		obj.put("output", output_list);
		
		try{
			FileWriter file = new FileWriter("C:\\Users\\YeonJeong\\Downloads\\DKELab\\계산과학공학\\program\\output.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.print(obj);
	}
}
*/
public class MakeJSONDocument {
	
	public static void main(String[] args){
		JSONObject obj = new JSONObject();
		obj.put("simulator", "KFLOW");
		
		JSONObject input = new JSONObject();
		input.put("Grid", args[0]);
		input.put("Umach", args[1]);
		input.put("AOA", args[2]);
		input.put("RE", args[3]);
		input.put("IVISC", args[4]);
		
		obj.put("input", input);
		
		JSONObject output = new JSONObject();
		JSONObject aerodynamic = new JSONObject();
		
		aerodynamic.put("Cl", args[5]);
		aerodynamic.put("Cdt", args[6]);
		aerodynamic.put("Cdp", args[7]);
		aerodynamic.put("Cdf", args[8]);
		aerodynamic.put("Cm", args[9]);
		
		output.put("aerodynamic", aerodynamic);
		obj.put("output", output);
		
		try{
			FileWriter file = new FileWriter("C:\\Users\\YeonJeong\\Downloads\\DKELab\\계산과학공학\\program\\output.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.print(obj);
	}
}