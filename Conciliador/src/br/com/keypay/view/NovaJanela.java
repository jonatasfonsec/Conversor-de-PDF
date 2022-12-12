package br.com.keypay.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NovaJanela extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9088025740883543564L;
	
	
	JButton botaoProcurarArquivo = new JButton();
	JButton botaoCalcularValores = new JButton();
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screenSize = toolkit.getScreenSize();
	JPanel painel = new JPanel();
	JFrame janela = new JFrame("Conversor de PDF para TXT");
	JTextArea caixaDeTexto = new JTextArea();
	JScrollPane barraRolagem = new JScrollPane(caixaDeTexto);
	
	
}
