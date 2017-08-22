/**
 * 
 */
package notepad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Trinh
 *
 */
public class MyNotepad_Trinh extends JFrame {
	JMenuBar mnbBar;
	JMenu mnuFile, mnuTools;
	JMenuItem mniOpen, mniExit, mniAnalyze;
	JTextArea txaContent;
	JScrollPane scrPane;

	public void Init() {
		// tao cac object
		mnbBar = new JMenuBar();
		mnuFile = new JMenu("File");
		mnuTools = new JMenu("Tools");
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniAnalyze = new JMenuItem("Analyze");

		// them mni vao mnuFile
		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		// them mni vao mnuFormat
		mnuTools.add(mniAnalyze);

		// them mnuFile va mnuFormat vao mnbBar
		mnbBar.add(mnuFile);
		mnbBar.add(mnuTools);
		// cai dat mnbBar thanh menu chinh cua frame
		setJMenuBar(mnbBar);

	}

	// Constuctor
	// tao ham open file
	public void openFile() {

		// tao JFilechoose cho phep nguoi dung chon tap tin trong may
		JFileChooser fchOpen = new JFileChooser();
		// hien thi cua so chon tap tin, nguoi dung chon va nhan nut open thi
		// ket qua luu vao result la Approve
		// neu nhan cancle se la cancle
		int result = fchOpen.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			// neu ket qua la approve thi tien hanh doc tap tin
			try {
				Scanner scn = new Scanner(fchOpen.getSelectedFile());
				// doc tung dong neu khong con thi dung neu con thi doc tiep
				while (scn.hasNextLine()) {
					txaContent.append(scn.nextLine() + "\n");
				}
				scn.close();
			} catch (Exception e) {
				// hien thi thong bao khi khong tim thay tap tin
				JOptionPane.showMessageDialog(null, "Selected file is not found");
			}

		}
	}

	//
	public void Close() {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			//
			System.exit(0);
		}
	}

	// tao ham Popup
	public void Popup() {

		int countSV = 0;
		int count70 = 0;
		int count45 = 0;
		int countfoc = 0;

		double dtbMin = 10;
		double dtbMax = 0;
		

		String hotenmin = null;
		String hotenmax = null;

		String maxfoc = null;

		String[] lines = txaContent.getText().split("\n");
		DecimalFormat diemFormat = new DecimalFormat("#0.00");
		
		for (int i = 1; i < lines.length; i++) {
			// System.out.println(lines[i]);
			String[] fields = lines[i].split(",");
			if (fields.length == 7) {
				String stt = fields[0];
				String sid = fields[1];
				String lastName = fields[2];
				String firstName = fields[3];

				int foc = Integer.parseInt(fields[4]);
				int introNW = Integer.parseInt(fields[5]);
				int adp = Integer.parseInt(fields[6]);

				// Tinh diem trung binh
				double dtb = (foc + introNW + adp) * 1.0 / 3;
				


				if (dtb >= 7.0) {
					count70++;
				}

				if (dtb < 4.5) {
					count45++;
				}
				countSV++;

				if (dtb < dtbMin) {
					dtbMin = dtb;
					hotenmin = lastName + firstName;
				}

				if (dtb > dtbMax) {
					dtbMax = dtb;
					hotenmax = lastName + firstName;
				}
				
				if (foc > countfoc) {
					countfoc = foc;
					maxfoc = lastName + firstName;
					;
				}

				if (dtb > dtbMax) {
					maxfoc = lastName + firstName;
				}

				// System.out.println(sid);

			}

		}
		String message = "So sinh vien co trong danh sach: " + countSV +"\n";
		message+= "So sinh vien co DTB > 7.0: " + count70 +"\n";
		message+= "So sinh vien co DTB < 4.5: " + count45 +"\n";
		message+= "DTB nho nhat: " + dtbMin+"\n";
		message+= "Ten SV co DTB nho nhat: " + hotenmin+"\n";
		message+= "DTB lon nhat: " + diemFormat.format(dtbMax)+"\n";
		message+= "Ten SV co DTB lon nhat: " + hotenmax+"\n";
		message+= "Diem FOC cao nhat: " + countfoc +"\n";
		message+= "Nhung Sv co diem FOC cao nhat:\n" + maxfoc +"\n";
		JOptionPane.showMessageDialog(MyNotepad_Trinh.this, message);
		
		/*System.out.println("So sinh vien co trong danh sach: " + countSV);
		System.out.println("So sinh vien co DTB > 7.0: " + count70);
		System.out.println("So sinh vien co DTB < 4.5: " + count45);
		System.out.println("DTB nho nhat: " + dtbMin);
		System.out.println("Ten SV co DTB nho nhat: " + hotenmin);
		System.out.println("DTB lon nhat: " + dtbMax);
		System.out.println("Ten SV co DTB lon nhat: " + hotenmax);
		System.out.println("Diem FOC cao nhat: " + countfoc);
		System.out.println("Nhung Sv co diem FOC cao nhat:\n" + maxfoc);*/

	}

	public MyNotepad_Trinh() {
		setTitle("MyNotepad_Trinh");
		setPreferredSize(new Dimension(600, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		// goi ham tao menu
		Init();
		//
		txaContent = new JTextArea();
		// hien thanh cuon neu van ban dai
		scrPane = new JScrollPane(txaContent);
		// them thanh cuon chua text vao frame
		getContentPane().add(scrPane);

		// tao action
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mniOpen) {
					// xu ly khi nhan nut open
					openFile();
				}
				if (e.getSource() == mniExit) {
					// xu ly khi nhan nut exit
					Close();
				}
				if (e.getSource() == mniAnalyze) {
					Popup();
				}
			}
		};
		// them su kien action cho cac mni
		mniOpen.addActionListener(action);
		mniExit.addActionListener(action);
		mniAnalyze.addActionListener(action);
		// xu ly su kien dong ung dung
		this.addWindowListener(new WindowAdapter() {
			public void windownClosing(WindowEvent e) {
				Close();
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNotepad_Trinh T = new MyNotepad_Trinh();
		T.setVisible(true);
	}

}