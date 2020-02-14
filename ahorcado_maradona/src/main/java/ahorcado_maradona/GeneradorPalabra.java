package ahorcado_maradona;

import java.util.Random;

public class GeneradorPalabra implements IGeneradorPalabra {

	private String[] palabras = new String[10];
	private String palabraFija = "";

	public String getPalabraFija() {
		return palabraFija;
	}

	public void setPalabraFija(String palabraFija) {
		this.palabraFija = palabraFija;
	}

	public String[] getPalabras() {
		return palabras;
	}

	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}

	public GeneradorPalabra() {
		String[] pal = { "MARADONA", "FAFRULA", "RAQUETAZO", "PASE", "EEEEEE", "DALMA", "GIANINA", "DIEGOJR", "CLAUDIA",
				"GUILLOTE" };
		this.setPalabras(pal);
	}

	public String getSeleccionPalabra() {
		if (palabraFija.isEmpty()) {
			String[] pal = this.getPalabras();
			Random r = new Random();
			int intPalabra = r.nextInt(10);
			return pal[intPalabra];
		} else
			return this.getPalabraFija();
	}
}
