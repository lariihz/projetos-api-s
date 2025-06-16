package com.example.contrucao_API_controle.model;

import api.entity.Usuario;
// Importações necessárias para o mapeamento JPA e Lombok
import jakarta.persistence.Column;           // Define colunas no banco de dados
import jakarta.persistence.Entity;           // Define esta classe como uma entidade JPA
import jakarta.persistence.GeneratedValue;   // Define geração automática de IDs
import jakarta.persistence.GenerationType;   // Define a estratégia de geração de IDs
import jakarta.persistence.Id;               // Define o identificador (Primary Key) da entidade
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;            // Define o nome da tabela no banco de dados
import lombok.NoArgsConstructor;             // Lombok - Gera um construtor sem argumentos

// Anotação para informar que esta classe representa uma entidade do banco de dados
@Entity

// Anotação para definir o nome da tabela que será criada no banco
@Table(name = "saida") // Aqui você pode mudar para o nome desejado, por exemplo, "pessoas"

// Lombok - Gera automaticamente os métodos getters e setters


// Lombok - Gera um construtor sem argumentos
@NoArgsConstructor
public class Saida {
    /**
     * Anotação que define o campo 'id' como a chave primária (Primary Key) da tabela.
     * A estratégia de geração é IDENTITY, que significa que o valor é gerado pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Define a coluna 'createTime' no banco de dados.
     * - `nullable = false`: Não pode ser nula.
     * - `updatable = false`: O valor não pode ser atualizado após a criação.
     * - Representa a data e hora de criação do registro.
     */
    @Column(nullable = false, updatable = false)
    private java.time.LocalDate dia;

    /**
     * Método anotado com @PrePersist, que é executado antes de inserir o objeto no banco de dados.
     * Aqui, estamos definindo que o campo `createTime` vai receber a data e hora atuais no momento da persistência.
     */
    @PrePersist
    public void prePersist() {
        this.dia = java.time.LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade_saida;

    public void setId(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}


/*
 * id_saida INT PRIMARY KEY AUTO_INCREMENT,
dia DATE,
id_usuario INT,
id_produto INT,
quantidade_saida INT,
 */