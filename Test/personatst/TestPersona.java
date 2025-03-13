package personatst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.Persona;

class PersonaTest {

	Persona ivan = new Persona("Jose", 20, 'H', 60.00, 160);
	Persona jose = new Persona("Carlos", 15 ,'T', 100.00, 190);
	Persona ismael = new Persona();
	 /**
     * El peso de la persona esta por debajo del peso ideal
     */
    public static final int INFRAPESO = -1;
 
    /**
     * El peso de la persona esta en su peso ideal
     */
    public static final int PESO_IDEAL = 0;
 
    /**
     * El peso de la persona esta por encima del peso ideal
     */
    public static final int SOBREPESO = 1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Persona ivan = new Persona("Jose", 20, 'H', 68.0, 1.75);
		Persona jose = new Persona("Carlos", 18 ,'T', 100.00, 7);
		Persona ismael = new Persona();
		jose.setPeso(120);
		ivan.setPeso(60);
		ivan.setAltura(1.60);
		
	
	}

	@Test
	void testPersona() {
	
		Persona carlos = new Persona();
		assert(carlos instanceof Persona);
		
	}

	@Test
	void testSetNombre() {
		Persona carlos = new Persona();
		carlos.setNombre("Julio");
		assertEquals(carlos.getNombre(), "Julio");
	}

	@Test
	void testSetEdad() {
		ismael.setEdad(12);
		assertTrue(ismael.getEdad() == 12);
	}
	

	@Test
    public void testGenerarDni() {
        Persona persona = new Persona();
        String dniRegex = "\\d{8}[A-Z]";

        assertTrue(persona.getDNI().matches(dniRegex));
        assertTrue(ivan.getDNI().matches(dniRegex));
        assertTrue(ismael.getDNI().matches(dniRegex));
    }
	
	
	@Test
	public void testEsValidoDNI() {
		assertTrue(jose.esValidoDNI());
		assertTrue(jose.esValidoDNI());
		assertTrue(ismael.esValidoDNI());
	}
	
	@Test
	void testSetSexo() {
		jose.setSexo('M');
		assertEquals(jose.getSexo(), 'M');
		
	
		jose.setSexo('T');
		assertEquals(jose.getSexo(), 'H');
	}
	
	
    @Test
    public void testCalcularIMCPesoIdeal() {
    	jose.setAltura(1.60);
        assertEquals(Persona.PESO_IDEAL, jose.calcularIMC());
    }
    
    
  
    @Test
    public void testGeneraLetraDNI() {
    	assertEquals(ismael.visualizarGeneraLetraDNI(11), 'B');
    	assertEquals(ismael.visualizarGeneraLetraDNI(22), 'E');
    	assertEquals(ismael.visualizarGeneraLetraDNI(1), 'R');
    }

	@Test
	void testSetPeso() {
		ismael.setPeso(92.1);
		assertTrue(ismael.getPeso()==92.1);
	}
	
	@Test
	void testMayorEdad() {
		jose.setEdad(1);
		assertTrue(ismael.esMayorDeEdad());
		assertFalse(jose.esMayorDeEdad());

	}
	
	
	@Test
	void testSetAltura() {
		ivan.setAltura(179.3);
		assertTrue(ivan.getAltura()==179.3);	
	}
	
    @Test
    public void testCalcularIMC_Infrapeso() {
        assertEquals(Persona.INFRAPESO, jose.calcularIMC());
    }
    
    @Test
    public void testCalcularIMC_Sobrepeso() {
        assertEquals(Persona.SOBREPESO, ismael.calcularIMC());
    }


	//	Persona ivan = new Persona("ivan", 20, 'H', 60.00, 162);

	@Test
	void testToString() {
		String resultadoEsperado = "Informacion de la persona:\n"
                + "Nombre: " + "Jose" + "\n"
                + "Sexo: " + "hombre" + "\n"
                + "Edad: " + 20 + " años\n"
                + "DNI: " + ivan.getDNI() + "\n"
                + "Peso: " + 60.00 + " kg\n"
                + "Altura: " + 160.0 + " metros\n";

		assertTrue(jose.toString().contains(resultadoEsperado));
		
	}


}
