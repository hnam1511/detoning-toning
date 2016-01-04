package toningword;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;



public class test1 {

	public static void main(String[] args) throws Exception{ 
		File f1 =  DataFolder.desktop("map-character-detoning.txt");
		BufferedReader fis = DataFolder.openReaderUtf8(f1);
		Map<Integer, Integer> lut = nh.loadDetoneMap(fis);
		fis.close();
		File f2 =  DataFolder.desktop("Truyen-Kieu.txt");
		BufferedReader fit = DataFolder.openReaderUtf8(f2);
		Map<String,List<String>> detone = nh.creatMapDetone(fit,lut);
//		BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
//		        String word = "";
//		       
//		        try
//		        {
//		            word = dataIn.readLine();
//		        }
//		        catch( IOException e )
//		        {
//		            System.out.println("Error!");
//		        }
//		        if(detone.containsKey(word)){
//		            nh.print(detone,word);
//		        }
		
//		String w = "Dau long hai a to nga ";
//		String s1= "Đầu lòng hai ả tố nga,";
//		String s2= "Đau lòng hai ả to nga";
//		String s3= "Chữ tải chữ mệnh khéo lả ghét nhau";
//		String s3= "Chữ tải chữ mệnh khéo lạ ghét nhau";
//		String s3= "Chữ tái chu menh khéo lả ghet nhau";
//		String s3= "Chu tải chữ menh khéo lạ ghét nhau";
//		double st1 = nh.similar(w, s1, detone);
//		System.out.println(st1);
//		double st2 = nh.similar(w, s2, detone);
//		System.out.println(st2);
//		String wa = "Tram nam trong coi nguoi ta.";
//		String s1a= "Trăm năm trong cõi người ta.";
//		String s2a= "Trăm năm trông coi người tả.";
//		double st1a = nh.similar(wa, s1a, detone);
//		System.out.println(st1a);
//		double st2a = nh.similar(wa, s2a, detone);
//		System.out.println(st2a);
		File f3 =  DataFolder.desktop("toning-Truyen-Kieu.txt");
		File f4 =  DataFolder.desktop("TruyenKieu-toned.txt");
		nh.finaldetone(f3,f4,detone);
	}
}
