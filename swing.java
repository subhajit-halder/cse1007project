import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;

public class CheckSum extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	JCheckBox chckbxMd;
	JCheckBox chckbxSha;
	JCheckBox chckbxSha_1;
	JCheckBox chckbxSha_2;
	JLabel op;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckSum frame = new CheckSum();
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
	public CheckSum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckSumGeneration = new JLabel("CHECK SUM GENERATION");
		lblCheckSumGeneration.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCheckSumGeneration.setBounds(290, 13, 385, 57);
		contentPane.add(lblCheckSumGeneration);
		
		JLabel lblEnterFilePath = new JLabel("Enter file path");
		lblEnterFilePath.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterFilePath.setBounds(26, 120, 107, 16);
		contentPane.add(lblEnterFilePath);
		
		textField = new JTextField();
		textField.setBounds(151, 118, 397, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAlgorithm = new JLabel("Algorithm");
		lblAlgorithm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlgorithm.setBounds(26, 220, 107, 27);
		contentPane.add(lblAlgorithm);
		chckbxMd = new JCheckBox("md5");
		chckbxMd.setBounds(151, 223, 70, 22);
		contentPane.add(chckbxMd);
		
		chckbxSha = new JCheckBox("sha256");
		chckbxSha.setBounds(225, 220, 70, 27);
		contentPane.add(chckbxSha);
		
		chckbxSha_1 = new JCheckBox("sha384");
		chckbxSha_1.setBounds(299, 223, 79, 22);
		contentPane.add(chckbxSha_1);
		
		 chckbxSha_2 = new JCheckBox("sha512");
		chckbxSha_2.setBounds(382, 223, 79, 22);
		contentPane.add(chckbxSha_2);
		
		JButton btnEnter = new JButton("Enter");
		
		contentPane.add(btnEnter);
		btnEnter.setBounds(77, 319, 97, 25);
		btnEnter.addActionListener(this);
		op = new JLabel("OUTPUT");
		op.setBounds(77, 430, 800, 200);
		contentPane.add(op);
		
		

		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		try {
		
		if(chckbxMd.isSelected()) {
			new md5();
			op.setText(md5.getMD5Checksum(textField.getText()));
		}
		else if(chckbxSha.isSelected()) {
            new sha256();
			op.setText(sha256.digestoffile(textField.getText()));
            
		}
		else if(chckbxSha_1.isSelected()) {
			new Sha384();
			op.setText(Sha384.encryptThisString(textField.getText()));
		}
		else if(chckbxSha_2.isSelected()) {
			new sha512();
			op.setText(sha512.getSHA512Checksum(textField.getText()));
		}
		}
		catch(Exception e) {
			
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}