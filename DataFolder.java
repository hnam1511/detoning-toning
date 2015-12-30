package toningword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class DataFolder {

	public static File file(String fname)
	{
		return new File(DataFolder.class.getResource(fname).getFile());
	}

	public static BufferedReader openReaderUtf8(File file) throws Exception
	{
		InputStreamReader utf = new InputStreamReader(new FileInputStream(file), "UTF-8"); 
		return new BufferedReader(utf);	
	}

	public static PrintWriter openDesktopWriterUtf8(String st) throws Exception
	{
		return openWriterUtf8(desktop(st));
	}
	public static File desktop(String string) 
	{
		return new File( System.getProperty("user.home") + "/Desktop/" + string );
	}
	
	public static PrintWriter openWriterUtf8(File file) throws Exception
	{
		file.getParentFile().mkdirs();
		OutputStreamWriter utf = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		return new PrintWriter(utf);	
	}
	
}
