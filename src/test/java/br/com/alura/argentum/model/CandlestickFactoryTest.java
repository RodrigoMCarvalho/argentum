package br.com.alura.argentum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class CandlestickFactoryTest {

	@Test
	@Ignore
	public void sequenciaNegociacoesSimples() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candle = factory.geraCandlestickPorData(negociacoes, hoje);
		
		Assert.assertEquals(20.0, candle.getMinimo(), 0.000);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.000);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.000);
		Assert.assertEquals(14000.0, candle.getVolume(), 0.000);
		
	}
	
	@Test
	@Ignore
	public void geraCandlestickUmaNegociacao() {
		
		LocalDateTime data = LocalDateTime.now();
		Negociacao negociacao = new Negociacao(40.00, 100, data);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao);
		CandlestickFactory factory = new CandlestickFactory(); 
		Candlestick candle = factory.geraCandlestickPorData(negociacoes, data);
		
		Assert.assertEquals(40.0, candle.getMinimo(), 0.000);
		Assert.assertEquals(40.0, candle.getMaximo(), 0.000);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.000);
		Assert.assertEquals(4000.0, candle.getVolume(), 0.000);
	}
	
	@Test
	public void geraCandlestickComZerosEmCasoDeNenhumaNegociacao() {
		
		LocalDateTime data = LocalDateTime.now();
		Negociacao negociacao = new Negociacao(40.0, 100, data);
		
		List<Negociacao> negociacoes = new ArrayList<>();
		CandlestickFactory factory = new CandlestickFactory(); 
		Candlestick candle = factory.geraCandlestickPorData(negociacoes, data);
		
		Assert.assertEquals(0.0, candle.getMinimo(), 0.000);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.000);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.000);
		Assert.assertEquals(0.0, candle.getVolume(), 0.000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
