package br.com.alura.argentum.model;

import java.time.LocalDateTime;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alura.argentum.builder.CandleBuilder;


class NegociacaoTest {

	@Test(expected=IllegalArgumentException.class)
	@Ignore
	public void naoDeveCriarNegociacaoComNumeroNegativo() {
		Negociacao negociacao = new Negociacao(-20.0, 100, LocalDateTime.now());
	}
	
	@Test
	public void precoMaximoNaoPodeSerMenorQueMinimo(){
	    Candlestick candle = new CandleBuilder().comAbertura(10)
	                        .comFechamento(20).comMinimo(8).comMaximo(5)
	                        .comVolume(100).comData(LocalDateTime.of(2016, 02, 25, 00, 23))
	                        .geraCandle();
	}
	
	

	
	
	
	
	
	
	
}
