/**
 * 
 */
package br.com.conductor.entitys;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.conductor.entitys.ContaModel;
import junit.framework.Assert;

/**
 * @author Italo
 *
 */
class ContaModelTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#ContaModel()}.
	 */
	@Test
	void testContaModel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#ContaModel(int, float, float, boolean, int)}.
	 */
	@Test
	void testContaModelIntFloatFloatBooleanInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#getIdConta()}.
	 */
	@Test
	void testGetIdConta() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#setIdConta(int)}.
	 */
	@Test
	void testSetIdConta() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#getIdPessoa()}.
	 */
	@Test
	void testGetIdPessoa() {
		//fail("Not yet implemented");
		ContaModel conta = new ContaModel(1, 1000, 950, true, 2);
		assertEquals(1, conta.getIdPessoa());
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#setIdPessoa(int)}.
	 */
	@Test
	void testSetIdPessoa() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#getSaldo()}.
	 */
	@Test
	void testGetSaldo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#setSaldo(float)}.
	 */
	@Test
	void testSetSaldo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#getLimiteSaqueDiario()}.
	 */
	@Test
	void testGetLimiteSaqueDiario() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#setLimiteSaqueDiario(float)}.
	 */
	@Test
	void testSetLimiteSaqueDiario() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#isFlagAtivo()}.
	 */
	@Test
	void testIsFlagAtivo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#setFlagAtivo(boolean)}.
	 */
	@Test
	void testSetFlagAtivo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#getTipoConta()}.
	 */
	@Test
	void testGetTipoConta() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#setTipoConta(int)}.
	 */
	@Test
	void testSetTipoConta() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#getDataCriacao()}.
	 */
	@Test
	void testGetDataCriacao() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#setDataCriacao(java.util.Date)}.
	 */
	@Test
	void testSetDataCriacao() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.entitys.ContaModel#toString()}.
	 */
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
