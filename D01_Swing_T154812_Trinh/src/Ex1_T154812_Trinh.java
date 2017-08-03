import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
public class Ex1_T154812_Trinh extends JFrame{
	JLabel lblUsername;
	JTextField txtUserName;
	private JPasswordField txtpassword;
	JTextPane txpane;
	
	public Ex1_T154812_Trinh(){
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		lblUsername = new JLabel("Username:");
		lblUsername.setLocation(30,50);
		lblUsername.setSize(80,25);
		
		getContentPane().add(lblUsername);
		txtUserName = new JTextField();
		txtUserName.setLocation(40,86);
		txtUserName.setSize(150,25);
		getContentPane().add(txtUserName);
		
		JLabel lblPasswordl = new JLabel("Password :");
		lblPasswordl.setBounds(30, 128, 63, 14);
		getContentPane().add(lblPasswordl);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(40, 153, 156, 25);
		getContentPane().add(txtpassword);
		txtpassword.setColumns(10);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = txtUserName.getText();
				 
				char[] passArray =  txtpassword.getPassword();
				String password = new String(passArray);
				if(userName.equals("admin")&& password.equals("root")){
					JOptionPane.showMessageDialog(Ex1_T154812_Trinh.this,"Hello! "+userName);
				}else{
					JOptionPane.showMessageDialog(Ex1_T154812_Trinh.this,"Login Fail");
					
				}
				
			}
		});
		btnNewButton.setBounds(58, 228, 89, 23);
		getContentPane().add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setBackground(SystemColor.inactiveCaption);
		chckbxNewCheckBox.setBounds(40, 185, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		txpane = new JTextPane();
		txpane.setFont(new Font("Tahoma", Font.BOLD, 14));
		txpane.setBackground(SystemColor.inactiveCaption);
		txpane.setText("LOGIN");
		txpane.setBounds(80, 11, 56, 20);
		getContentPane().add(txpane);
		setLocationRelativeTo(null);
	}
public static void main(String [] args ){
Ex1_T154812_Trinh frame = new Ex1_T154812_Trinh();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(250,300);
}
}