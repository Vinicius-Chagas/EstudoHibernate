package dao;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

import javax.persistence.EntityManager;

public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public Cliente buscarPorID(Long Id){
        return em.find(Cliente.class, Id);
    }

}
