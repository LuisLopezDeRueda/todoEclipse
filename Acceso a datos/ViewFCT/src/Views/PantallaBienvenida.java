package Views;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PantallaBienvenida extends View{
	
	private JLabel lblBienvenida;
	
	
	public PantallaBienvenida(AppController appView) {
		super(appView);			
		setLayout(null);
		
		lblBienvenida = new JLabel();
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setLabelFor(this);
		lblBienvenida.setBounds(93, 108, 246, 76);
		add(lblBienvenida);
		
	}
	public void actualizar() {
		lblBienvenida.setText("BIENVENIDO " + appView.getUsuarioPrueba().getNombre());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541745109735952352L;

	
}
