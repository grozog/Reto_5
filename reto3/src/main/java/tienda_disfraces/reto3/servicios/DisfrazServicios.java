package tienda_disfraces.reto3.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_disfraces.reto3.modelo.Disfraz;
import tienda_disfraces.reto3.repositorio.DisfrazRepositorio;

@Service
public class DisfrazServicios {

    @Autowired
    private DisfrazRepositorio disfrazRepositorio;

    public List<Disfraz> getAll(){
        return disfrazRepositorio.getAll();
    }

    public Optional<Disfraz> getDisfraz(int id){
        return disfrazRepositorio.getDisfraz(id);
    }

    public Disfraz save(Disfraz disfraz){
        if(disfraz.getId()==null){
            return disfrazRepositorio.save(disfraz);
        }else{
            Optional<Disfraz> disAux=disfrazRepositorio.getDisfraz(disfraz.getId());
            if (disAux.isEmpty()){
                return disfrazRepositorio.save(disfraz);
            } else{
                return disfraz;
            }
        }
    }

    public Disfraz update(Disfraz disfraz){
        if(disfraz.getId()!=null){
            Optional<Disfraz> e=disfrazRepositorio.getDisfraz(disfraz.getId());
            if(!e.isEmpty()){
                if(disfraz.getName()!=null){
                    e.get().setName(disfraz.getName());
                }
                if(disfraz.getBrand()!=null){
                    e.get().setBrand(disfraz.getBrand());
                }
                if(disfraz.getYear()!=null){
                    e.get().setYear(disfraz.getYear());
                }
                if(disfraz.getDescription()!=null){
                    e.get().setDescription(disfraz.getDescription());
                }

                disfrazRepositorio.save(e.get());
                return e.get();
            }else{
                return disfraz;
            }
        }else{
            return disfraz;
        }
    }

  public boolean deleteDisfraz(int disfrazId) {
        Boolean borrar= getDisfraz(disfrazId).map(disfraz -> {
            disfrazRepositorio.delete(disfraz);
            return true;
        }).orElse(false);
        return borrar;
    }


}
