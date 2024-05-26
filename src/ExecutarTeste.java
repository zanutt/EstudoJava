import java.math.BigDecimal;

public class ExecutarTeste {
    public static void main(String[] args) {

        Produto produto1 = new Produto();

        produto1.setId(1L);
        produto1.setNomeProduto("Consulta");
        produto1.setValor(BigDecimal.valueOf(150.00));

        Produto produto2 = new Produto();

        produto2.setId(300L);
        produto2.setNomeProduto("Consulta Especialista");
        produto2.setValor(BigDecimal.valueOf(450.00));

        Venda venda = new Venda();
        venda.setDescricaoVenda("Venda 1");
        venda.setEnderecoEntrega("Entrega via E-mail");
        venda.setId(10L);
        venda.setNomeCliente("Matheus");

        venda.getListaProdutos().add(produto1);
        venda.getListaProdutos().add(produto2);


        System.out.println("Descrição da Venda : "
                + venda.getDescricaoVenda() + " e o total: "
                    + venda.totalVenda());

    }
}
