package View.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Join_GUI extends JFrame implements ActionListener, KeyListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JTextField txt1; //아이디
	JTextField txt2; //비번
	
	Join_GUI() {
		// Frame
		super("");
		setBounds(100, 100, 500, 500);

		// Panel
		JPanel panel = new JPanel(); // 패널생성

		panel.setLayout(null);

		// Component
		btn1 = new JButton("회원가입");
		btn2 = new JButton("취소");
		btn3 = new JButton("중복확인");
		txt1 = new JTextField("ID : ");
		txt2 = new JTextField("PW : ");


		// Positioning

		btn1.setBounds(110, 250, 120, 40); // 회원가입
		btn2.setBounds(250, 250, 120, 40); // 취소
		btn3.setBounds(315, 70, 90, 25); // 중복확인
		txt1.setBounds(60,100,350,40);	// 아이디
		txt2.setBounds(60,160,350,40);	// 비번

		// Event처리
		
//		btn1 로그인 처리 해야됨

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		


		btn1.setFont(new Font("굴림", Font.BOLD, 12));
		btn2.setFont(new Font("굴림", Font.BOLD, 12));
		btn3.setFont(new Font("굴림", Font.BOLD, 12));

		// Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
		panel.add(txt2);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

//		btn1 회원가입 기능 추가해야됨
		
		//회원가입 취소 시 메인화면으로 이동
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MAINGUI();
				
			}
		});
		
		// 포커스 시 공백처리
        txt1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt1.getText().equals("ID : ")) {
                    txt1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt1.getText().isEmpty()) {
                    txt1.setText("ID : ");
                }
            }
        });

        txt2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt2.getText().equals("PW : ")) {
                    txt2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt2.getText().isEmpty()) {
                    txt2.setText("PW : ");
                }
            }
        });

	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {}
}