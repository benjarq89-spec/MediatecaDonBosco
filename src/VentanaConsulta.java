import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaConsulta extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaConsulta() {
        setTitle("Inventario de Materiales - Mediateca UDB");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Columnas genéricas
        String[] columnas = {"ID", "Título", "Dato 1", "Dato 2", "Dato 3"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Panel de botones
        JPanel pnl = new JPanel();
        JButton bLib = new JButton("Ver Libros");
        JButton bRev = new JButton("Ver Revistas");
        JButton bCD = new JButton("Ver CDs");
        JButton bTes = new JButton("Ver Tesis");

        pnl.add(bLib); pnl.add(bRev); pnl.add(bCD); pnl.add(bTes);
        add(pnl, BorderLayout.NORTH);

        MaterialDAO dao = new MaterialDAO();

        // Eventos
        bLib.addActionListener(e -> cargar(dao.consultarLibros()));
        bRev.addActionListener(e -> cargar(dao.consultarRevistas()));
        bCD.addActionListener(e -> cargar(dao.consultarCDs()));
        bTes.addActionListener(e -> cargar(dao.consultarTesis()));
    }

    private void cargar(List<Object[]> datos) {
        modelo.setRowCount(0);
        for (Object[] f : datos) modelo.addRow(f);
    }
}
