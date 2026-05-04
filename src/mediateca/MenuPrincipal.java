package mediateca;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private String rolUsuario;

    public MenuPrincipal(String rol) {
        this.rolUsuario = rol;

        setTitle("Sistema Mediateca UDB - Bienvenido: " + rol);
        setSize(700, 550); // Aumentamos un poco el tamaño para que quepa todo bien
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Superior: Título
        JLabel lblTitulo = new JLabel("Panel de Control - Mediateca Don Bosco", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel Central: Botones organizados
        JPanel panelBotones = new JPanel(new GridLayout(5, 2, 15, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // --- BOTONES DE GESTIÓN (Altas) ---
        JButton btnLibros = new JButton("Ingresar Libros");
        JButton btnTesis = new JButton("Ingresar Tesis");
        JButton btnCDs = new JButton("Ingresar CDs");
        JButton btnRevistas = new JButton("Ingresar Revistas");

        // --- BOTÓN DE CONSULTA (El que necesitabas para ver la lista) ---
        JButton btnConsulta = new JButton("🔎 CONSULTAR INVENTARIO COMPLETO");
        btnConsulta.setBackground(new Color(200, 230, 255)); // Un color azul claro para diferenciarlo

        // --- BOTONES DE OPERACIONES ---
        JButton btnPrestamo = new JButton("Realizar Préstamo");
        JButton btnDevolucion = new JButton("Procesar Devolución");

        // --- BOTONES DE SISTEMA ---
        JButton btnConfig = new JButton("Configuración de Mora");
        JButton btnUsuarios = new JButton("Gestión de Usuarios");

        // Agregar botones según privilegios
        panelBotones.add(btnLibros);
        panelBotones.add(btnTesis);
        panelBotones.add(btnCDs);
        panelBotones.add(btnRevistas);

        // La consulta es para todos, pero la ponemos en un lugar visible
        panelBotones.add(btnConsulta);

        if (rolUsuario.equals("Administrador")) {
            panelBotones.add(btnPrestamo);
            panelBotones.add(btnDevolucion);
            panelBotones.add(btnConfig);
            panelBotones.add(btnUsuarios);
        }

        add(panelBotones, BorderLayout.CENTER);

        // --- FUNCIONALIDAD DE LOS BOTONES ---

        btnLibros.addActionListener(e -> new VentanaLibro().setVisible(true));
        btnTesis.addActionListener(e -> new VentanaTesis().setVisible(true));
        btnCDs.addActionListener(e -> new VentanaCD().setVisible(true));
        btnRevistas.addActionListener(e -> new VentanaRevista().setVisible(true));

        // ESTE ABRE LA TABLA QUE TE MOSTRARÁ EL LIBRO QUE INGRESASTE
        btnConsulta.addActionListener(e -> new VentanaConsulta().setVisible(true));

        btnPrestamo.addActionListener(e -> new VentanaPrestamo().setVisible(true));
        btnDevolucion.addActionListener(e -> new VentanaDevolucion().setVisible(true));
        btnConfig.addActionListener(e -> new VentanaConfiguracion().setVisible(true));
        btnUsuarios.addActionListener(e -> new VentanaGestionUsuarios().setVisible(true));

        // Botón de Salir
        JButton btnSalir = new JButton("Cerrar Sesión");
        btnSalir.addActionListener(e -> {
            dispose();
            new VentanaLogin().setVisible(true);
        });
        add(btnSalir, BorderLayout.SOUTH);
    }
}