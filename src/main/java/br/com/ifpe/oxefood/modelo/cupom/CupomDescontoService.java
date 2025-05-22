package br.com.ifpe.oxefood.modelo.cupom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CupomDescontoService {

    @Autowired
    private CupomDescontoRepository repository;

    @Transactional
    public CupomDesconto save(CupomDesconto cupomDesconto) {

        cupomDesconto.setHabilitado(Boolean.TRUE);
        return repository.save(cupomDesconto);
    }

    public List<CupomDesconto> listarTodos() {

        return repository.findAll();
    }

    public CupomDesconto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CupomDesconto cupomDescontoAlterado) {

        CupomDesconto cupom = repository.findById(id).get();
        cupom.setCodigoDesconto(cupomDescontoAlterado.getCodigoDesconto());
        cupom.setPercentualDesconto(cupomDescontoAlterado.getPercentualDesconto());
        cupom.setValorDesconto(cupomDescontoAlterado.getValorDesconto());
        cupom.setValorMinimoPedidoPermitido(cupomDescontoAlterado.getValorMinimoPedidoPermitido());
        cupom.setQuantidadeMaximaUso(cupomDescontoAlterado.getQuantidadeMaximaUso());
        cupom.setInicioVigencia(cupomDescontoAlterado.getInicioVigencia());
        cupom.setFimVigencia(cupomDescontoAlterado.getFimVigencia());

        repository.save(cupom);
    }

    @Transactional
    public void delete(Long id) {

        CupomDesconto CupomDesconto = repository.findById(id).get();
        CupomDesconto.setHabilitado(Boolean.FALSE);

        repository.save(CupomDesconto);
    }

}
