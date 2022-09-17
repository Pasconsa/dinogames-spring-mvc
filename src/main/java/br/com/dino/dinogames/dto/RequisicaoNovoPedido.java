package br.com.dino.dinogames.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.dino.dinogames.model.Pedido;
import br.com.dino.dinogames.model.StatusPedido;

public class RequisicaoNovoPedido {    //04 Esta classe esta recebendo os novos pedidos aqui sera salva

	@NotBlank // 05 anotação do java validation que esse campo não pode ficar vazio
	private String nomeProduto;  //04 mesmo nome do pedido html
	
	private String urlProduto;
	@NotBlank
	private String urlImagem;
	private String descricao;
	@NotNull
	private BigDecimal valorNegociado;
	
	
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
	}
	public Pedido toPedido() { //04 este pedido é do pedido controller
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setValorNegociado(valorNegociado);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
	
	
}

