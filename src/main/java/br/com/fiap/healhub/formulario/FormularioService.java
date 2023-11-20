package br.com.fiap.healhub.formulario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioService {
    @Autowired
    FormularioRepository repo;

    public List<Formulario> findAll(){
        return repo.findAll();
    }

    public boolean delete(Long id) {
        var formulario = repo.findById(id);
        if(formulario.isEmpty()) return false;

        repo.deleteById(id);
        return true;
    }

    public void save(Formulario formulario) {
        repo.save(formulario);
    }
}
