package tienda_disfraces.reto3.modelo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @autor Gladys Leticia Ramirez Torres
 *
 */
@Entity
@Table(name = "message")
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "costumeid")
    @JsonIgnoreProperties({ "messages", "reservations" })
    private Disfraz costume;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({ "messages", "reservations" })
    private Cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Disfraz getCostume() {
        return costume;
    }

    public void setCostume(Disfraz costume) {
        this.costume = costume;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    

    // public Integer getIdMessage() {
    //     return idMessage;
    // }

    // public void setIdMessage(Integer idMessage) {
    //     this.idMessage = idMessage;
    // }

    // public String getMessageText() {
    //     return messageText;
    // }

    // public void setMessageText(String messageText) {
    //     this.messageText = messageText;
    // }

    // public Disfraz getDisfraces() {
    //     return costume;
    // }

    // public void setDisfraces(Disfraz costume) {
    //     this.costume = costume;
    // }

    // public Cliente getClientes() {
    //     return client;
    // }

    // public void setClientes(Cliente client) {
    //     this.client = client;
    // }

}
