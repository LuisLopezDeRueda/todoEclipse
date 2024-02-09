package EJ6Otraforma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InicializarEJ6OJ  implements ActionListener{
	
	private JButton boton;
	private JTextField textField;
	
	
	public InicializarEJ6OJ(JButton boton1, JTextField textField1) {
		boton = boton1;
		textField = textField1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(textField.getText().isEmpty()) {
				textField.setText("1");
			}else {
				textField.setText((Integer.parseInt(textField.getText())+1)+"");
			}
			}catch(NumberFormatException error) {
				textField.setText("");
				
				JOptionPane.showMessageDialog(boton, "Has puesto una palabra ", "Error de palabra" , JOptionPane.ERROR_MESSAGE, null);;
				
			}
		}
	};

