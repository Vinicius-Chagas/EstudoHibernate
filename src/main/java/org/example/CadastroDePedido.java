package org.example;

import dao.CategoriaDao;
import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import modelo.*;
import util.JPAUtil;
import vo.RelatorioDeVendas;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args){
        CadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao pd = new ProdutoDao(em);
        CategoriaDao cd = new CategoriaDao(em);
        ClienteDao clientetDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);
        Produto produto = pd.buscarPorID(1L);
        Cliente cliente = clientetDao.buscarPorID(1L);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItensPedido(10,pedido,produto));

        em.getTransaction().begin();

        pedidoDao.cadastrar(pedido);
        em.getTransaction().commit();

        BigDecimal total = pedidoDao.valorTotalVendido();
        System.out.println(total);
        List<RelatorioDeVendas> relatorio = pedidoDao.relatorioDeVendas();
        relatorio.forEach(System.out::println);
        em.close();



    }
    private static void CadastrarProduto(){
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Redmi 10","Bão de mais",new BigDecimal("2000"), celulares);
        Cliente cliente = new Cliente("Rodrigo","123456789");

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao pd = new ProdutoDao(em);
        CategoriaDao cd = new CategoriaDao(em);
        ClienteDao clientetDao = new ClienteDao(em);

        em.getTransaction().begin();
        cd.cadastrar(celulares);
        pd.cadastrar(celular);
        clientetDao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
