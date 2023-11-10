package proj.sis.dist.ac2voos.domain.client;

import lombok.*;

import javax.persistence.*;

@Table(name="client")
@Entity(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "clientID")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientID;

    private String name;
    private String lastname;
    private String cpf;
    private String login;
    private String password;

    public Client(RequestClient requestClient){
        this.clientID = requestClient.clientID();
        this.name = requestClient.name();
        this.lastname = requestClient.lastname();
        this.cpf = requestClient.cpf();
        this.login = requestClient.login();
        this.password = requestClient.password();
    }
}