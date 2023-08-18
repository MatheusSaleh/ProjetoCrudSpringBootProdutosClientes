package br.edu.fema.spring.exception.dto;

import java.io.Serializable;

public class ErroDeValidacaoDeFormularioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    public String campo;
    public String mensagem;

    public ErroDeValidacaoDeFormularioDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
