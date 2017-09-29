package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Ip;

public class Calculator {

	private JFrame frmSubnetCalculator;
	private JTextField firstOct;
	private JTextField secondOct;
	private JTextField thirdOct;
	private JTextField fourthOct;
	private Ip ip;
	private JTextField vlsm1Oct;
	private JTextField vlsm2Oct;
	private JTextField vlsm3Oct;
	private JTextField vlsm4Oct;
	private JTextField vlsmLength;
	private JTextField ipSubnet1Oct;
	private JTextField ipSubnet2Oct;
	private JTextField ipSubnet3Oct;
	private JTextField ipSubnet4Oct;
	private JTextField subnet1Oct;
	private JTextField subnet2Oct;
	private JTextField subnet3Oct;
	private JTextField subnet4Oct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					Calculator window = new Calculator();
					window.frmSubnetCalculator.setVisible(true);
					window.frmSubnetCalculator.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSubnetCalculator = new JFrame();
		frmSubnetCalculator.setResizable(false);
		frmSubnetCalculator.setAlwaysOnTop(true);
		frmSubnetCalculator.setLocationRelativeTo(null);
		frmSubnetCalculator.setTitle("Subnet Calculator");
		frmSubnetCalculator.setBounds(100, 100, 435, 457);
		frmSubnetCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSubnetCalculator.getContentPane().setLayout(null);
		ip = new Ip();

		JLabel lblNewLabel = new JLabel("Enter the ip adress:");
		lblNewLabel.setBounds(10, 11, 434, 14);
		frmSubnetCalculator.getContentPane().add(lblNewLabel);

		firstOct = new JTextField();
		firstOct.setHorizontalAlignment(SwingConstants.RIGHT);
		firstOct.setToolTipText("Value should be an integer 1-255");
		firstOct.setBounds(72, 36, 30, 20);
		frmSubnetCalculator.getContentPane().add(firstOct);
		firstOct.setColumns(3);

		secondOct = new JTextField();
		secondOct.setHorizontalAlignment(SwingConstants.RIGHT);
		secondOct.setToolTipText("Value should be an integer 1-255");
		secondOct.setBounds(132, 36, 30, 20);
		frmSubnetCalculator.getContentPane().add(secondOct);
		secondOct.setColumns(3);

		thirdOct = new JTextField();
		thirdOct.setHorizontalAlignment(SwingConstants.RIGHT);
		thirdOct.setToolTipText("Value should be an integer 1-255");
		thirdOct.setBounds(192, 36, 30, 20);
		frmSubnetCalculator.getContentPane().add(thirdOct);
		thirdOct.setColumns(3);

		fourthOct = new JTextField();
		fourthOct.setHorizontalAlignment(SwingConstants.RIGHT);
		fourthOct.setToolTipText("Value should be an integer 1-255");
		fourthOct.setBounds(252, 36, 30, 20);
		frmSubnetCalculator.getContentPane().add(fourthOct);
		fourthOct.setColumns(3);

		JLabel label = new JLabel(".");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(112, 39, 10, 14);
		frmSubnetCalculator.getContentPane().add(label);

		JLabel label_1 = new JLabel(".");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(172, 39, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_1);

		JLabel label_2 = new JLabel(".");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(232, 39, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_2);

		JButton btnNewButton = new JButton("Show Info");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ip.setFirstOctet(Integer.parseInt(firstOct.getText()));
				ip.setSecondOctet(Integer.parseInt(secondOct.getText()));
				ip.setThirdOctet(Integer.parseInt(thirdOct.getText()));
				ip.setFourthOctet(Integer.parseInt(fourthOct.getText()));

				String err = new String();
				boolean flag = false;

