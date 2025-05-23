package br.com.ifpe.oxefood.api.cupom;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cupom.CupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CupomDescontoRequest {

    private String codigoDesconto;

    private double percentualDesconto;

    private double valorDesconto;

    private double valorMinimoPedidoPermitido;

    private int quantidadeMaximaUso;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicioVigencia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fimVigencia;

    public CupomDesconto build() {

        return CupomDesconto.builder()
                .codigoDesconto(codigoDesconto)
                .percentualDesconto(percentualDesconto)
                .valorDesconto(valorDesconto)
                .valorMinimoPedidoPermitido(valorMinimoPedidoPermitido)
                .quantidadeMaximaUso(quantidadeMaximaUso)
                .inicioVigencia(inicioVigencia)
                .fimVigencia(fimVigencia)
                .build();
    }

}
