import static org.junit.Assert.assertEquals;

public class SolutionTest {

	@org.junit.Test
	public void testComBaseNula() {
		assertEquals(0, Solution.potencia(0, 1));
		assertEquals(0, Solution.potencia(0, 10));
	}

	@org.junit.Test
	public void testComExpoenteNulo() {
		assertEquals(1, Solution.potencia(1, 0));
		assertEquals(1, Solution.potencia(2, 0));
		assertEquals(1, Solution.potencia(100, 0));
	}
	
	@org.junit.Test
	public void testComCasosNormais() {
		assertEquals(2, Solution.potencia(2, 1));
		assertEquals(9, Solution.potencia(3, 2));
		assertEquals(27, Solution.potencia(3, 3));
	}
	
}
