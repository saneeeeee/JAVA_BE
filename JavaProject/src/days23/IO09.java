package days23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO09 {

	public static void main(String[] args) throws IOException {
		// 경로 확인 및 생성의 이유로   File  객체는 아래와 같이 두번 생성하여 완성합니다
		File dir = new File("D:\\JAVA01\\java_se\\temp");
		if( !dir.exists() ) dir.mkdirs();  // 폴더가 없으면 폴더를 생성
		
		File file_binary = new File(dir, "binary_data.dat");
		File file_text = new File(dir, "text_data.txt");
		// File file_binary = new File("D:\\JAVA01\\java_se\\temp\\binary_data.dat");
		
		// 파일로부터 이진 데이터를 읽어올 수 있는 스트림 객체 생성
		FileInputStream fis_bynary = new FileInputStream(file_binary);
		// 파일로부터 텍스트 데이터를 읽어올 수 있는 스트림 객체 생성
		FileReader fr_text = new FileReader(file_text);
		
		// 파일의 존재와 오픈의 오류는 디스크 상의 문제이므로, 명령으로 해결할수 없습니다
		// 따라서 파일 입출력( 또는 화면입출력)은 항상 예외처리가 따라다닙니다.
		
		// 이진데이터 읽어와서 출력
		// binary 형식으로 써넣은 내용은  binary 형식으로 읽어서 실제 구분할 수 있는 데이터를 
		// 얻을수 있습니다
		int data_binary;
		data_binary = fis_bynary.read();
		System.out.println(data_binary);
		data_binary = fis_bynary.read();
		System.out.println(data_binary);
		fis_bynary.close();
		
		// text 데이터는 한글자씩 읽어옵니다. 그래서 반복실행문을 이용합니다
		// 텍스트 파일의 내용을 한 글자씩 읽어들이는 경우
		// 입력 데이터의 저장 형식은 반드시 int 타입으로 문자값을 전달 받아야합니다.
		// 파일에 끝에 도달하면 -1 값이 읽혀져 오는데,  char 은 부호가 없는 자료형이므로 
		// -값을 처리할 수 없고, 파일의 끝으로 인식되지 않기 때문입니다.
		// char 형으로 읽어 낸다면, 무조건 양수로만 취급하여 반복을 빠져나올 수 없습니다.
		int data_text;
		data_text = fr_text.read();
		while( data_text  != -1 ) {
			System.out.print((char)data_text);
			data_text = fr_text.read();
		}
		//while( ( data_text = fr_text.read() ) != -1 )
		//		System.out.print((char)data_text);
		fr_text.close();

	}

}
