package br.com.keypay.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ValorMultilateralProduto {

	static DecimalFormat df = new DecimalFormat("###,###,###.00");
	static String regexp = "multilateral\\s+produto\\s*:\\s*([\\d.,]+)\\s*";
	static Pattern MULTILATERAL_PRODUTO = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
	static Scanner scanner = null;
	static double soma = 0;

	public static void obtemValoresParaSoma(String textoConvertido) {


		try {
			scanner = new Scanner(textoConvertido);
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Matcher matcher = MULTILATERAL_PRODUTO.matcher(linha);
				if (!matcher.find())
					continue;
				String valorString = matcher.group(1);
				Double valorDouble = Double.parseDouble(valorString.trim().replaceAll("\\.", "").replace(",", "."));
				soma += valorDouble;
			}
			String dx = ("Total de Valores Multilateral Produto: R$ "+df.format(soma));
			JOptionPane.showMessageDialog (null, dx);
		} finally {
			scanner.close();
		}
	}

}
