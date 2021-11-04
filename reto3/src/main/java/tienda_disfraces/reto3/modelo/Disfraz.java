package tienda_disfraces.reto3.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Grupo 6
 */

@Entity
@Table(name = "costume")
/**
 * Costume
 */
public class Disfraz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
   * int idCostume
   */
    private Integer id;
    /**
     * Sring name
     */
    private String name;
    /**
     * String brand
     */
    private String brand;
    /**
     * int year
     */
    private Integer year;
    /**
     * string description
     */
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("costumes")
    /**
     * Category
     */
    private Categoria category;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "costume")
    @JsonIgnoreProperties({ "costume", "client" })
    /**
     * Messages
     */
    private List<Mensaje> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "costume")
    @JsonIgnoreProperties({ "costume", "messages" })
    /**
     * Reservation
     */
    private List<Reserva> reservations;
    /**
     *  int Id
     * @return
     */

    public Integer getId() {
        return id;
    }
    /**
     *
     * @param id
     */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     *
     * @return Id
     */

    public String getName() {
        return name;
    }
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Brand
     */

    public String getBrand() {
        return brand;
    }
    /**
     *
     * @param brand
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     *
     * @return year
     */
    public Integer getYear() {
        return year;
    }
    /**
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *
     * @return Category
     */
    public Categoria getCategory() {
        return category;
    }
    /**
     * @param Category
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }
    /**
     *
     * @return Messages
     */
    public List<Mensaje> getMessages() {
        return messages;
    }
    /**
     *
     * @param messages
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
    /**
     *
     * @return Reservation
     */
    public List<Reserva> getReservations() {
        return reservations;
    }
    /**
     *
     * @param reservations
     */
    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }

}
