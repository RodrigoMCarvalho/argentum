package br.com.alura.argentum.xstream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateTimeConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return type.isAssignableFrom(LocalDateTime.class);
	}

	@Override   //transforma um Objeto em XML
	public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
		
		LocalDateTime data = (LocalDateTime) object;
		ZonedDateTime dataComZona = data.atZone(ZoneOffset.systemDefault());
		long milisegundos = dataComZona.toInstant().toEpochMilli();
		
		//como será visualizado no xml
		writer.startNode("time");
		writer.setValue(String.valueOf(milisegundos)); //necessário converter para long para String 
		writer.endNode();
		
		writer.startNode("timezone");
		writer.setValue(dataComZona.getZone().toString());
		writer.endNode();
	}

	@Override   //transforma um XML em Objeto
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		
		reader.moveDown(); //entrar no xml ("time")
		String milisegundos = reader.getValue();
		reader.moveUp();   //sair do xml 
		
		reader.moveDown(); //entrar no xml ("timezome")
		String timezone = reader.getValue();
		reader.moveUp();
		
		long tempoEmMilis = Long.parseLong(milisegundos);
		Instant tempo = Instant.ofEpochMilli(tempoEmMilis);
		
		ZoneId zone = ZoneId.of(timezone);
		ZonedDateTime dataComZona = ZonedDateTime.ofInstant(tempo, zone);
		
		LocalDateTime data = dataComZona.toLocalDateTime();
		
		return data;
	}

}
