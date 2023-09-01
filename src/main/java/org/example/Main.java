package org.example;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Redmi 10","Bão de mais",new BigDecimal("2000"), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao pd = new ProdutoDao(em);
        CategoriaDao cd = new CategoriaDao(em);

        em.getTransaction().begin();
        cd.cadastrar(celulares);
        pd.cadastrar(celular);
        em.getTransaction().commit();
        em.close();


    }
}