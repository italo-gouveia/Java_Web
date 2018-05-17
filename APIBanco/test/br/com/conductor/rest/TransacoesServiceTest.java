/**
 * 
 */
package br.com.conductor.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.conductor.entitys.TransacaoModel;
import br.com.conductor.rest.TransacoesService;

/**
 * @author Italo
 *
 */
class TransacoesServiceTest {

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
	 * Test method for {@link br.com.conductor.rest.TransacoesService#listarTransacoesPorId(int)}.
	 */
	@Test
	void testListarTransacoesPorId() {
		TransacoesService ts = new TransacoesService();
		List<TransacaoModel> result = ts.listarTransacoesPorId(2);
		
		assertNotNull(result);
	}

	/**
	 * Test method for {@link br.com.conductor.rest.TransacoesService#listarTransacoesPorPeriodo(int, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testListarTransacoesPorPeriodo() {
		TransacoesService ts = new TransacoesService();
		List<TransacaoModel> result = ts.listarTransacoesPorPeriodo(2, "2018-05-10", "2018-05-12");
		
		assertNotNull(result);
	}

}
