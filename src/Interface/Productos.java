
package Interface;

import Clases.producto;
import java.util.LinkedList;

public interface Productos {
    LinkedList<producto> obtenerProductos();
    boolean agregarProducto(String nombre, String descripcion, double precio, int stock);
    boolean actualizarStock(int idProducto, String movimiento, int cantidad, int id_usuario, String observaciones);
    boolean actualizarProducto(int idProducto, String nombre, String descripcion, double precio, int stock);
    boolean comprobarToken(String token);
    boolean BorrarProducto(int idProducto);
}
