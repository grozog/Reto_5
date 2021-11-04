package tienda_disfraces.reto3.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tienda_disfraces.reto3.repositorio.Crud.CategoriaCrudRepositorio;
import tienda_disfraces.reto3.modelo.Categoria;

/**
 * @autor Gladys Leticia Ramirez Torres
 */
@Repository
public class CategoriaRepositorio {
    @Autowired
    private CategoriaCrudRepositorio crudCategoria;

    public List<Categoria> getAll() {
        return (List<Categoria>) crudCategoria.findAll();
    }

    public Optional<Categoria> getCategoria(int id) {
        return crudCategoria.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return crudCategoria.save(categoria);
    }

    public void delete(Categoria categoria) {
        crudCategoria.delete(categoria);
    }
}
