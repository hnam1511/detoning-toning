package toningword;

import java.io.File;

public class DataAcess {

	 public static File file(String fname)
	 {
	  return new File(DataAcess.class.getResource(fname).getFile());
	 }

	}