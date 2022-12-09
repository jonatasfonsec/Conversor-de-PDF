package br.com.keypay.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValorMultilateralProduto {

	static List<String> listaValoresEmString = new ArrayList<String>();

	@SuppressWarnings("unlikely-arg-type")
	public static void obtemValoresParaSoma(String textoConvertido){

		Pattern p = Pattern.compile("(Multilateral Produto:\\s)([\\d.;,]*)");
		Matcher m = p.matcher(textoConvertido);

		while (m.find()) {
			listaValoresEmString.add(m.group(2));
		}

		
		for(int i = 0;i>=listaValoresEmString.size();i++) {
			String str = listaValoresEmString.get(i).replace(".","").replace(",","");
			listaValoresEmString.set(listaValoresEmString.indexOf(i),str);
		}
		System.out.println(listaValoresEmString);
		

		
	}		


}
