package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Main;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VtnCrear1 extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = 1L;
	private static final String[] PLACEHOLDER = {"Nombre","Fabricante","Familia","Precio"};
	private JTextField textNombre, textFabricante, textFamilia, textPrecio;
	private JButton btnSiguiente, btnCancelar;
	

	public VtnCrear1() {
		setBounds(100, 100, 663, 408);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setFont(new Font("Serif", Font.BOLD, 15));
		textNombre.setText(PLACEHOLDER[0]);
		textNombre.setBounds(79, 71, 188, 60);
		getContentPane().add(textNombre);
		textNombre.addFocusListener(this);
		
		textFabricante = new JTextField();
		textFabricante.setHorizontalAlignment(SwingConstants.CENTER);
		textFabricante.setFont(new Font("Serif", Font.BOLD, 15));
		textFabricante.setText(PLACEHOLDER[1]);
		textFabricante.setBounds(79, 205, 188, 60);
		getContentPane().add(textFabricante);
		textFabricante.addFocusListener(this);
		
		textFamilia = new JTextField();
		textFamilia.setHorizontalAlignment(SwingConstants.CENTER);
		textFamilia.setFont(new Font("Serif", Font.BOLD, 15));
		textFamilia.setText(PLACEHOLDER[2]);
		textFamilia.setBounds(388, 71, 188, 60);
		getContentPane().add(textFamilia);
		textFamilia.addFocusListener(this);
		
		textPrecio = new JTextField();
		textPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecio.setFont(new Font("Serif", Font.BOLD, 15));
		textPrecio.setText(PLACEHOLDER[3]);
		textPrecio.setBounds(388, 205, 188, 60);
		getContentPane().add(textPrecio);
		textPrecio.addFocusListener(this);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Serif", Font.BOLD, 15));
		btnSiguiente.setBounds(502, 325, 104, 36);
		getContentPane().add(btnSiguiente);
		btnSiguiente.setEnabled(false);
		btnSiguiente.addActionListener(this);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Serif", Font.BOLD, 15));
		btnCancelar.setBounds(388, 325, 104, 36);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		addDocumentListenerToTextField(textNombre);
        addDocumentListenerToTextField(textFabricante);
        addDocumentListenerToTextField(textFamilia);
        addDocumentListenerToTextField(textPrecio);

	}
	
	/**
	 * Metodo que activa o no los botones dependiendo de si lo campos cumplen las restrcciones necesarias
	 */
	private void actualizarVisibilidadBoton() {
        String nombre = textNombre.getText();
        String fabricante = textFabricante.getText();
        String familia = textFamilia.getText();
        String precioStr = textPrecio.getText().trim();

        boolean camposNoVacios = !nombre.isEmpty() && !fabricante.isEmpty() && !familia.isEmpty();

        boolean precioValido = false;
        boolean familiaValida = validarString(familia);
        boolean fabricanteValido = validarString(fabricante);
        boolean nombreValido = validarString(nombre);
        try {
            double precio = Double.parseDouble(precioStr);
            precioValido = precio > 0;
        } catch (NumberFormatException ignored) {
            
        }
        
        if (precioValido) {
        	textPrecio.setForeground(Color.BLACK);
        } else {
        	textPrecio.setForeground(Color.RED);
        }
            if (nombreValido) {
                textNombre.setForeground(Color.BLACK);
            } else {
                textNombre.setForeground(Color.RED);
            }
            if (fabricanteValido) {
                textFabricante.setForeground(Color.BLACK);
            } else {
                textFabricante.setForeground(Color.RED);
            }
            if (familiaValida) {
                textFamilia.setForeground(Color.BLACK);
            } else {
                textFamilia.setForeground(Color.RED);
            }

            camposNoVacios = camposNoVacios && nombreValido;
        

        btnSiguiente.setEnabled(camposNoVacios && precioValido);
    }
	

	private void addDocumentListenerToTextField(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarVisibilidadBoton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarVisibilidadBoton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarVisibilidadBoton();
            }

        });
    }
	
	

	@Override
	public void focusGained(FocusEvent e) {
	    JTextField fuente = (JTextField) e.getSource();
	    String texto = fuente.getText();
	    int indice = -1;
	    
	    if(fuente == textNombre) indice = 0;
	    else if(fuente == textFabricante) indice = 1;
	    else if(fuente == textFamilia) indice = 2;
	    else if(fuente == textPrecio) indice = 3;

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
	    
	    if(fuente == textNombre) indice = 0;
	    else if(fuente == textFabricante) indice = 1;
	    else if(fuente == textFamilia) indice = 2;
	    else if(fuente == textPrecio) indice = 3;

	    if(indice != -1 && texto.isEmpty()) {
	        fuente.setForeground(Color.GRAY);
	        fuente.setText(PLACEHOLDER[indice]);
	    }
		
		if (texto.isEmpty()) {
		} else {
			if (textNombre == e.getSource()) {
				Main.obtenerNombre(textNombre.getText());
			} else if (textFamilia == e.getSource()) {
				Main.obtenerFamilia(textFamilia.getText());
			} else if (textPrecio == e.getSource()) {
				Main.obtenerPrecio(textPrecio.getText());
			} else if (textFabricante == e.getSource()) {
				Main.obtenerFabricante(textFabricante.getText());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnSiguiente == e.getSource()) {
			new VtnCrear2().setVisible(true);
			dispose();
		}else if(btnCancelar == e.getSource()) {
			new VtnPrincipal().setVisible(true);
			dispose();
		}
	}

	/**
	 * Método que según una expresión regular valida o no la cadena de String recogida
	 * @param nombre
	 * @return
	 */
	
	
	private boolean validarString(String cadenaTexto) {
		String regex = "[\\p{L} -&&[^\u2000-\u206F\u2E00-\u2E7F\\s()\\[\\]{}]]{0,30}";
		
		for(String placeholder : PLACEHOLDER) {
			if(cadenaTexto.trim().equalsIgnoreCase(placeholder)) {
				cadenaTexto = null;
				return false;
			}
		}
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cadenaTexto);
		if (cadenaTexto == null) {
			return true;
		} else {
		return matcher.matches();
		}
	}

	/**
	 * Método que según una expresión regular valida o no la cadena de String recogida
	 * @param familia
	 * @return
	 */
	
}
