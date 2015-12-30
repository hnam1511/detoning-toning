package toningword;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;



public class toning {

	public static void main(String[] args) throws Exception{ 
		File f1 =  DataFolder.desktop("map-character-detoning.txt");
		BufferedReader fis = DataFolder.openReaderUtf8(f1);
		Map<Integer, Integer> lut = method.loadDetoneMap(fis);
		fis.close();
		File f2 =  DataFolder.desktop("Truyen-Kieu.txt");
		BufferedReader fit = DataFolder.openReaderUtf8(f2);
		Map<String,List<String>> detone = method.creatMapDetone(fit,lut);
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
//		            method.print(detone,word);
//		        }
		
//		String w = "Chu tai chu memethod kheo la ghet methodau.";
//		String s1= "Chữ tài chữ mệmethod khéo là ghét methodau.";
//		String s2= "Chu tai chữ mệmethod khèo là ghét methodau.";
//		String s3= "Chữ tải chữ mệmethod khéo lả ghét methodau";
//		String s3= "Chữ tải chữ mệmethod khéo lạ ghét methodau";
//		String s3= "Chữ tái chu memethod khéo lả ghet methodau";
//		String s3= "Chu tải chữ memethod khéo lạ ghét methodau";
//		double st1 = method.similar(w, s1, detone);
//		System.out.println(st1);
//		double st2 = method.similar(w, s3, detone);
//		System.out.println(st2);
//		String wa = "Tram nam trong coi nguoi ta.";
//		String s1a= "Trăm năm trong cõi người ta.";
//		String s2a= "Trăm năm trông coi người tả.";
//		double st1a = method.similar(wa, s1a, detone);
//		System.out.println(st1a);
//		double st2a = method.similar(wa, s2a, detone);
//		System.out.println(st2a);
		File f3 =  DataFolder.desktop("toning-Truyen-Kieu.txt");
		File f4 =  DataFolder.desktop("TruyenKieu-toned.txt");
		method.finaldetone(f3,f4,detone);
	}
}
