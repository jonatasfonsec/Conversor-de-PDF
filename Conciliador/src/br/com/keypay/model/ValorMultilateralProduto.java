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
	static ArrayList<String> valoresEmTela = new ArrayList<String>() ;

	public static void obtemValoresParaSoma(String textoConvertido) {

		try {
			System.out.print(textoConvertido);
			scanner = new Scanner(textoConvertido);
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Matcher matcher = MULTILATERAL_PRODUTO.matcher(linha);
				if (!matcher.find())
					continue;

				String valorString = (matcher.group(2));
				valoresEmTela.add(valorString);
				valoresEmTela.add("");

				Double valorDouble = Double.parseDouble(valorString.trim().replaceAll("\\.", "").replace(",", "."));
				somaTotal += valorDouble;
			}

			String dx = ("Total de Valores Multilateral Produto: R$ " + df.format(somaTotal));
			JOptionPane.showMessageDialog(null, dx);
			defineTextoNaCaixaDeTexto(dx+"\n");

		} finally {
			scanner.close();
			somaTotal = 0;
		}
	}
	
	public static ArrayList<String> getvaloresEmTela() {
		
		ArrayList<String> listaDeValores = valoresEmTela;
		return listaDeValores;
		
	}
	
	



}
