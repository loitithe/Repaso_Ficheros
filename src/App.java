import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

    }

    static void escribeLeeProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "producto1", 5.3, true, 'Y'));
        productos.add(new Producto(2, "producto2", 4.1, true, 'D'));
        productos.add(new Producto(3, "producto3", 3.0, false, 'R'));
        productos.add(new Producto(4, "producto4", 2.5, true, 'Y'));

        try (RandomAccessFile raf = new RandomAccessFile("Ejemplo_raf.dat", "rw")) {
            for (Producto producto : productos) {
                raf.writeInt(producto.getId());
                // limitar el String a 10 caracteres , asi sabemos donde empieza y donde acaba
                StringBuffer sb = new StringBuffer(producto.getNombre());
                sb.setLength(10);
                raf.writeChars(sb.toString());
                raf.writeDouble(producto.getPrecio());
                raf.writeBoolean(producto.isDescuento());
                raf.writeChar(producto.getTipo());

            }
            // cuantos bytes son cada registro : int 4 - String 2 por caracter - double 8
            // boolean 1 char 2 = 35bytes por registro, empezando en 0
            leePosicion(raf, 105);
            leePosicion(raf, 70);
            leePosicion(raf, 0);
            leePosicion(raf, 35);
            leePosicion(raf, 70);

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /*
     * 
     * Long: 8 bytes
     * Integer: 4 bytes
     * Short: 2 bytes
     * Byte: 1 byte
     * Double: 8 bytes
     * Float: 4 bytes
     * Boolean: 1 byte
     * Char: 2 bytes
     * String: 2 bytes por cada caracter.
     * 
     */
    static void leePosicion(RandomAccessFile raf, int posicion) {
        try {
            raf.seek(posicion);

            System.out.println(raf.readInt());
            String nombre = "";
            for (int i = 0; i < 10; i++) {
                nombre += raf.readChar();
            }
            // System.out.println(raf.readUTF());
            System.out.println(nombre);

            System.out.println(raf.readDouble());

            System.out.println(raf.readBoolean());

            System.out.println(raf.readChar());
            System.out.println("=============");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
