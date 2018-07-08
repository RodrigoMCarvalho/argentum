package br.com.alura.argentum.builder;

import java.time.LocalDateTime;

import br.com.alura.argentum.model.Candlestick;

public class CandleBuilder {

	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private LocalDateTime data;

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}

	public CandleBuilder comData(LocalDateTime data) {
		this.data = data;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	// O Método que efetivamente gera o Candlestick
	public Candlestick geraCandle() {
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}

	public double getAbertura() {
		return abertura;
	}

	public void setAbertura(double abertura) {
		this.abertura = abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public void setFechamento(double fechamento) {
		this.fechamento = fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
