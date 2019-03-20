package phoneBook;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

//스윙 라이브러리: 자바에서 윈도우 창을 제어하는 라이브러리
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PhoneBook implements KeyListener{
	//field
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();  
	JTextArea menuDisplay = new JTextArea();
	JTextArea printDisplay = new JTextArea();
	JTextField inputDisplay = new JTextField();
	JScrollPane printScrollPane;

	String name = "";
	String phoneNum = "";
	
	//메뉴 이동을 위해 지정
	int MODE = 0;
	int MODE2 = 90;
	
	PhoneItem item = new PhoneItem();
		
	ArrayList<PhoneItem> phonelist = new ArrayList<PhoneItem>();
	
	//constructor method
	public PhoneBook() throws Exception {
		makeDisplay();
		makePhoneList();
	}
	
	//main method
	public static void main(String[] args) throws Exception {

		PhoneBook PhoneBook = new PhoneBook();

	}//end of main
		
	//화면 디자인
	public void makeDisplay() {
		mainFrame.setTitle("phoneBook");
		mainFrame.setSize(600,400);
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//스윙 라이브러리는 가비지 컬렉션 작동 안함 => 메모리 잡아먹는 것 창 닫을 때 삭제
		mainFrame.setDefaultCloseOperation(3);
		mainFrame.setLocationRelativeTo(null);						//null: 가운데 정렬
		
		//프레임이 가지고 있는 패널을 가져옴
		//레이아웃 지정
//		mainFrame.getContentPane().add(menuDisplay, BorderLayout.WEST);
//		mainFrame.getContentPane().add(printScrollPane, BorderLayout.CENTER);
//		mainFrame.getContentPane().add(inputDisplay, BorderLayout.SOUTH);
		
		//영역 구분을 위해 사이즈, 보더 및 타이틀 지정
		menuDisplay.setBorder(new TitledBorder("phoneBook menu"));
		menuDisplay.setSize(280, 275);
		menuDisplay.setLocation(10, 20);
		menuDisplay.setEditable(false);
		
		printDisplay.setSize(280, 275);
		printDisplay.setLocation(255, 20);
		printDisplay.setEditable(false);
		printDisplay.setFocusable(false);
		printDisplay.setRequestFocusEnabled(false);
		printDisplay.setWrapStyleWord(true);
		printDisplay.setLineWrap(true);
		
		printScrollPane = new JScrollPane(printDisplay);
		printScrollPane.setBorder(new TitledBorder("display"));
		printScrollPane.setSize(280, 275);
		printScrollPane.setLocation(300, 20);
				
		inputDisplay.setBorder(new TitledBorder("input area"));
		inputDisplay.setSize(560,40);
		inputDisplay.setLocation(10, 310);
		inputDisplay.addKeyListener(this);
		
		mainPanel.setBorder(new TitledBorder("phoneBook main"));
		mainPanel.setLayout(null);
		mainPanel.setLocation(0, 0);
		
		mainPanel.add(menuDisplay);
		mainPanel.add(printScrollPane);
		mainPanel.add(inputDisplay);
		
		mainFrame.getContentPane().add(mainPanel, null);
		
		mainFrame.setVisible(true);
		
		inputDisplay.requestFocus();
		
		menuDisplay.setText(Properties.menu_EX1);
	}
	
	//파일 읽어들이기(I/O)
	public void makePhoneList() throws Exception {
		try {
				DataInputStream dis = new DataInputStream(new FileInputStream(new File(Properties.filePath)));
				
				while(true) {
					String strArray = dis.readLine();	//한 줄씩 읽어들이기
					
					if(strArray == null) {
						break;
					}
					
					String[] str1 = strArray.split(",");
					//System.out.println("txt 파일 안에서 읽은 데이터 :: "+ strArray);
					phonelist.add(new PhoneItem(str1[0], str1[1]));
					
					//System.out.println("phonelist:: "+phonelist);
					
					//System.out.println("이름: " + str1[0] + ", 전화번호: " + str1[1]);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//키 입력했을 때 이벤트
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int keyNumber = arg0.getKeyCode();
		
		System.out.println("입력한 키:: " + keyNumber);
		
		if(keyNumber == 49 && MODE == 0) {
			try {
				menu1();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(keyNumber == 50 && MODE == 0) {
			printDisplay.setText(Properties.menu2_name);
			menu2_name();
		}else if(keyNumber == 10 && MODE == 31) {
			menu2_phone();
		}else if(keyNumber == 10 && MODE == 32) {
			menu2();
		}else if(keyNumber == 89 && MODE == 33) {
			menu2_saveForced();
		}else if(keyNumber == 78 && MODE == 33) {
			menu2_no();
		}else if(keyNumber == 51 && MODE == 0) {
			menu3();
		}else if(keyNumber == 10 && MODE == 41) {
			menu3_del();
		}else if(keyNumber == 52 && MODE == 0){
			menu4();
		}else if(keyNumber == 49 && MODE == 99){
			menu4_inputKey1();
		}else if(keyNumber == 10 && MODE == 98){
			menu4_inputName();
		}else if(keyNumber == 10 && MODE == 97){
			menu4_reviseName1();
		}else if(keyNumber == 27 && MODE == 97){
			menu6();
		}else if(keyNumber == 10 && MODE == 96){
			menu4_reviseName2();
		}else if(keyNumber == 50 && MODE == 99){
			menu4_inputKey2();
		}else if(keyNumber == 10 && MODE == 95){
			menu4_inputNumber();
		}else if(keyNumber == 10 && MODE == 94){
			menu4_reviseNumber1();
		}else if(keyNumber == 27 && MODE == 94) {
			menu6();
		}else if(keyNumber == 10 && MODE == 93){
			menu4_reviseNumber2();
		}else if(keyNumber == 89 && MODE2 == 90){
			menu6();
		}else if(keyNumber == 54 && MODE2 == 90) {
			menu6();
		}else if(keyNumber == 53 && MODE2 == 90) {
			menu5();
		}
	}

	//구체적인 동작: 전화번호부 전체보기
	public void menu1() throws Exception {
		printDisplay.setText("");
		printDisplay.append(Properties.menu1_list);
		for (PhoneItem item : phonelist) {
			printDisplay.append(item.toString() + "\n");
		}
		inputDisplay.setText("");
		MODE = 0;
		MODE2 = 90;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 추가: 2번을 입력했을 때
	private void menu2_name() {
		// TODO Auto-generated method stub
		inputDisplay.setText("");
		
		MODE = 31;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 추가: 이름 입력 후 엔터키를 입력했을 때
	private void menu2_phone() {
		// TODO Auto-generated method stub
		name = inputDisplay.getText();
		printDisplay.append("입력하신 이름: "+ name +"\n");
		printDisplay.append(Properties.menu2_phone);
		inputDisplay.setText("");
		
		MODE = 32;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 추가: 전화번호 입력 후 엔터키 입력했을 때
	public void menu2() {
		phoneNum = inputDisplay.getText();
		printDisplay.append("입력하신 전화번호: "+ phoneNum + "\n");
		inputDisplay.setText("");
		MODE = 0;
		
		int chk = 0;
		
		for(PhoneItem item : phonelist) {
			if(name.equals(item.getName())) {
				chk = 1;
			}
			if(name.equals(item.getName()) && name.equals(item.getTelNum())) {
				chk = 2;
			}
		}
		
		if(chk == 1) {
			printDisplay.append(Properties.menu2_duplicate2);
			MODE = 33;
		}else if(chk == 2) {
			printDisplay.append("중복되는 이름과 전화번호부가 있습니다. \n");
		}else {
			phonelist.add(new PhoneItem(name, phoneNum));
			phoneNumSave();
			printDisplay.append(Properties.menu2_add);
			MODE = 0;
		}
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 추가: 이름이 중복되도 저장
	private void menu2_saveForced() {
		// TODO Auto-generated method stub
		phonelist.add(new PhoneItem(name, phoneNum));
		phoneNumSave();
		printDisplay.append(Properties.menu2_add);
		MODE = 0;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 추가: 이름 중복 시 저장하지 않음
	private void menu2_no() {
		// TODO Auto-generated method stub
		printDisplay.append("저장을 취소했습니다. \n");
		MODE = 0;
		inputDisplay.setText("");
		printDisplay.setText("");
		printDisplay.append("전화번호를 저장하지 않았습니다. \n");
		printDisplay.append("메뉴를 선택하세요.");
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 추가: file 쓰기
	private void phoneNumSave() {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter(Properties.filePath);
			
			for(PhoneItem writeItem : phonelist) {
				fw.write(writeItem.getName() + "," + writeItem.getTelNum() + "\n");
			}
			fw.flush();
			fw.close();
			//printDisplay.append(Properties.menu2_add);
			
		}catch(Exception e) {
			e.printStackTrace();
			printDisplay.append("전화번호부 추가 실패");
		}
	}

	//전화번호부 삭제: 전화번호부 삭제 모드 진입
	public void menu3() {
		printDisplay.setText("");
		MODE = 41;
		printDisplay.append(Properties.menu3_del);
		inputDisplay.setText("");
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 삭제: 전화번호 삭제후 상태 저장
	public void menu3_del() {
		name = inputDisplay.getText();
		//System.out.println(name);
		
		for(PhoneItem item : phonelist) {
			if(item.getName().equals(name)) {
				phonelist.remove(item);
				break;
			}
		}
		phoneNumSave();
		printDisplay.append("전화번호부에서 "+ name + "항목이 삭제되었습니다. \n");
		inputDisplay.setText("");
		MODE = 0;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	PhoneItem searchResultName;
	PhoneItem searchResultNum;
	
	//전화번호부 수정 진입
	private void menu4() {
		// TODO Auto-generated method stub
		inputDisplay.setText("");
		printDisplay.setText(Properties.menu4);
		MODE = 99;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//이름 수정 선택
	private void menu4_inputKey1() {
		// TODO Auto-generated method stub
		printDisplay.setText("");
		printDisplay.setText(Properties.menu4_inputKey1);
		inputDisplay.setText("");
		MODE = 98;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//수정할 이름 입력
	private void menu4_inputName() {
		// TODO Auto-generated method stub
		name = inputDisplay.getText();
		System.out.println("inputName:: "+name);
		
		for(PhoneItem item : phonelist) {
			if(item.getName().equals(name)) {
				searchResultName = item;
				System.out.println("searchResultName:: "+searchResultName);
				printDisplay.setText(Properties.menu4_inputName);
				MODE = 97;
				inputDisplay.setText("");
				System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
				break;
			}else {
				printDisplay.setText("등록된 이름이 없습니다. 확인한 후 메뉴를 다시 선택하세요. \n");
				MODE = 0;
				System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
			}
		}
		
	}
	
	//수정
	private void menu4_reviseName1() {
		// TODO Auto-generated method stub
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
		printDisplay.setText(Properties.menu4_reviseName);
		
		MODE = 96;
	}
	
	private void menu4_reviseName2() {
		// TODO Auto-generated method stub
		name = inputDisplay.getText();
		//System.out.println("getName2: "+ name);
		
		searchResultName.setName(name);
		phoneNumSave();
		
		MODE = 0;
		inputDisplay.setText("");
		printDisplay.setText("이름이 변경되었습니다. 메뉴를 선택하세요.\n");
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호 수정
	private void menu4_inputKey2() {
		// TODO Auto-generated method stub
		printDisplay.setText("");
		printDisplay.setText(Properties.menu4_inputKey2);
		inputDisplay.setText("");
		MODE = 95;
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//수정할 전화번호 입력
	private void menu4_inputNumber() {
		// TODO Auto-generated method stub
		phoneNum = inputDisplay.getText();
		System.out.println("inputPhoneNum :"+phoneNum);
		
		for(PhoneItem item : phonelist) {
			if(item.getTelNum().equals(phoneNum)) {
				searchResultNum = item;
				System.out.println("searchResultNum:: "+searchResultNum);
				printDisplay.setText(Properties.menu4_inputNum);
				MODE = 94;
				inputDisplay.setText("");
				System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
				break;
			}else {
				printDisplay.setText("등록된 전화번호가 없습니다. 확인한 후 메뉴를 다시 선택하세요. \n");
				MODE = 0;
				System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
			}
		}
	}
	
	//수정
	private void menu4_reviseNumber1() {
		// TODO Auto-generated method stub
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
		printDisplay.setText(Properties.menu4_reviseNum);
		
		MODE = 93;
	}
	
	private void menu4_reviseNumber2() {
		// TODO Auto-generated method stub
		phoneNum = inputDisplay.getText();
		//System.out.println("getPhoneNum: "+ phoneNum);
		
		searchResultNum.setTelNum(phoneNum);
		phoneNumSave();
		
		MODE = 0;
		inputDisplay.setText("");
		printDisplay.setText("전화번호가 변경되었습니다. 메뉴를 선택하세요.\n");
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
	}
	
	//전화번호부 종료
	public void menu5() {
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
		System.exit(0);
	}
	
	//전화번호부 화면 초기화
	private void menu6() {
		// TODO Auto-generated method stub
		System.out.println("mode: "+ MODE + " // mode2: "+ MODE2);
		inputDisplay.setText("");
		printDisplay.setText("");
		MODE = 0;
	}

	//----------------------------- 사용하지 않는 method ------------------------------------
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub	
	}
	
}//end of class
