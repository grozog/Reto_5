package tienda_disfraces.reto3.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @autor Gladys Leticia Ramirez Torres
 */
@Entity
@Table(name = "category")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Disfraz> costumes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Disfraz> getCostumes() {
        return costumes;
    }

    public void setCostumes(List<Disfraz> costumes) {
        this.costumes = costumes;
    }

    // public Integer getId() {
    // return id;
    // }

    // public void setId(Integer id) {
    // this.id = id;
    // }

    // public String getName() {
    // return name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public String getDescription() {
    // return description;
    // }

    // public void setDescription(String description) {
    // this.description = description;
    // }

    // public List<Disfraz> getCostumes() {
    // return costumes;
    // }

    // public void setCostumes(List<Disfraz> costumes) {
    // this.costumes = costumes;
    // }
}
