import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class MakeJSONDocument {

	private static String simulator_value = null;
	private static String gridname_value = null;
	private static String Umach_value = null;
	private static String AOA_value = null;
	private static String RE_value = null;
	private static String IVISC_value = null;
	private static String rho_inf_value = null;
	private static String t_inf_value = null;
	private static String p_inf_value = null;
	private static String t_wall_value = null;
	private static String Intensity_value = null;
	private static String f_func_value = null;
	private static String f_order_value = null;
	private static String liminter_value = null;
	private static String Cl_value = null;
	private static String Cdt_value = null;
	private static String Cdp_value = null;
	private static String Cdf_value = null;
	private static String Cm_value = null;
	
	
	public MakeJSONDocument(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("simulator", "KFLOW");

		JSONObject input = new JSONObject();
		input.put("Grid", args[0]);
		input.put("Umach", args[1]);
		input.put("AOA", args[2]);
		input.put("RE", args[3]);
		input.put("IVISC", args[4]);

		input.put("rho_inf", args[5]);
		input.put("t_inf", args[6]);
		input.put("p_inf", args[7]);
		input.put("t_wall", args[8]);
		input.put("intensity", args[9]);
		input.put("f_func", args[10]);
		input.put("f_order", args[11]);
		input.put("liminter", args[12]);

		obj.put("input", input);

		JSONObject output = new JSONObject();
		JSONObject aerodynamic = new JSONObject();

		aerodynamic.put("Cl", args[13]);
		aerodynamic.put("Cdt", args[14]);
		aerodynamic.put("Cdp", args[15]);
		aerodynamic.put("Cdf", args[16]);
		aerodynamic.put("Cm", args[17]);

		output.put("aerodynamic", aerodynamic);
		obj.put("output", output);

		try {
			FileWriter file = new FileWriter("result.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(obj);

		JSONParser parser = new JSONParser();

		try {
			Object obj2 = parser
					.parse(new FileReader(
							"C:\\Users\\SeonJeong\\Desktop\\Coding\\Test1\\src\\result.json"));

			JSONObject object = (JSONObject) obj2;

			simulator_value = object.get("simulator").toString();

			JSONObject input2 = (JSONObject) object.get("input");
			gridname_value = input2.get("Grid").toString();
			Umach_value = input2.get("Umach").toString();
			AOA_value = input2.get("AOA").toString();
			RE_value = input2.get("RE").toString();
			IVISC_value = input2.get("IVISC").toString();
			rho_inf_value = input2.get("rho_inf").toString();
			t_inf_value = input2.get("t_inf").toString();
			p_inf_value = input2.get("p_inf").toString();
			t_wall_value = input2.get("t_wall").toString();
			Intensity_value = input2.get("intensity").toString();
			f_func_value = input2.get("f_func").toString();
			f_order_value = input2.get("f_order").toString();
			liminter_value = input2.get("liminter").toString();

			JSONObject output2 = (JSONObject) object.get("output");
			JSONObject aerodynamic2 = (JSONObject) output2.get("aerodynamic");
			Cl_value = aerodynamic2.get("Cl").toString();
			Cdt_value = aerodynamic2.get("Cdt").toString();
			Cdp_value = aerodynamic2.get("Cdp").toString();
			Cdf_value = aerodynamic2.get("Cdf").toString();
			Cm_value = aerodynamic2.get("Cm").toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// mongoDB insert
		MongoClient mongoClient = null;

		try {
			mongoClient = new MongoClient("localhost", 27017);
			System.out.println("connect success");

			// write permission
			WriteConcern w = new WriteConcern(1, 2000);
			mongoClient.setWriteConcern(w);

			// db connect
			DB db = mongoClient.getDB("test");

			// collection bring
			DBCollection coll = db.getCollection("testDB1");

			// data insert in testDB1 table
			DBObject doc_all = new BasicDBObject();

			DBObject doc_input = new BasicDBObject();
			doc_input.put("Grid", gridname_value);
			doc_input.put("Umach", Umach_value);
			doc_input.put("AOA", AOA_value);
			doc_input.put("RE", RE_value);
			doc_input.put("IVISC", IVISC_value);
			doc_input.put("rho_inf", rho_inf_value);
			doc_input.put("t_inf", t_inf_value);
			doc_input.put("p_inf", p_inf_value);
			doc_input.put("t_wall", t_wall_value);
			doc_input.put("intensity", Intensity_value);
			doc_input.put("f_func", f_func_value);
			doc_input.put("f_order", f_order_value);
			doc_input.put("liminter", liminter_value);

			DBObject doc_output = new BasicDBObject();
			DBObject doc_aerodynamic = new BasicDBObject();
			doc_aerodynamic.put("Cl", Cl_value);
			doc_aerodynamic.put("Cdt", Cdt_value);
			doc_aerodynamic.put("Cdp", Cdp_value);
			doc_aerodynamic.put("Cdf", Cdf_value);
			doc_aerodynamic.put("Cm", Cm_value);
			doc_output.put("aerodynamic", doc_aerodynamic);

			doc_all.put("simulator", simulator_value);
			doc_all.put("input", doc_input);
			doc_all.put("output", doc_output);

			coll.insert(doc_all);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}