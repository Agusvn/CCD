package Menus;
import Conexion.ConexionDB;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.*;


public class MenuAlumno extends JFrame{
    public MenuAlumno(){
        setSize(700, 700);
        ImageIcon icono = new ImageIcon("logo.png");
        setIconImage(icono.getImage());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        crea_menu();
        setTitle("Alumno");
    }

    public ArrayList<String> valoresCombo(String campo, String tabla){
        ConexionDB db = new ConexionDB();
        Connection con = db.iniciarConexion();
        try{
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("Select " + campo + " FROM " + tabla);

            ArrayList<String> lista = new ArrayList<>();

            while (resultSet.next()) {
                String nombre = resultSet.getString(campo);
                lista.add(nombre);
            }
            resultSet.close();
            statement.close();
            con.close();
            db.cerrarConexion();
            return lista;
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void crea_menu(){
        String url = "jdbc:mysql://localhost:3306/ccd_db";
        String user = "root";
        String contr = "12341234";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, contr);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        JPanel panelContainer = new JPanel();
        CardLayout cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);
        int anchoVentana = 700;
        int altoVentana = 700;
        panelContainer.setSize(anchoVentana, altoVentana);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - anchoVentana) / 2;
        int y = (screenSize.height - altoVentana) / 2;
        setLocation(x, y);
        panelContainer.setBackground(Color.decode("#000059"));

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Vista");
        JMenuItem faltas = new JMenuItem("Faltas");
        JMenuItem trabajos = new JMenuItem("Trabajos");
        this.setJMenuBar(barra);
        
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panelTrabajos = new JPanel();
        JPanel panelFaltas = new JPanel();

        ArrayList<String> opciones = valoresCombo("mat_desc", "materias");
        JComboBox<String> comboMaterias = new JComboBox<>();
        for (String opcion : opciones) {
            comboMaterias.addItem(opcion);
        }
        comboMaterias.setBounds(300, 300, 150, 25);
        comboMaterias.setSelectedItem(null);
        panelTrabajos.add(comboMaterias);
        
        TableModel dataModel = new AbstractTableModel() {
          public int getColumnCount() { return 10; }
          public int getRowCount() { return 10;}
          public Object getValueAt(int row, int col) { 
              return new Integer(row*col); 
          }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);
        panelTrabajos.add(table);
        
        tabbedPane.addTab("Trabajos", panelTrabajos);
        tabbedPane.addTab("Faltas", panelFaltas);
        getContentPane().add(tabbedPane);
    }
}