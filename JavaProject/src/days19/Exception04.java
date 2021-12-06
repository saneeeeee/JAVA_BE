package days19;

import java.text.ParseException;

public class Exception04 {

	public static void main(String[] args) {
		try {
			// 예외상황 고의 발행
			ArithmeticException a 
				= new ArithmeticException("ArithmeticException 고의발생");
			throw a; 
		}catch(ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch(RuntimeException e){
			System.out.printf("RuntimeException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch(Exception e) {
			System.out.printf("Exception - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}
		
		
		try {
			// 예외상황 고의 발행
			RuntimeException a 
				= new RuntimeException("RuntimeException 고의발생");
			throw a; 
		}catch(ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch(RuntimeException e){
			System.out.printf("RuntimeException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch(Exception e) {
			System.out.printf("Exception - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}
		
		try {
			// 예외상황 고의 발행
			ParseException a 
				= new ParseException("ParseException 고의발생", 0);
			throw a; 
		}catch(ArithmeticException e) {
			System.out.printf("ArithmeticException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		}catch(RuntimeException e){
			System.out.printf("RuntimeException - ");
			System.out.println("에러 메시지 : " + e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
