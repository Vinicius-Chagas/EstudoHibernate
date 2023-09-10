package modelo;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Informatica extends Produto{
    private String marca;
    private Integer modelo;

    public Informatica() {
    }

    public Informatica(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        super(nome, descricao, preco, categoria);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }
}
