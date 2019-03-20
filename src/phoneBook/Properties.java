package phoneBook;

public class Properties {
	
	static String menu_EX1 = "====== 미니 전화번호부 ======\n"
			+ "1. 전화번호부 전체보기\n"
			+ "2. 전화번호부 입력하기\n"
			+ "3. 전화번호부 지우기\n"
			+ "4. 전화번호부 수정하기\n "
			+ "5. 전화번호부 종료하기\n "
			+ "6. 전화번호부 화면 초기화\n "
			+"=========================\n";
	
	static String menu1_list = "===== 전화번호부 전체보기 =====\n";
	static String menu2_name = "===== 전화번호 입력모드 =====\n"
			+ "이름 입력 후 엔터를 누르세요\n ";
	static String menu2_phone = "전화번호 입력 후 엔터를 누르세요\n ";
	static String menu2_add = "등록이 완료되었습니다\n "
			+ "메뉴를 선택하세요\n ";
	static String menu2_duplicate = "동일한 이름과 전화번호가 존재합니다\n "
			+ "입력에 실패하였습니다\n "
			+ "메뉴를 선택하세요\n ";
	static String menu2_duplicate2 = "전화번호는 다르지만 같은 이름이 존재합니다\n "
			+ "그래도 입력하시겠습니까? (y/n)\n ";
	static String menu2_no = "입력을 취소하였습니다\n "
			+ "메뉴를 선택하세요\n ";
	static String menu3_del = "===== 전화번호부 삭제모드 =====\n"
			+ "삭제할 전화번호부 등록명(이름)을 입력하세요. \n ";
	static String menu4 = "==== 전화번호 수정 모드 =====\n"
			+ "1. 이름 입력\n"
			+ "2. 전화번호 입력\n"
			+ "번호를 선택하세요.\n";
	static String menu4_inputKey1 = "==== 전화번호부 수정 모드 =====\n"
			+ "수정할 이름을 입력하고 ENTER를 누르세요. \n";
	static String menu4_inputName = "==== 전화번호부 수정 모드 =====\n"
			+ "입력하신 이름을 전화번호부에서 찾았습니다. 진행하려면 ENTER를, 아니면 ESC를 누르세요. \n";	
	static String menu4_reviseName = "==== 전화번호부 수정 모드 =====\n"
			+ "새로 등록할 이름을 입력하고 ENTER를 누르세요.\n";		  
	static String menu4_inputKey2 = "==== 전화번호부 수정 모드 =====\n"
			+ "수정할 전화번호를 입력하고 ENTER를 누르세요. \n";
	static String menu4_inputNum = "==== 전화번호부 수정 모드 =====\n"
			+ "입력하신 전화번호를 전화번호부에서 찾았습니다. 진행하려면 ENTER를, 아니면 ESC를 누르세요. \n";
	static String menu4_reviseNum = "==== 전화번호부 수정 모드 =====\n"
			+ "새로 등록할 전화번호를 입력하고 ENTER를 누르세요.\n";		
	
	
	

	static String filePath = "C:/workspace/MiniPhoneBook/src/phoneBook/phonebook.txt";
	static String filePathTest = "C:/workspace/MiniPhoneBook/src/phoneBook/phonebook_test.txt";
}
