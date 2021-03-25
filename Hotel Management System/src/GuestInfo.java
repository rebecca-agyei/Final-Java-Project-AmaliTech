import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Image;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuestInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldGuestRef;
	private JTextField textFieldFirstName;
	private JTextField textFieldSurname;
	private JTextField textFieldAddress;
	private JTextField textFieldMobile;
	private JTextField textFieldEmail;
	private JTextField textFieldCCN;
	private JComboBox comboBoxSelect;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestInfo frame = new GuestInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textFieldNationality;
	private JTextField textFieldSearch;
	private JTextField textFieldAmount;
	private JTextField textFieldTax;
	private JTextField textFieldTotal;
	
	public void refreshTable(){
		try {
			String query = "select * from HotelGuestInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 */
	public GuestInfo() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1470, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 278, 707);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GuestRef");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 99, 30);
		panel.add(lblNewLabel);
		
		textFieldGuestRef = new JTextField();
		textFieldGuestRef.setBounds(119, 12, 137, 29);
		panel.add(textFieldGuestRef);
		textFieldGuestRef.setColumns(10);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(119, 51, 137, 29);
		panel.add(textFieldFirstName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(10, 50, 99, 30);
		panel.add(lblFirstName);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(119, 93, 137, 29);
		panel.add(textFieldSurname);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSurname.setBounds(10, 92, 99, 30);
		panel.add(lblSurname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(10, 133, 99, 30);
		panel.add(lblGender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfBirth.setBounds(10, 179, 99, 30);
		panel.add(lblDateOfBirth);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(119, 220, 137, 29);
		panel.add(textFieldAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(10, 219, 99, 30);
		panel.add(lblAddress);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setColumns(10);
		textFieldMobile.setBounds(119, 261, 137, 29);
		panel.add(textFieldMobile);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobileNumber.setBounds(10, 260, 99, 30);
		panel.add(lblMobileNumber);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(119, 302, 137, 29);
		panel.add(textFieldEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 301, 99, 30);
		panel.add(lblEmail);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNationality.setBounds(10, 342, 99, 30);
		panel.add(lblNationality);
		
		JLabel lblProofOfId = new JLabel("Proof of ID");
		lblProofOfId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProofOfId.setBounds(10, 383, 99, 30);
		panel.add(lblProofOfId);
		
		JLabel lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArrivalDate.setBounds(10, 423, 99, 30);
		panel.add(lblArrivalDate);
		
		JLabel lblDepartureDate = new JLabel("Departure Date");
		lblDepartureDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartureDate.setBounds(10, 464, 99, 30);
		panel.add(lblDepartureDate);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomType.setBounds(10, 505, 99, 30);
		panel.add(lblRoomType);
		
		JLabel lblRoomNumber = new JLabel("Room No.");
		lblRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomNumber.setBounds(10, 546, 99, 30);
		panel.add(lblRoomNumber);
		
		JLabel lblModeOfPayment = new JLabel("Payment Mode");
		lblModeOfPayment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModeOfPayment.setBounds(10, 587, 114, 30);
		panel.add(lblModeOfPayment);
		
		textFieldCCN = new JTextField();
		textFieldCCN.setColumns(10);
		textFieldCCN.setBounds(119, 629, 137, 29);
		panel.add(textFieldCCN);
		
		JLabel lblCreditCardNo = new JLabel("Credit Card No.");
		lblCreditCardNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreditCardNo.setBounds(10, 628, 99, 30);
		panel.add(lblCreditCardNo);
		
		JLabel lblCreditCardExp = new JLabel("Credit Card Exp.");
		lblCreditCardExp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreditCardExp.setBounds(10, 669, 99, 30);
		panel.add(lblCreditCardExp);
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female"}));
		comboBoxGender.setBounds(119, 133, 137, 30);
		panel.add(comboBoxGender);
		
		JComboBox comboBoxProofOfID = new JComboBox();
		comboBoxProofOfID.setModel(new DefaultComboBoxModel(new String[] {"Select Proof of ID", "National ID", "Voters ID", "Passport", "Driver's License", "Social Security Card", "Other"}));
		comboBoxProofOfID.setBounds(119, 383, 137, 30);
		panel.add(comboBoxProofOfID);
		
		JComboBox comboBoxRoomType = new JComboBox();
		comboBoxRoomType.setModel(new DefaultComboBoxModel(new String[] {"Select Room Type", "Single", "Double", "Triple", "Twin", "Family"}));
		comboBoxRoomType.setBounds(119, 505, 137, 30);
		panel.add(comboBoxRoomType);
		
		JComboBox comboBoxRoomNo = new JComboBox();
		comboBoxRoomNo.setModel(new DefaultComboBoxModel(new String[] {"Select Room No.", "001", "002", "003", "004", "005", "006", "007", "008", "009", "101", "102", "103", "104", "105", "106", "107", "108", "109", "201", "202", "203", "204", "205", "206", "207", "208", "209", "301", "302", "303", "304", "305", "306", "307", "308", "309", "401", "402", "403", "404", "405", "406", "407", "408", "409", "501", "502", "503", "504", "505", "506", "507", "508", "509"}));
		comboBoxRoomNo.setBounds(119, 546, 137, 30);
		panel.add(comboBoxRoomNo);
		
		JComboBox comboBoxPaymentMode = new JComboBox();
		comboBoxPaymentMode.setModel(new DefaultComboBoxModel(new String[] {"Select Payment Mode", "Cash", "Credit Card"}));
		comboBoxPaymentMode.setBounds(119, 587, 137, 30);
		panel.add(comboBoxPaymentMode);
		
		JDateChooser dateChooserDOB = new JDateChooser();
		dateChooserDOB.setBounds(119, 179, 137, 30);
		panel.add(dateChooserDOB);
		
		JDateChooser dateChooserArrivalDate = new JDateChooser();
		dateChooserArrivalDate.setBounds(119, 423, 137, 30);
		panel.add(dateChooserArrivalDate);
		
		JDateChooser dateChooserDepartureDate = new JDateChooser();
		dateChooserDepartureDate.setBounds(119, 464, 137, 30);
		panel.add(dateChooserDepartureDate);
		
		textFieldNationality = new JTextField();
		textFieldNationality.setColumns(10);
		textFieldNationality.setBounds(119, 342, 137, 29);
		panel.add(textFieldNationality);
		
		JDateChooser dateChooserCCE = new JDateChooser();
		dateChooserCCE.setBounds(119, 669, 137, 30);
		panel.add(dateChooserCCE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(298, 170, 1042, 405);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1022, 379);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent argO) {
				try {
					int row = table.getSelectedRow();
					String GuestRef_ = (table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from HotelGuestInfo where GuestRef =  '"+GuestRef_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						textFieldGuestRef.setText(rs.getString("GuestRef"));
						textFieldFirstName.setText(rs.getString("FirstName"));
						textFieldSurname.setText(rs.getString("Surname"));
						comboBoxGender.setSelectedItem(rs.getString("Gender"));
						dateChooserDOB.setDateFormatString(rs.getString("DateOfBirth"));
						textFieldAddress.setText(rs.getString("Address"));
						textFieldMobile.setText(rs.getString("MobileNumber"));
						textFieldEmail.setText(rs.getString("Email"));
						textFieldNationality.setText(rs.getString("Nationality"));
						comboBoxProofOfID.setSelectedItem(rs.getString("ProofOfID"));
						dateChooserArrivalDate.setDateFormatString(rs.getString("ArrivalDate"));
						dateChooserDepartureDate.setDateFormatString(rs.getString("DepartureDate"));
						comboBoxRoomType.setSelectedItem(rs.getString("RoomType"));
						comboBoxRoomNo.setSelectedItem(rs.getString("RoomNo"));
						comboBoxPaymentMode.setSelectedItem(rs.getString("PaymentMode"));
						textFieldCCN.setText(rs.getString("CreditCardNo"));
						dateChooserCCE.setDateFormatString(rs.getString("CreditCardExp"));
						
					}
					
					pst.close();
					rs.close();
								
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(298, 11, 1042, 148);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnLoadTable = new JButton("LOAD GUEST DATA");
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				try {
					String query = "select * from HotelGuestInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
								
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadTable.setBounds(359, 62, 322, 41);
		panel_2.add(btnLoadTable);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				String query = "INSERT INTO HotelGuestInfo(GuestRef,FirstName,Surname,Gender,DateOfBirth,Address,MobileNumber,Email,Nationality,ProofOfID,ArrivalDate,DepartureDate,RoomType,RoomNo,PaymentMode,CreditCardNo,CreditCardExp)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldGuestRef.getText() );
					pst.setString(2, textFieldFirstName.getText() );
					pst.setString(3, textFieldSurname.getText() );
					pst.setString(4, (String) comboBoxGender.getSelectedItem() );
					pst.setString(5, dateChooserDOB.getDateFormatString() );
					pst.setString(6, textFieldAddress.getText() );
					pst.setString(7, textFieldMobile.getText() );
					pst.setString(8, textFieldEmail.getText() );
					pst.setString(9, textFieldNationality.getText() );
					pst.setString(10, (String) comboBoxProofOfID.getSelectedItem());
					pst.setString(11, dateChooserArrivalDate.getDateFormatString() );
					pst.setString(12, dateChooserDepartureDate.getDateFormatString() );
					pst.setString(13, (String) comboBoxRoomType.getSelectedItem() );
					pst.setString(14, (String) comboBoxRoomNo.getSelectedItem() );
					pst.setString(15, (String) comboBoxPaymentMode.getSelectedItem() );
					pst.setString(16, textFieldCCN.getText() );
					pst.setString(17, dateChooserCCE.getDateFormatString() );
					
					pst.execute();
					pst.close();		
								
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				if(table.getSelectedRow() == -1) {
					if(table.getSelectedRow() == 0) {
						JOptionPane.showMessageDialog(null, "Data Saved", "Hotel Management System", JOptionPane.OK_OPTION);
						
					}
				}
								
				refreshTable();
			}
		});
		btnSave.setBounds(27, 11, 137, 92);
		panel_2.add(btnSave);
		
		JButton btnUpdate = new JButton("UPDATE / EDIT");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				try {
					String query = "Update HotelGuestInfo set GuestRef='"+textFieldGuestRef.getText()+"' ,FirstName='"+textFieldFirstName.getText()+"' ,Surname='"+textFieldSurname.getText()+"' ,Gender='"+(String) comboBoxGender.getSelectedItem()+"' ,"
							+ "DateOfBirth='"+dateChooserDOB.getDateFormatString()+"' ,Address='"+textFieldAddress.getText()+"' ,MobileNumber='"+textFieldMobile.getText()+"' ,Email='"+textFieldEmail.getText()+"' ,Nationality='"+textFieldNationality.getText()+"' ,"
									+ "ProofOfID='"+(String) comboBoxProofOfID.getSelectedItem()+"' ,ArrivalDate='"+dateChooserArrivalDate.getDateFormatString()+"' ,DepartureDate='"+dateChooserDepartureDate.getDateFormatString()+"' ,RoomType='"+(String) comboBoxRoomType.getSelectedItem()+"' ,"
											+ "RoomNo='"+(String) comboBoxRoomNo.getSelectedItem()+"' ,PaymentMode='"+(String) comboBoxPaymentMode.getSelectedItem()+"' ,CreditCardNo='"+textFieldCCN.getText()+"' ,CreditCardExp='"+dateChooserCCE.getDateFormatString()+"'"
													+ " where GuestRef='"+textFieldGuestRef.getText()+"'  ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					pst.close();		
								
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				refreshTable();
			}
		});
		btnUpdate.setBounds(359, 11, 320, 41);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "DELETE", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
				try {
					String query = "delete from HotelGuestInfo where GuestRef='"+textFieldGuestRef.getText()+"'  ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pst.close();		
								
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				refreshTable();
				}
			}
		});
		btnDelete.setBounds(190, 11, 130, 92);
		panel_2.add(btnDelete);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				try {
					textFieldGuestRef.setText(null);
					textFieldFirstName.setText(null);
					textFieldSurname.setText(null);
					comboBoxGender.setSelectedIndex(0);
					dateChooserDOB.setDate(null);
					textFieldAddress.setText(null);
					textFieldMobile.setText(null);
					textFieldEmail.setText(null);
					textFieldNationality.setText(null);
					comboBoxProofOfID.setSelectedIndex(0);
					dateChooserArrivalDate.setDate(null);
					dateChooserDepartureDate.setDate(null);
					comboBoxRoomType.setSelectedIndex(0);
					comboBoxRoomNo.setSelectedIndex(0);
					comboBoxPaymentMode.setSelectedIndex(0);
					textFieldCCN.setText(null);
					dateChooserCCE.setDate(null);
					
					
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
					
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(713, 11, 137, 92);
		panel_2.add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "EXIT", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
					try {
						System.exit(JFrame.EXIT_ON_CLOSE);
									
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					refreshTable();
					}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(877, 11, 120, 92);
		panel_2.add(btnExit);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent argO) {
				try {
					String selection = (String)comboBoxSelect.getSelectedItem();
					String query = "select * from HotelGuestInfo where "+selection+" = ? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldSearch.getText() );
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();	
					rs.close();
								
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textFieldSearch.setBounds(359, 113, 322, 30);
		panel_2.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		comboBoxSelect = new JComboBox();
		comboBoxSelect.setModel(new DefaultComboBoxModel(new String[] {"Select item to search", "GuestRef", "Surname", "Gender", "ArrivalDate", "DepartureDate", "RoomType", "PaymentMode"}));
		comboBoxSelect.setBounds(80, 114, 240, 29);
		panel_2.add(comboBoxSelect);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(298, 597, 232, 121);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 212, 99);
		panel_3.add(scrollPane_1);
		
		JLabel lblPaymentDetails = new JLabel("PAYMENT DETAILS");
		scrollPane_1.setViewportView(lblPaymentDetails);
		lblPaymentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(551, 597, 139, 31);
		contentPane.add(lblAmount);
		
		JLabel lblTax = new JLabel("TAX");
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTax.setBounds(551, 639, 139, 31);
		contentPane.add(lblTax);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT TO BE PAID");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalAmount.setBounds(551, 681, 253, 31);
		contentPane.add(lblTotalAmount);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(814, 597, 181, 27);
		contentPane.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		textFieldTax = new JTextField();
		textFieldTax.setColumns(10);
		textFieldTax.setBounds(814, 639, 181, 27);
		contentPane.add(textFieldTax);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(814, 685, 181, 27);
		contentPane.add(textFieldTotal);
		
		JButton btnTotal = new JButton("TOTAL");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				double singleRoom = 100;
				double doubleRoom = 180;
				double tripleRoom = 250;
				double twinRoom = 150;
				double familyRoom = 350;
				
				try {
					if(comboBoxRoomType.getSelectedItem().equals("Single")) {
						double t = (singleRoom * 0.014);
						String tax = String.format("GHS %.2f", t);
						textFieldTax.setText(tax);
						
						String Amount = String.format("GHS %.2f", singleRoom);
						textFieldAmount.setText(Amount);
						
						String TotalAmountPaid = String.format("GHS %.2f", singleRoom + t);
						textFieldTotal.setText(TotalAmountPaid);
					}
					else if(comboBoxRoomType.getSelectedItem().equals("Double")) {
						double t = (doubleRoom * 0.014);
						String tax = String.format("GHS %.2f", t);
						textFieldTax.setText(tax);
						
						String Amount = String.format("GHS %.2f", doubleRoom);
						textFieldAmount.setText(Amount);
						
						String TotalAmountPaid = String.format("GHS %.2f", doubleRoom + t);
						textFieldTotal.setText(TotalAmountPaid);
					}
					else if(comboBoxRoomType.getSelectedItem().equals("Triple")) {
						double t = (tripleRoom * 0.014);
						String tax = String.format("GHS %.2f", t);
						textFieldTax.setText(tax);
						
						String Amount = String.format("GHS %.2f", tripleRoom);
						textFieldAmount.setText(Amount);
						
						String TotalAmountPaid = String.format("GHS %.2f", tripleRoom + t);
						textFieldTotal.setText(TotalAmountPaid);
					}
					else if(comboBoxRoomType.getSelectedItem().equals("Twin")) {
						double t = (twinRoom * 0.014);
						String tax = String.format("GHS %.2f", t);
						textFieldTax.setText(tax);
						
						String Amount = String.format("GHS %.2f", twinRoom);
						textFieldAmount.setText(Amount);
						
						String TotalAmountPaid = String.format("GHS %.2f", twinRoom + t);
						textFieldTotal.setText(TotalAmountPaid);
					}
					else if(comboBoxRoomType.getSelectedItem().equals("Family")) {
						double t = (familyRoom * 0.014);
						String tax = String.format("GHS %.2f", t);
						textFieldTax.setText(tax);
						
						String Amount = String.format("GHS %.2f", familyRoom);
						textFieldAmount.setText(Amount);
						
						String TotalAmountPaid = String.format("GHS %.2f", familyRoom + t);
						textFieldTotal.setText(TotalAmountPaid);
					}
					
						
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				refreshTable();
				
			}
		});
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTotal.setBounds(1030, 597, 120, 115);
		contentPane.add(btnTotal);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argO) {
				try {
					table.print();
					
				} catch(java.awt.print.PrinterException e) {
					System.err.format("No Printer Found", e.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(1184, 597, 120, 115);
		contentPane.add(btnPrint);
		
		refreshTable();
	}
}
