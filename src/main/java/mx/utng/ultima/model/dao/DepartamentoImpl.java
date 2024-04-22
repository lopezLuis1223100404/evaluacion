package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Departamento;

@Repository
public class DepartamentoImpl implements IDepartamentoDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Departamento> list() {
        return em.createQuery("from Departamento").getResultList();
    }

    @Override
    public void save(Departamento departamento) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(departamento.getId() != null && departamento.getId()>0){
            em.merge(departamento);
        }else{
            //Registro nuevo al usar persist
            em.persist(departamento);
        }
    }

    @Override
    public Departamento getById(Long id) {
        return em.find(Departamento.class, id);
    }

    @Override
    public void delete(Long id) {
      Departamento departamento = getById(id);
      em.remove(departamento);
    }
    

}
