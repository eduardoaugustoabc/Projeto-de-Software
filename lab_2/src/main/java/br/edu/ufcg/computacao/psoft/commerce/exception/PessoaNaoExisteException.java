package br.edu.ufcg.computacao.psoft.commerce.exception;

public class PessoaNaoExisteException extends CommerceException{
    public PessoaNaoExisteException() {

        super("A Pessoa consultada nao existe!");
    }
}
