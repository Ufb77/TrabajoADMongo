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
	

	/**
	 * Create the frame.
	 */
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
	
	private void actualizarVisibilidadBoton() {
        String nombre = textNombre.getText();
        String fabricante = textFabricante.getText();
        String familia = textFamilia.getText();
        String precioStr = textPrecio.getText().trim();

        boolean camposNoVacios = !nombre.isEmpty() && !fabricante.isEmpty() && !familia.isEmpty();

        boolean precioValido = false;
        boolean familiaValida = validarFamilia(familia);
        boolean fabricanteValido = validarNombre(fabricante);
        boolean nombreValido = validarNombre(nombre);
        try {
            double precio = Double.parseDouble(precioStr);
            precioValido = precio > 0;
        } catch (NumberFormatException ignored) {
            // No es un Double válido
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
	    JTextField fuente = (JTextField) e.getSource();//Recoge en un texfield comun lo que pille el texfield activo
	    String texto = fuente.getText();
	    int indice = -1;//Variable indice para que no se ralle a la hora de presionar en un txtfield
	    
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
		// TODO Auto-generated method stub
	
		
		if(btnSiguiente == e.getSource()) {
//			Main.addDocument();
			
			
			new VtnCrear2().setVisible(true);
			dispose();
		}else if(btnCancelar == e.getSource()) {
			new VtnPrincipal().setVisible(true);
			dispose();
		}
		
	}
	private boolean validarNombre(String nombre) {
        // Expresión regular para permitir letras, 'ñ' y acentos, y limitar la longitud a 30 caracteres
        String regex = "[\\p{L}&&[^\u2000-\u206F\u2E00-\u2E7F\\s]]{1,30}";

        // Validar con la expresión regular
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);

        return matcher.matches();
    }
	
	private boolean validarFamilia(String familia) {
        // Expresión regular para permitir letras, 'ñ' y acentos, y limitar la longitud a 30 caracteres
        String regex = "[\\p{L}&&[^\u2000-\u206F\u2E00-\u2E7F\\s]]{1,20}";

        // Validar con la expresión regular
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(familia);

        return matcher.matches();
    }
	
	
//	IDEA PLACEHOLDER A LA HORA DE CREAR Y BUSCAR
//	@Override
//	public void focusGained(FocusEvent e) {
//		// TODO Auto-generated method stub
//		if (campoDeTexto.getText().equals(PLACEHOLDER)) {
//			campoDeTexto.setText("");
//			campoDeTexto.setForeground(Color.BLACK);
//		}
//	}
//
//	@Override
//	public void focusLost(FocusEvent e) {
//		if (campoDeTexto.getText().isEmpty()) {
//			campoDeTexto.setForeground(Color.BLACK);
//			campoDeTexto.setText(PLACEHOLDER);
//		}
//	}
}
