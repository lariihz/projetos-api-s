package com.example.contrucao_API_controle.model;

// Importações necessárias para o mapeamento JPA e Lombok
import jakarta.persistence.Column;           // Define colunas no banco de dados
import jakarta.persistence.Entity;           // Define esta classe como uma entidade JPA
import jakarta.persistence.GeneratedValue;   // Define geração automática de IDs
import jakarta.persistence.GenerationType;   // Define a estratégia de geração de IDs
import jakarta.persistence.Id;               // Define o identificador (Primary Key) da entidade
import jakarta.persistence.Table;            // Define o nome da tabela no banco de dados
import lombok.Getter;                        // Lombok - Gera os métodos GET automaticamente
import lombok.NoArgsConstructor;             // Lombok - Gera um construtor sem argumentos
import lombok.Setter;                        // Lombok - Gera os métodos SET automaticamente

// Anotação para informar que esta classe representa uma entidade do banco de dados
@Entity

// Anotação para definir o nome da tabela que será criada no banco
@Table(name = "usuario") // Aqui você pode mudar para o nome desejado, por exemplo, "pessoas"

// Lombok - Gera automaticamente os métodos getters e setters
@Getter
@Setter

// Lombok - Gera um construtor sem argumentos
@NoArgsConstructor
public class Usuario {
        /**
     * Anotação que define o campo 'id' como a chave primária (Primary Key) da tabela.
     * A estratégia de geração é IDENTITY, que significa que o valor é gerado pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Define a coluna 'name' no banco de dados.
     * - `nullable = false`: Essa coluna não pode ser nula.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Define a coluna 'setor' no banco de dados.
     * - `length = 15`: Limita o tamanho do campo para 15 caracteres.
     * - Não é obrigatório (não possui nullable = false), então pode ser nulo.
     */
    @Column(nullable = false)
    private String setor;
}