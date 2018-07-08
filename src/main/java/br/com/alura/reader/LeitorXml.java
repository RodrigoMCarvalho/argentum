package br.com.alura.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.model.Negociacao;
import br.com.alura.argentum.xstream.LocalDateTimeConverter;

public class LeitorXml {
	
//	public static void main(String[] args) {
//		
//		Negociacao negociacao = new Negociacao(20.0, 2, LocalDateTime.now());
//		
//		XStream xStream = new XStream(new DomDriver());
//		xStream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
//		
//		String xml = xStream.toXML(negociacao);
//		System.out.println(xml);
//	}
	
	public List<Negociacao> carrega(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		stream.alias("negociacao", Negociacao.class);
		
		return (List<Negociacao>) stream.fromXML(inputStream);
	}
}
