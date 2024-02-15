package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Main;

public class VtnBuscar extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;

	JTextField valor;
	private static final String PLACEHOLDER = "VALOR";
	JComboBox claves;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private int operacion;

	/**
	 * Create the frame.
	 */
	public VtnBuscar(int operacion) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		this.operacion = operacion;

		claves = new JComboBox();
		claves.setFont(new Font("Verdana", Font.BOLD, 15));
		claves.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Familia", "Fabricante", "Precio",
				"Tonalidad", "Número de cuerdas", "Número de tambores", "Número de teclas", "Número de pedales",
				"Material", "Clasificación", "Accesorio para tocar" }));
		claves.setBounds(201, 77, 218, 50);
		getContentPane().add(claves);

		etiquetaCampoValor(operacion);

		valor = new JTextField();
		valor.setFont(new Font("Verdana", Font.BOLD, 15));
		valor.setHorizontalAlignment(SwingConstants.CENTER);
		valor.setForeground(Color.GRAY);
		valor.setText(PLACEHOLDER);
		valor.setBounds(201, 184, 218, 50);
		getContentPane().add(valor);
		valor.addFocusListener(this);

		btnSiguiente = new JButton("Buscar");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

		


	}

	@Override
	public void focusGained(FocusEvent e) {
		if (valor.getText().equals(PLACEHOLDER)) {
			valor.setText("");
			valor.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

//		if(valor == e.getSource()) {
//
//			String valorClave = (String) claves.getSelectedItem();
//			
//			switch(valorClave) {
//			
//			
//			case "Nombre":
//				Main.obtenerNombre(valor.getText());
//				break;
//			case "Familia":
//				Main.obtenerFamilia(valor.getText());
//				break;
//			case "Fabricante":
//				Main.obtenerFabricante(valor.getText());
//				break;
//			case "Precio":
//				Main.obtenerPrecio(valor.getText());
//				break;
//			case "Tonalidad":
//				Main.obtenerTonalidad(valor.getText());
//				break;
//			case "Número de cuerdas":
//				Main.obtenerNumCuerdas(valor.getText());
//				break;
//			case "Número de tambores":
//				Main.obtenerNumTambores(valor.getText());
//				break;
//			case "Número de teclas":
//				Main.obtenerNumTeclas(valor.getText());
//				break;
//			case "Número de pedales":
//				Main.obtenerNumPedales(valor.getText());
//				break;
//			case "Material":
//				Main.obtenerMaterial(valor.getText());
//				break;
//			case "Clasificación":
//				Main.obtenerClasificacion(valor.getText());
//				break;
//			case "Accesorio para tocar":
//				Main.obtenerAccesorioTocar(valor.getText());
//				break;
//			}
//			
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String texto;
		if (btnSiguiente == e.getSource()) {

			texto = Main.obtenerConsulta(claves.getSelectedItem().toString(), valor.getText()); 
			
			System.out.println(claves.getSelectedItem() + " " + valor.getText());
			
			if (operacion == VtnPrincipal.BUSCAR) {
				new VtnResultado(operacion,texto).setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.MODIFICAR) {
				new VtnResultado(VtnPrincipal.MODIFICAR, texto).setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.ELIMINAR) {
				//Esta llamando al metodo eliminar muchos
				texto = Main.deleteManyInstruments(claves.getSelectedItem().toString(), valor.getText());
				//PARA LA CONSULTA DE ELIMINAR TODOS LOS DOCUMENTOS QUE CUMPLAN LA CONDICION CAMPOX == VALOR
				//IDEA -> PONER UN CHECKBOX QUE SI SE MARCA SE EJECUTA EL METODO ELIMINAR VARIOS QUE HAY EN EL MAIN
				
				new VtnResultado(VtnPrincipal.ELIMINAR, texto).setVisible(true);
				dispose();
			}

		}
		
		if (btnCancelar == e.getSource()) {
			new VtnPrincipal().setVisible(true);
			dispose();
		}

	}
	
	private void etiquetaCampoValor(Integer operacion) {
		JTextArea etiquetaValor;
		if (operacion == 1) {
			etiquetaValor = new JTextArea();
			etiquetaValor.setFont(new Font("Verdana", Font.PLAIN, 10));
			etiquetaValor.setBackground(new Color(240, 240, 240));
			etiquetaValor.setWrapStyleWord(true);
			etiquetaValor.setLineWrap(true);
			etiquetaValor.setText("Introduzca valor del campo deseado para obtener el registro completo");
			etiquetaValor.setBounds(201, 142, 217, 30);
			getContentPane().add(etiquetaValor);
			claves.addActionListener(this);
		}else if (operacion == 2) {
			etiquetaValor = new JTextArea();
			etiquetaValor.setFont(new Font("Verdana", Font.PLAIN, 10));
			etiquetaValor.setBackground(new Color(240, 240, 240));
			etiquetaValor.setWrapStyleWord(true);
			etiquetaValor.setLineWrap(true);
			etiquetaValor.setText("Introduzca el dato para modificar el valor del campo elegido");
			etiquetaValor.setBounds(201, 142, 217, 30);
			getContentPane().add(etiquetaValor);
			claves.addActionListener(this);
		}else if(operacion == 3){
			etiquetaValor = new JTextArea();
			etiquetaValor.setFont(new Font("Verdana", Font.PLAIN, 10));
			etiquetaValor.setBackground(new Color(240, 240, 240));
			etiquetaValor.setWrapStyleWord(true);
			etiquetaValor.setLineWrap(true);
			etiquetaValor.setText("Introduzca valor del campo deseado para borrar su registro completo");
			etiquetaValor.setBounds(201, 142, 217, 30);
			getContentPane().add(etiquetaValor);
			claves.addActionListener(this);
		}
	}
}
