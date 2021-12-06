package days23;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO14 {

	public static void main(String[] args) throws IOException {
		// 이진 형식,  text  형식 모두 가능하지만 가능하다면  이진형식으로.... 실습해주세요

		// "D:\\JAVA01\\Java_se\\temp" 폴더안의  "eclipse-inst-jre-win64.exe"  파일을
		// "D:\\JAVA01\\Java_se\\copy" 폴더로 복사 
		// 이진 형식으로 읽어... 바로 써넣는 방식
		
		String CopyPath = "D:\\JAVA01\\java_se\\copy";   //사본 파일 경로
		String OriginalPath = "D:\\JAVA01\\java_se\\temp";  // 원본 파일 경로
		String Filename = "eclipse-inst-jre-win64.exe";
		File originDir = new File(OriginalPath);  // 읽어올 파일 경로 설정
		File fileOriginal = new File( originDir, Filename);  // 읽어올 파일 설정
		
		File copyDir = new File(CopyPath);  // 써넣을 경로 설정
		if( !copyDir.exists() ) copyDir.mkdirs(); // 써넣을 경로 생성
		File fileCopy = new File( copyDir, Filename);  // 써넣을 파일 설정
		
		BufferedInputStream  bis 
			= new BufferedInputStream( new FileInputStream(fileOriginal) );
		BufferedOutputStream bos
			= new BufferedOutputStream( new FileOutputStream( fileCopy ) );
		
		// int data;
		// while( ( data = bis.read() ) != -1 ) bos.write( data );
		
		byte [] data = new byte[1024];
		int size;
		while( (size = bis.read(data)) != -1 ) bos.write(data, 0, size);
		
		bis.close();
		bos.close();
	}

}
