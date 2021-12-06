package days24;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hh:mm");
		String f_name = sdf.format(today).toString()+".dat";
		
		System.out.println(f_name);
		
		File f = new File(f_name);
	}

}
