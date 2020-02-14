package ahorcado_maradona;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.*;
import org.junit.jupiter.*;
import ahorcado_maradona.GeneradorPalabra;
import ahorcado_maradona.Juego;

public class Test_ahorcado {
	
	@Test
	public void testIngresoUsuario() {
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		juego.setNombreUsuario("Pepe");
		String respuesta = juego.getNombreUsuario();
		assertEquals("Pepe", respuesta);
	}

	@Test
	public void testPalabraFija() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		String respuesta = juego.getPalabraFija();
		assertEquals("MARADONA", respuesta);
	}

	@Test
	public void testLetraValida() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		boolean respuesta = juego.validarLetra('R');
		assertEquals(true, respuesta);
	}

	@Test
	public void testLetraInvalida() {
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		boolean respuesta = juego.validarLetra('e');
		assertEquals(false, respuesta);
	}

	@Test
	public void testIngresoValido() {
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		boolean respuesta = juego.validarUsuario("Pepe");
		assertEquals("Usuario valido", true, respuesta);
	}

	@Test
	public void testIngresoInvalido() {
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		boolean respuesta = juego.validarUsuario("asdasdasdasdasdasdasdasdasdasdasdasd");
		assertEquals("Usuario invalido", false, respuesta);
	}

	@Test
	public void testArrayPalabraAcertada() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		char[] respuesta = juego.getEstadoPalabra();
		char[] pal = new char[8];

		for (int i = 0; i < 8; i++) {
			pal[i] = '_';
		}
		assertArrayEquals(pal, respuesta);
	}

	@Test
	public void testArrayPalabraPintada() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		juego.validarLetra('R');
		char[] respuesta = juego.getEstadoPalabra();
		char[] pal = new char[8];
		for (int i = 0; i < 8; i++) {
			pal[i] = '_';
		}
		pal[2] = 'R';
		assertArrayEquals(pal, respuesta);
	}

	@Test
	public void testArrayPalabraPintadaX() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		juego.validarLetra('A');
		char[] respuesta = juego.getEstadoPalabra();
		char[] pal = new char[8];
		for (int i = 0; i < 8; i++) {
			pal[i] = '_';
		}
		pal[1] = 'A';
		pal[3] = 'A';
		pal[7] = 'A';
		assertArrayEquals(pal, respuesta);
	}

	@Test
	public void testArrayPalabraPinta2() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		juego.validarLetra('R');
		juego.validarLetra('M');
		char[] respuesta = juego.getEstadoPalabra();
		char[] pal = new char[8];
		for (int i = 0; i < 8; i++) {
			pal[i] = '_';
		}
		pal[0] = 'M';
		pal[2] = 'R';
		assertArrayEquals(pal, respuesta);
	}

	@Test
	public void testArrayPalabraPinta3() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		juego.validarLetra('R');
		juego.validarLetra('M');
		juego.validarLetra('A');
		juego.validarLetra('D');
		juego.validarLetra('O');
		juego.validarLetra('N');
		char[] respuesta = juego.getEstadoPalabra();
		char[] pal = new char[8];
		pal[0] = 'M';
		pal[1] = 'A';
		pal[2] = 'R';
		pal[3] = 'A';
		pal[4] = 'D';
		pal[5] = 'O';
		pal[6] = 'N';
		pal[7] = 'A';
		assertArrayEquals(pal, respuesta);
	}

	@Test
	public void testIngresoVacio() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		boolean respuesta = juego.validarUsuario("");
		assertEquals("Usuario invalido", false, respuesta);
	}

	@Test
	public void testIngresoJugadoresValido() {
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		boolean respuesta = juego.validarModoJugadores(1);
		assertEquals("Usuario valido", true, respuesta);
	}

	@Test
	public void testIngresoJugadoresInvalido() {
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		boolean respuesta = juego.validarModoJugadores(2);
		assertEquals("Usuario invalido", false, respuesta);
	}

	@Test
	public void testRegistroUsuario() {
		String usuario = "dieguito";
		String password = "diegote";
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		juego.registrarUsuario(usuario, password);
		String usu = juego.getNombreUsuario();
		String pass = juego.getPassUsuario();
		assertEquals(usuario, usu);
		assertEquals(password, pass);
	}

	@Test
	public void testLoginValido() {
		String usuario = "dieguito";
		String password = "diegote";
		String usuarioPrueba = "dieguito";
		String passwordPrueba = "diegote";
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		juego.registrarUsuario(usuario, password);
		String usu = juego.getNombreUsuario();
		String pass = juego.getPassUsuario();
		assertEquals(usuarioPrueba, usu);
		assertEquals(passwordPrueba, pass);
	}

	@Test
	public void testLoginInvalido() {
		String usuario = "dieguito";
		String password = "diegote";
		String usuarioPrueba = "fafrula";
		String passwordPrueba = "raquetazo";
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		juego.registrarUsuario(usuario, password);
		String usu = juego.getNombreUsuario();
		String pass = juego.getPassUsuario();
		assertNotEquals(usuarioPrueba, usu);
		assertNotEquals(passwordPrueba, pass);
	}

	@Test
	public void testSeleccionPalabraOK() {
		boolean b = false;
		GeneradorPalabra gp = new GeneradorPalabra();
		String pal = gp.getSeleccionPalabra();
		String[] palabras = gp.getPalabras();
		for (String p : palabras) {
			if (p == pal)
				b = true;
		}
		assertEquals(true, b);
	}

	@Test
	public void testPalabraEnJuegoInvalida() {
		boolean b = false;
		GeneradorPalabra gp = new GeneradorPalabra();
		String pal = "D10S";
		String[] palabras = gp.getPalabras();
		for (String p : palabras) {
			if (p == pal)
				b = true;
		}
		assertEquals(false, b);
	}

	@Test
	public void testLetrasNoAcertadas() {
		ArrayList<Character> letrasNoAcertadas = new ArrayList<Character>();
		ArrayList<Character> listadoNoAcertado = new ArrayList<Character>();
		listadoNoAcertado.add('x');
		listadoNoAcertado.add('z');
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		juego.validarLetra('x');
		juego.validarLetra('z');
		letrasNoAcertadas = juego.getLetrasNoAcertadas();
		assertEquals(listadoNoAcertado, letrasNoAcertadas);

	}

	@Test
	public void testVidasRestantes() {
		int vidas;
		int v = 4;
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		juego.validarLetra('x');
		juego.validarLetra('z');
		vidas = juego.getVidas();
		assertEquals(v, vidas);
	}

	@Test
	public void testArriesgarPalabra() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		boolean resultado = juego.arriesgarPalabra("MARADONA");
		assertEquals(true, resultado);
	}

	@Test
	public void testArriesgarPalabraInvalida() {
		GeneradorPalabra gp = new GeneradorPalabra();
		Juego juego = new Juego(gp);
		boolean resultado = juego.arriesgarPalabra("ArthasMenethil");
		assertEquals(false, resultado);
	}
	
	@Test
	public void testVictoria() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		juego.validarLetra('M');
		juego.validarLetra('A');
		juego.validarLetra('R');
		juego.validarLetra('A');
		juego.validarLetra('D');
		juego.validarLetra('O');
		juego.validarLetra('N');
		juego.validarLetra('A');
		boolean respuesta=juego.juegoGanado();
		assertEquals(true, respuesta);
	}
	
	@Test
	public void testDerrota() {
		GeneradorPalabra gp = new GeneradorPalabra();
		gp.setPalabraFija("MARADONA");
		Juego juego = new Juego(gp);
		juego.validarLetra('F');
		juego.validarLetra('G');
		juego.validarLetra('H');
		juego.validarLetra('I');
		juego.validarLetra('J');
		juego.validarLetra('K');
		int respuesta=juego.getVidas();
		assertEquals(0, respuesta);
	}

}
