package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class VtnPrincipal extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JButton crear, modificar, buscar, borrar;
	final static Integer BUSCAR = 1;
	final static Integer MODIFICAR = 2;
	final static Integer ELIMINAR = 3;

	public VtnPrincipal() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		crear = new JButton("Crear");
		crear.setBounds(150, 63, 100, 100);
		getContentPane().add(crear);
		crear.addActionListener(this);
		crear.addMouseListener(this);

		modificar = new JButton("Modificar");
		modificar.setBounds(150, 207, 100, 100);
		getContentPane().add(modificar);
		modificar.addActionListener(this);
		modificar.addMouseListener(this);

		buscar = new JButton("Buscar");
		buscar.setBounds(390, 63, 100, 100);
		getContentPane().add(buscar);
		buscar.addActionListener(this);
		buscar.addMouseListener(this);
		
		borrar = new JButton("Eliminar");
		borrar.setBounds(390, 207, 100, 100);
		getContentPane().add(borrar);
		borrar.addActionListener(this);
		borrar.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (crear == e.getSource()) {
			new VtnCrear1().setVisible(true);
			dispose();
		} else if (modificar == e.getSource()) {
			new VtnBuscar(MODIFICAR).setVisible(true);
			dispose();
		} else if (buscar == e.getSource()) {
			new VtnBuscar(BUSCAR).setVisible(true);
			dispose();
		} else if (borrar == e.getSource()) {
			new VtnBuscar(ELIMINAR).setVisible(true);
			dispose();
		}

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		if (crear == e.getSource()) {
			crear.setBackground(Color.YELLOW);
		}
		else if (modificar == e.getSource()) {
			modificar.setBackground(Color.CYAN);
		}
		else if (borrar == e.getSource()) {
			borrar.setBackground(Color.MAGENTA);
		}
		else if (buscar == e.getSource()) {
			buscar.setBackground(Color.PINK);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (crear == e.getSource()) {
			crear.setBackground(UIManager.getColor("Button.background"));
		}
		else if (modificar == e.getSource()) {
			modificar.setBackground(UIManager.getColor("Button.background"));
		}
		else if (borrar == e.getSource()) {
			borrar.setBackground(UIManager.getColor("Button.background"));
		}
		else if (buscar == e.getSource()) {
			buscar.setBackground(UIManager.getColor("Button.background"));
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
