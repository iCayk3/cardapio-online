package br.com.w4solution.lanches.infra.exceptions;

public class ValidacaoAutenticacaoException extends RuntimeException {
    public ValidacaoAutenticacaoException(String message){
        super(message);
    }
}
