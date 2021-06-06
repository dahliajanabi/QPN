package GUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataObjects.DataComplexVector;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import Utilities.DataOverNetwork;

import javax.swing.JTextPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class InputFloatFloat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFloatFloat frame = new InputFloatFloat(); // change here
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
	public InputFloatFloat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtReal1 = new JTextPane();
		txtReal1.setText("1.0");
		txtReal1.setToolTipText("");
		txtReal1.setBounds(10, 38, 72, 20);
		contentPane.add(txtReal1);

		JTextPane txtReal2 = new JTextPane(); // new text box
		txtReal2.setToolTipText("");
		txtReal2.setText("1.0");
		txtReal2.setBounds(10, 69, 72, 20);
		contentPane.add(txtReal2);

		JTextPane txtImaginary1 = new JTextPane();
		txtImaginary1.setToolTipText("");
		txtImaginary1.setText("1.0");
		txtImaginary1.setBounds(99, 38, 72, 20);
		contentPane.add(txtImaginary1);

		JTextPane txtImaginary2 = new JTextPane();
		txtImaginary2.setToolTipText("");
		txtImaginary2.setText("1.0");
		txtImaginary2.setBounds(99, 69, 72, 20);
		contentPane.add(txtImaginary2);

		JTextPane txtPetriPort = new JTextPane();
		txtPetriPort.setText("1080");
		txtPetriPort.setBounds(10, 100, 285, 20);
		contentPane.add(txtPetriPort);

		JTextPane txtTargetPlaceName = new JTextPane();
		txtTargetPlaceName.setText("p4");
		txtTargetPlaceName.setBounds(10, 7, 285, 20);
		contentPane.add(txtTargetPlaceName);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socket s;
				try {
					s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(txtPetriPort.getText()));
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					DataOverNetwork DataToSend = new DataOverNetwork();
					DataToSend.petriObject = new DataComplexVector(); // change here
					if (!txtReal1.getText().equals("null")) {

						DataComplexVector p1 = new DataComplexVector();
						p1.SetName(txtTargetPlaceName.getText());
						p1.Value = new ComplexVector(2,
								new ComplexValue(Float.parseFloat(txtReal1.getText()),
										Float.parseFloat(txtImaginary1.getText())),
								new ComplexValue(Float.parseFloat(txtReal2.getText()),
										Float.parseFloat(txtImaginary2.getText())));
						DataToSend.petriObject.SetValue(p1);
					} else {
						DataToSend.petriObject.SetValue(null);
					}
					DataToSend.petriObject.SetName(txtTargetPlaceName.getText());

					DataToSend.NetWorkPort = Integer.parseInt(txtPetriPort.getText());
					oos.writeObject(DataToSend);
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(166, 131, 129, 44);
		contentPane.add(btnSend);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtReal1.setText("");
				txtReal2.setText("");
				txtImaginary1.setText("");
				txtImaginary2.setText("");
			}
		});
		btnClear.setBounds(10, 131, 146, 44);
		contentPane.add(btnClear);
	}
}
