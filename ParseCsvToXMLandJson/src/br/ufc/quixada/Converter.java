package br.ufc.quixada;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Converter {
	private String Divisor;
	private Document finalXML;
	private Element Raiz;
	private BufferedReader br;
	private ArrayList<String> tagNames;
	
	public Converter(){
		this.Divisor = ",";
		this.finalXML = null;
		this.Raiz = null;
		this.br = null;
	}

	public Boolean ConverterXML(String ArquivoCSV, String ArquivoFinal)
	{
		try{
			InputStream in = getClass().getResourceAsStream(ArquivoCSV);
			br = new BufferedReader(new InputStreamReader(in));
			String arquivoCSV = br.readLine();
			if(arquivoCSV != null){
				AdicionarRaiz(arquivoCSV, ArquivoFinal);

			} else {
				System.out.println("Error: Arquivo de entrada  "+ArquivoCSV+ "esta vazio.");
				return false;
			}
		}catch (FileNotFoundException e){
			System.out.println("Error: Arquivo de entrada "+ArquivoCSV+" nao encontrado. Aborted.");
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(br != null){
				try{
					br.close();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		System.out.println("Sucesso: Arquivo "+ArquivoCSV+" convertido em "+ArquivoFinal);
		return true;
	}

	public void AdicionarRaiz(String csvEntrada, String ArquivoFinal){
		try {
			finalXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Raiz = finalXML.createElement("Estudantes");
			finalXML.appendChild(Raiz);
			tagNames = new ArrayList<String>(Arrays.asList(csvEntrada.split(Divisor)));
			String csvRecord;
			while((csvRecord = br.readLine()) != null){
				AdicionarFolhas(csvRecord);
			}
			GerarXML(ArquivoFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void AdicionarFolhas(String csvRecord){
        ArrayList<String> FolhasNode = new ArrayList<String>(Arrays.asList(csvRecord.split(Divisor)));
        Element folhas = finalXML.createElement("INFORS");
        Raiz.appendChild(folhas);
        int valueIndex = 0;
        for(String tag: tagNames){
            Element el = finalXML.createElement(tag);
            String value;
            if(valueIndex >= FolhasNode.size()){
                value = "";
                System.out.println(tagNames);
                System.out.println(csvRecord);
            }
            else {
                value = FolhasNode.get(valueIndex);
            }
            el.appendChild(finalXML.createTextNode(value));
            folhas.appendChild(el);
            valueIndex++;

        }

    }


	public void GerarXML(String ArquivoFinal) throws TransformerConfigurationException{
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer optimusPrime = tFactory.newTransformer();
		DOMSource dom = new DOMSource(finalXML);
		StreamResult result = new StreamResult(new File(ArquivoFinal));

		optimusPrime.setOutputProperty(OutputKeys.INDENT,"yes");
		
		optimusPrime.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
		optimusPrime.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		try {
			optimusPrime.transform(dom, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
}