package br.com.keypay.model;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValorMultilateralProduto {

	public static void obtemValoresParaSoma(String textoConvertido) throws IOException {

		//Pattern p = Pattern.compile("(Multilateral):(\\d+[.]\\d\\d)");
		//Pattern p = Pattern.compile("Multilateral");
		Pattern p = Pattern.compile("(Multilateral Produto:)|(\\d+[.]\\d+[,]\\d\\d)");

		//while ((textoConvertido = buffer.readLine()) != null) {}

			Matcher m = p.matcher(textoConvertido);
			
			while (m.find()) {

				//System.out.println(m.group(1) + "\t" + m.group(2));
				System.out.println(m.group());
				//System.out.println(m.group(2));

			}

		

	}
}
