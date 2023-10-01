package Aplicacion;

import javax.swing.*;
import Menus.MenuAlumno;
import Conexion.ConexionDB;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.Year;
import java.lang.String;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Cuaderno extends JFrame{
    protected String var_nom;
    protected String var_contr;
    protected int contraseña;
    private VentanaRegistro ventanaRegistro;
    private String nom_us;
    private String contr;
    private String direccion;
    private String nombre;
    private String apellido;
    private int telefono;
    private int dni; 
    private String tipo;
    private String colegio;
    public int userCode;
    public Date fecha_nac;
    private String provincia;
    private String nacionalidad;
    private String localidad;
    private String email;
    
    
    public Cuaderno(){
        setTitle("Cuaderno de Comunicaciones Digital");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icono = new ImageIcon("logo.png");
        setIconImage(icono.getImage());
        int anchoVentana = 435;
        int altoVentana = 620;
        setSize(anchoVentana, altoVentana);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - anchoVentana) / 2;
        int y = (screenSize.height - altoVentana) / 2;
        setLocation(x, y);
    }

    public ArrayList<String> consulta(String campo, String tabla){
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
            return null;
        }
    }
    
    public ArrayList<String> consultaWhere(String campo, String tabla, String tabla2, String valor){
        ConexionDB db = new ConexionDB();
        Connection con = db.iniciarConexion();
        try{
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("Select " + campo + " FROM " + tabla + " WHERE " + tabla2 + " = '" + valor + "'");

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
            return null;
        }
    }
    public ArrayList<String> consultaWhere2(String campo, String campo2, String tabla, String campo3, String valor, String valor2){
        ConexionDB db = new ConexionDB();
        Connection con = db.iniciarConexion();
        try{
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("Select " + campo +", " + campo2 + " FROM " + tabla + " WHERE " + campo3 + " = '" + valor + "'" + "and " + campo2 + "= '" + valor2 + "'");

            ArrayList<String> lista = new ArrayList<>();

            while (resultSet.next()) {
                String nombre = resultSet.getString(campo);
                String contraseña = resultSet.getString(campo2);
                lista.add(nombre);
                lista.add(contraseña);
            }
            resultSet.close();
            statement.close();
            con.close();
            db.cerrarConexion();
            
            return lista;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void Inicio(){

        Font f1 = new Font("Helvetica", Font.ITALIC, 18);
        Font f2 = new Font("Helvetica", Font.PLAIN, 16);
        JPanel panel = new JPanel(null);
        panel.setSize(435, 675);
        this.add(panel);
        
        JLabel i = new JLabel();
        ImageIcon logo = new ImageIcon("logo.png");
        Icon iconLogo = new ImageIcon(logo.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
        i.setIcon(iconLogo);
        i.setBounds(145, 30, 125, 125);

        JLabel nom_us = new JLabel("Nombre de usuario");
        nom_us.setBounds(50, 175, 325, 20);
        nom_us.setFont(f1);
        nom_us.setForeground(Color.decode("#EDEDF0"));

        JTextField TNom = new JTextField(" Ingrese su nombre de usuario");
        TNom.setBounds(50, 200, 325, 30);
        TNom.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TNom.getText().equals(" Ingrese su nombre de usuario")) {
                    TNom.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (TNom.getText().isEmpty()) {
                    TNom.setText(" Ingrese su nombre de usuario");
                }
            }
        });

        JLabel Contra = new JLabel("Contraseña");
        Contra.setBounds(50, 240, 325, 20);
        Contra.setFont(f1);
        Contra.setForeground(Color.decode("#EDEDF0"));

        JTextField TContra =  new JTextField(" Ingrese su contraseña");
        TContra.setBounds(50, 265, 325, 30);
        TContra.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TContra.getText().equals(" Ingrese su contraseña")) {
                    TContra.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (TContra.getText().isEmpty()) {
                    TContra.setText(" Ingrese su contraseña");
                }
            }
        });

        JButton inciar = new JButton("Iniciar Sesión");
        inciar.setBounds(50, 330, 325, 50);

        JLabel olvidar = new JLabel("<html><u>Olvidé mi contraseña</u></html>");
        olvidar.setBounds(50, 395, 125, 30);
        olvidar.setForeground(Color.decode("#EDEDF0"));

        JPanel linePanel = new JPanel();
        linePanel.setLayout(null);
        linePanel.setBackground(Color.decode("#999893"));
        linePanel.setBounds(50, 445, 95, 2);

        JPanel linePanel2 = new JPanel();
        linePanel2.setLayout(null);
        linePanel2.setBackground(Color.decode("#999893"));
        linePanel2.setBounds(277, 445, 98, 2);

        JLabel or = new JLabel("¿No tiene cuenta?");
        or.setBounds(155, 438, 150, 15);
        or.setForeground(Color.decode("#999893"));

        JButton registrar = new JButton("Registrarse");
        registrar.setBounds(50, 485, 325, 50);

        ActionListener escuchador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String command = e.getActionCommand();
                if (command.equals("Iniciar Sesión")){
                    var_nom = TNom.getText();
                    InicioSesion();
                } else if (command.equals("Registrarse")){
                    mostrarVentanaRegistro();
                }
            }
        };
        olvidar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        olvidar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(null, "Olvidaste tu contraseña");
            }
             @Override
            public void mouseEntered(MouseEvent e) {
                olvidar.setForeground(Color.decode("#51DB78"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                olvidar.setForeground(Color.decode("#EDEDF0"));
            }
        });

        inciar.addActionListener(escuchador);
        registrar.addActionListener(escuchador);
        panel.setBackground(Color.decode("#000059"));
        panel.add(i);
        panel.add(nom_us);
        panel.add(TNom);
        panel.add(Contra);
        panel.add(TContra);
        panel.add(inciar);
        panel.add(registrar);
        panel.add(olvidar);
        panel.add(linePanel);
        panel.add(linePanel2);
        panel.add(or);
        panel.repaint();
    }

    private void mostrarVentanaRegistro() {
        if (ventanaRegistro == null) {
            ventanaRegistro = new VentanaRegistro();
            ventanaRegistro.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    ventanaRegistro = null;
                }
            });
        }
        ventanaRegistro.setVisible(true);
        this.setVisible(false); 
    }

    public void InicioSesion(int num){
        ArrayList<String> array_ = new ArrayList<>();
        String userType;
        boolean valid;
        switch(num){
            case 0:
                array_ = consultaWhere("tipo", "usuarios", "username", var_nom);
                userType = array_.get(0);
                valid = validaUser(var_nom, var_contr);
                if(valid == true){
                    switch(userType){
                        case "Alumno":
                            MenuAlumno_();
                            break;
                        default:
                            break;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña no válidos");
                }
            case 1:
                System.out.println("");
                break;
            default:
                break;
        }
    }

    private class VentanaRegistro extends JFrame {
        String stgMes = "mes";
        ArrayList<String> listaDias;

        public VentanaRegistro() {
            setSize(700, 700);
            ImageIcon icono = new ImageIcon("logo.png");
            setIconImage(icono.getImage());
            setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            crea_regis();
        }

        public void aplicaEstilo(JLabel label){
            Font f2 = new Font("Helvetica", Font.PLAIN, 16);
            label.setFont(f2);
            label.setForeground(Color.decode("#EDEDF0"));
        }

        private void crea_regis(){
            JPanel panel = new JPanel();
            panel.setBackground(Color.decode("#000059"));
            panel.setLayout(null);
            int anchoVentana = 700;
            int altoVentana = 700;
            setSize(anchoVentana, altoVentana);
            panel.setSize(anchoVentana, altoVentana);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screenSize.width - anchoVentana) / 2;
            int y = (screenSize.height - altoVentana) / 2;
            setLocation(x, y);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton back = new JButton("Volver");
            back.setBounds(0, 0, 70, 25);
            ActionListener escuchador = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    dispose();
                    Main main = new Main();
                    main.main(null);
                    main = null;
                }
            };
            back.addActionListener(escuchador);
            panel.add(back);

            JLabel LTipo = new JLabel("Tipo de usuario");
            aplicaEstilo(LTipo);
            LTipo.setBounds(20, 25, 150, 25);
            String[] opciones = {"Preceptor", "Alumno", "Profesor", "Adulto Responsable", "Gestor"};
            JComboBox Tipo = new JComboBox<>(opciones);
            Tipo.setSelectedItem(null);
            Tipo.setBounds(20, 55, 140, 25);

            JLabel LNombre = new JLabel("Nombre");
            aplicaEstilo(LNombre);
            LNombre.setBounds(20, 85, 140, 25);
            JTextField TNombre = new JTextField();
            TNombre.setBounds(20, 115, 140, 25);

            JLabel LApellido = new JLabel("Apellido");
            aplicaEstilo(LApellido);
            LApellido.setBounds(20, 140, 140, 25);
            JTextField TApellido = new JTextField();
            TApellido.setBounds(20, 170, 140, 25);

            JLabel LDni = new JLabel("DNI");
            aplicaEstilo(LDni);
            LDni.setBounds(20, 200, 140, 25);
            JTextField Tdni = new JTextField();
            Tdni.setBounds(20, 230, 140, 25);

            JLabel LNom_us = new JLabel("Nombre de usuario");
            aplicaEstilo(LNom_us);
            LNom_us.setBounds(20, 320, 140, 25);
            JTextField TNom_us = new JTextField();
            TNom_us.setBounds(20, 350, 140, 25);

            JLabel LContra = new JLabel("Contraseña");
            aplicaEstilo(LContra);
            LContra.setBounds(20, 380, 140, 25);
            JTextField TContra = new JTextField();
            TContra.setBounds(20, 410, 140, 25);
            
            JLabel LFecha = new JLabel("Fecha de nacimiento");
            aplicaEstilo(LFecha);
            LFecha.setBounds(20, 440, 240, 25);
            int anioActual = Year.now().getValue();
            int anioInicio = 1960;

            JComboBox<String> combo_año = new JComboBox<>();
            for (int i = anioInicio; i <= anioActual; i++) {
                combo_año.addItem(Integer.toString(i));
            }
            combo_año.setBounds(20, 470, 55, 25);

            ArrayList<String> listaMes = consulta("mes", "meses order by numero");
            JComboBox<String> combo_mes = new JComboBox<>();
            for (String opcion : listaMes) {
                combo_mes.addItem(opcion);
            }
            combo_mes.setBounds(80, 470, 55, 25);
            JComboBox<String> combo_dia = new JComboBox<>();
            combo_dia.setBounds(140, 470, 55, 25);

            stgMes = combo_mes.getItemAt(0);
            listaDias = consultaWhere("dias", "meses", "mes", stgMes);
            int maxDias = Integer.parseInt(listaDias.get(0));

            for (int i = 1; i <= maxDias; i++) {
                combo_dia.addItem(String.valueOf(i));
            }

            combo_mes.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        stgMes = combo_mes.getSelectedItem().toString();
                        System.out.println("Mes obtenido del combo: " + stgMes);
                        listaDias = consultaWhere("dias", "meses", "mes", stgMes);
                        int maxDias = Integer.parseInt(listaDias.get(0));
                        combo_dia.removeAllItems();
                        for (int i = 1; i <= maxDias; i++) {
                            combo_dia.addItem(String.valueOf(i));
                        }
                    }
                }
            });

            combo_dia.setBounds(140, 470, 55, 25);

            JLabel LDireccion = new JLabel("Dirección");
            aplicaEstilo(LDireccion);
            LDireccion.setBounds(20, 500, 140, 25);

            JTextField TDireccion = new JTextField();
            TDireccion.setBounds(20, 530, 140, 25);

            JLabel LTelefono = new JLabel("Núnmero de teléfono");
            aplicaEstilo(LTelefono);
            LTelefono.setBounds(20, 560, 140, 25);
            
            JTextField T_telefono = new JTextField();
            T_telefono.setBounds(20, 590, 140, 25);
            
            JLabel LProv = new JLabel("Provincia");
            aplicaEstilo(LProv);
            LProv.setBounds(370, 20, 140, 25);
            ArrayList<String> provincias = consulta("pro_desc","provincias");
            JComboBox<String> combo_pro = new JComboBox<>();
            for (String opcion : provincias){
                combo_pro.addItem(opcion);
            }
            combo_pro.setSelectedItem(null);
            combo_pro.setBounds(370, 50, 140, 25);
            
            JLabel L_loc = new JLabel("Localidad");
            aplicaEstilo(L_loc);
            L_loc.setBounds(370, 90, 140, 25);
            ArrayList<String> localidades = consulta("loc_desc","localidades");
            JComboBox<String> combo_loc = new JComboBox<>();
            for (String opcion : localidades){
                combo_loc.addItem(opcion);
            }
            combo_loc.setSelectedItem(null);
            combo_loc.setBounds(370, 120, 140, 25);
            
            JLabel LNac = new JLabel("Nacionalidad");
            aplicaEstilo(LNac);
            LNac.setBounds(370, 150, 140, 25);
            ArrayList<String> nacionalidades = consulta("nac_desc","nacionalidades");
            JComboBox<String> combo_nac = new JComboBox<>();
            for (String opcion : nacionalidades){
                combo_nac.addItem(opcion);
            }
            combo_nac.setSelectedItem(null);
            combo_nac.setBounds(370, 180, 140, 25);
        
            JLabel Lemail = new JLabel("Correo Electrónico");
            aplicaEstilo(Lemail);
            Lemail.setBounds(370, 210, 140, 25);
            JTextField Temail = new JTextField();
            Temail.setBounds(370, 240, 140, 25);

            JButton registrarse = new JButton("Confirmar");
            registrarse.setBounds(500, 500, 140, 25);
            registrarse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isFieldValid(TApellido) && isFieldValid(TContra) && isFieldValid(TDireccion)
                        && isFieldValid(Tdni) && isFieldValid(TNom_us) && isFieldValid(T_telefono) && isFieldValid(TNombre)
                        && isComboValid(Tipo) && isComboValid(combo_dia) && isComboValid(combo_pro) && isComboValid(combo_nac)
                        && isComboValid(combo_loc) && isFieldValid(Temail)){
                        
                        String YY = combo_año.getSelectedItem().toString();
                        String MM = combo_mes.getSelectedItem().toString();
                        String DD = combo_dia.getSelectedItem().toString();
                        int index = listaMes.indexOf(MM);
                        String MM_ = (index != -1) ? String.valueOf(index + 1) : null;

                        String fecha = YY + "-" + MM_ + "-" + DD;
                        
                        String nombre = TNombre.getText();
                        String apellido = TApellido.getText();
                        String nom_us= TNom_us.getText();
                        String contr = TContra.getText();
                        String direccion = TDireccion.getText();
                        int telefono = valida_telefono(T_telefono.getText());
                        int dni = valida_dni(Tdni.getText());
                        String tipo = Tipo.getSelectedItem().toString();
                        String prov = combo_pro.getSelectedItem().toString();
                        String loc = combo_loc.getSelectedItem().toString();
                        String nac = combo_nac.getSelectedItem().toString();
                        String email = validaEmail(Temail.getText());
                        
                        ArrayList<String> arrayProv = new ArrayList<>();
                        arrayProv = consultaWhere("pro_cod", "provincias", "pro_desc", prov);
                        int pro_cod =  Integer.parseInt(arrayProv.get(0));
                        
                        ArrayList<String> arrayNac = new ArrayList<>();
                        arrayNac = consultaWhere("nac_cod", "nacionalidades", "nac_desc", nac);
                        int nac_cod =  Integer.parseInt(arrayProv.get(0));
                        
                        ArrayList<String> arrayLoc = new ArrayList<>();
                        arrayLoc = consultaWhere("loc_cod", "localidades", "loc_desc", loc);
                        int loc_cod =  Integer.parseInt(arrayProv.get(0));
                        
                        insert(nom_us, contr, tipo, dni, nombre, apellido, fecha, direccion, telefono, pro_cod, loc_cod, nac_cod, email);
                        
                        if (dni!=0 && telefono!=0 && email!=""){
                            ventanaRegistro.dispose();
                            switch(tipo){
                                case "Alumno":
                                    MenuAlumno_();
                                    break;
                                case "Preceptor":
                                    MenuPreceptor();
                                    break;
                                case "Adulto Responsable":
                                    MenuAdultoResponsable();
                                    break;
                                case "Gestor":
                                    break;
                            }
                        }
                    } else {
                        advertencia(TNombre);
                        advertencia(TApellido);
                        advertencia(TContra);
                        advertencia(TDireccion);
                        advertencia(TNom_us);
                        advertencia(Tdni);
                        advertencia(T_telefono);
                        advertencia(Temail);
                    }
                }
            });

            Color obligatorioColor = Color.decode("#C21C10");
            Color normalColor = Color.decode("#000000");
            Focus focusListener = new Focus(" Campo obligatorio*", obligatorioColor, normalColor);

            add(panel);
            TApellido.addFocusListener(focusListener);
            TNombre.addFocusListener(focusListener);
            TContra.addFocusListener(focusListener);
            TDireccion.addFocusListener(focusListener);
            TNom_us.addFocusListener(focusListener);
            Tdni.addFocusListener(focusListener);
            T_telefono.addFocusListener(focusListener);
            panel.add(LTipo);
            panel.add(Tipo);
            panel.add(LNombre);
            panel.add(TNombre);
            panel.add(LApellido);
            panel.repaint();
            panel.add(TApellido);
            panel.add(LDni);
            panel.add(Tdni);
            panel.add(LNom_us);
            panel.add(TNom_us);
            panel.add(LContra);
            panel.add(TContra);
            panel.add(LFecha);
            panel.add(LDireccion);
            panel.add(TDireccion);
            panel.add(LTelefono);
            panel.add(T_telefono);
            panel.add(registrarse);
            panel.add(combo_año);
            panel.add(combo_mes);
            panel.add(combo_dia);
            panel.add(combo_loc);
            panel.add(combo_nac);
            panel.add(combo_pro);
            panel.add(LNac);
            panel.add(L_loc);
            panel.add(LProv);
            panel.add(Lemail);
            panel.add(Temail);
        }
        
        public void advertencia (JTextField TF){
            if (TF.getText().trim().isEmpty()){
                System.out.println("Entro en el IF");
                TF.setText(" Campo obligatorio*");
                TF.setForeground(Color.decode("#C21C10"));
            }
        }
        
        public static boolean verificarComponente(Container container, Component componente) {
            Component[] componentes = container.getComponents();
            for (Component c : componentes) {
                if (c == componente) {
                    return true;
                }
            }
            return false;
        }

        private boolean isFieldValid(JTextField textField) {
            String text = textField.getText().trim();
            return !text.isEmpty() && !text.equals(" Campo obligatorio*");
        }

        private boolean isComboValid(JComboBox comboBox){
            try{
                String opcion =  (String) comboBox.getSelectedItem();
                return !opcion.isEmpty();
            } catch (NullPointerException e){
                return false;
            }
        }

        public void valida_vacio(JTextField TF){
            if (TF.getText().equals("") || TF.getText().equals(" Campo obligatorio*")){
                JOptionPane.showMessageDialog(null, "Falta informacion");
            }
        }

        public int valida_telefono(String valor){
            try{
                if (valor.length()==10 && valor.charAt(0)=='1' && valor.charAt(1)=='1') {
                    int num = Integer.parseInt(valor);
                    return num;
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese un numero de telefono valido (11........)");
                    return 0;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese un numero de telefono valido (11........)");
                return 0;
            }
        }

        public int valida_dni(String valor){
            if (valor.length()==8){
                try{
                    int num = Integer.parseInt(valor);
                    return num;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Dni no válido");
                    return 0;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Dni no válido");
                return 0;         
            }
        }
        
        public String validaEmail(String mail){
            if (mail.contains("@") && mail.contains(".com")){
                return mail;
            }else{
                System.out.println("Correo incorrecto");
                return "";
            }
        }
    }
    public boolean validaUser(String var_nom, String psswd){
        ArrayList<String> lista = new ArrayList<>();
        lista = consultaWhere2("username", "psswd", "usuarios", "username", var_nom, psswd);
        if(!lista.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public void insert(String nom_us, String contra, String tipo, int dni, String nombre, String apellido, String fecha, String direccion, int telefono, int pro_cod, int loc_cod, int nac_cod, String mail) {
        ConexionDB db = new ConexionDB();
        Connection con = db.iniciarConexion();
        PreparedStatement preparedStatement = null;

        try {
            // Obtener el próximo código de usuario
            int userCode = getNextUserCode(con);

            // Consulta de inserción preparada
            String stgInsert = "INSERT INTO usuarios (user_cod, username, psswd, tipo, dni, nombre, apellido, fecha_nac, nac_cod, direccion, loc_cod, pro_cod, telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = con.prepareStatement(stgInsert);

            preparedStatement.setInt(1, userCode);
            preparedStatement.setString(2, nom_us);
            preparedStatement.setString(3, contra);
            preparedStatement.setString(4, tipo);
            preparedStatement.setInt(5, dni);
            preparedStatement.setString(6, nombre);
            preparedStatement.setString(7, apellido);
            preparedStatement.setString(8, fecha);
            preparedStatement.setInt(9, nac_cod);
            preparedStatement.setString(10, direccion);
            preparedStatement.setInt(11, loc_cod);
            preparedStatement.setInt(12, pro_cod);
            preparedStatement.setInt(13, telefono);
            preparedStatement.setString(14, mail);

            // Ejecutar la consulta de inserción
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                con.commit();
                System.out.println("Registro exitoso\n");
            } else {
                System.out.println("No se pudo insertar el registro\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        db.cerrarConexion();
    }

    private int getNextUserCode(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(user_cod) FROM usuarios");
        int nextCode = 1;

        if (resultSet.next()) {
            nextCode = resultSet.getInt(1) + 1;
        }
        statement.close();
        return nextCode;
    }

    public void MenuAlumno_(){
        this.dispose();
        MenuAlumno men_alu = new MenuAlumno();
    }

    public void MenuAdultoResponsable(){}
    
    public void MenuDocenteJardin() {
        JPanel panel = new JPanel(null);
        panel.setSize(1000, 700);
        panel.setLayout(null);

        String[] cursos = { "Sala Roja", "Sala Amarilla", "Sala Naranja" };
        JComboBox<String> combo_curso = new JComboBox<String>(cursos);
        combo_curso.setBounds(100, 50, 200, 30);
        panel.add(combo_curso);

        String[] alumnos = { "Agustín Villa", "Joaquín Guardia", "Masaki Kondo" };
        JComboBox<String> combo_alumnos = new JComboBox<String>(alumnos);
        combo_alumnos.setBounds(400, 50, 200, 30);
        panel.add(combo_alumnos);

        JButton add_nota = new JButton("Añadir Nota");
        add_nota.setBounds(700, 50, 200, 30);
        add_nota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AniadirNota();
            }
        });
        panel.add(add_nota);

        JPanel panel_table = new JPanel(new BorderLayout());
        panel_table.setBounds(100, 110, 800, 500);

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas sean de solo lectura
            }
        };

        modelo.addColumn("Fecha");
        modelo.addColumn("Comunicado");
        modelo.addColumn("Notificado");

        JTable tabla = new JTable(modelo);
        tabla.setBorder(new LineBorder(Color.BLACK));

        // Configura el ancho fijo para las columnas de encabezado
        TableColumn column;

        // "Fecha" con ancho 100
        column = tabla.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);

        // "Comunicado" con ancho 600
        column = tabla.getColumnModel().getColumn(1);
        column.setPreferredWidth(600);

        // "Notificado" con ancho 100
        column = tabla.getColumnModel().getColumn(2);
        column.setPreferredWidth(100);

        modelo.addRow(new Object[] { "29/9", "Se informa que Main", "Sí" });
        modelo.addRow(new Object[] { "29/9", "Se informa que Mainsito", "No" });
        modelo.addRow(new Object[] { "29/9", "Se informa que Mainsote", "No" });

        panel_table.add(new JScrollPane(tabla), BorderLayout.CENTER);
        panel.add(panel_table);
        this.setContentPane(panel);
    }

    public void MenuDocentePrimaria() {
        JPanel panel = new JPanel(null);
        panel.setSize(1000, 700);
        panel.setLayout(null);

        String[] cursos = { "1° Grado", "2° Grado", "3° Grado" };
        JComboBox<String> combo_curso = new JComboBox<String>(cursos);
        combo_curso.setBounds(100, 50, 200, 30);
        panel.add(combo_curso);

        String[] alumnos = { "Agustín Villa", "Joaquín Guardia", "Masaki Kondo" };
        JComboBox<String> combo_alumnos = new JComboBox<String>(alumnos);
        combo_alumnos.setBounds(400, 50, 200, 30);
        panel.add(combo_alumnos);

        JButton add_nota = new JButton("Añadir Nota");
        add_nota.setBounds(700, 50, 200, 30);
        add_nota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AniadirNota();
            }
        });
        panel.add(add_nota);

        JPanel panel_table = new JPanel(new BorderLayout());
        panel_table.setBounds(100, 110, 800, 500);

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas sean de solo lectura
            }
        };

        modelo.addColumn("Fecha");
        modelo.addColumn("Comunicado");
        modelo.addColumn("Notificado");

        JTable tabla = new JTable(modelo);
        tabla.setBorder(new LineBorder(Color.BLACK));

        // Configura el ancho fijo para las columnas de encabezado
        TableColumn column;

        // "Fecha" con ancho 100
        column = tabla.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);

        // "Comunicado" con ancho 600
        column = tabla.getColumnModel().getColumn(1);
        column.setPreferredWidth(600);

        // "Notificado" con ancho 100
        column = tabla.getColumnModel().getColumn(2);
        column.setPreferredWidth(100);

        modelo.addRow(new Object[] { "29/9", "Se informa que Main", "Sí" });
        modelo.addRow(new Object[] { "29/9", "Se informa que Mainsito", "No" });
        modelo.addRow(new Object[] { "29/9", "Se informa que Mainsote", "No" });

        panel_table.add(new JScrollPane(tabla), BorderLayout.CENTER);
        panel.add(panel_table);
        this.setContentPane(panel);
    }

    public void AniadirNota() {
        Font f = new Font("Helvetica", Font.BOLD, 20);

        // Crear el panel principal
        JPanel panel = new JPanel(null);
        panel.setSize(1000, 700);
        panel.setLayout(null);

        // Panel para opciones
        JPanel panel_op = new JPanel(null);
        panel_op.setSize(250, 700);
        panel_op.setLayout(null);
        panel_op.setBackground(Color.decode("#A5C8E7"));

        // Panel para la nota
        JPanel panel_nota = new JPanel(null);
        panel_nota.setBounds(250, 0, 750, 700);

        // Botón Volver
        JButton bt_volver = new JButton("Volver");
        bt_volver.setBounds(10, 10, 100, 20);
        bt_volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuDocenteJardin();
            }
        });
        panel_op.add(bt_volver);

        // Combo de cursos
        String[] cursos = { "Sala Roja", "Sala Amarilla", "Sala Naranja" };
        JComboBox<String> combo_curso = new JComboBox<String>(cursos);
        combo_curso.setBounds(50, 75, 150, 30);
        panel_op.add(combo_curso);

        // Array de elementos
        String[] elementos = { "Agustín Villa", "Joaquín Guardia", "Masaki Kondo", "Agustín Villa",
                "Joaquín Guardia", "Masaki Kondo", "Agustín Villa", "Joaquín Guardia", "Masaki Kondo", "Agustín Villa",
                "Joaquín Guardia", "Masaki Kondo", "Agustín Villa", "Joaquín Guardia", "Masaki Kondo", "Agustín Villa",
                "Joaquín Guardia", "Masaki Kondo", "Agustín Villa", "Joaquín Guardia", "Masaki Kondo", "Agustín Villa",
                "Joaquín Guardia", "Masaki Kondo" };

        // Panel para las casillas de verificación
        JPanel check_panel = new JPanel();
        check_panel.setLayout(new BoxLayout(check_panel, BoxLayout.Y_AXIS));

        // JScrollPane para el panel de casillas de verificación
        JScrollPane scrollPane = new JScrollPane(check_panel);
        scrollPane.setBounds(50, 150, 150, 450);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);

        // Crear el arreglo de casillas de verificación (checkboxes) para los elementos
        JCheckBox[] checkboxes = new JCheckBox[elementos.length];

        // Crear el checkbox "Seleccionar Todos"
        JCheckBox selectAllCheckbox = new JCheckBox("Seleccionar Todos");

        // Agregar ActionListener al checkbox "Seleccionar Todos"
        selectAllCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el estado del checkbox "Seleccionar Todos"
                boolean selected = selectAllCheckbox.isSelected();

                // Aplicar ese estado a todos los demás checkboxes
                for (int i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].setSelected(selected);
                }
            }
        });

        // Agregar el checkbox "Seleccionar Todos" al panel de casillas de verificación
        check_panel.add(selectAllCheckbox);

        // Agregar los checkboxes al panel de casillas de verificación
        for (int i = 0; i < elementos.length; i++) {
            checkboxes[i] = new JCheckBox(elementos[i]);
            checkboxes[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            check_panel.add(checkboxes[i]);
        }

        // Etiqueta y campo de texto para la fecha
        JLabel lbl_fecha = new JLabel("Fecha");
        lbl_fecha.setFont(f);
        lbl_fecha.setBounds(50, 50, 150, 30);
        panel_nota.add(lbl_fecha);

        JTextField fecha = new JTextField("AAAA-MM-DD");
        fecha.setBounds(50, 90, 150, 20);
        panel_nota.add(fecha);

        // Crear el JTextArea
        JTextArea comunicado = new JTextArea();
        // comunicado.setBounds(50, 140, 625, 400);
        comunicado.setLineWrap(true); // Habilitar el salto de línea automático
        comunicado.setWrapStyleWord(true); // Saltar palabras completas
        comunicado.setMargin(new Insets(5, 5, 5, 5));

        // Crear el JScrollPane y agregar el JTextArea a él
        JScrollPane scrollPane_ta = new JScrollPane(comunicado);
        scrollPane_ta.setBounds(50, 140, 625, 400);
        scrollPane_ta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_ta.getVerticalScrollBar().setUnitIncrement(15);

        // Agregar el JScrollPane al panel
        panel_nota.add(scrollPane_ta); // Donde "panel_nota" es el panel en el que deseas agregar el JTextArea

        // Botón "Subir Nota"
        JButton subir_nota = new JButton("Subir Nota");
        subir_nota.setBounds(475, 570, 200, 30);
        panel_nota.add(subir_nota);

        // Agregar componentes al panel de la nota
        panel_nota.add(lbl_fecha);
        panel_nota.add(fecha);

        // Agregar componentes a los paneles principales
        panel_op.add(scrollPane); // Agregamos el JScrollPane con las casillas de verificación al panel_op
        panel.add(panel_nota);
        panel.add(panel_op);
        this.setContentPane(panel);
    }
    
    public void MenuDocenteSecundaria(){}
    public void MenuPreceptor(){}

}
