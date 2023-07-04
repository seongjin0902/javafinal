package View.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyWriter_GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JLabel lbl1;
	JTable tbl1;
	JTextArea area1;
	JScrollPane scroll1;
	JScrollPane scroll2;

	MyWriter_GUI() {
		// Frame
		super("내가 쓴 글");
		setBounds(100, 100, 900, 900);

		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);

		// Component
		btn1 = new JButton("나가기");

		lbl1 = new JLabel("내가 쓴 글 목록");
		tbl1 = new JTable();

		area1 = new JTextArea();
		scroll1 = new JScrollPane(area1);
		scroll2 = new JScrollPane(area1);

		JTextField srch = new JTextField();

		// Positioning
		lbl1.setBounds(10, 10, 860, 80); // 제목
		tbl1.setBounds(10, 100, 860, 680); // 작성 글
		btn1.setBounds(770, 800, 90, 30); // 나가기

		// Event처리
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
				dispose(); // 현재 GUI 창 닫기

				new MAINGUI(); // GUI1으로 돌아가기
			}
		});

		lbl1.addKeyListener(this);
		area1.setEditable(false);
		btn1.setFont(new Font("굴림", Font.BOLD, 12));
		lbl1.setFont(new Font("굴림", Font.BOLD, 30));

		// Add_Panel_Component
		panel.add(btn1);
		panel.add(lbl1);
		panel.add(tbl1);
		panel.add(scroll1);
		panel.add(scroll2);
		panel.add(srch);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
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