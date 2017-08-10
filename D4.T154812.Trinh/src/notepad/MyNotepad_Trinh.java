package notepad;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
* 
*/
/**
* @author US
*
*/
public class MyNotepad_Trinh extends JFrame {
JMenuBar mnbBar;
JMenu mnuFile, mnuTool;
JMenuItem mniOpen, mniExit, mniPopup;
JTextArea txaContent;
JScrollPane scrPane;
public void Init() {
// tao cac object
mnbBar = new JMenuBar();
mnuFile = new JMenu("File");
mnuTool = new JMenu("Tool");
mniOpen = new JMenuItem("Open");
mniExit = new JMenuItem("Exit");
mniPopup = new JMenuItem("Popup");
// them mni vao mnuFile
mnuFile.add(mniOpen);
mnuFile.addSeparator();
mnuFile.add(mniExit);
// them mni vao mnuFormat
mnuTool.add(mniPopup);
// them mnuFile va mnuFormat vao mnbBar
mnbBar.add(mnuFile);
mnbBar.add(mnuTool);
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
// tao ham exit
public void Close() {
int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm",
JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
if (result == JOptionPane.YES_OPTION) {
// thuc thi thoat chuong trinh
System.exit(0);
}
}
//tao ham Popup
public void Popup(){
}
public MyNotepad_Trinh() {
setTitle("Lam gi ke tui");
setPreferredSize(new Dimension(600, 500));
setDefaultCloseOperation(EXIT_ON_CLOSE);
pack();
setLocationRelativeTo(null);
// goi ham tao menu
Init();
// tao vung hien thi van ban
// van ban hien thi trong text area
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
if(e.getSource()==mniPopup){
}
}
};
// them su kien action cho cac mni
mniOpen.addActionListener(action);
mniExit.addActionListener(action);
mniPopup.addActionListener(action);
// xu ly su kien dong ung dung
this.addWindowListener(new WindowAdapter() {
public void windownClosing(WindowEvent e) {
Close();
}
});
}
public static void main(String[] args) {
MyNotepad_Trinh frame = new MyNotepad_Trinh();
frame.setVisible(true);
}
}