				if (ip.getFirstOctet() <= 0 || ip.getFirstOctet() > 255) {
					err = err + " First octet is out of range! ";
					firstOct.setText("");
					flag = true;
				}
				if (ip.getSecondOctet() <= 0 || ip.getSecondOctet() > 255) {
					secondOct.setText("");
					err = err + " Second octet is out of range! ";
					flag = true;
				}
				if (ip.getThirdOctet() <= 0 || ip.getThirdOctet() > 255) {
					thirdOct.setText("");
					err = err + " Third octet is out of range! ";
					flag = true;
				}
				if (ip.getFourthOctet() <= 0 || ip.getFourthOctet() > 255) {
					fourthOct.setText("");
					err = err + " Fourth octet is out of range! ";
					flag = true;
				}
				
				if(flag == true) {
					JOptionPane.showMessageDialog(frmSubnetCalculator, err, "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(324, 158, 81, 22);
		frmSubnetCalculator.getContentPane().add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 191, 395, 2);
		frmSubnetCalculator.getContentPane().add(separator);
		
		JLabel lblIpI = new JLabel("Result");
		lblIpI.setBounds(10, 204, 39, 14);
		frmSubnetCalculator.getContentPane().add(lblIpI);
		
		JLabel lblNewLabel_1 = new JLabel("Network Class: ");
		lblNewLabel_1.setBounds(10, 229, 75, 14);
		frmSubnetCalculator.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSubnetMask = new JLabel("Subnet Mask:");
		lblSubnetMask.setBounds(10, 254, 75, 14);
		frmSubnetCalculator.getContentPane().add(lblSubnetMask);
		
		JLabel lblCidr = new JLabel("CIDR: ");
		lblCidr.setBounds(10, 279, 32, 14);
		frmSubnetCalculator.getContentPane().add(lblCidr);
		
		JLabel lblHostPerSubnet = new JLabel("Host per Subnet: ");
		lblHostPerSubnet.setBounds(10, 304, 90, 14);
		frmSubnetCalculator.getContentPane().add(lblHostPerSubnet);
		
		JLabel lblNetworkAdress = new JLabel("Network Address:");
		lblNetworkAdress.setBounds(10, 329, 90, 14);
		frmSubnetCalculator.getContentPane().add(lblNetworkAdress);
		
		JLabel lblBroadcastAdress = new JLabel("Broadcast Adress:");
		lblBroadcastAdress.setBounds(10, 354, 90, 14);
		frmSubnetCalculator.getContentPane().add(lblBroadcastAdress);
		
		JLabel lblBitsInHost = new JLabel("Bits in Host:");
		lblBitsInHost.setBounds(10, 379, 57, 14);
		frmSubnetCalculator.getContentPane().add(lblBitsInHost);
		
		JLabel lblBitsInNetwork = new JLabel("Bits in Network:");
		lblBitsInNetwork.setBounds(10, 404, 75, 14);
		frmSubnetCalculator.getContentPane().add(lblBitsInNetwork);
		
		vlsm1Oct = new JTextField();
		vlsm1Oct.setEnabled(false);
		vlsm1Oct.setToolTipText("Value should be an integer 1-255");
		vlsm1Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		vlsm1Oct.setColumns(3);
		vlsm1Oct.setBounds(72, 67, 30, 20);
		frmSubnetCalculator.getContentPane().add(vlsm1Oct);
		
		JLabel label_3 = new JLabel(".");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(112, 73, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_3);
		
		vlsm2Oct = new JTextField();
		vlsm2Oct.setEnabled(false);
		vlsm2Oct.setToolTipText("Value should be an integer 1-255");
		vlsm2Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		vlsm2Oct.setColumns(3);
		vlsm2Oct.setBounds(132, 67, 30, 20);
		frmSubnetCalculator.getContentPane().add(vlsm2Oct);
		
		vlsm3Oct = new JTextField();
		vlsm3Oct.setEnabled(false);
		vlsm3Oct.setToolTipText("Value should be an integer 1-255");
		vlsm3Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		vlsm3Oct.setColumns(3);
		vlsm3Oct.setBounds(192, 67, 30, 20);
		frmSubnetCalculator.getContentPane().add(vlsm3Oct);
		
		vlsm4Oct = new JTextField();
		vlsm4Oct.setEnabled(false);
		vlsm4Oct.setToolTipText("Value should be an integer 1-255");
		vlsm4Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		vlsm4Oct.setColumns(3);
		vlsm4Oct.setBounds(252, 67, 30, 20);
		frmSubnetCalculator.getContentPane().add(vlsm4Oct);
		
		JLabel label_4 = new JLabel(".");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(232, 73, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(".");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(172, 73, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("/");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(292, 70, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_6);
		
		vlsmLength = new JTextField();
		vlsmLength.setEnabled(false);
		vlsmLength.setBounds(314, 67, 30, 20);
		frmSubnetCalculator.getContentPane().add(vlsmLength);
		vlsmLength.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("");
		
		radioButton.setSelected(true);
		radioButton.setBounds(33, 33, 21, 23);
		frmSubnetCalculator.getContentPane().add(radioButton);
		
		JRadioButton ipVLSM = new JRadioButton("");

		
		ipVLSM.setBounds(33, 64, 21, 23);
		frmSubnetCalculator.getContentPane().add(ipVLSM);
		
		JRadioButton ipAndSubnet = new JRadioButton("");
		
		
		
		ipSubnet1Oct = new JTextField();
		ipSubnet1Oct.setEnabled(false);
		ipSubnet1Oct.setToolTipText("Value should be an integer 1-255");
		ipSubnet1Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		ipSubnet1Oct.setColumns(3);
		ipSubnet1Oct.setBounds(72, 98, 30, 20);
		frmSubnetCalculator.getContentPane().add(ipSubnet1Oct);
		
		ipSubnet2Oct = new JTextField();
		ipSubnet2Oct.setEnabled(false);
		ipSubnet2Oct.setToolTipText("Value should be an integer 1-255");
		ipSubnet2Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		ipSubnet2Oct.setColumns(3);
		ipSubnet2Oct.setBounds(132, 97, 30, 20);
		frmSubnetCalculator.getContentPane().add(ipSubnet2Oct);
		
		ipSubnet3Oct = new JTextField();
		ipSubnet3Oct.setEnabled(false);
		ipSubnet3Oct.setToolTipText("Value should be an integer 1-255");
		ipSubnet3Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		ipSubnet3Oct.setColumns(3);
		ipSubnet3Oct.setBounds(192, 97, 30, 20);
		frmSubnetCalculator.getContentPane().add(ipSubnet3Oct);
		
		ipSubnet4Oct = new JTextField();
		ipSubnet4Oct.setEnabled(false);
		ipSubnet4Oct.setToolTipText("Value should be an integer 1-255");
		ipSubnet4Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		ipSubnet4Oct.setColumns(3);
		ipSubnet4Oct.setBounds(252, 98, 30, 20);
		frmSubnetCalculator.getContentPane().add(ipSubnet4Oct);
		
		subnet1Oct = new JTextField();
		subnet1Oct.setEnabled(false);
		subnet1Oct.setToolTipText("Value should be an integer 1-255");
		subnet1Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		subnet1Oct.setColumns(3);
		subnet1Oct.setBounds(72, 129, 30, 20);
		frmSubnetCalculator.getContentPane().add(subnet1Oct);
		
		subnet2Oct = new JTextField();
		subnet2Oct.setEnabled(false);
		subnet2Oct.setToolTipText("Value should be an integer 1-255");
		subnet2Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		subnet2Oct.setColumns(3);
		subnet2Oct.setBounds(132, 129, 30, 20);
		frmSubnetCalculator.getContentPane().add(subnet2Oct);
		
		subnet3Oct = new JTextField();
		subnet3Oct.setEnabled(false);
		subnet3Oct.setToolTipText("Value should be an integer 1-255");
		subnet3Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		subnet3Oct.setColumns(3);
		subnet3Oct.setBounds(192, 128, 30, 20);
		frmSubnetCalculator.getContentPane().add(subnet3Oct);
		
		subnet4Oct = new JTextField();
		subnet4Oct.setEnabled(false);
		subnet4Oct.setToolTipText("Value should be an integer 1-255");
		subnet4Oct.setHorizontalAlignment(SwingConstants.RIGHT);
		subnet4Oct.setColumns(3);
		subnet4Oct.setBounds(252, 129, 30, 20);
		frmSubnetCalculator.getContentPane().add(subnet4Oct);
		
		
		ipAndSubnet.setBounds(33, 94, 21, 23);
		frmSubnetCalculator.getContentPane().add(ipAndSubnet);
		
		/*When the states are change on the radio buttons then the fields are turn disabled */
		radioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(radioButton.isSelected()) {
					ipVLSM.setSelected(false);
					ipAndSubnet.setSelected(false);
					firstOct.setEnabled(true);
					secondOct.setEnabled(true);
					thirdOct.setEnabled(true);
					fourthOct.setEnabled(true);
					vlsm1Oct.setEnabled(false);
					vlsm2Oct.setEnabled(false);
					vlsm3Oct.setEnabled(false);
					vlsm4Oct.setEnabled(false);
					vlsmLength.setEnabled(false);
					ipSubnet1Oct.setEnabled(false);
					ipSubnet2Oct.setEnabled(false);
					ipSubnet3Oct.setEnabled(false);
					ipSubnet4Oct.setEnabled(false);
					subnet1Oct.setEnabled(false);
					subnet2Oct.setEnabled(false);
					subnet3Oct.setEnabled(false);
					subnet4Oct.setEnabled(false);
				}
			}
		});
		
