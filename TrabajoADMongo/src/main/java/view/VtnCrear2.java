package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Main;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VtnCrear2 extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1L;
	private JTextField textTonalidad, textNumCuerdas, textNumTambores, txtMaterial, txtClasificacion, 
	txtElementoParaTocar, txtFormato, txtConexion, textNumTeclas, textNumPedales;
	private static final String[] PLACEHOLDER = {"Tonalidad", "NumCuerdas", "NumTambores", "NumTeclas", "NumPedales", "Material", "Clasificacion", 
			"Elemento para tocar", "Formato", "Conexion"};
	private JButton btnAdd, btnAtras;
	

	/**
	 * Create the frame.
	 */
	public VtnCrear2() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		textTonalidad = new JTextField();
		textTonalidad.setFont(new Font("Serif", Font.BOLD, 15));
		textTonalidad.setHorizontalAlignment(SwingConstants.CENTER);
		textTonalidad.setText(PLACEHOLDER[0]);
		textTonalidad.setBounds(84, 62, 188, 36);
		getContentPane().add(textTonalidad);
		textTonalidad.addFocusListener(this);

		textNumCuerdas = new JTextField();
		textNumCuerdas.setFont(new Font("Serif", Font.BOLD, 15));
		textNumCuerdas.setHorizontalAlignment(SwingConstants.CENTER);
		textNumCuerdas.setText(PLACEHOLDER[1]);
		textNumCuerdas.setBounds(84, 108, 188, 36);
		getContentPane().add(textNumCuerdas);
		textNumCuerdas.addFocusListener(this);

		textNumTambores = new JTextField();
		textNumTambores.setFont(new Font("Serif", Font.BOLD, 15));
		textNumTambores.setHorizontalAlignment(SwingConstants.CENTER);
		textNumTambores.setText(PLACEHOLDER[2]);
		textNumTambores.setBounds(84, 200, 188, 36);
		getContentPane().add(textNumTambores);
		textNumTambores.addFocusListener(this);

		textNumTeclas = new JTextField();
		textNumTeclas.setFont(new Font("Serif", Font.BOLD, 15));
		textNumTeclas.setHorizontalAlignment(SwingConstants.CENTER);
		textNumTeclas.setText(PLACEHOLDER[3]);
		textNumTeclas.setBounds(84, 154, 188, 36);
		getContentPane().add(textNumTeclas);
		textNumTeclas.addFocusListener(this);

		textNumPedales = new JTextField();
		textNumPedales.setFont(new Font("Serif", Font.BOLD, 15));
		textNumPedales.setHorizontalAlignment(SwingConstants.CENTER);
		textNumPedales.setText(PLACEHOLDER[4]);
		textNumPedales.setBounds(364, 62, 188, 36);
		getContentPane().add(textNumPedales);
		textNumPedales.addFocusListener(this);

		txtMaterial = new JTextField();
		txtMaterial.setFont(new Font("Serif", Font.BOLD, 15));
		txtMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaterial.setText(PLACEHOLDER[5]);
		txtMaterial.setBounds(364, 108, 188, 36);
		getContentPane().add(txtMaterial);
		txtMaterial.addFocusListener(this);

		txtClasificacion = new JTextField();
		txtClasificacion.setFont(new Font("Serif", Font.BOLD, 15));
		txtClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtClasificacion.setText(PLACEHOLDER[6]);
		txtClasificacion.setBounds(364, 154, 188, 36);
		getContentPane().add(txtClasificacion);
		txtClasificacion.addFocusListener(this);

		txtElementoParaTocar = new JTextField();
		txtElementoParaTocar.setFont(new Font("Serif", Font.BOLD, 15));
		txtElementoParaTocar.setHorizontalAlignment(SwingConstants.CENTER);
		txtElementoParaTocar.setText(PLACEHOLDER[7]);
		txtElementoParaTocar.setBounds(364, 200, 188, 36);
		getContentPane().add(txtElementoParaTocar);
		txtElementoParaTocar.addFocusListener(this);

		txtFormato = new JTextField();
		txtFormato.setFont(new Font("Serif", Font.BOLD, 15));
		txtFormato.setHorizontalAlignment(SwingConstants.CENTER);
		txtFormato.setText(PLACEHOLDER[8]);
		txtFormato.setBounds(84, 246, 188, 36);
		getContentPane().add(txtFormato);
		txtFormato.addFocusListener(this);
		
		txtConexion = new JTextField();
		txtConexion.setFont(new Font("Serif", Font.BOLD, 15));
		txtConexion.setHorizontalAlignment(SwingConstants.CENTER);
		txtConexion.setText(PLACEHOLDER[9]);
		txtConexion.setBounds(364, 246, 188, 36);
		getContentPane().add(txtConexion);
		txtConexion.addFocusListener(this);
		
		
		btnAdd = new JButton("Añadir");
		btnAdd.setFont(new Font("Serif", Font.BOLD, 15));
		btnAdd.setBounds(517, 322, 104, 36);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnAtras = new JButton("Cancelar");
		btnAtras.setFont(new Font("Serif", Font.BOLD, 15));
		btnAtras.setBounds(404, 322, 104, 36);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
	}


	@Override
	public void focusGained(FocusEvent e) {
	    JTextField fuente = (JTextField) e.getSource();//Recoge en un texfield comun lo que pille el texfield activo
	    String texto = fuente.getText();
	    int indice = -1;//Variable indice para que no se ralle a la hora de presionar en un txtfield
	    
	    if(fuente == textTonalidad) indice = 0;
	    else if(fuente == textNumCuerdas) indice = 1;
	    else if(fuente == textNumTambores) indice = 2;
	    else if(fuente == textNumTeclas) indice = 3;
	    else if(fuente == textNumPedales) indice = 4;
	    else if(fuente == txtMaterial) indice = 5;
	    else if(fuente == txtClasificacion) indice = 6;
	    else if(fuente == txtElementoParaTocar) indice = 7;
	    else if(fuente == txtFormato) indice = 8;
	    else if(fuente == txtConexion) indice = 9;

	    if(indice != -1 && texto.equals(PLACEHOLDER[indice])) {
	        fuente.setText("");
	        fuente.setForeground(Color.BLACK);
	    }
		
	}


	@Override
	public void focusLost(FocusEvent e) {
	    JTextField fuente = (JTextField) e.getSource();
	    String texto = fuente.getText().trim();
	    int indice = -1;
	    
	    if(fuente == textTonalidad) indice = 0;
	    else if(fuente == textNumCuerdas) indice = 1;
	    else if(fuente == textNumTambores) indice = 2;
	    else if(fuente == textNumTeclas) indice = 3;
	    else if(fuente == textNumPedales) indice = 4;
	    else if(fuente == txtMaterial) indice = 5;
	    else if(fuente == txtClasificacion) indice = 6;
	    else if(fuente == txtElementoParaTocar) indice = 7;
	    else if(fuente == txtFormato) indice = 8;
	    else if(fuente == txtConexion) indice = 9;

	    if(indice != -1 && texto.isEmpty()) {
	    	fuente.setForeground(Color.GRAY);
	    	fuente.setText(PLACEHOLDER[indice]);
	    }
	    
		if (texto.isEmpty()) {
		} else {
			if (textTonalidad == e.getSource()) {
				System.out.println(textTonalidad.getText());
				Main.obtenerTonalidad(textTonalidad.getText());
			} else if (textNumCuerdas == e.getSource()) {
				System.out.println(textNumCuerdas.getText());
				Main.obtenerNumCuerdas(textNumCuerdas.getText());
			} else if (textNumTambores == e.getSource()) {
				System.out.println(textNumTambores.getText());
				Main.obtenerNumTambores(textNumTambores.getText());
			} else if (textNumTeclas == e.getSource()) {
				System.out.println(textNumTeclas.getText());
				Main.obtenerNumTeclas(textNumTeclas.getText());
			} else if (textNumPedales == e.getSource()) {
				System.out.println(textNumPedales.getText());
				Main.obtenerNumPedales(textNumPedales.getText());
			} else if (txtMaterial == e.getSource()) {
				System.out.println(txtMaterial.getText());
				Main.obtenerMaterial(txtMaterial.getText());
			} else if (txtClasificacion == e.getSource()) {
				System.out.println(txtClasificacion.getText());
				Main.obtenerClasificacion(txtClasificacion.getText());
			} else if (txtElementoParaTocar == e.getSource()) {
				System.out.println(txtElementoParaTocar.getText());
				Main.obtenerAccesorioTocar(txtElementoParaTocar.getText());
			} else if (txtFormato == e.getSource()) {
				System.out.println(txtFormato.getText());
				Main.obtenerFormato(txtFormato.getText());
			} else if (txtConexion == e.getSource()) {
				System.out.println(txtConexion.getText());
				Main.obtenerConexion(txtConexion.getText());
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnAdd == e.getSource()) {
			Main.addDocument();
			new VtnPrincipal().setVisible(true);
			dispose();
		}else if(btnAtras == e.getSource()) {
			new VtnCrear1().setVisible(true);
			dispose();
		}
	}
}
