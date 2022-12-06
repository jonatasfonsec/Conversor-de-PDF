package br.com.keypay.controller;


import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import br.com.keypay.model.ValorMultilateralProduto;

public class ArquivoPDF {
	
	String textoConvertido ="";

	public String getTextoConvertido() {
		return textoConvertido;
	}

	public void setTextoConvertido(String textoConvertido) {
		this.textoConvertido = textoConvertido;
	}

	public String leArquivoPDFEArmazenaEmString(String ArquivoPDF) throws IOException {
		File file = new File(ArquivoPDF);
		PDDocument document = Loader.loadPDF(file);
		
		if (!document.isEncrypted()) {
		    PDFTextStripper stripper = new PDFTextStripper();
		    String text = stripper.getText(document);
		    setTextoConvertido(text);
		    //System.out.println("Text:" + text);
		}
		document.close();
	return textoConvertido;
	}
	
	
}
