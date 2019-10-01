package br.ufc.quixada;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json extends DefaultHandler {
	
	private String arquivoJSON = "arquivos/json.json";

	private String qName;
	
	private List<Estudante> estudantes;

	private Estudante estudante;
	

	public void parse(String arquivo) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxFactory.newSAXParser();
		saxParser.parse(new File(arquivo), this);	
	}

	public void startDocument() throws SAXException {
		System.out.println("Abrindo Documento...");
		this.estudantes = new ArrayList<Estudante>();
	}

	public void endDocument() throws SAXException {
		System.out.println("Fechando Documento.");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(arquivoJSON), estudantes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("INFORS")) {
			this.estudante = new Estudante();
		}
		this.qName = qName;
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("INFORS")) {
			estudantes.add(estudante);
		}
		
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		String texto = new String(ch, start, length);
		
		if(!texto.trim().isEmpty()) {
			texto = texto.replace("\"", "");
			switch (qName) {
			case "id":
				estudante.setId(Integer.parseInt(texto));
				break;
			case "code": 
				estudante.setCode(texto);
				break;
			case "pres": 
				estudante.setPres(texto);
				break;
			case "type": 				
				estudante.setType(texto);
			case "from":
				estudante.setFrom(texto);
			case "to":
				estudante.setTo(texto);
			default:
				break;
			}
		}
	}

	public String getCaminhoJSON() {
		return arquivoJSON;
	}

	public void setCaminhoJSON(String caminhoJSON) {
		this.arquivoJSON = caminhoJSON;
	}
}
	

