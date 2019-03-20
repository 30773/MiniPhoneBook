package phoneBook;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArrayListTest3_190309 {
	
	//PhoneItem 형식만 담을 수 있는 arraylist 객체 생성
	static ArrayList<PhoneItem> phonelist = new ArrayList<PhoneItem>();
	
	//목적: 새로운 연락처 추가
	//1. 파라미터 정보를 phoneList 배열에 추가
	//2. 추가된 배열을 포함한 파일 내용을 업데이트 하기
	private static void addPhoneList(String string, String string2) {

		phonelist.add(new PhoneItem(string, string2));
		
		writePhoneList();
	}
	
	//목적: 텍스트 파일에 새로운 데이터 입력(추가, 쓰기)
	private static void writePhoneList() {
		try {
			//파일을 쓸 때도 마찬가지로 예외처리 필요
			FileWriter fw = new FileWriter(Properties.filePath);
				
				for(PhoneItem writeItem : phonelist) {
					fw.write(writeItem.getName() + "," + writeItem.getTelNum() + "\n");
				}
				fw.flush();
				fw.close();
				
				System.out.println("----- 파일이 저장되었습니다 -----");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//목적: 텍스트 파일을 읽어서 phonelist 배열에 담기
	private static void readFileAddList(String filePath) {
		//파일을 읽을 때는 예외처리(throws exception도 가능)가 필수
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(filePath));
			
			while(true) {
				String text = dis.readLine();			//텍스트 파일 내 데이터를 한 줄 씩 읽음
				
				//무한 반복 현상을 막기 위해 텍스트 내 데이터가 없으면 끝내도록
				if(text == null) {
					break;
				}
				
				String[] strArray = text.split(","); 	//comma를 기준으로 자르기: 잘라야 원하는 데이터 추출이 가능하니까
//					System.out.println("strArray 값내 첫번째 값 확인: "+strArray[0]);
//					System.out.println("strArray 값내 두번째 값 확인: "+strArray[1]);
//					System.out.println("strArray 값내 세번째 값 확인: "+strArray[2]);	//데이터가 없으므로 ArrayIndexOutOfBoundsException 발생 
				
				//split으로 자른 데이터 arraylist에 담기(이 작업에서 헤맸다! 반드시 재확인)
				//1. phonelist를 그냥 쓸 수 있는 이유 필드에서 static으로 지정
				//2. arraylist 형식의 phonelist 변수에 넣기 위해 add 함수 사용
				//3. add 함수 내에 PhoneItem 인스턴스를 생성해야 가져다 사용할 수 있다는 점도 포인트다
				phonelist.add(new PhoneItem(strArray[0], strArray[1]));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//목적: phonelist 내용 출력하기
	private static void printPhoneList() {
		//enhanced for loop
		for (PhoneItem readItem : phonelist) {
			System.out.println(readItem.toString());
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		System.out.println("----- main method start -----");
		readFileAddList(Properties.filePath);
		printPhoneList();
		addPhoneList("t6","01066666667");			//새로운 연락처 추가	
		readFileAddList(Properties.filePath);		//추가 후 파일 다시 읽기
		printPhoneList();							//전화번호 리스트 출력
		System.out.println("----- main method end -----");
		
		
	}//end of main
		
}//end of class
