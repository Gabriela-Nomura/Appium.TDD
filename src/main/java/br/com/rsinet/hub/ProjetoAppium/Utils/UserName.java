package br.com.rsinet.hub.ProjetoAppium.Utils;

import java.util.Random;

public class UserName {
	public static String getNomeUsuario(int quantidadeLetra) {
		Random quantidadedeletras = new Random();
		int index;
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVYWXZabcdefghijklmnopqrstuvxwyz0123456789";
		String palavraRandom = "";

		for (int i = 0; i <= quantidadeLetra - 1; i++) {
			index = quantidadedeletras.nextInt(caracteres.length());
			palavraRandom += caracteres.substring(index, index + 1);
		}
		return palavraRandom;
	}
}
