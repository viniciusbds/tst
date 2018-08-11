import static org.junit.Assert.assertEquals;

public class PotenciaRecursivaTest {

	@org.junit.Test
	public void testComBaseNula() {
		assertEquals(0, PotenciaRecursiva.potencia(0, 1));
		assertEquals(0, PotenciaRecursiva.potencia(0, 10));
	}

	@org.junit.Test
	public void testComExpoenteNulo() {
		assertEquals(1, PotenciaRecursiva.potencia(1, 0));
		assertEquals(1, PotenciaRecursiva.potencia(2, 0));
		assertEquals(1, PotenciaRecursiva.potencia(100, 0));
	}
	
	@org.junit.Test
	public void testComCasosNormais() {
		assertEquals(2, PotenciaRecursiva.potencia(2, 1));
		assertEquals(9, PotenciaRecursiva.potencia(3, 2));
		assertEquals(27, PotenciaRecursiva.potencia(3, 3));
	}
	
}
