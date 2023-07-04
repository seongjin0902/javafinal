package View.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MAINGUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1; // 글작성
	JButton btn2; // 내가 쓴 글
	JButton btn3; // 로그인
	JButton btn4; // 회원가입
	JButton btn5; // 검색

	JTable tbl1; // 인기글
	JTable tbl2; // 메인글

	JLabel lbl1; // 게시판라벨

	JTextArea area1;
	JScrollPane scroll1; // 인기글 스크롤
	JScrollPane scroll2; // 메인글 스크롤

	JTextField srch; // 검색창
	DefaultTableModel model;

	MAINGUI() {
		super("MAIN MENU");
		setBounds(100, 100, 900, 900);

//		패널
		JPanel panel = new JPanel();
		panel.setLayout(null);

//		테이블 열이름
		String[] columns = { "number", "id", "title", "date" };
//		테이블 데이터
//		테이블 모델
		DefaultTableModel model = new DefaultTableModel(columns, 0);

// 		Component
		btn1 = new JButton("글 작성");
		btn2 = new JButton("내가 쓴글");
		btn3 = new JButton("로그인");
		btn4 = new JButton("회원가입");
		btn5 = new JButton("검색");
		tbl1 = new JTable();
		tbl2 = new JTable();
		lbl1 = new JLabel("게시판");
		area1 = new JTextArea();
		scroll1 = new JScrollPane(area1);
		scroll2 = new JScrollPane(area1);
		srch = new JTextField();

//		Position
		tbl1.setBounds(10, 130, 860, 200); // 인기글
		tbl2.setBounds(10, 340, 860, 450); // 메인글
		lbl1.setBounds(280, 10, 300, 60); // 제목

		btn1.setBounds(680, 80, 90, 30); // 글작성
		btn2.setBounds(775, 80, 90, 30); // 내가 쓴 글
		btn3.setBounds(680, 800, 90, 30); // 로그인
		btn4.setBounds(775, 800, 90, 30); // 회원가입
		btn5.setBounds(160, 800, 60, 30); // 검색

		scroll1.setBounds(10, 130, 860, 200); // 인기글 스크롤
		scroll2.setBounds(10, 340, 860, 450); // 메인글 스크롤

		srch.setBounds(15, 800, 140, 30); // 검색

//		event 처리
//		글작성
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Writer_GUI();
				dispose();
			}
		});

//		내가 쓴 글
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MyWriter_GUI();
				dispose();
			}
		});
		// 로그인 화면으로 이동
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login_GUI();
				dispose();
			}
		});
		// 회원가입 화면으로 이동
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Join_GUI();
				dispose();
			}
		});

		tbl1.addKeyListener(this);
		area1.setEditable(false);

		btn1.setFont(new Font("굴림", Font.BOLD, 12));
		btn2.setFont(new Font("굴림", Font.BOLD, 12));
		btn3.setFont(new Font("굴림", Font.BOLD, 12));
		btn4.setFont(new Font("굴림", Font.BOLD, 12));
		btn5.setFont(new Font("굴림", Font.BOLD, 12));

		lbl1.setFont(new Font("굴림", Font.BOLD, 30)); // 제목

		// Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		panel.add(lbl1); // 다 같이 게시판 제목

		panel.add(srch);
		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}