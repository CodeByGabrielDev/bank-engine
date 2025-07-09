package unisenai.ContaBancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Utilitarios.Utils;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	
	
	
	@Test
	public void validadorCpf() {
		boolean cpf = Utils.formatarCpf("122.438.919-05");
		assertTrue(cpf);
	}
}
