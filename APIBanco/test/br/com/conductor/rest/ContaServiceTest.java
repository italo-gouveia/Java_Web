/**
 * 
 */
package br.com.conductor.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.conductor.dao.ContaDAO;
import br.com.conductor.entitys.ContaModel;
import br.com.conductor.rest.ContaService;

/**
 * @author Italo
 *
 */
class ContaServiceTest {

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
	 * Test method for {@link br.com.conductor.rest.ContaService#addConta(br.com.conductor.entitys.ContaModel)}.
	 */
	@Test
	void testAddConta() {
		ContaService cs = new ContaService();
		
		int idPessoa = 2;
		float saldo = 2000;
		float limiteSaqueDiario = 900;
		boolean flagAtivo = true;
		int tipoConta = 2;
		ContaModel conta = new ContaModel(idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta);
		String resultado = cs.addConta(conta);
		
		assertEquals(resultado, "Operação realizada com sucesso!");
	}

	/**
	 * Test method for {@link br.com.conductor.rest.ContaService#consultarSaldoPorId(int)}.
	 */
	@Test
	void testConsultarSaldoPorId() {
		ContaService cs = new ContaService();
		assertEquals(1954.00, cs.consultarSaldoPorId(2));
	}

	/**
	 * Test method for {@link br.com.conductor.rest.ContaService#saqueConta(double, int)}.
	 */
	@Test
	void testSaqueConta() {
		ContaService cs = new ContaService();
		float saldoAnterior = cs.consultarSaldoPorId(1);
		cs.saqueConta(200, 1);
		float novoSaldo = cs.consultarSaldoPorId(1);
		
		assertEquals(saldoAnterior, novoSaldo-200);
	}

	/**
	 * Test method for {@link br.com.conductor.rest.ContaService#depositoConta(double, int)}.
	 */
	@Test
	void testDepositoConta() {
		ContaService cs = new ContaService();
		float saldoAnterior = cs.consultarSaldoPorId(2);
		cs.depositoConta(500, 2);
		float novoSaldo = cs.consultarSaldoPorId(2);
		
		assertEquals(saldoAnterior, novoSaldo+500);
	}

	/**
	 * Test method for {@link br.com.conductor.rest.ContaService#bloqueioConta(boolean, int)}.
	 * @throws Exception 
	 */
	@Test
	void testAtividadeConta() throws Exception {
		ContaService cs = new ContaService();
		ContaDAO cd = new ContaDAO();
		boolean status = cd.verificarStatusConta(3);
		
		assertEquals(status, true);
	}

}
