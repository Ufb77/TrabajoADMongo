package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VtnModificarYEliminar extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JTextField clave, valor;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private int operacion;
	private String texto;

	/**
	 * Create the frame.
	 */
	public VtnModificarYEliminar(int operacion, String texto) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.operacion = operacion;
		this.texto = texto;
		
		clave = new JTextField();
		clave.setText("Nueva Clave/Clave Eliminar");
		clave.setBounds(201, 60, 188, 60);
		getContentPane().add(clave);
		clave.addFocusListener(this);
		
		valor = new JTextField();
		valor.setText("Nuevo Valor / Valor Eliminar");
		valor.setBounds(201, 184, 188, 60);
		getContentPane().add(valor);
		valor.addFocusListener(this);
		
		
		btnSiguiente = new JButton("Ok");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(btnSiguiente == e.getSource()) {
			if(operacion == VtnPrincipal.MODIFICAR) {
				//OPERACION MOD BD
				new VtnPrincipal().setVisible(true);
			}else if(operacion == VtnPrincipal.ELIMINAR) {
				new VtnPrincipal().setVisible(true);
			}
			
			
		}else if(btnCancelar == e.getSource()) {
			new VtnResultado(operacion, texto).setVisible(true);
			dispose();
		}
		
	}

}
