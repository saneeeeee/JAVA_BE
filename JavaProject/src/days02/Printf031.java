package days02;

public class Printf031 {

	public static void main(String[] args) {
		// JavaSecond.java  �� ����ߴ� ����ǥ��  ��Ȯ�� ������, ����� ����Ͽ�
		// ����ϼ���.  
		// ����� ����Ҷ� �Ҽ����� ���ڸ��� ����ϼ���.
		// ���� ���� ���� ������ ���� ������ ����ϵ�, ���� ����� ��Ȯ�� ������ ����մϴ�
		// �� �׸��� ��� ������ ���ĵǰ� ������ּ���
		// (���������� ������ 89���� 100���̶�� �� ������ �Ҽ����� ���� ��ġ�� ����
		//    89
		//  100
		System.out.printf("\t\t   ###����ǥ###\n");
		System.out.printf("--------------------------------------------------\n");
		System.out.printf("%3s\t%10s\t%3s\t%s\t%s\t%s\t%5s\n",  
				"��ȣ", "�̸�", "����", "����", "����", "����", "���");
		System.out.printf("--------------------------------------------------\n");
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n" , 
				1, "ȫ�浿", 98,87,56,(98+87+56) , (98+87+56)/3.0 );
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n" , 
				2, "ȫ�漭", 78,68,98,(78+68+98) , (78+68+98)/3.0 );
		System.out.printf("%3d\t%10s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n" , 
				3, "ȫ�泲", 100,100,100,(100+100+100) , (100+100+100)/3.0 );
		System.out.printf("--------------------------------------------------\n");
	}

}
