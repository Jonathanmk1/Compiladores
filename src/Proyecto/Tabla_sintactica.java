package Proyecto;
import Proyecto_analizador_sintatico.sinat;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class Tabla_sintactica extends JPanel {

    private JButton boton; 

    public Tabla_sintactica() {
        initComponents();
        tabla();
        initializeBackButton();
    }

    private void tabla() {
        JTable modelo = new JTable();
        DefaultTableModel sintatica = new DefaultTableModel(
            new Object[]{" ", "class", "{", "}", ";", "a", "b", "c", "int", "string", "$", "P", "C", "M", "V", "I", "T"}, 0
        );
        modelo.setModel(sintatica);
        JScrollPane tampanel = new JScrollPane(modelo);
        tampanel.setPreferredSize(new Dimension(750, 300));

        sintatica.addRow(new Object[]{0, "d3", "", "", "", "", "", "", "", "", "", "1", "2", "", "", "", ""});
        sintatica.addRow(new Object[]{1, "", "", "", "", "", "", "", "", "", "Acepta", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{2, "", "", "", "", "", "", "", "", "", "R1", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{3, "", "", "", "", "d6", "d7", "d8", "", "", "", "", "", "4", "", "5", ""});
        sintatica.addRow(new Object[]{4, "", "", "", "", "", "", "", "", "", "R2", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{5, "", "d9", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{6, "", "R6", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{7, "", "R7", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{8, "", "R8", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{9, "", "", "", "", "", "", "", "d12", "d13", "", "", "", "", "10", "", "11"});
        sintatica.addRow(new Object[]{10, "", "", "d14", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{11, "", "", "", "", "d16", "d17", "d18", "", "", "", "", "", "", "", "15", ""});
        sintatica.addRow(new Object[]{12, "", "", "", "", "R9", "R9", "R9", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{13, "", "", "", "", "R10", "R10", "R10", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{14, "", "", "", "", "", "", "", "", "", "R3", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{15, "", "", "", "d19", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{16, "", "", "", "R6", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{17, "", "", "", "R7", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{18, "", "", "", "R8", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{19, "", "", "R5", "", "", "", "", "", "", "", "", "", "", "", "", ""});
        sintatica.addRow(new Object[]{20, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""});

        this.setLayout(new java.awt.BorderLayout());
        this.add(tampanel, java.awt.BorderLayout.CENTER);
    }

    private void initializeBackButton() {
        boton = new JButton("Regresar");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarAlFramePrincipal();
            }
        });
        
        this.add(boton, java.awt.BorderLayout.SOUTH);
    }

    private void regresarAlFramePrincipal() {
        javax.swing.JFrame sinta = new sinat();
        sinta.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setPreferredSize(new java.awt.Dimension(750, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>

}
