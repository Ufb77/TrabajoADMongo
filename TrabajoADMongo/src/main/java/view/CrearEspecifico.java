package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CrearEspecifico extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1L;

	JTextField textTonalidad, textNumCuerdas, textNumTambores, textNumTeclastxtNPedales, txtMaterial, txtClasificacion, 
	txtElementoParaTocar, txtFormato, txtConexion, textNumTeclas, textNumPedales;
	private JButton btnAdd;
	private JButton btnAtras;
	

	/**
	 * Create the frame.
	 */
	public CrearEspecifico() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		textTonalidad = new JTextField();
		textTonalidad.setText("Tonalidad");
		textTonalidad.setBounds(32, 63, 188, 36);
		getContentPane().add(textTonalidad);

		textNumCuerdas = new JTextField();
		textNumCuerdas.setText("Nº Cuerdas");
		textNumCuerdas.setBounds(32, 126, 188, 36);
		getContentPane().add(textNumCuerdas);

		textNumTambores = new JTextField();
		textNumTambores.setText("Nº Tambores");
		textNumTambores.setBounds(32, 240, 188, 36);
		getContentPane().add(textNumTambores);

		textNumTeclas = new JTextField();
		textNumTeclas.setText("Nº Teclas");
		textNumTeclas.setBounds(32, 183, 188, 36);
		getContentPane().add(textNumTeclas);

		textNumPedales = new JTextField();
		textNumPedales.setText("Nº Pedales");
		textNumPedales.setBounds(262, 63, 188, 36);
		getContentPane().add(textNumPedales);

		txtMaterial = new JTextField();
		txtMaterial.setText("Material");
		txtMaterial.setBounds(262, 126, 188, 36);
		getContentPane().add(txtMaterial);

		txtClasificacion = new JTextField();
		txtClasificacion.setText("Clasificacion");
		txtClasificacion.setBounds(262, 183, 188, 36);
		getContentPane().add(txtClasificacion);

		txtElementoParaTocar = new JTextField();
		txtElementoParaTocar.setText("Elemento para tocar");
		txtElementoParaTocar.setBounds(262, 240, 188, 36);
		getContentPane().add(txtElementoParaTocar);

		txtFormato = new JTextField();
		txtFormato.setText("Formato");
		txtFormato.setBounds(481, 112, 140, 36);
		getContentPane().add(txtFormato);

		txtConexion = new JTextField();
		txtConexion.setText("Conexion");
		txtConexion.setBounds(481, 158, 140, 36);
		getContentPane().add(txtConexion);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(532, 335, 89, 23);
		getContentPane().add(btnAdd);
		
		btnAtras = new JButton("<-");
		btnAtras.setBounds(418, 335, 89, 23);
		getContentPane().add(btnAtras);

	}


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
