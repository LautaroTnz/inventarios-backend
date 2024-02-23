package Lt.Inventarios.Service;

import Lt.Inventarios.Entity.Producto;
import Lt.Inventarios.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {


    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Long idProducto) {
        Producto producto =
                this.productoRepository.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Long idProducto) {
        this.productoRepository.deleteById(idProducto);
    }
}
