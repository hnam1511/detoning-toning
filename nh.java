package toningword;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class nh {

	
	public static Map<Integer, Integer> loadDetoneMap(BufferedReader reader) throws Exception
	{
		Map<Integer, Integer> lut = new TreeMap<Integer, Integer>();
        
		while(true)
		{
			String line = reader.readLine();
			if(line == null) break;
			String[] cells = line.replace("->", " ").split("\\s+[ ?!:;]+");
			if(cells.length < 0) continue;
			lut.put((int)cells[0].charAt(0), (int)cells[1].charAt(0));
		}
		
		return lut;
	}
	
	public static void add(Map<String, List<String>> lut, String s, String t)
    {
        List<String> ls = lut.get(s);
        if(ls == null) {
            ls=new ArrayList<String>();
            ls.add(t);
            lut.put(s, ls);
        }
        else if(!ls.contains(t)){
            ls.add(t);
        }
    }
	
	
    public static void print(Map<String, List<String>> lut,String s)
    {
        
        for(String t: lut.get(s))
        System.out.println(s + " -> " + t); 
    }
    
    public static String res(String toned, Map<Integer, Integer> lut) 
	{
		String res = "";
		
		for(int k=0; k<toned.length(); k++)
		{
			int ck = toned.charAt(k);
			
			if(lut.containsKey(ck)) res += (char)(int)lut.get(ck);
			else res += (char)ck;
		}
		
		return res;
	}

	public static Map<String, List<String>> creatMapDetone(BufferedReader fit,Map lut) throws IOException {
		Map<String, List<String>> res=new TreeMap<String, List<String>>();
		BufferedReader reader = new BufferedReader(new BufferedReader(fit));
		String line;
		List<String> lis =new ArrayList<String>();
		while(true)
		{
	            line = reader.readLine();
	            if(line == null) break;
	            if(!lis.isEmpty())lis.removeAll(lis);
	            for(String sk: line.split("[ ,.:;!?~']+"))
	            {
	            	lis.add(sk);
	            }
	            for(int i=0;i<lis.size();i++){
	            	String sa1 = lis.get(i);
	            	String sb1=detoning(sa1,lut);
	            	add(res,sb1,sa1);
	                if (i+1<lis.size()) 
	                {
	                    String sa2=lis.get(i+1);
	                    sa1=sa1.concat(" "+sa2);
	                    String sb2=detoning(sa2,lut);
	                    sb1=sb1.concat(" "+sb2);
	                    add(res,sb1,sa1);
	                    if (i+2<lis.size())
	                    {
	                        String sa3=lis.get(i+2);
	                        sa1=sa1.concat(" "+sa3);
		                    String sb3=detoning(sa3,lut);
		                    sb1=sb1.concat(" "+sb3);
		                    add(res,sb1,sa1);
	                        if (i+3<lis.size())
	                        {
	                        	String sa4=lis.get(i+3);
	                        	sa1=sa1.concat(" "+sa4);
			                    String sb4=detoning(sa4,lut);
			                    sb1=sb1.concat(" "+sb4);
			                    add(res,sb1,sa1);
	                        }
	                    }
	                
	                }
	            }
		}
		return res;
	}
	

	public static String detoning(String toned, Map<Integer, Integer> lut) 
	{
		String res = "";
		
		for(int k=0; k<toned.length(); k++)
		{
			int ck = toned.charAt(k);
			
			if(lut.containsKey(ck)) res += (char)(int)lut.get(ck);
			else res += (char)ck;
		}
		
		return res;
	}

	public static double similar(String A, String B, Map<String, List<String>> m) {
		boolean ak;
		double x=0;
		List<String> lis =new ArrayList<String>();
 		for(String tk: A.split("[ ,.:;!?~']+")){
        	lis.add(tk);                        	// list A: word need to toning
		}
        List<String> lut =new ArrayList<String>();
    	for(String xk: B.split("[ ,.:;!?~']+")){
            lut.add(xk);							// list B: word toned but need to compare
    	}
    	List<String> keyset = new ArrayList<String>();
    	double sk =Math.max(lis.size(), lut.size());
    	for(int i=0;i<lis.size();i++){
    		String s=lis.get(i);					// List A:	s
    		String t=lut.get(i);					// List B:	t
    		if(m.containsKey(s)){
    			keyset=m.get(s);ak=compare(t,keyset);
        		if (ak&&i+1<sk) 
                {
                    String sa2=lis.get(i+1);			// List A:	sa2
                    String s2=s.concat(" "+sa2);				
                    String ta2=lut.get(i+1);			// List B:	ta2
                    String t2=t.concat(" "+ta2);
                    if(m.containsKey(s2))
                    { 
                    	keyset=m.get(s2);
                        ak=compare(t2,keyset);
                        if (ak&&i+2<sk)
                        {
//                			i++;
                            String sa3=lis.get(i+2);		// List A:	sa3
                            String s3=s2.concat(" "+sa3);			
                            String ta3=lut.get(i+2);		// List B:	ta3
                            String t3=t2.concat(" "+ta3);
                            if(m.containsKey(s3)){
                            	keyset=m.get(s3);
                                ak=compare(t3,keyset);
                        		if (ak&&i+3<sk)
                                {
//                        			i++;
                                	String sa4=lis.get(i+3);			// List A:	sa4
                                	String s4=s3.concat(" "+sa4);		//s3: 4 tu lien tiep
                                	String ta4=lut.get(i+3);			// List B:	ta4
                                	String t4=t3.concat(" "+ta4);		//t3: 4 tu lien tiep
                                	if(m.containsKey(s4)){
                                		keyset=m.get(s4);
                                        ak=compare(t4,keyset);
                                		if(ak&&i!=sk-4) {
                                			x++;
                                		}
                                		else if(ak&&i==sk-4) {
                                			x+=4;
                                			i+=3;
                                		}
                                	}
                                	
                                }
                            }
                            
                        	
                        }
                    }
    		}
    		
        		
            }
    	}
		return x/sk;
	}

	private static  boolean compare(String t, List<String> keyset) {
		
		for(int ik=0;ik<keyset.size();ik++){
			if(keyset.get(ik).equals(t)) {
				return true;
			}
		}
		return false;
	}

	public static void finaldetone(File f3, File f4, Map<String, List<String>> detone) throws Exception {
		PrintWriter out = DataFolder.openWriterUtf8(f4);
		BufferedReader in = DataFolder.openReaderUtf8(f3);
		in.readLine();
		while(true)
		{
			Set<String> toning = new TreeSet<String>();
			List<String> sizeline = new ArrayList<String>();
			String s =in.readLine();
			if(s==null)break;
			toning.add(s);
			String t=s;
			int i=-1;
			for(String sk: s.split("[ ,.:;!?~']+")){
				sizeline.add(sk);
			}
			creat(s,i,detone,toning,sizeline);
//			for(String sk:toning){
//				System.out.println(sk);
//			}
			for(String sk:toning){
				if(nh.similar(s, sk, detone)==1){
					System.out.println(sk);
					out.println(sk);
				}
			}
		}
		out.close();
	}
	private static void creat(String s, int i, Map<String, List<String>> detone,Set<String>toning,List<String>sizeline) 
	{
		i++;
		if(i<sizeline.size()){
			if(detone.containsKey(sizeline.get(i)))
			{
				String z=sizeline.get(i);
				for(String sk: detone.get(sizeline.get(i))) 
				{
					String t=s.replaceFirst(z, sk);
					int xk=i;
					creat(t,xk,detone, toning,sizeline);
				}
			}
		}
		if(i==sizeline.size()){
			toning.add(s);
			i=-1;
		}
	}

	//	private static void copy(ArrayList<String> use, Set<String> toning) {
//		use.removeAll(use);
//		for(String sk:toning){
//			use.add(sk);
//		}
//	}
}
