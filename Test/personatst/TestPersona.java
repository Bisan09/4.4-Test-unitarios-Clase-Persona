package personatst;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


	public class TestPersona {

	    @Test
	    public void testConstructorPorDefecto() {
	        Persona persona = new Persona();
	        assertNotNull(persona);
	        assertEquals("", persona.getNombre());
	        assertEquals(0, persona.getEdad());
	        assertEquals('H', persona.getSexo());
	        assertEquals(0.0, persona.getPeso());
	        assertEquals(0.0, persona.getAltura());
	        assertNotNull(persona.getDNI());
	    }

	    @Test
	    public void testConstructorConParametros() {
	        Persona persona = new Persona("Juan", 30, 'H');
	        assertEquals("Juan", persona.getNombre());
	        assertEquals(30, persona.getEdad());
	        assertEquals('H', persona.getSexo());
	        assertEquals(0.0, persona.getPeso());
	        assertEquals(0.0, persona.getAltura());
	        assertNotNull(persona.getDNI());
	    }

	    @Test
	    public void testSettersYGetters() {
	        Persona persona = new Persona("Carlos", 25, 'H');
	        persona.setNombre("Miguel");
	        persona.setEdad(26);
	        persona.setSexo('M');
	        persona.setPeso(70.5);
	        persona.setAltura(1.75);

	        assertEquals("Miguel", persona.getNombre());
	        assertEquals(26, persona.getEdad());
	        assertEquals('M', persona.getSexo());
	        assertEquals(70.5, persona.getPeso());
	        assertEquals(1.75, persona.getAltura());
	    }

	    @Test
	    public void testComprobarSexo() {
	        Persona persona1 = new Persona("Juan", 20, 'H');
	        assertEquals('H', persona1.getSexo());
	        
	        Persona persona2 = new Persona("Ana", 22, 'X'); // Sexo no válido
	        assertEquals('H', persona2.getSexo());
	    }

	    @Test
	    public void testCalcularIMC() {
	        Persona persona1 = new Persona("Juan", 25, 'H', 70, 1.75);
	        assertEquals(0, persona1.calcularIMC()); // IMC ideal

	        Persona persona2 = new Persona("Ana", 30, 'M', 50, 1.75);
	        assertEquals(-1, persona2.calcularIMC()); // Infrapeso

	        Persona persona3 = new Persona("Carlos", 35, 'H', 90, 1.75);
	        assertEquals(1, persona3.calcularIMC()); // Sobrepeso
	    }

	    @Test
	    public void testEsMayorDeEdad() {
	        Persona persona1 = new Persona("Juan", 20, 'H');
	        assertTrue(persona1.esMayorDeEdad());

	        Persona persona2 = new Persona("Ana", 17, 'M');
	        assertFalse(persona2.esMayorDeEdad());
	    }

	    @Test
	    public void testToString() {
	        Persona persona = new Persona("Pedro", 28, 'H', 80, 1.80);
	        String expected = "Informacion de la persona:\n"
	                + "Nombre: Pedro\n"
	                + "Sexo: hombre\n"
	                + "Edad: 28 años\n"
	                + "DNI: " + persona.getDNI() + "\n"
	                + "Peso: 80.0 kg\n"
	                + "Altura: 1.8 metros\n";
	        assertEquals(expected, persona.toString());
	    }
	}
