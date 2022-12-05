package br.com.keypay.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import br.com.keypay.controller.FileExplorer;

public class Janela {

	
	@SuppressWarnings("deprecation")
	public Janela() {
		JButton botao = new JButton();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Painel painel = new Painel();
		JFrame janela = new JFrame("Conversor de PDF para TXT");
		JTextArea jTextArea =  new JTextArea();
		
		botao.setLabel("Procurar Arquivo");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				new FileExplorer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		});
		
		
		painel.add(botao);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(screenSize.width, screenSize.height);
		janela.add(painel);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		//janela.pack();

	}
	
	
	

}
