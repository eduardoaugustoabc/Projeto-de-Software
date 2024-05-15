package br.edu.ufcg.computacao.psoft.commerce.exception;

public class ProdutoNaoExisteException extends CommerceException{
    public ProdutoNaoExisteException() {

        super("O Produto consultado nao existe!");
    }
}
