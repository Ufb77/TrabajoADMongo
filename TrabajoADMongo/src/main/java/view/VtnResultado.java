package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VtnResultado extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnSiguiente, btnCancelar;
	private Integer operacion;
	private String texto;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public VtnResultado(Integer operacion, String texto) {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.operacion = operacion;
		this.texto = texto;

		btnSiguiente = new JButton("Aceptar");
		btnSiguiente.setFont(new Font("Serif", Font.BOLD, 15));
		btnSiguiente.setBounds(502, 325, 122, 33);
		getContentPane().add(btnSiguiente);
		btnSiguiente.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Serif", Font.BOLD, 15));
		btnCancelar.setBounds(370, 325, 122, 33);
		getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 25, 599, 271);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Rockwell", Font.PLAIN, 15));
		textArea.setText(this.texto);
		scrollPane.setViewportView(textArea);
		btnCancelar.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnSiguiente == e.getSource()) {

			if (operacion == VtnPrincipal.BUSCAR) {
				new VtnPrincipal().setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.MODIFICAR) {
				new VtnPrincipal().setVisible(true);
				dispose();
			} else if (operacion == VtnPrincipal.ELIMINAR) {
				new VtnPrincipal().setVisible(true);
				dispose();
			}

		} else if (btnCancelar == e.getSource()) {
			new VtnBuscar(operacion).setVisible(true); 									
			dispose();

		}
	}
}
