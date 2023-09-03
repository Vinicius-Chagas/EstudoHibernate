package dao;

import modelo.Produto;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }

    public Produto atualizar(Produto produto){
        return this.em.merge(produto);
    }

    public void remover(Produto produto){
        produto = em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscarPorID(Long Id){
        return em.find(Produto.class, Id);
    }

    public List<Produto> buscatTodos(){
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome){
        return em.createQuery("SELECT p FROM Produto p WHERE p.nome = :nome", Produto.class).setParameter("nome",nome).getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nome){
        return em.createQuery("SELECT p FROM Produto p WHERE p.categoria.nome = :nome", Produto.class).setParameter("nome",nome).getResultList();
    }

    public List<BigDecimal> buscarPrecoPorNome(String nome){
        return em.createQuery("SELECT p.preco FROM Produto p WHERE p.categoria.nome = :nome", BigDecimal.class).setParameter("nome",nome).getResultList();
    }
}
