package librerias;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * <p>
 * Clase estática para leer de teclado con comprobación de tipo de datos y
 * escribir en pantalla.
 * </p>
 * 
 * <p>
 * Los tipos de dato que maneja son:
 * </p>
 * 
 * <ul>
 * <li>Integer
 * <li>Double
 * <li>Character
 * <li>Byte
 * <li>Short
 * <li>Long
 * <li>Float
 * <li>Boolean
 * <li>String
 * <li>LocalDate
 * </ul>
 * 
 * @author Amadeo
 * @version 2.0
 * @since 2018-07-01
 */
public class IO {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Constructor
	 */
	IO() {
		sc.useDelimiter("\n");
	}

	/**
	 * Muestra un objeto
	 * 
	 * @param objeto
	 */
	static public void print(Object o) {
		System.out.print(o);
	}

	/**
	 * Muestra un objeto y salta de línea
	 * 
	 * @param objeto
	 */
	static public void println(Object o) {
		System.out.println(o);
	}

	/**
	 * Muestra objetos según un formato
	 * 
	 * @param formato
	 * @param objetos
	 */
	static public void printf(String format, Object... objects) {
		System.out.printf(format, objects);
	}

	/**
	 * Lee un valor de tipo byte
	 * 
	 * @return Byte
	 */
	static public Byte readByte() {
		while (true) {
			try {
				return Byte.parseByte(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo byte.");
			}
		}
	}

	/**
	 * Lee un valor de tipo byte o null
	 * 
	 * @return Byte
	 */
	static public Byte readByteOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Byte.parseByte(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo byte.");
			}
		}
	}

	/**
	 * Lee un valor de tipo short
	 * 
	 * @return Short
	 */
	static public Short readShort() {
		while (true) {
			try {
				return Short.parseShort(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo short.");
			}
		}
	}

	/**
	 * Lee un valor de tipo short o null
	 * 
	 * @return Short
	 */
	static public Short readShortOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Short.parseShort(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo short.");
			}
		}
	}

	/**
	 * Lee un valor de tipo int
	 * 
	 * @return Integer
	 */
	static public Integer readInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo int.");
			}
		}
	}

	/**
	 * Lee un valor de tipo int o null
	 * 
	 * @return Integer
	 */
	static public Integer readIntOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Integer.parseInt(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo int.");
			}
		}
	}

	/**
	 * Lee un valor de tipo long
	 * 
	 * @return Long
	 */
	static public Long readLong() {
		while (true) {
			try {
				return Long.parseLong(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo long.");
			}
		}
	}

	/**
	 * Lee un valor de tipo Long o null
	 * 
	 * @return Long
	 */
	static public Long readLongOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Long.parseLong(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo long.");
			}
		}
	}

	/**
	 * Lee un valor de tipo float
	 * 
	 * @return Float
	 */
	static public Float readFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo float.");
			}
		}
	}

	/**
	 * Lee un valor de tipo float o null
	 * 
	 * @return Float
	 */
	static public Float readFloatOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Float.parseFloat(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo float.");
			}
		}
	}

	
	/**
	 * Lee un valor de tipo double
	 * 
	 * @return Double
	 */
	static public Double readDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo double.");
			}
		}
	}

	/**
	 * Lee un valor de tipo double
	 * 
	 * @return Double
	 */
	static public Double readDoubleOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Double.parseDouble(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo double.");
			}
		}
	}

	/**
	 * Lee un valor de tipo LocalDate
	 * 
	 * @return LocalDate
	 */
	static public LocalDate readLocalDate() {
		while (true) {
			try {
				String s[] = sc.nextLine().split("-");
				return LocalDate.of(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo fecha (aaaa-mm-dd).");
			}
		}
	}

	/**
	 * Lee un valor de tipo LocalDate o null
	 * 
	 * @return LocalDate
	 */
	static public LocalDate readLocalDateOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				String s[] = in.split("-");
				return LocalDate.of(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo fecha (aaaa-mm-dd).");
			}
		}
	}

	/**
	 * Lee un valor de tipo boolean
	 * 
	 * @return Boolean
	 */
	static public Boolean readBoolean() {
		while (true) {
			String s = sc.nextLine().toLowerCase();
			if (s.equals("true")) return true;
			if (s.equals("false")) return false;
			System.err.print("ERROR: No es de tipo boolean (true o false).");
		}
	}

	/**
	 * Lee un valor de tipo boolean o null
	 * 
	 * @return Boolean
	 */
	static public Boolean readBooleanOrNull() {
		while (true) {
			String s = sc.nextLine().toLowerCase();
			if (s.isBlank()) return null;
			if (s.equals("true")) return true;
			if (s.equals("false")) return false;
			System.err.print("ERROR: No es de tipo boolean (true o false).");
		}
	}

	/**
	 * Lee un valor de tipo char
	 * 
	 * @return Character
	 */
	static public Character readChar() {
		while (true) {
			String s = sc.nextLine();
			if (s.length() == 1) {
				return s.toCharArray()[0];
			}
			System.err.print("ERROR: No es de tipo char.");
		}
	}

	/**
	 * Lee un valor de tipo char o null
	 * 
	 * @return Character
	 */
	static public Character readCharOrNull() {
		while (true) {
			String s = sc.nextLine();
			if (s.isBlank()) {
				return null;
			}
			if (s.length() == 1) {
				return s.toCharArray()[0];
			}
			System.err.print("ERROR: No es de tipo char.");
		}
	}

	/**
	 * Lee un valor de tipo String
	 * 
	 * @return String
	 */
	static public String readStringOrNull() {
		String s = sc.nextLine();
		if (s.isBlank()) {
			return null;
		}
		return s;
	}

	/**
	 * Lee un valor de tipo String
	 * 
	 * @return String
	 */
	static public String readString() {
		while (true) {
			String s = sc.nextLine();
			if (!s.isBlank()) {
				return s;
			}
			System.err.print("ERROR: Está vacío.");
		}
	}
}
