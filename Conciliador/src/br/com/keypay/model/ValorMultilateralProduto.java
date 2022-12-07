package br.com.keypay.model;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ValorMultilateralProduto {

	public static void obtemValoresParaSoma(String textoConvertido) throws IOException {

		//Pattern p = Pattern.compile(".*Multilateral Produto:\\s([\\d+.,]).*"); 
		Pattern p = Pattern.compile("(.*Multilateral Produto:)(\\s([\\d+.,]).*)");

			Matcher m = p.matcher(textoConvertido);
			
			while (m.find()) {
					System.out.println(m.group(2));
				
			}

		

	}
}
