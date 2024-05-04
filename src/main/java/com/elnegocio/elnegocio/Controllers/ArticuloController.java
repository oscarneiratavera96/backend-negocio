package com.elnegocio.elnegocio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elnegocio.elnegocio.Entities.Articulos;
import com.elnegocio.elnegocio.Repositories.ArticulosRepositories;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticulosRepositories articulosRepositories;

    @GetMapping
    public List<Articulos> getAllArticules() {
        return articulosRepositories.findAll();
    }

    @PostMapping
    public Articulos createArticules(@RequestBody Articulos articulo) {
        return articulosRepositories.save(articulo);

    }

    @GetMapping("/{id}")
    public Articulos getArticulesId(@PathVariable Long id) {
        return articulosRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el articulo con el ID: " + id));
    }

    @PutMapping("/{id}")
    public Articulos UpdateArticules(@PathVariable Long id, @RequestBody Articulos detailsArticule) {
        Articulos articulo = articulosRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el articulo con el ID: " + id));

        articulo.setAutor(detailsArticule.getAutor());
        articulo.setFecha(detailsArticule.getFecha());
        articulo.setTitulo(detailsArticule.getTitulo());
        articulo.setParrafos(detailsArticule.getParrafos());
        articulo.setEsInvitado(detailsArticule.isEsInvitado());

        return articulosRepositories.save(articulo);

    }

    @DeleteMapping("/{id}")
    public String DeleteProducto(@PathVariable Long id) {
        Articulos articulo = articulosRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el articulo con el ID: " + id));

        articulosRepositories.delete(articulo);
        return "El articulo con el id: " + id + " fue elimado correctamente";
    }
}
