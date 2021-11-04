package tienda_disfraces.reto3.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_disfraces.reto3.modelo.Cliente;
import tienda_disfraces.reto3.repositorio.ClienteRepositorio;

/**
 *
 * @author Andres Mejia
 */

@Service
public class ClienteServicios {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> getAll() {
        return clienteRepositorio.getAll();
    }

    public Optional<Cliente> getClient(int clientId) {
        return clienteRepositorio.getCliente(clientId);
    }

    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return clienteRepositorio.save(client);
        } else {
            Optional<Cliente> e = clienteRepositorio.getCliente(client.getIdClient());
            if (e.isEmpty()) {
                return clienteRepositorio.save(client);
            } else {
                return client;
            }
        }
    }

    public Cliente update(Cliente client) {
        if (client.getIdClient() != null) {
            Optional<Cliente> e = clienteRepositorio.getCliente(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                clienteRepositorio.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clienteRepositorio.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
