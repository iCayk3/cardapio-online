package br.com.w4solution.lanches.infra.exceptions;

public class ValidacaoCadastroUsuarioException extends RuntimeException {
    public ValidacaoCadastroUsuarioException(String message){
        super(message);
    }
}
