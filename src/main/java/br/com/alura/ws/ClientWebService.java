package br.com.alura.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.alura.argentum.model.Negociacao;
import br.com.alura.reader.LeitorXml;

public class ClientWebService {
	
	public static final String URL_WEBSERVICES = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes(){
		HttpURLConnection connection = null;
				
		try {
			URL url = new URL(URL_WEBSERVICES);
			connection = (HttpURLConnection) url.openConnection(); //abrindo conexão com a URL passada
		
			InputStream content = connection.getInputStream(); //adiciona o conteúdo da "connection"(url) em "content"
			
			return new LeitorXml().carrega(content);
		
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			connection.disconnect();
		}
	}
	
	public static void main(String[] args) {
		ClientWebService ws = new ClientWebService();
		List<Negociacao> negociacoes = ws.getNegociacoes();
		
		for (Negociacao negociacao : negociacoes) {
			System.out.println(negociacao.getPreco());
		}
	}
	
	
	
	
	
	
}
