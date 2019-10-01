package br.ufc.quixada;

public class Principal {

	public static final String ARQUIVO_JSON = "arquivos/teste.json";
	public static final String ARQUIVO_XML = "arquivos/novo.xml";
	public static final String ArquivoCSV = "vle.csv";
	
	
    public static void main(String[] args) throws Exception {
     
    	//Converter con = new Converter();
    	//con.ConverterXML(ArquivoCSV, ARQUIVO_XML);
    	
    	new Json().parse(ARQUIVO_XML);
    	
    }
}
