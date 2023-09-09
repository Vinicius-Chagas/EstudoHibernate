package dao;

import modelo.Pedido;
import modelo.Produto;
import vo.RelatorioDeVendas;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido){
        this.em.persist(pedido);
    }

    public BigDecimal valorTotalVendido(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendas> relatorioDeVendas(){
        String jpql = "SELECT new vo.RelatorioDeVendas(produto.nome, SUM(item.qnt),MAX(pedido.data))"+
                " FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto "+
                "GROUP BY produto.nome " +
                "ORDER BY SUM(item.qnt) DESC";

        return em.createQuery(jpql,RelatorioDeVendas.class).getResultList();
    }

}
