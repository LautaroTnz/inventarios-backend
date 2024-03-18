package Lt.Inventarios.Rest;


import Lt.Inventarios.Entity.Producto;
import Lt.Inventarios.Service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//localhost:8080/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoRest {

    private static final Logger logger = LoggerFactory.getLogger(ProductoRest.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoService.listarProductos();
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    @GetMapping("/productos/{id}")
        public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id){
            Producto producto = this.productoService.buscarProductoPorId(id);
            return ResponseEntity.ok(producto);
        }


    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);
        return this.productoService.guardarProducto(producto);
    }

    @PutMapping("productos/{id}")
    public ResponseEntity<Producto>actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto productoRecibido){
        Producto producto = this.productoService.buscarProductoPorId(id);
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setExistencia(productoRecibido.getExistencia());
        this.productoService.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarProducto(@PathVariable long id){
        Producto producto = productoService.buscarProductoPorId(id);
        this.productoService.eliminarProductoPorId(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
