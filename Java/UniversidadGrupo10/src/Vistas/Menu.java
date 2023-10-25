/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author ejarq
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icono=new ImageIcon(getClass().getResource("../Recursos/logo_ULP.jpg"));
        Image miImagen=icono.getImage();
        jdEscritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(miImagen,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenu = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jmiFormulario = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jmiForMat = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jmiInscripcion = new javax.swing.JMenuItem();
        jmiNotas = new javax.swing.JMenuItem();
        jmConsulta = new javax.swing.JMenu();
        jmiAlumPorMat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdEscritorioLayout = new javax.swing.GroupLayout(jdEscritorio);
        jdEscritorio.setLayout(jdEscritorioLayout);
        jdEscritorioLayout.setHorizontalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        jdEscritorioLayout.setVerticalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");
        jmAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlumnoActionPerformed(evt);
            }
        });

        jmiFormulario.setText("Formulario");
        jmiFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFormularioActionPerformed(evt);
            }
        });
        jmAlumno.add(jmiFormulario);

        jMenu.add(jmAlumno);

        jmMateria.setText("Materia");

        jmiForMat.setText("Formulario");
        jmiForMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiForMatActionPerformed(evt);
            }
        });
        jmMateria.add(jmiForMat);

        jMenu.add(jmMateria);

        jmAdministracion.setText("Administracion");

        jmiInscripcion.setText("Inscripciones");
        jmiInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInscripcionActionPerformed(evt);
            }
        });
        jmAdministracion.add(jmiInscripcion);

        jmiNotas.setText("Notas");
        jmiNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNotasActionPerformed(evt);
            }
        });
        jmAdministracion.add(jmiNotas);

        jMenu.add(jmAdministracion);

        jmConsulta.setText("Consulta");

        jmiAlumPorMat.setText("Alumno por Materia");
        jmiAlumPorMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlumPorMatActionPerformed(evt);
            }
        });
        jmConsulta.add(jmiAlumPorMat);

        jMenu.add(jmConsulta);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlumnoActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jmAlumnoActionPerformed

    private void jmiForMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiForMatActionPerformed
        // TODO add your handling code here:
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        FormularioMateria formMat=new FormularioMateria();
        formMat.setVisible(true);
        jdEscritorio.add(formMat);       
        jdEscritorio.moveToFront(formMat);
    }//GEN-LAST:event_jmiForMatActionPerformed

    private void jmiInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInscripcionActionPerformed
        // TODO add your handling code here:
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        Inscripciones Ins=new Inscripciones();
        Ins.setVisible(true);
        jdEscritorio.add(Ins);
        jdEscritorio.moveToFront(Ins);
    }//GEN-LAST:event_jmiInscripcionActionPerformed

    private void jmiNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNotasActionPerformed
        // TODO add your handling code here:
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ActualizarNotas acNot=new ActualizarNotas();
        acNot.setVisible(true);
        jdEscritorio.add(acNot);
        jdEscritorio.moveToFront(acNot);
    }//GEN-LAST:event_jmiNotasActionPerformed

    private void jmiAlumPorMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlumPorMatActionPerformed
        // TODO add your handling code here:
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ConsultaXMateria conXMat=new ConsultaXMateria();
        conXMat.setVisible(true);
        jdEscritorio.add(conXMat);
        jdEscritorio.moveToFront(conXMat);
    }//GEN-LAST:event_jmiAlumPorMatActionPerformed

    private void jmiFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFormularioActionPerformed
        // TODO add your handling code here:
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        FormularioAlumno forAlum=new FormularioAlumno();
        forAlum.setVisible(true);
        jdEscritorio.add(forAlum);       
        jdEscritorio.moveToFront(forAlum);   
    }//GEN-LAST:event_jmiFormularioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        UIManager.put("nimbusBase", new Color(44, 62, 80 ));
        UIManager.put("nimbusBlueGrey", new Color(93, 109, 126));        

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JDesktopPane jdEscritorio;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenu jmConsulta;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenuItem jmiAlumPorMat;
    private javax.swing.JMenuItem jmiForMat;
    private javax.swing.JMenuItem jmiFormulario;
    private javax.swing.JMenuItem jmiInscripcion;
    private javax.swing.JMenuItem jmiNotas;
    // End of variables declaration//GEN-END:variables
}
