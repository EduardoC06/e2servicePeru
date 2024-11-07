
package Interface;

import Clases.producto;
import java.util.LinkedList;

public interface Productos {
    LinkedList<producto> obtenerProductos();
    boolean agregarProducto(String nombre, String descripcion, double precio, int stock);
    boolean actualizarProducto(int idProducto, String nombre, String descripcion, double precio, int stock);
    boolean comprobarToken(String token);
    boolean BorrarProducto(int idusuario, int idProducto);
}
