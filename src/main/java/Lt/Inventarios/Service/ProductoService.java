package Lt.Inventarios.Service;

import Lt.Inventarios.Entity.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Long idProducto);

    public Producto guardarProducto (Producto producto);

    public void eliminarProductoPorId(Long idProducto);
}
