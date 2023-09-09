package vo;

import java.time.LocalDate;

public class RelatorioDeVendas {
    private String nomeProduto;
    private Long qntVendida;
    private LocalDate dataUltimaVenda;

    public RelatorioDeVendas(String nomeProduto, Long qntVendida, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.qntVendida = qntVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Long getQntVendida() {
        return qntVendida;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendas{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", qntVendida=" + qntVendida +
                ", dataUltimaVenda=" + dataUltimaVenda +
                '}';
    }
}
