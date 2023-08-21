package br.edu.fema.spring.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ErroDeValidacaoDeFormularioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    public String campo;
    public String mensagem;

}
