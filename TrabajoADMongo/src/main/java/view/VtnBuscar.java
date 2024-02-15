package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Main;
import lombok.val;

public class VtnBuscar extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;
	private static final String PLACEHOLDER = "VALOR";
	private JComboBox claves;
	private JTextField valor;
	private JButton btnSiguiente, btnCancelar;
	private Integer operacion;
	private JCheckBox chbxDeleteMany;
	private JTextArea etiquetaChbox;

	/**
	 * Create the frame.
	 */
	public VtnBuscar(Integer operacion) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		this.operacion = operacion;

		claves = new JComboBox();
		claves.setFont(new Font("Serif", Font.BOLD, 15));
		claves.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Familia", "Fabricante", "Precio",
				"Tonalidad", "Número de cuerdas", "Número de tambores", "Número de teclas", "Número de pedales",
				"Material", "Clasificación", "Accesorio para tocar" }));
		claves.setBounds(201, 77, 218, 50);
		getContentPane().add(claves);
		claves.addActionListener(this);


		etiquetaCampoValor(operacion);

		valor = new JTextField();
		valor.setFont(new Font("Serif", Font.BOLD, 15));
		valor.setHorizontalAlignment(SwingConstants.CENTER);
		valor.setForeground(Color.GRAY);
		valor.setText(PLACEHOLDER);
		valor.setBounds(201, 184, 218, 43);
		getContentPane().add(valor);
		valor.addFocusListener(this);

		btnSiguiente = new JButton("Buscar");
		btnSiguiente.setFont(new Font("Serif", Font.BOLD, 15));
		btnSiguiente.setBounds(513, 326, 111, 32);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Serif", Font.BOLD, 15));
		btnCancelar.setBounds(403, 326, 100, 32);
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
		if (valor.getText().isEmpty()) {
			valor.setText(PLACEHOLDER);
			valor.setForeground(Color.GRAY);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String texto;
		if (btnSiguiente == e.getSource()) {
			if (operacion == VtnPrincipal.BUSCAR) {
				texto = Main.obtenerConsulta(claves.getSelectedItem().toString(), valor.getText()); 
				new VtnResultado(operacion,texto).setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.MODIFICAR) {
				new VtnModificar(operacion, valor.getText()).setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.ELIMINAR) {
				if (chbxDeleteMany.isSelected()) {
					texto = Main.deleteManyInstruments(claves.getSelectedItem().toString(), valor.getText());
				}else {
					texto = Main.deleteInstrument(claves.getSelectedItem().toString(), valor.getText());
				}
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
		}else if (operacion == 2) {
			etiquetaValor = new JTextArea();
			etiquetaValor.setFont(new Font("Verdana", Font.PLAIN, 10));
			etiquetaValor.setBackground(new Color(240, 240, 240));
			etiquetaValor.setWrapStyleWord(true);
			etiquetaValor.setLineWrap(true);
			etiquetaValor.setText("Introduzca el dato a modificar del campo elegido");
			etiquetaValor.setBounds(201, 142, 217, 30);
			getContentPane().add(etiquetaValor);
		}else if(operacion == 3){
			etiquetaValor = new JTextArea();
			etiquetaValor.setFont(new Font("Verdana", Font.PLAIN, 10));
			etiquetaValor.setBackground(new Color(240, 240, 240));
			etiquetaValor.setWrapStyleWord(true);
			etiquetaValor.setLineWrap(true);
			etiquetaValor.setText("Introduzca valor del campo deseado para borrar su registro completo");
			etiquetaValor.setBounds(201, 142, 217, 30);
			getContentPane().add(etiquetaValor);
			
			chbxDeleteMany = new JCheckBox("");
			chbxDeleteMany.setHorizontalAlignment(SwingConstants.LEFT);
			chbxDeleteMany.setBounds(201, 247, 21, 32);
			getContentPane().add(chbxDeleteMany);
			chbxDeleteMany.addActionListener(this);
			
			etiquetaChbox = new JTextArea();
			etiquetaChbox.setFont(new Font("Serif", Font.BOLD, 15));
			etiquetaChbox.setWrapStyleWord(true);
			etiquetaChbox.setText("Marque si desea que se borren todos los registros que cumplan la condición campo - valor");
			etiquetaChbox.setLineWrap(true);
			etiquetaChbox.setBackground(new Color(240, 240, 240));
			etiquetaChbox.setBounds(223, 249, 174, 94);
			getContentPane().add(etiquetaChbox);
		}
	}
}
