package br.com.keypay.controller;


import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ArquivoPDF {
	

	public String leArquivoPDFEArmazenaEmString(String ArquivoPDF) throws IOException {
		File file = new File(ArquivoPDF);
		PDDocument document = Loader.loadPDF(file);
		String textoConvertido = "";
		
		if (!document.isEncrypted()) {
		    PDFTextStripper stripper = new PDFTextStripper();
		    String text = stripper.getText(document);
		    textoConvertido = text;
		    System.out.println("Text:" + text);
		}
		document.close();
	return textoConvertido;
	}
}
