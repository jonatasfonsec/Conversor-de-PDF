package br.com.keypay.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValorMultilateralProduto {

	static List<String> arrayValoresEmString = new ArrayList<String>();
	static List<Double> arrayValoresEmDouble = new ArrayList<Double>();

	public static void obtemValoresParaSoma(String textoConvertido) throws IOException {

		// Pattern p = Pattern.compile(".*Multilateral Produto:\\s([\\d+.,]).*");
		Pattern p = Pattern.compile("(.*Multilateral Produto:)(\\s([\\d+.,]).*)");
		Matcher m = p.matcher(textoConvertido);

		
		// Enquanto a condicao regex for valida, imprime o resultado atual.
		while (m.find()) {
			arrayValoresEmString.add(m.group(2));
		}
		
		//Valida se o array foi preenchido com o resultado da pesquisa regex e imprime
		for (String str : arrayValoresEmString) {
			System.out.println(str);
		}
		
		//TODO CONVERTER LISTA DE STRING PARA DOUBLE E SOMAR SEU RESULTADO.
		
		
		
	}
}
