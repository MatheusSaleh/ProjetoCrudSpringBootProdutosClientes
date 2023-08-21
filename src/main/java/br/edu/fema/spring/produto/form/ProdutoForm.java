package br.edu.fema.spring.produto.form;

import br.edu.fema.spring.categoria.model.Categoria;
import lombok.Getter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class ProdutoForm {
    @NotEmpty
    private String nome;
    @NotNull @DecimalMin(value = "0.01") @Digits(integer = 8, fraction = 2)
    private Float valor;
    @NotNull
    private Categoria categoria;

}
