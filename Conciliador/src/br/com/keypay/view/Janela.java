package br.com.keypay.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import br.com.keypay.controller.ArquivoPDF;

public class Janela {

	@SuppressWarnings("deprecation")
	public Janela() {
		JButton botao = new JButton();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Painel painel = new Painel();
		JFrame janela = new JFrame("Conversor de PDF para TXT");
		JTextArea jTextArea = new JTextArea();
		
		
		

		painel.add(botao);

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(screenSize.width, screenSize.height);
		janela.add(painel);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		// janela.pack();
		
		
		botao.setLabel("Procurar Arquivo");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					procuraArquivoPDFNoComputador();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		

	}
	
	public void procuraArquivoPDFNoComputador() throws IOException {
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		ArquivoPDF arquivoPDF = new ArquivoPDF();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
		
		jfc.setDialogTitle("Selecione o arquivo PDF");
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			arquivoPDF.leArquivoPDFEArmazenaEmString(jfc.getSelectedFile().getPath());
		}
		
	}

}
