package PetShopDB.mvc.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;

public abstract class HtmlPdf {
	
	private static String HTML = "<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			
			+ "  <title>{{titulo}}</title>\r\n"
			
			+ "  <style>\r\n"
			+ "    body {\r\n"
			+ "      font-family: Arial, sans-serif;\r\n"
			+ "      margin: 20px;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    h1 {\r\n"
			+ "      font-size: 28px;\r\n"
			+ "      text-align: center;\r\n"
			+ "      margin-bottom: 30px;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    h2 {\r\n"
			+ "      font-size: 22px;\r\n"
			+ "      margin-top: 40px;\r\n"
			+ "      margin-bottom: 10px;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    table {\r\n"
			+ "      border-collapse: collapse;\r\n"
			+ "      width: 100%;\r\n"
			+ "      margin-bottom: 20px;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    th, td {\r\n"
			+ "      border: 1px solid #ccc;\r\n"
			+ "      padding: 10px;\r\n"
			+ "      text-align: left;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    th {\r\n"
			+ "      background-color: #f2f2f2;\r\n"
			+ "      font-weight: bold;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    tr:nth-child(even) {\r\n"
			+ "      background-color: #f9f9f9;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    .animal-name {\r\n"
			+ "      font-weight: bold;\r\n"
			+ "    }\r\n"
			+ "\r\n"
			+ "    .animal-species {\r\n"
			+ "      font-style: italic;\r\n"
			+ "    }\r\n"
			+ "  </style>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "  <h1>{{titulo}}</h1>\r\n"
			+ "  \r\n"
			
			+ "{{conteudo}}"
			
			+ "</body>\r\n"
			+ "</html>\r\n"
			+ "";

	public static boolean gerarPdf(String titulo, String conteudo, String nomePdf) {
		String html = HTML;
		html = html.replace("{{titulo}}", titulo);
		html = html.replace("{{conteudo}}", conteudo);
		
		String pdfFile = "src\\PetShopDB\\mvc\\pdf\\pdfs\\" + nomePdf + ".pdf";

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


