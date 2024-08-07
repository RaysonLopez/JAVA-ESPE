/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interface.ViewCliente;

import ConexionBD.ConexionBDPropiedades;
import elmain.ImageRenderer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rayson
 */
public class VISTAIngresoPropiedades extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    /**
     * Creates new form Propiedades
     */
    public VISTAIngresoPropiedades() {
        initComponents();
        tableModel=new DefaultTableModel(new Object[][]{},new String[]{"k",""})
        {
            @Override 
            public boolean isCellEditable(int row,int column){
                return false;
            }
            @Override
            public Class<?> getColumnClass(int column){
                if(column==0){
                    return ImageIcon.class;
                }
                return Object.class;
            }
        };
        ConexionBDPropiedades conexionBD=new ConexionBDPropiedades();
        conexionBD.actualizarTablaMongo(tableModel);
        dataTable.setModel(tableModel);
        dataTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        dataTable.setRowHeight(50);
        dataTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        errorNames.setVisible(false);
        errorDescripcion.setVisible(false);
        errorDirrecion.setVisible(false);
        errorPrecio.setVisible(false);
        errorMetros.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        nombrePLabel = new javax.swing.JLabel();
        nroCuartosLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        errorDirrecion = new javax.swing.JLabel();
        metrosLabel = new javax.swing.JLabel();
        errorPrecio = new javax.swing.JLabel();
        errorMetros = new javax.swing.JLabel();
        namesPropiedad = new javax.swing.JTextField();
        descripcionText = new javax.swing.JTextField();
        precioText = new javax.swing.JTextField();
        metrosText = new javax.swing.JTextField();
        deleteTable = new javax.swing.JButton();
        saveTable = new javax.swing.JButton();
        ModificateTable = new javax.swing.JButton();
        numeroCuartosCombo = new javax.swing.JComboBox<>();
        ubicacionLabel = new javax.swing.JLabel();
        languaje = new javax.swing.JComboBox<>();
        publicarButtom = new javax.swing.JButton();
        ubicacionCombo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        descriptionLabel = new javax.swing.JLabel();
        disponibilidadCombo = new javax.swing.JComboBox<>();
        disponibilidadLabel = new javax.swing.JLabel();
        dirreccionText = new javax.swing.JTextField();
        dirrecionLabel = new javax.swing.JLabel();
        errorNames = new javax.swing.JLabel();
        errorDescripcion = new javax.swing.JLabel();
        leerButtom = new javax.swing.JButton();
        fondoCampos = new javax.swing.JLabel();
        fondoM = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(dataTable);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 800, 231));

        nombrePLabel.setText("Nombres Completos");
        jPanel2.add(nombrePLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 164, -1));

        nroCuartosLabel.setText("Numeros De Cuartos");
        jPanel2.add(nroCuartosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 120, -1));

        precioLabel.setText("Precio");
        jPanel2.add(precioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 183, -1));

        errorDirrecion.setForeground(new java.awt.Color(255, 0, 51));
        errorDirrecion.setText("Error:No puede estar vacio");
        jPanel2.add(errorDirrecion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 170, 30));

        metrosLabel.setText("Metros Cuadrados");
        jPanel2.add(metrosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 183, -1));

        errorPrecio.setForeground(new java.awt.Color(255, 0, 51));
        errorPrecio.setText("Precio Incorrecto");
        jPanel2.add(errorPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 183, -1));

        errorMetros.setForeground(new java.awt.Color(255, 0, 51));
        errorMetros.setText("Error:metros incorrectos");
        jPanel2.add(errorMetros, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 183, -1));

        namesPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namesPropiedadActionPerformed(evt);
            }
        });
        jPanel2.add(namesPropiedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 189, -1));

        descripcionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionTextActionPerformed(evt);
            }
        });
        jPanel2.add(descripcionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 183, 30));

        precioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTextActionPerformed(evt);
            }
        });
        jPanel2.add(precioText, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 183, 30));

        metrosText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metrosTextActionPerformed(evt);
            }
        });
        jPanel2.add(metrosText, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 183, -1));

        deleteTable.setText("ELIMINAR");
        deleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTableActionPerformed(evt);
            }
        });
        jPanel2.add(deleteTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        saveTable.setText("GUARDAR");
        saveTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTableActionPerformed(evt);
            }
        });
        jPanel2.add(saveTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        ModificateTable.setText("MODIFICAR");
        ModificateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificateTableActionPerformed(evt);
            }
        });
        jPanel2.add(ModificateTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, -1));

        numeroCuartosCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        numeroCuartosCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroCuartosComboActionPerformed(evt);
            }
        });
        jPanel2.add(numeroCuartosCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 120, 30));

        ubicacionLabel.setText("Ubicacion");
        jPanel2.add(ubicacionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 183, -1));

        languaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "English" }));
        languaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languajeActionPerformed(evt);
            }
        });
        jPanel2.add(languaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 480, -1, -1));

        publicarButtom.setText("PUBLICAR");
        publicarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicarButtomActionPerformed(evt);
            }
        });
        jPanel2.add(publicarButtom, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        ubicacionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aruba", "Afghanistan", "Angola", "Anguilla", "Åland Islands", "Albania", "Andorra", "United Arab Emirates", "Argentina", "Armenia", "American Samoa", "Antarctica", "French Southern Territories", "Antigua and Barbuda", "Australia", "Austria", "Azerbaijan", "Burundi", "Belgium", "Benin", "Bonaire", "Sint Eustatius and Saba", "Burkina Faso", "Bangladesh", "Bulgaria", "Bahrain", "Bahamas", "Bosnia and Herzegovina", "Saint Barthélemy", "Belarus", "Belize", "Bermuda", "Bolivia", "Plurinational State of", "Brazil", "Barbados", "Brunei Darussalam", "Bhutan", "Bouvet Island", "Botswana", "Central African Republic", "Canada", "Cocos (Keeling) Islands", "Switzerland", "Chile", "China", "Côte d'Ivoire", "Cameroon", "Congo", "The Democratic Republic of the", "Congo", "Cook Islands", "Colombia", "Comoros", "Cabo Verde", "Costa Rica", "Cuba", "Curaçao", "Christmas Island", "Cayman Islands", "Cyprus", "Czechia", "Germany", "Djibouti", "Dominica", "Denmark", "Dominican Republic", "Algeria", "Ecuador", "Egypt", "Eritrea", "Western Sahara", "Spain", "Estonia", "Ethiopia", "Finland", "Fiji", "Falkland Islands (Malvinas)", "France", "Faroe Islands", "Micronesia", "Federated States of", "Gabon", "United Kingdom", "Georgia", "Guernsey", "Ghana", "Gibraltar", "Guinea", "Guadeloupe", "Gambia", "Guinea-Bissau", "Equatorial Guinea", "Greece", "Grenada", "Greenland", "Guatemala", "French Guiana", "Guam", "Guyana", "Hong Kong", "Heard Island and McDonald Islands", "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia", "Isle of Man", "India", "British Indian Ocean Territory", "Ireland", "Iran", "Islamic Republic of", "Iraq", "Iceland", "Israel", "Italy", "Jamaica", "Jersey", "Jordan", "Japan", "Kazakhstan", "Kenya", "Kyrgyzstan", "Cambodia", "Kiribati", "Saint Kitts and Nevis", "Korea", "Republic of", "Kuwait", "Lao People's Democratic Republic", "Lebanon", "Liberia", "Libya", "Saint Lucia", "Liechtenstein", "Sri Lanka", "Lesotho", "Lithuania", "Luxembourg", "Latvia", "Macao", "Saint Martin (French part)", "Morocco", "Monaco", "Moldova", "Republic of", "Madagascar", "Maldives", "Mexico", "Marshall Islands", "North Macedonia", "Mali", "Malta", "Myanmar", "Montenegro", "Mongolia", "Northern Mariana Islands", "Mozambique", "Mauritania", "Montserrat", "Martinique", "Mauritius", "Malawi", "Malaysia", "Mayotte", "Namibia", "New Caledonia", "Niger", "Norfolk Island", "Nigeria", "Nicaragua", "Niue", "Netherlands", "Norway", "Nepal", "Nauru", "New Zealand", "Oman", "Pakistan", "Panama", "Pitcairn", "Peru", "Philippines", "Palau", "Papua New Guinea", "Poland", "Puerto Rico", "Korea", "Democratic People's Republic of", "Portugal", "Paraguay", "Palestine", "State of", "French Polynesia", "Qatar", "Réunion", "Romania", "Russian Federation", "Rwanda", "Saudi Arabia", "Sudan", "Senegal", "Singapore", "South Georgia and the South Sandwich Islands", "Saint Helena", "Ascension and Tristan da Cunha", "Svalbard and Jan Mayen", "Solomon Islands", "Sierra Leone", "El Salvador", "San Marino", "Somalia", "Saint Pierre and Miquelon", "Serbia", "South Sudan", "Sao Tome and Principe", "Suriname", "Slovakia", "Slovenia", "Sweden", "Eswatini", "Sint Maarten (Dutch part)", "Seychelles", "Syrian Arab Republic", "Turks and Caicos Islands", "Chad", "Togo", "Thailand", "Tajikistan", "Tokelau", "Turkmenistan", "Timor-Leste", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Tuvalu", "Taiwan", "Province of China", "Tanzania", "United Republic of", "Uganda", "Ukraine", "United States Minor Outlying Islands", "Uruguay", "United States", "Uzbekistan", "Holy See (Vatican City State)", "Saint Vincent and the Grenadines", "Venezuela", "Bolivarian Republic of", "Virgin Islands", "British", "Virgin Islands", "U.S.", "Viet Nam", "Vanuatu", "Wallis and Futuna", "Samoa", "Yemen", "South Africa", "Zambia", "Zimbabwe" }));
        ubicacionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubicacionComboActionPerformed(evt);
            }
        });
        jPanel2.add(ubicacionCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 90, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("BIENVENIDO AL INGRESO DE CLIENTE\n\nFLEXIHOME\n\n");
        jScrollPane3.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 280, 60));

        descriptionLabel.setText("Descripcion");
        jPanel2.add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, -1));

        disponibilidadCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Venta", "Arriendo", "Reserva" }));
        disponibilidadCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disponibilidadComboActionPerformed(evt);
            }
        });
        jPanel2.add(disponibilidadCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 30));

        disponibilidadLabel.setText("Disponibilidad");
        jPanel2.add(disponibilidadLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 80, -1));

        dirreccionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirreccionTextActionPerformed(evt);
            }
        });
        jPanel2.add(dirreccionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 183, 30));

        dirrecionLabel.setText("Dirreccion");
        jPanel2.add(dirrecionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 183, -1));

        errorNames.setForeground(new java.awt.Color(255, 0, 51));
        errorNames.setText("Error, tiene que tener un nombre y un apellido");
        jPanel2.add(errorNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 250, 30));

        errorDescripcion.setForeground(new java.awt.Color(255, 0, 51));
        errorDescripcion.setText("Error, tiene que tener un nombre y un apellido");
        jPanel2.add(errorDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 250, 30));

        leerButtom.setText("LEER");
        leerButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerButtomActionPerformed(evt);
            }
        });
        jPanel2.add(leerButtom, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        fondoCampos.setBackground(new java.awt.Color(255, 255, 255));
        fondoCampos.setOpaque(true);
        jPanel2.add(fondoCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 800, 210));
        jPanel2.add(fondoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 900, 580));

        add(jPanel2, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void namesPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namesPropiedadActionPerformed

    }//GEN-LAST:event_namesPropiedadActionPerformed

    private void descripcionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionTextActionPerformed

    private void precioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTextActionPerformed
        String precio=precioText.getText();
        if(precio.matches("^\\d+(\\.\\d{1,2})?$")){
            errorPrecio.setVisible(false);
        }else{
            errorPrecio.setText("Error: debe ser numero decimal");
            errorPrecio.setVisible(true);
        }
    }//GEN-LAST:event_precioTextActionPerformed

    private void metrosTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metrosTextActionPerformed

    }//GEN-LAST:event_metrosTextActionPerformed

    private void deleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTableActionPerformed

    }//GEN-LAST:event_deleteTableActionPerformed

    private void saveTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTableActionPerformed
     
    }//GEN-LAST:event_saveTableActionPerformed

    private void ModificateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificateTableActionPerformed

    }//GEN-LAST:event_ModificateTableActionPerformed

    private void numeroCuartosComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroCuartosComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroCuartosComboActionPerformed

    private void languajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languajeActionPerformed

    }//GEN-LAST:event_languajeActionPerformed

    private void ubicacionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicacionComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubicacionComboActionPerformed

    private void disponibilidadComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disponibilidadComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disponibilidadComboActionPerformed

    private void dirreccionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirreccionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirreccionTextActionPerformed

    private void publicarButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicarButtomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publicarButtomActionPerformed

    private void leerButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerButtomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leerButtomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ModificateTable;
    public javax.swing.JTable dataTable;
    public javax.swing.JButton deleteTable;
    public javax.swing.JTextField descripcionText;
    public javax.swing.JLabel descriptionLabel;
    public javax.swing.JTextField dirreccionText;
    public javax.swing.JLabel dirrecionLabel;
    public javax.swing.JComboBox<String> disponibilidadCombo;
    public javax.swing.JLabel disponibilidadLabel;
    public javax.swing.JLabel errorDescripcion;
    public javax.swing.JLabel errorDirrecion;
    public javax.swing.JLabel errorMetros;
    public javax.swing.JLabel errorNames;
    public javax.swing.JLabel errorPrecio;
    private javax.swing.JLabel fondoCampos;
    private javax.swing.JLabel fondoM;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> languaje;
    public javax.swing.JButton leerButtom;
    public javax.swing.JLabel metrosLabel;
    public javax.swing.JTextField metrosText;
    public javax.swing.JTextField namesPropiedad;
    public javax.swing.JLabel nombrePLabel;
    public javax.swing.JLabel nroCuartosLabel;
    public javax.swing.JComboBox<String> numeroCuartosCombo;
    public javax.swing.JLabel precioLabel;
    public javax.swing.JTextField precioText;
    public javax.swing.JButton publicarButtom;
    public javax.swing.JButton saveTable;
    public javax.swing.JComboBox<String> ubicacionCombo;
    public javax.swing.JLabel ubicacionLabel;
    // End of variables declaration//GEN-END:variables

    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }
    }
}
