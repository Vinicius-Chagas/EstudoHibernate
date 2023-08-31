package org.example;

import dao.ProdutoDao;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Redmi 10");
        celular.setDescricao("Bão de mais");
        celular.setPreco(new BigDecimal("2000"));

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao pd = new ProdutoDao(em);

        em.getTransaction().begin();
        pd.cadastrar(celular);
        em.getTransaction().commit();
        em.close();

    }
}