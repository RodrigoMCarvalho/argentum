package br.com.alura.argentum.xstream;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.model.Negociacao;

public class LocalDateTimeConverterTest {
	
	@Test
	public void deveRetornarXmlComDataCorreta() {
		
		LocalDateTime hoje = LocalDateTime.of(2018, 7, 7, 22, 34, 03);
		Negociacao negociacao = new Negociacao(20.0, 4, hoje);
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		String xmlConvertido = stream.toXML(negociacao);
		
		String xmlEsperado = 
				"<negociacao>\n"
				+ "  <preco>20.0</preco>\n"
				+ "  <quantidade>4</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1531013643000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		
		Assert.assertEquals(xmlEsperado, xmlConvertido);
	}
	
	@Test
	public void deveConverterUmXmlParaUmaNegociacaoCorreta() {
		
		String xml = 
				"<negociacao>\n"
				+ "  <preco>20.0</preco>\n"
				+ "  <quantidade>4</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1531013643000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		
		XStream stream = new XStream(new DomDriver());
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		stream.alias("negociacao", Negociacao.class);
		
		Negociacao negociacaoGerada = (Negociacao) stream.fromXML(xml);
		
		LocalDateTime hoje = LocalDateTime.of(2018, 7, 7, 22, 34, 03);
		Negociacao negociacaoEsperada  = new Negociacao(20.0, 4, hoje);		
		
		Assert.assertEquals(negociacaoEsperada, negociacaoGerada);
		
	}
		
	
	
	
	
	
	

}
