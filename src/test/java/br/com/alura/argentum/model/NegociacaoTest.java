package br.com.alura.argentum.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import br.com.alura.argentum.builder.CandleBuilder;


class NegociacaoTest {

	//@Test(expected=IllegalArgumentException.class)
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
	
	@Test
	public void horariosDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.of(2018, 7, 7, 22, 34, 03);
		LocalDateTime agora = LocalDateTime.of(2018, 7, 7, 21, 34, 03);
		Negociacao negociacao  = new Negociacao(20.0, 4, hoje);
		
		Assert.assertTrue(negociacao.isMesmoDia(agora));
	}

	@Test
	public void mesesDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.of(2018, 7, 7, 22, 34, 03);
		LocalDateTime agora = LocalDateTime.of(2018, 6, 7, 21, 34, 03);
		Negociacao negociacao  = new Negociacao(20.0, 4, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(agora));
	}

	@Test
	public void anosDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.of(2018, 7, 7, 22, 34, 03);
		LocalDateTime agora = LocalDateTime.of(2017, 6, 7, 21, 34, 03);
		Negociacao negociacao  = new Negociacao(20.0, 4, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(agora));
	}
	
	@Test
	public void negociacaoDeTresDiasDiferentesGeraTresCandlesDiferentes() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao1  = new Negociacao(20.0, 4, hoje);
		Negociacao negociacao2 = new Negociacao(20.0, 4, hoje);
		Negociacao negociacao3  = new Negociacao(20.0, 4, hoje);
		
		LocalDateTime amanha = hoje.plusDays(1);
		Negociacao negociacao4  = new Negociacao(20.0, 50, amanha);
		Negociacao negociacao5 = new Negociacao(10.0, 4, amanha);
		
		LocalDateTime depois = hoje.plusDays(2);
		Negociacao negociacao6  = new Negociacao(35.0, 4, depois);
		Negociacao negociacao7  = new Negociacao(35.0, 4, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, 
				negociacao4, negociacao5, negociacao6, negociacao7);
		
		CandlestickFactory factory = new CandlestickFactory();
		List<Candlestick> candlesticks = factory.constroiCandle(negociacoes);
		
		Assert.assertTrue(negociacoes.get(0).isMesmoDia(candlesticks.get(0).getData()));
		Assert.assertTrue(negociacoes.get(1).isMesmoDia(candlesticks.get(1).getData()));
		Assert.assertTrue(negociacoes.get(2).isMesmoDia(candlesticks.get(2).getData()));
		
		
		
		
		
	}
	
	
	
	
	
}
