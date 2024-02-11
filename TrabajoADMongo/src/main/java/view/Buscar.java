package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import controller.Main;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Buscar extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;

	JTextField valor;
	JComboBox claves;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private int operacion;

	/**
	 * Create the frame.
	 */
	public Buscar(int operacion) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		this.operacion = operacion;

		valor = new JTextField();
		valor.setText("Valor");
		valor.setBounds(201, 184, 188, 60);
		getContentPane().add(valor);
		valor.addFocusListener(this);

		btnSiguiente = new JButton("Buscar");
		btnSiguiente.setBounds(535, 335, 89, 23);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(403, 335, 89, 23);
		getContentPane().add(btnCancelar);

		claves = new JComboBox();
		claves.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Familia", "Fabricante", "Precio",
				"Tonalidad", "Número de cuerdas", "Número de tambores", "Número de teclas", "Número de pedales",
				"Material", "Clasificación", "Accesorio para tocar" }));
		claves.setBounds(201, 77, 188, 50);
		getContentPane().add(claves);
		claves.addActionListener(this);

		btnCancelar.addActionListener(this);

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

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

		if (btnSiguiente == e.getSource()) {

			String texto = Main.obtenerConsulta(claves.getSelectedItem(), valor.getText()); //Obtiene el resultado de la consulta
			
			System.out.println(claves.getSelectedItem() + " " + valor.getText());
			
			if (operacion == General.BUSCAR) {
				new Resultados(operacion, texto).setVisible(true);
				dispose();
			} else if (operacion == General.MODIFICAR) {

				new Resultados(General.MODIFICAR, texto).setVisible(true);
				dispose();
			} else if (operacion == General.ELIMINAR) {
				// operacion bd
				new Resultados(General.ELIMINAR, texto).setVisible(true);
				dispose();
			}

		}
		
		
		
		
		if (btnCancelar == e.getSource()) {

			new General().setVisible(true);

		}

	}
}
