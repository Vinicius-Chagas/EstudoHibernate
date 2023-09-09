package modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name="itens_pedido")
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int qnt;
    private BigDecimal preco_unit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    public ItensPedido(int qnt, Pedido pedido, Produto produto) {
        this.qnt = qnt;
        this.pedido = pedido;
        this.produto = produto;
        this.preco_unit = produto.getPreco();
    }

    public ItensPedido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public BigDecimal getPreco_unit() {
        return preco_unit;
    }

    public void setPreco_unit(BigDecimal preco_unit) {
        this.preco_unit = preco_unit;
    }

    public Pedido getPedido_id() {
        return pedido;
    }

    public void setPedido_id(Pedido pedido_id) {
        this.pedido = pedido_id;
    }

    public Produto getProduto_id() {
        return produto;
    }

    public void setProduto_id(Produto produto_id) {
        this.produto = produto_id;
    }

    public BigDecimal getValor(){
        return this.preco_unit.multiply(new BigDecimal(this.qnt));
    }
}
