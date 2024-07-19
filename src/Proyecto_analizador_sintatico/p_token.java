package Proyecto_analizador_sintatico;

import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

public class p_token extends javax.swing.JPanel {

    public p_token() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtextarea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnpros = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(580, 682));
        setMinimumSize(new java.awt.Dimension(580, 682));
        setPreferredSize(new java.awt.Dimension(580, 682));

        jLabel1.setText("INGRESE LA CADENA:");

        jtextarea.setColumns(20);
        jtextarea.setRows(5);
        jScrollPane1.setViewportView(jtextarea);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "token", "lexema", "linea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btnpros.setText("PROCESA");
        btnpros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnpros, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpros, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 261, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnprosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprosActionPerformed
        String texto = jtextarea.getText();
        ArrayList<Token> tokens = Pruebas.lex(texto);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Token token : tokens) {
            Object[] rowData = new Object[4];
            rowData[0] = token.getId();
            rowData[1] = token.getTipo();
            rowData[2] = token.getValor();
            int offset = jtextarea.getText().indexOf(token.getValor());
            int linea = 1;
            try {
                linea = jtextarea.getLineOfOffset(offset) + 1;
            } catch (BadLocationException ex) {
                Logger.getLogger(Compilador1.class.getName()).log(Level.SEVERE, null, ex);
            }
            rowData[3] = linea;
            model.addRow(rowData);
        }
    }//GEN-LAST:event_btnprosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnpros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jtextarea;
    // End of variables declaration//GEN-END:variables
}
