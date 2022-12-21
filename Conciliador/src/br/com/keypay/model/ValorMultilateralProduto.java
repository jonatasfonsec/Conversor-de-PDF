package br.com.keypay.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import br.com.keypay.view.Janela;

public class ValorMultilateralProduto extends Janela {

	static DecimalFormat df = new DecimalFormat("###,###,###.00");
//	static String regexp = "multilateral\\s+produto\\s*:\\s*([\\d.,]+)\\s*";
	// KEYPAY
	// static String regexp = "multilateral\\s+produto\\s*:\\s*([\\d.,]+)\\s*";
	// CONTABILIDADE
	static String regexp = "(Produto|Lançamento\\s):\\s([\\d.,]+)";
	static Pattern MULTILATERAL_PRODUTO = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
	static Scanner scanner = null;
	static double somaTotal = 0;

	public static void obtemValoresParaSoma(String textoConvertido) {

		try {
			scanner = new Scanner(textoConvertido);
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Matcher matcher = MULTILATERAL_PRODUTO.matcher(linha);
				if (!matcher.find())
					continue;

				String valorString = (matcher.group(2));

				Double valorDouble = Double.parseDouble(valorString.trim().replaceAll("\\.", "").replace(",", "."));
				somaTotal += valorDouble;
			}

			String dx = ("Total de Valores Multilateral Produto: R$ " + df.format(somaTotal));
			JOptionPane.showMessageDialog(null, dx);

		} finally {
			scanner.close();
			somaTotal = 0;
		}
	}

	public static void destacaValoresDaSomaEmTela(String textoConvertido) {

		try {
			scanner = new Scanner(textoConvertido);

			String linha = scanner.nextLine();
			Matcher matcher = MULTILATERAL_PRODUTO.matcher(linha);
			while (scanner.hasNextLine()) {
				String valorString = (matcher.group(2));
				defineTextoNaCaixaDeTexto(valorString);
				System.out.println(valorString);

			}
		} finally {
			scanner.close();
		}
	}

}
