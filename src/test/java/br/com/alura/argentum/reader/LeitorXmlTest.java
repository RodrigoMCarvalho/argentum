package br.com.alura.argentum.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.argentum.model.Negociacao;
import br.com.alura.reader.LeitorXml;

class LeitorXmlTest {

	@Test
	public void carregaXmlComApenasUmaNegociacao() {
		
		String xml = 
				"<list>\n"
				+ "  <negociacao>\n"
				+ "    <preco>20.0</preco>\n"
				+ "    <quantidade>4</quantidade>\n"
				+ "    <data>\n"
				+ "      <time>1531013643000</time>\n"
				+ "      <timezone>America/Sao_Paulo</timezone>\n"
				+ "    </data>\n"
				+ "  </negociacao>\n"
				+ "</list>";
		
		LeitorXml leitor = new LeitorXml();
		InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(inputStream);
		
		Negociacao negociacaoEsperada  = new Negociacao(20.0, 4, LocalDateTime.of(2018, 7, 7, 22, 34, 03));	
		
		Assert.assertEquals(1, negociacoes.size()); //se a lista tiver o tamanho de 1
		Assert.assertEquals(negociacaoEsperada, negociacoes.get(0));  //se negociacaoEsperada é a primeira da lista
		
		
		
		
		
	}

}
