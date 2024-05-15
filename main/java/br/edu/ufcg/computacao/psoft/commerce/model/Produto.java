    package br.edu.ufcg.computacao.psoft.commerce.model;

    import com.fasterxml.jackson.annotation.JsonProperty;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.springframework.data.annotation.Id;

    //@data cria hashcode, get, set, equals, etc
    @Data
    @Builder
    @NoArgsConstructor
    public class Produto {
        @JsonProperty("id")
        @Id
        private Long id;
        @JsonProperty("nome_produto")
        private String nome_produto;
        @JsonProperty("codigo_barras")
        private String codigo_barras;
        @JsonProperty("preco")
        private double preco;
        @JsonProperty("nome_fabricante")
        private String nome_fabricante;

        @Builder
        public Produto(Long id, String nome_produto, String codigo_barras, double preco, String nome_fabricante) {
            this.id = id;
            this.nome_produto = nome_produto;
            this.codigo_barras = codigo_barras;
            this.preco = preco;
            this.nome_fabricante = nome_fabricante;
        }
    }

