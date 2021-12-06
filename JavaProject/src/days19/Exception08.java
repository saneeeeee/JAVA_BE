package days19;

import java.io.File;
import java.io.IOException;

public class Exception08 {
	
	static int cnt = 0;
	public static void main(String[] args) {
		File f1 = createFile("");
		File f2 = createFile("abc.txt");
		File f3 = createFile("");
	}
	public static File createFile(String fileName) {
		File f = null;
		try {
			if( fileName==null || fileName.equals("") )
				throw new IOException("파일이름이 유효하지 않습니다" );
		}catch( IOException e) {
			fileName = "제목없음" + ++cnt + ".txt";
		}catch( Exception e) {
			e.printStackTrace();
		} finally {
			// 예외처리가 생겼든 안생겼든 반드시 실행하고 지나갈 영역 : finally
			f = new File(fileName);
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println(fileName + "파일 생성에 실패했습니다");
			}
		}
		return f;
	}

}
