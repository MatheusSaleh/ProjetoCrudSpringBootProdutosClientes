package br.edu.fema.spring.exception.resource;

import br.edu.fema.spring.exception.dto.ErroDeValidacaoDeFormularioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionResource {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroDeValidacaoDeFormularioDTO>> formularioInvalido
            (MethodArgumentNotValidException exception){
        List<ErroDeValidacaoDeFormularioDTO> errosDeValidacao = new ArrayList<>();

        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errosDeValidacao.add(
              new ErroDeValidacaoDeFormularioDTO(fieldError.getField(), fieldError.getDefaultMessage())
            );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errosDeValidacao);
    }
}
