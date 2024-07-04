package br.com.ifpe.oxefood.modelo.cupomdesconto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CupomDescontoService {
    
    @Autowired
    private CupomDescontoRepository repository;

    @Transactional
    public CupomDesconto save(CupomDesconto cupom) {

        cupom.setHabilitado(Boolean.TRUE);
        cupom.setVersao(1L);
        cupom.setDataCriacao(LocalDate.now());

        return repository.save(cupom);
    }

    public List<CupomDesconto> listarTodos() {
  
        return repository.findAll();
    }

    public CupomDesconto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void delete(Long id) {

        CupomDesconto cupomDesconto = repository.findById(id).get();
        cupomDesconto.setHabilitado(Boolean.FALSE);
        cupomDesconto.setVersao(cupomDesconto.getVersao() + 1);

        repository.save(cupomDesconto);
    }
}
