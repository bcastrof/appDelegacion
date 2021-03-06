/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modeloBBDD.CochesBBDD;
import modeloBBDD.ConducenBBDD;
import modeloVentanas.Coches;
import modeloVentanas.Conducen;

/**
 *
 * @author BCASTROF
 */
public class vPruebas extends javax.swing.JFrame {

    private final modeloBBDD.CochesBBDD cochesBBDD = new CochesBBDD();
    private List<Coches> ch = cochesBBDD.listarCoches();
    private String matricula;
    private DefaultTableModel jModel;
    ConducenBBDD conducenBBDD = new ConducenBBDD();

    /**
     * Creates new form vPruebas
     */
    public vPruebas() {
        initComponents();
       
        lalal();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        java.util.Date date3 = new java.util.Date();
        sm3 =
        new SpinnerDateModel(date3, null, null, Calendar.HOUR_OF_DAY);
        jsfin = new javax.swing.JSpinner(sm3);
        java.util.Date date = new java.util.Date();
        sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jsinicio = new javax.swing.JSpinner(sm);
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "lo coge", "que coche", "fecha", "hora salida", "hora llegada", "motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("AÑADIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de3 = new JSpinner.DateEditor(jsfin, "HH:mm");
        jsfin.setEditor(de3);

        JSpinner.DateEditor de = new JSpinner.DateEditor(jsinicio, "HH:mm");
        jsinicio.setEditor(de);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jsinicio)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jsfin)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jsinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jsfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked

    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        DateFormat horaFormat = new SimpleDateFormat("HH:mm");

        int index = jComboBox1.getSelectedIndex();
        coche = ch.get(index);
        String fecha = dateFormat.format(jDateChooser1.getDate());
        String horaRecogida = dateFormat.format(jDateChooser1.getDate()).concat(" ").concat(horaFormat.format(sm.getDate()).concat(":00"));
        String horaEntrega = dateFormat.format(jDateChooser1.getDate()).concat(" ").concat(horaFormat.format(sm3.getDate()).concat(":00"));
        String motivo = jTextField1.getText();
        reserva = new Conducen(fecha, horaRecogida, horaEntrega, motivo);
        //          System.out.println(accesoUsuario.getUserWin()+" "+coche.getMatricula()+" "+fecha + " " + horaRecogida + " " + horaEntrega+" "+motivo);
        if (conducenBBDD.insertarReserva(accesoUsuario, coche, reserva) == true) {
            System.out.println(accesoUsuario.getUserWin() + " " + coche.getMatricula() + " " + fecha + " " + horaRecogida + " " + horaEntrega + " " + motivo);
            limpiarReservas();
        } else {
            System.out.println("caca");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void añadirEsccuhaDataChoser() {
        jDateChooser1.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    listarviajes1();
                }
            }
        });
        this.add(jDateChooser1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vPruebas().setVisible(true);
            }
        });
    }

    public void listarviajes() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        jModel = (DefaultTableModel) jTable1.getModel();
        List<Conducen> co = conducenBBDD.listarReservas(dateFormat.format(jDateChooser1.getDate()));
        if (jTable1.getRowCount() == 0) {

            for (int i = 0; i < co.size(); i++) {

                jModel.insertRow(jModel.getRowCount(), new Object[]{
                    co.get(i).getUsuario(), co.get(i).getCoche(), co.get(i).getFechaRecogida(), co.get(i).getMotivo()
                });

            }
        } else {
            jModel.setRowCount(0);
            for (int i = 0; i < co.size(); i++) {

                jModel.insertRow(jModel.getRowCount(), new Object[]{
                    co.get(i).getUsuario(), co.get(i).getCoche(), co.get(i).getFechaRecogida(), co.get(i).getMotivo()
                });

            }
        }

    }

    public void listarviajes1() {
        jModel = (DefaultTableModel) jTable1.getModel();
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        List<Conducen> co = conducenBBDD.listarReservas1();
        if (jTable1.getRowCount() == 0) {

            int i = 0;
            do {
                if (co.get(i).getFechaRecogida().equals(fecha())) {
                    jModel.insertRow(jModel.getRowCount(), new Object[]{
                        co.get(i).getUsuario(), co.get(i).getCoche(), co.get(i).getFechaRecogida(), co.get(i).getHoraRecogida().substring(11, 16),co.get(i).getHoraEntrega().substring(11, 16),co.get(i).getMotivo()
                    });
                }
                i++;
            } while (i < co.size());

        } else {
            jModel.setRowCount(0);
            int i = 0;
            do {
                if (co.get(i).getFechaRecogida().equals(fecha())) {
                    jModel.insertRow(jModel.getRowCount(), new Object[]{
                        co.get(i).getUsuario(), co.get(i).getCoche(), co.get(i).getFechaRecogida(), co.get(i).getHoraRecogida().substring(11, 16),co.get(i).getHoraEntrega().substring(11, 16),co.get(i).getMotivo()
                    });
                }
                i++;
            } while (i < co.size());
        }
       for(int j= 0; j<6; j++){
         
           jTable1.getColumnModel().getColumn(j).setCellRenderer(Alinear);  
       }
        
    }

    public String fecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(jDateChooser1.getDate());
        return date;
    }
 public  void lalal(){
       String prueba = "2017-11-14 17:00:00.000000";
       
        String substring = prueba.substring(11, 16);
       
       System.out.println(substring);
 }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner jsfin;
    private javax.swing.JSpinner jsinicio;
    // End of variables declaration//GEN-END:variables
}
