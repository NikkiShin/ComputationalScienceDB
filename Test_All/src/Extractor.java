import java.io.*;
import java.util.StringTokenizer;

public class Extractor {
	
	public String GridName;
	public String Umach;
	public String AOA;
	public String RE;
	public String IVISC;
	public String rho_inf;
	public String t_inf;
	public String p_inf;
	public String t_wall;
	public String intensity;
	public String f_func;
	public String f_order;
	public String liminter;
	public String Cl;
	public String Cdt;
	public String Cdp;
	public String Cdf;
	public String Cm;
	public String solfile;

	public Extractor(String[] args) throws IOException{
		if(args.length!=2){
			System.out.println("usage: java extractor *.inp *.dat");
		}
		for(int i=0; i<2; i++){
			BufferedReader in = new BufferedReader(new FileReader(args[i]));
			String line = "";
			int rownum = 0;
			int colnum = 0;
			String line2 = "";
			int rownum2 = 0;
			int colnum2 = 0;
			
			while ((line = in.readLine())!= null){
				rownum++;
				colnum=0;
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()){
					String str = st.nextToken();
					if(i == 0){
						if(rownum == 1 && colnum==0){
							GridName = str;
						}
						if(rownum ==4){
							if (colnum == 0){
								Umach = str;
							}else if(colnum ==1){
								AOA = str;
							}else if(colnum ==3){
								RE = str;
							}else if(colnum ==4){
								IVISC = str;
							}
						}
						if(rownum == 9 && colnum ==0){
							solfile = str;
							BufferedReader in2 = new BufferedReader(new FileReader(solfile));
							while ((line2 = in2.readLine())!= null){
								rownum2++;
								colnum2=0;
								StringTokenizer st2 = new StringTokenizer(line2);
								while(st2.hasMoreTokens()){
									String str2 = st2.nextToken();
									if(rownum2 == 6){
									if(colnum2 == 0){
										rho_inf = str2;
									}else if(colnum2 ==1){
										t_inf = str2;						
									}else if(colnum2 ==2){
										p_inf = str2;	
									}else if(colnum2 ==3){
										t_wall = str2;		
									}
								}
								if(rownum2 == 8){
									if(colnum2 == 1){
										intensity = str2;
									}
								}
								if (rownum2 == 13){
									if(colnum2 == 0){
										f_func = str2;
									}else if(colnum2 ==1){
										f_order = str2;						
									}else if(colnum2 ==3){
										liminter = str2;		
									}
								}colnum2++;
								}
							}
						}
					}
					else if (i == 1){
						if(rownum == 2 && colnum == 2){
							Cl = str;
						}else if( rownum == 3){
							if(colnum == 0){
								Cdt = str;
							}else if (colnum ==1){
								Cdp = str;						
							}else if (colnum ==2){
								Cdf = str;
							}
							
						}else if( rownum == 4){
							Cm = str;
						}
					}
					colnum++;
				}
				
			}
		in.close();	
		}
	}
}