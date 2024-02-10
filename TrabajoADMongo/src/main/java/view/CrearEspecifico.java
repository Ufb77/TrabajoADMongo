package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Main;

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
		textTonalidad.addFocusListener(this);

		textNumCuerdas = new JTextField();
		textNumCuerdas.setText("Nº Cuerdas");
		textNumCuerdas.setBounds(32, 126, 188, 36);
		getContentPane().add(textNumCuerdas);
		textNumCuerdas.addFocusListener(this);

		textNumTambores = new JTextField();
		textNumTambores.setText("Nº Tambores");
		textNumTambores.setBounds(32, 240, 188, 36);
		getContentPane().add(textNumTambores);
		textNumTambores.addFocusListener(this);

		textNumTeclas = new JTextField();
		textNumTeclas.setText("Nº Teclas");
		textNumTeclas.setBounds(32, 183, 188, 36);
		getContentPane().add(textNumTeclas);
		textNumTeclas.addFocusListener(this);

		textNumPedales = new JTextField();
		textNumPedales.setText("Nº Pedales");
		textNumPedales.setBounds(262, 63, 188, 36);
		getContentPane().add(textNumPedales);
		textNumPedales.addFocusListener(this);

		txtMaterial = new JTextField();
		txtMaterial.setText("Material");
		txtMaterial.setBounds(262, 126, 188, 36);
		getContentPane().add(txtMaterial);
		txtMaterial.addFocusListener(this);

		txtClasificacion = new JTextField();
		txtClasificacion.setText("Clasificacion");
		txtClasificacion.setBounds(262, 183, 188, 36);
		getContentPane().add(txtClasificacion);
		txtClasificacion.addFocusListener(this);

		txtElementoParaTocar = new JTextField();
		txtElementoParaTocar.setText("Elemento para tocar");
		txtElementoParaTocar.setBounds(262, 240, 188, 36);
		getContentPane().add(txtElementoParaTocar);
		txtElementoParaTocar.addFocusListener(this);

		txtFormato = new JTextField();
		txtFormato.setText("Formato");
		txtFormato.setBounds(481, 112, 140, 36);
		getContentPane().add(txtFormato);
		txtFormato.addFocusListener(this);
		
		txtConexion = new JTextField();
		txtConexion.setText("Conexion");
		txtConexion.setBounds(481, 158, 140, 36);
		getContentPane().add(txtConexion);
		txtConexion.addFocusListener(this);
		
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(532, 335, 89, 23);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnAtras = new JButton("<-");
		btnAtras.setBounds(418, 335, 89, 23);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
	}


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(textTonalidad == e.getSource()) {
			System.out.println(textTonalidad.getText());
			Main.obtenerTonalidad(textTonalidad.getText());
		}else if(textNumCuerdas == e.getSource()) {
			System.out.println(textNumCuerdas.getText());
			Main.obtenerNumCuerdas(textNumCuerdas.getText());
		}else if(textNumTambores == e.getSource()) {
			System.out.println(textNumTambores.getText());
			Main.obtenerNumTambores(textNumTambores.getText());
		}else if(textNumTeclas == e.getSource()) {
			System.out.println(textNumTeclas.getText());
			Main.obtenerNumTeclas(textNumTeclas.getText());
		}else if(textNumPedales == e.getSource()) {
			System.out.println(textNumPedales.getText());
			Main.obtenerNumPedales(textNumPedales.getText());
		}else if(txtMaterial == e.getSource()) {
			System.out.println(txtMaterial.getText());
			Main.obtenerMaterial(txtMaterial.getText());
		}else if(txtClasificacion == e.getSource()) {
			System.out.println(txtClasificacion.getText());
			Main.obtenerClasificacion(txtClasificacion.getText());
		}else if(txtElementoParaTocar == e.getSource()) {
			System.out.println(txtElementoParaTocar.getText());
			Main.obtenerAccesorioTocar(txtElementoParaTocar.getText());
		}else if(txtFormato == e.getSource()) {
			System.out.println(txtFormato.getText());
			Main.obtenerFormato(txtFormato.getText());
		}else if(txtConexion == e.getSource()) {
			System.out.println(txtConexion.getText());
			Main.obtenerConexion(txtConexion.getText());
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnAdd == e.getSource()) {
			Main.addDocument();
			new General().setVisible(true);
			dispose();
		}else if(btnAtras == e.getSource()) {
			new CrearGeneral().setVisible(true);
			dispose();
		}
	}
}
