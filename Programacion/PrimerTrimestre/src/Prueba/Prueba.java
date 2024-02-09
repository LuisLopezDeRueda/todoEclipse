package Prueba;

import javax.swing.JFrame;

public class Prueba {
	
	public static void main(String[] ar) {
		
	JFrame ventana=new JFrame();
	ventana.setTitle("Ejemplo titulo"); //Titulo
	ventana.setSize(600,400);; //Tamaño
	ventana.setLocationRelativeTo(null);//Si es null la ventana sale centrada en la pantalla
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cuando salgamos del programa termine el proceso
	ventana.setVisible(true );//Para que se vea 
	}
	
}
