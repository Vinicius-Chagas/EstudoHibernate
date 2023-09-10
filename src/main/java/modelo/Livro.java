package modelo;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Livro extends Produto{

    private String autor;
    private int numeroPaginas;

    public Livro() {
    }

    public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor, int numeroPaginas) {
        super(nome, descricao, preco, categoria);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
