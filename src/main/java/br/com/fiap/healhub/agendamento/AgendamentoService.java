package br.com.fiap.healhub.agendamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    @Autowired
    AgendamentoRepository repo;

    public List<Agendamento> findAll(){
        return repo.findAll();
    }

    public boolean delete(Long id) {
        var agendamento = repo.findById(id);
        if(agendamento.isEmpty()) return false;

        repo.deleteById(id);
        return true;
    }

    public void save(Agendamento agendamento) {
        repo.save(agendamento);
    }
    
}
