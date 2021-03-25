import java.awt.EventQueue;
import java.awt.Image;

import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class LoginWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		Image images = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(images));
		lblNewLabel.setBounds(141, 98, 99, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		Image images1 = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(images1));
		lblNewLabel_1.setBounds(141, 132, 99, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(250, 99, 171, 20);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		Image images2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(images2));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				try {
					String query = "select * from HotelEmployeeInfo where username=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count + 1;
					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
						frame.dispose();
						GuestInfo guestinfo = new GuestInfo();
						guestinfo.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong Username and Password");
						
					}
					rs.close();
					pst.close();
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, e);		
				}
				
			}
				
			
		});
		btnLogin.setBounds(187, 179, 128, 44);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 133, 171, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		Image images3 = new ImageIcon(this.getClass().getResource("/hotel.png")).getImage();
		label.setIcon(new ImageIcon(images3));
		label.setBounds(10, 49, 128, 174);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 51);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("LACABECCA HOTEL");
		scrollPane.setViewportView(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 30));
	}
}
