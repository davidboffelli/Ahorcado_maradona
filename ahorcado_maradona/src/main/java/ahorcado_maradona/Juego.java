package ahorcado_maradona;

import java.util.ArrayList;

import ahorcado_maradona.IGeneradorPalabra;

public class Juego {
	
	private String nombreUsuario;
	private String passUsuario;
	private int modoJuego;
	private String palabraFija;
	private char[] estadoPalabra;
	private ArrayList<Character> letrasNoAcertadas = new ArrayList<Character>();
	private int vidas;

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public ArrayList<Character> getLetrasNoAcertadas() {
		return letrasNoAcertadas;
	}

	public void setEstadoPalabra(char[] estadoPalabra) {
		this.estadoPalabra = estadoPalabra;
	}

	public String getPassUsuario() {
		return passUsuario;
	}

	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}

	public char[] getEstadoPalabra() {
		return estadoPalabra;
	}

	public String getPalabraFija() {
		return palabraFija;
	}

	public void setPalabraFija(String palabraFija) {
		this.palabraFija = palabraFija;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getModoJuego() {
		return modoJuego;
	}

	public void setModoJuego(int modoJuego) {
		this.modoJuego = modoJuego;

	}

	public Juego(IGeneradorPalabra gp) {
		String pal = gp.getSeleccionPalabra();
		this.setPalabraFija(pal);
		this.setVidas(6);
		this.setEstadoPalabra(new char[palabraFija.length()]);
		for (int i = 0; i < palabraFija.length(); i++) {
			estadoPalabra[i] = '_';
		}
	}

	public boolean registrarUsuario(String nombreUsuario, String passUsuario) {
		if (nombreUsuario.length() <= 20 && nombreUsuario.length() > 0) {
			this.setNombreUsuario(nombreUsuario);
			this.setPassUsuario(passUsuario);
			return true;
		} else
			return false;
	}

	public boolean validarUsuario(String nombreUsuario) {
		if (nombreUsuario.length() <= 20 && nombreUsuario.length() > 0) {
			this.setNombreUsuario(nombreUsuario);

			return true;
		} else
			return false;
	}

	public boolean validarModoJugadores(int opcion) {
		if (opcion == 1) {
			this.setModoJuego(opcion);
			return true;
		} else
			return false;
	}

	public boolean validarLetra(char c) {
		int indice = palabraFija.indexOf(c);
		String pal = palabraFija;
		if (indice >= 0) {
			ArrayList<Integer> listaIndices = new ArrayList<Integer>();
			while (indice != -1) {
				listaIndices.add(indice);
				pal = pal.replaceFirst(Character.toString(c), "_");
				indice = pal.indexOf(c);
			}
			for (Integer li : listaIndices) {
				estadoPalabra[li] = c;
			}
			return true;
		} else
			letrasNoAcertadas.add(c);
		this.setVidas(this.getVidas() - 1);
		return false;
	}

	public boolean arriesgarPalabra(String pal) {
		if (getPalabraFija() == pal)
			return true;
		else {
			this.setVidas(0);
			return false;
		}
	}
	
	public boolean juegoGanado() {
		if(this.getPalabraFija().equalsIgnoreCase(String.valueOf(this.getEstadoPalabra()))){
			return true;
		}
		else {
			return false;
		}
					
	}


}
