package days23;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class IO21 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 특정 날짜를 입력 받아서 그날짜 파일만 출력하세요
		// 날짜 입력 양식을 정해서 잘못된 입력은 다시 입력 받게 설정해주세요

		String inputDate;
		Date iDate;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy_MM_dd");

		boolean form = false;
		while (true) { /* 날짜를 양식데로 입력해주세요. 양식 틀리면 다시 입력 */
			System.out.print("출력할 날짜를 입력하세요.(2020-01-01)");
			try {
				inputDate = in.readLine();
				if(inputDate.length()!=10) throw new Exception();
				iDate = sdf1.parse(inputDate);
				break;
			} catch (ParseException e) {
				System.out.println("잘못된 양식 입니다. 다시 입력해 주세요\n");
			} catch (Exception e) {
				System.out.println("잘못된 양식 입니다. 다시 입력해 주세요\n");
			}
		}
		
		// 읽어올 파일 경로 설정
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		// 폴더에서 모든 파일 목록 불러옴
		String[] f = dir.list();
		System.out.println(sdf2.format(iDate));
		//	File[] nf = new File[10];
		// 파일 명들을 이용한 반복실행문을 실행하여 입력한 파일만 대상으로 내용을 읽은 후 화면 출력
		for (int i = 0; i < f.length; i++) {
			if(f[i].length()>10) {
				String s1 = sdf2.format(iDate);
				File file = new File(dir,f[i]);
				String s2 = f[i].substring(0,10);
				if (s1.equals(s2)) {
					
					ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
					ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>)ois.readObject();
					
					for(int j = 0 ;j<list.size();j++)
						System.out.printf("%d. %s\n",j+1,list.get(j));
					ois.close();
				}
			}
		}
		System.out.println("작업이 실행되었습니다.");
	}

}
