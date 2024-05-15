package br.edu.ufcg.computacao.psoft.commerce.constraints;

import jakarta.validation.*;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidadorCodigoDeBarras.class)
public @interface CodigoDeBarras{

    String message() default "Codigo de Barras invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
