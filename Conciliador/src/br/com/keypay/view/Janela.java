package br.com.keypay.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import br.com.keypay.controller.ArquivoPDF;
import br.com.keypay.model.ValorMultilateralProduto;

public class Janela {
	
	
	JButton botaoProcurarArquivo = new JButton();
	JButton botaoCalcularValores = new JButton();
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screenSize = toolkit.getScreenSize();
	JPanel painel = new JPanel();
	JFrame janela = new JFrame("Conversor de PDF para TXT");
	JTextArea caixaDeTexto = new JTextArea();
	JScrollPane barraRolagem = new JScrollPane(caixaDeTexto);

	
	public Janela() {

		painel.setLayout(new BorderLayout());
		caixaDeTexto.setVisible(true);
		caixaDeTexto.setLineWrap(true);
	
		

		painel.add(botaoProcurarArquivo,BorderLayout.NORTH);
		painel.add(botaoCalcularValores,BorderLayout.EAST);
		painel.add(barraRolagem);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(screenSize.width, screenSize.height);
		janela.add(painel);
		
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		
		
		
		botaoProcurarArquivo.setText("Procurar Arquivo");
		botaoCalcularValores.setText("Calcular Valores:");
		
		
		botaoProcurarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					procuraArquivoPDFNoComputador();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		botaoCalcularValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				ValorMultilateralProduto.obtemValoresParaSoma(caixaDeTexto.getText());
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
			
			recebeStringDoArquivoPDF(arquivoPDF.leArquivoPDFEArmazenaEmString(jfc.getSelectedFile().getPath()));
		}
		
	}
	
	public void recebeStringDoArquivoPDF(String textoDoArquivoPDF) {
		//Passa a string do texto convertido para o box
		caixaDeTexto.setText(textoDoArquivoPDF);
	}
	
	

}