		ipAndSubnet.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(ipAndSubnet.isSelected()) {
					radioButton.setSelected(false);
					ipVLSM.setSelected(false);
					firstOct.setEnabled(false);
					secondOct.setEnabled(false);
					thirdOct.setEnabled(false);
					fourthOct.setEnabled(false);
					vlsm1Oct.setEnabled(false);
					vlsm2Oct.setEnabled(false);
					vlsm3Oct.setEnabled(false);
					vlsm4Oct.setEnabled(false);
					vlsmLength.setEnabled(false);
					ipSubnet1Oct.setEnabled(true);
					ipSubnet2Oct.setEnabled(true);
					ipSubnet3Oct.setEnabled(true);
					ipSubnet4Oct.setEnabled(true);
					subnet1Oct.setEnabled(true);
					subnet2Oct.setEnabled(true);
					subnet3Oct.setEnabled(true);
					subnet4Oct.setEnabled(true);
				}
			}
		});
		ipVLSM.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(ipVLSM.isSelected()) {
					radioButton.setSelected(false);
					ipAndSubnet.setSelected(false);
					firstOct.setEnabled(false);
					secondOct.setEnabled(false);
					thirdOct.setEnabled(false);
					fourthOct.setEnabled(false);
					vlsm1Oct.setEnabled(true);
					vlsm2Oct.setEnabled(true);
					vlsm3Oct.setEnabled(true);
					vlsm4Oct.setEnabled(true);
					vlsmLength.setEnabled(true);
					ipSubnet1Oct.setEnabled(false);
					ipSubnet2Oct.setEnabled(false);
					ipSubnet3Oct.setEnabled(false);
					ipSubnet4Oct.setEnabled(false);
					subnet1Oct.setEnabled(false);
					subnet2Oct.setEnabled(false);
					subnet3Oct.setEnabled(false);
					subnet4Oct.setEnabled(false);
				}
			}
		});
		
		JLabel label_7 = new JLabel(".");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(112, 103, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel(".");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(112, 135, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel(".");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(172, 135, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel(".");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(172, 103, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel(".");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(232, 103, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel(".");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(232, 132, 10, 14);
		frmSubnetCalculator.getContentPane().add(label_12);
		
		}
}
