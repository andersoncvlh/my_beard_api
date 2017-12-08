package com.mybeardapi.test;

import org.junit.Test;

import com.mybeardapi.security.GeradorSenha;

public class TestGeradorSenha {

	@Test
	public void test() {
		System.out.println(GeradorSenha.generate("12345678"));
		System.out.println(GeradorSenha.generate("12345678"));
		System.out.println(GeradorSenha.generate("12345678"));
		System.out.println(GeradorSenha.generate("12345678"));
	}
	
}
