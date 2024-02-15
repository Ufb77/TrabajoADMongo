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

public class VtnModificar extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;
	private static final String PLACEHOLDER = "Nuevo Valor";
	private JTextField valor;
	private JComboBox<String> claves;
	private JButton btnSiguiente, btnCancelar;
	private Integer operacion;
	private String texto;
	private JTextArea etiqueta;

	/**
	 * Create the frame.
	 */
	public VtnModificar(int operacion, String texto) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.operacion = operacion;
		this.texto = texto;

		claves = new JComboBox();
		claves.setFont(new Font("Serif", Font.BOLD, 15));
		claves.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Familia", "Fabricante", "Precio",
				"Tonalidad", "Número de cuerdas", "Número de tambores", "Número de teclas", "Número de pedales",
				"Material", "Clasificación", "Accesorio para tocar" }));
		claves.setBounds(201, 56, 218, 50);
		getContentPane().add(claves);

		valor = new JTextField();
		valor.setFont(new Font("Serif", Font.BOLD, 15));
		valor.setHorizontalAlignment(SwingConstants.CENTER);
		valor.setText(PLACEHOLDER);
		valor.setBounds(201, 200, 218, 50);
		getContentPane().add(valor);
		valor.addFocusListener(this);

		btnSiguiente = new JButton("Aceptar");
		btnSiguiente.setFont(new Font("Serif", Font.BOLD, 15));
		btnSiguiente.setBounds(516, 318, 108, 40);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Serif", Font.BOLD, 15));
		btnCancelar.setBounds(403, 318, 103, 40);
		getContentPane().add(btnCancelar);
		
		etiqueta = new JTextArea();
		etiqueta.setFont(new Font("Serif", Font.BOLD, 15));
		etiqueta.setWrapStyleWord(true);
		etiqueta.setText("Introduzca el nuevo valor deseado para el campo previamente seleccionado");
		etiqueta.setLineWrap(true);
		etiqueta.setBackground(new Color(240, 240, 240));
		etiqueta.setBounds(212, 120, 192, 65);
		getContentPane().add(etiqueta);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void focusGained(FocusEvent e) {
	    if(valor.getText().equals(PLACEHOLDER)) {
	    	valor.setText("");
	    	valor.setForeground(Color.BLACK);
	    }
	}

	@Override
	public void focusLost(FocusEvent e) {
	    if(valor.getText().isEmpty()) {
	        valor.setForeground(Color.GRAY);
	        valor.setText(PLACEHOLDER);
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (btnSiguiente == e.getSource()) {
			if (operacion == VtnPrincipal.MODIFICAR) {
				String resultado = Main.modifyOne(claves.getSelectedItem().toString(), this.texto, valor.getText());
				new VtnResultado(VtnPrincipal.MODIFICAR, resultado).setVisible(true);
			} else if (operacion == VtnPrincipal.ELIMINAR) {
				new VtnPrincipal().setVisible(true);
			}
			dispose();

		} else if (btnCancelar == e.getSource()) {
			new VtnResultado(operacion, texto).setVisible(true);
			dispose();
		}
	}
}
