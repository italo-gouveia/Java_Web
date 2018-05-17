/**
 * 
 */
package br.com.conductor.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.conductor.dao.ContaDAO;
import br.com.conductor.entitys.ContaModel;

/**
 * @author Italo
 *
 */
class ContaDAOTest {

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
	 * Test method for {@link br.com.conductor.dao.ContaDAO#getSaldoPorId(int)}.
	 * @throws Exception 
	 */
	@Test
	void testGetSaldoPorId() throws Exception {
		ContaDAO c = new ContaDAO();
		assertEquals(1954, c.getSaldoPorId(2));
	}

	/**
	 * Test method for {@link br.com.conductor.dao.ContaDAO#getLimiteSaquePorId(int)}.
	 */
	@Test
	void testGetLimiteSaquePorId() throws Exception{
		ContaDAO c = new ContaDAO();
		assertEquals(300, c.getLimiteSaquePorId(2));
	}

	/**
	 * Test method for {@link br.com.conductor.dao.ContaDAO#getTotalSacadoHoje(int)}.
	 * @throws Exception 
	 */
	@Test
	void testGetTotalSacadoHoje() throws Exception {
		ContaDAO c = new ContaDAO();
		assertNotEquals(2000, c.getTotalSacadoHoje(1));
	}

	/**
	 * Test method for {@link br.com.conductor.dao.ContaDAO#verificarStatusConta(int)}.
	 * @throws Exception 
	 */
	@Test
	void testVerificarStatusConta() throws Exception {
		ContaDAO c = new ContaDAO();
		assertTrue(c.verificarStatusConta(1));
	}

	/**
	 * Test method for {@link br.com.conductor.dao.ContaDAO#addConta(br.com.conductor.entitys.ContaModel)}.
	 */
	@Test
	void testAddConta() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.conductor.dao.ContaDAO#depositar(int, double)}.
	 * @throws Exception 
	 */
	@Test
	void testDepositar() throws Exception {
		float saldo = 1500;
		float limiteDiarioSaque = 1200;
		int idConta = 1;
		int tipoConta = 2;
		boolean ativo = true;
		ContaDAO cd = new ContaDAO();
		ContaModel cm = new ContaModel(idConta, saldo, limiteDiarioSaque, ativo, tipoConta);
		
		int idGerado = cd.addConta(cm);
		assertNotEquals(idGerado, 0);
	}

	/**
	 * Test method for {@link br.com.conductor.dao.ContaDAO#sacar(int, double)}.
	 * @throws Exception 
	 */
	@Test
	void testSacar() throws Exception {
		ContaDAO cd = new ContaDAO();
		double valorSaque = cd.sacar(2, 50);
		
		assertEquals(valorSaque, 50);
	}

	/**
	 * Test method for {@link br.com.conductor.dao.ContaDAO#statusConta(int, boolean)}.
	 */
	@Test
	void testStatusConta() {
		fail("Not yet implemented");
	}

}
