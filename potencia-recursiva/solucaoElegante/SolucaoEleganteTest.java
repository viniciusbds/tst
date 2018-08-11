package solucaoElegante;
import static org.junit.Assert.assertEquals;

public class SolucaoEleganteTest {

	@org.junit.Test
	public void testComBaseNula() {
		assertEquals(0, SolucaoElegante.potencia(0, 1),00000001);
		assertEquals(0, SolucaoElegante.potencia(0, 10),00000001);
	}

	@org.junit.Test(expected = IllegalArgumentException.class)
	public void testIndeterminacaoZeroElevadoAZero() {
		assertEquals(1, SolucaoElegante.potencia(0, 0),00000001);
	}
	
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void testIndeterminacaoDivisaoPorZero() {
		assertEquals(1, SolucaoElegante.potencia(0, -1),00000001);
	}

	@org.junit.Test
	public void testComExpoenteNulo() {
		assertEquals(1, SolucaoElegante.potencia(1, 0),00000001);
		assertEquals(1, SolucaoElegante.potencia(2, 0),00000001);
		assertEquals(1, SolucaoElegante.potencia(100, 0),00000001);
	}
	
	@org.junit.Test
	public void testComCasosNormais() {
		assertEquals(2, SolucaoElegante.potencia(2, 1),00000001);
		assertEquals(9, SolucaoElegante.potencia(3, 2),00000001);
		assertEquals(27, SolucaoElegante.potencia(3, 3),00000001);
	}
	
	@org.junit.Test
	public void testComExpoenteNegativo() {
		assertEquals(1/3, SolucaoElegante.potencia(3, -1),00000001);
		assertEquals(1/27, SolucaoElegante.potencia(3, -3),00000001);
		assertEquals(1/9, SolucaoElegante.potencia(-3, -2),00000001);
		assertEquals(1, SolucaoElegante.potencia(1, -100),00000001);
	}

}
