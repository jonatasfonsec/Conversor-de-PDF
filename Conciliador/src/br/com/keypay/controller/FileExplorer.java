package br.com.keypay.controller;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileExplorer {
	public FileExplorer() throws IOException {

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF","pdf");
		
		jfc.setDialogTitle("Selecione o arquivo PDF");
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			ArquivoPDF arquivoPDF = new ArquivoPDF();
			arquivoPDF.leArquivoPDF(jfc.getSelectedFile().getPath());
			
			
		}

	}

}
