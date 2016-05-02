import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException{
		Extractor extractor = new Extractor(args);
		
		String[] input = new String[18];
		input[0] = extractor.GridName;
		input[1] = extractor.Umach;
		input[2] = extractor.AOA;
		input[3] = extractor.RE;
		input[4] = extractor.IVISC;
		input[5] = extractor.rho_inf;
		input[6] = extractor.t_inf;
		input[7] = extractor.p_inf;
		input[8] = extractor.t_wall;
		input[9] = extractor.intensity;
		input[10] = extractor.f_func;
		input[11] = extractor.f_order;
		input[12] = extractor.liminter;	
		input[13] = extractor.Cl;
		input[14] = extractor.Cdt;
		input[15] = extractor.Cdp;
		input[16] = extractor.Cdf;
		input[17] = extractor.Cm;
		
		MakeJSONDocument JSONdoc = new MakeJSONDocument(input);
		
	}
}
