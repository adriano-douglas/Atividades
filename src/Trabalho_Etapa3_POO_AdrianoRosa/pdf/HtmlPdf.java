package Trabalho_Etapa3_POO_AdrianoRosa.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;

public abstract class HtmlPdf {
	
	private static String HTML = "<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "  <title>Lista de Pedidos</title>\r\n"
			+ "  <style>\r\n"
			+ "    body {\r\n"
			+ "      font-family: Arial, sans-serif;\r\n"
			+ "      margin: 20px;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    h1 {\r\n"
			+ "      text-align: left;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    h3 {\r\n"
			+ "      margin-top: 5px;\r\n"
			+ "      margin-bottom: 10px;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    table {\r\n"
			+ "      width: 100%;\r\n"
			+ "      border-collapse: collapse;\r\n"
			+ "      margin-top: 20px;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    th, td {\r\n"
			+ "      padding: 10px;\r\n"
			+ "      text-align: left;\r\n"
			+ "      border-bottom: 1px solid #ddd;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    th {\r\n"
			+ "      background-color: #f5f5f5;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    ul {\r\n"
			+ "      margin: 0;\r\n"
			+ "      padding: 0;\r\n"
			+ "      list-style-type: none;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    li {\r\n"
			+ "      margin-bottom: 5px;\r\n"
			+ "    }\r\n"
			+ "  </style>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "  <h1>Lista de Pedidos</h1>\r\n"
			
			+ "{{conteudo}}"
			
			+ "</body>\r\n"
			+ "</html>\r\n"
			+ "";

	public static boolean gerarPdf(String conteudo, String nomePdf) {
		String html = HTML;
		html = html.replace("{{conteudo}}", conteudo);
		
		String pdfFile = "src//Trabalho_Etapa3_POO_AdrianoRosa//pdf//pdfs_gerados//" + nomePdf + ".pdf";

        try {
            // Criar um PdfWriter para o arquivo PDF
            PdfWriter writer = new PdfWriter(new FileOutputStream(pdfFile));

            // Criar uma instância do ConverterProperties
            ConverterProperties converterProperties = new ConverterProperties();

            // Converter a string HTML para PDF
            HtmlConverter.convertToPdf(html, writer, converterProperties);

            // Fechar o writer
            writer.close();

            System.out.println("Arquivo PDF gerado com sucesso!");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}
	
}


