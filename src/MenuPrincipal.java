import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        // Configuración básica de la ventana
        setTitle("Sistema de Inventario - Mediateca UDB");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Diseño de la interfaz con espacio para el título y 4 botones
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel lblTitulo = new JLabel("Panel de Control", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblTitulo);

        // Definición de botones
        JButton btnLibros = new JButton("Gestión de Libros");
        JButton btnRevistas = new JButton("Gestión de Revistas");
        JButton btnCDs = new JButton("Gestión de CDs");
        JButton btnTesis = new JButton("Gestión de Tesis");

        // Agregando componentes al contenedor
        add(btnLibros);
        add(btnRevistas);
        add(btnCDs);
        add(btnTesis);

        // --- Eventos de los botones ---

        btnLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaLibro vLibro = new VentanaLibro();
                vLibro.setVisible(true);
            }
        });

        btnRevistas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaRevista vRevista = new VentanaRevista();
                vRevista.setVisible(true);
            }
        });

        btnCDs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se agregó la llave de cierre que faltaba aquí
                VentanaCD vCD = new VentanaCD();
                vCD.setVisible(true);
            }
        });

        btnTesis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaTesis vTesis = new VentanaTesis();
                vTesis.setVisible(true);
            }

        });
        JButton btnConsulta = new JButton("Ver Inventario General");
        add(btnConsulta);

        btnConsulta.addActionListener(e -> {
            new VentanaConsulta().setVisible(true);
        });
    }
}