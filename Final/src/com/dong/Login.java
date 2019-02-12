package com.dong;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 46, 172, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("·ÂËÎ", Font.PLAIN, 22));
		label.setBounds(55, 46, 71, 37);
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801");
		label_2.setFont(new Font("·ÂËÎ", Font.PLAIN, 22));
		label_2.setBounds(55, 96, 71, 37);
		panel.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 96, 172, 37);
		panel.add(passwordField);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(55, 182, 83, 27);
		panel.add(button);
		
		JButton button_1 = new JButton("\u767B\u9646");
		button_1.setBounds(181, 182, 93, 27);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		button_2.setBounds(315, 182, 93, 27);
		panel.add(button_2);
	}
}
