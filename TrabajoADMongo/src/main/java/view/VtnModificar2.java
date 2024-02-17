package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Main;
import javax.swing.JLabel;

public class VtnModificar2 extends JDialog implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static final String PLACEHOLDER = "Nuevo Valor";
	private JTextField valor;
	private JButton okButton;
	private JButton cancelButton;
	private Integer operacion;
	private String campo;
	private String valorAnterior;

	public VtnModificar2(String campo, String valorAnterior, Integer operacion) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			this.operacion = operacion;
			this.campo = campo;
			this.valorAnterior = valorAnterior;
			
			valor = new JTextField();
			valor.setFont(new Font("Serif", Font.BOLD, 15));
			valor.setHorizontalAlignment(SwingConstants.CENTER);
			valor.setText(PLACEHOLDER);
			valor.setBounds(91, 113, 255, 65);
			getContentPane().add(valor);
			valor.addFocusListener(this);

			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 436, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{

				okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				JLabel lblNewLabel = new JLabel("Introduzca el nuevo valor deseado");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Serif", Font.BOLD, 15));
				lblNewLabel.setBounds(91, 56, 255, 31);
				getContentPane().add(lblNewLabel);
				cancelButton.addActionListener(this);

			}
		}
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
			valor.setForeground(Color.GRAY);
			valor.setText(PLACEHOLDER);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (okButton == e.getSource()) {
			if (operacion == VtnPrincipal.MODIFICAR) {
				String resultado = Main.modifyOne(campo, valorAnterior, valor.getText());
				new VtnResultado(VtnPrincipal.MODIFICAR, resultado).setVisible(true);
			} else if (operacion == VtnPrincipal.ELIMINAR) {
				new VtnPrincipal().setVisible(true);
			}
			dispose();

		} else if (cancelButton == e.getSource()) {
			new VtnResultado(operacion, valorAnterior).setVisible(true);
			dispose();
		}
	}
}
