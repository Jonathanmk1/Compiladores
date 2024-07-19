package Proyecto_analizador_sintatico;

import Proyecto.Tabla_sintactica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;

public class sinat extends javax.swing.JFrame {

    public sinat() {
        initComponents();
        InitStyles();
        SetDate();
    }

    private void InitStyles() {
        mensaje.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        mensaje.setForeground(Color.BLACK);
        navText.putClientProperty("FlatLaf.style", "font: bold $h3.regular.font");
        navText.setForeground(Color.white);
        etqDay.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        etqDay.setForeground(Color.white);
        appName.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        appName.setForeground(Color.white);
    }

    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        etqDay.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }

    public static void ShowJPanel(JPanel p) {
        p.setSize(750, 430);
        p.setLocation(0, 0);

        panelmuestra.removeAll();
        panelmuestra.add(p, BorderLayout.CENTER);
        panelmuestra.revalidate();
        panelmuestra.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        appName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TABLA_SINTA = new javax.swing.JButton();
        btn_incad = new javax.swing.JButton();
        btn_token = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        etqDay = new javax.swing.JLabel();
        panelmuestra = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1050, 660));

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(13, 71, 161));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));

        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setText("COMPILADORES");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        TABLA_SINTA.setBackground(new java.awt.Color(21, 101, 192));
        TABLA_SINTA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TABLA_SINTA.setForeground(new java.awt.Color(255, 255, 255));
        TABLA_SINTA.setText("TABLA SINTACTICA");
        TABLA_SINTA.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        TABLA_SINTA.setBorderPainted(false);
        TABLA_SINTA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TABLA_SINTA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TABLA_SINTA.setIconTextGap(13);
        TABLA_SINTA.setInheritsPopupMenu(true);
        TABLA_SINTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TABLA_SINTAActionPerformed(evt);
            }
        });

        btn_incad.setBackground(new java.awt.Color(21, 101, 192));
        btn_incad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_incad.setForeground(new java.awt.Color(255, 255, 255));
        btn_incad.setText("Input CADENA");
        btn_incad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_incad.setBorderPainted(false);
        btn_incad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_incad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_incad.setIconTextGap(13);
        btn_incad.setInheritsPopupMenu(true);
        btn_incad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_incadActionPerformed(evt);
            }
        });

        btn_token.setBackground(new java.awt.Color(21, 101, 192));
        btn_token.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_token.setForeground(new java.awt.Color(255, 255, 255));
        btn_token.setText("TABLA_TOKEN");
        btn_token.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_token.setBorderPainted(false);
        btn_token.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_token.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_token.setIconTextGap(13);
        btn_token.setInheritsPopupMenu(true);
        btn_token.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tokenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_incad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_token, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(TABLA_SINTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(TABLA_SINTA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_incad, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btn_token, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        header.setBackground(new java.awt.Color(25, 118, 210));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        etqDay.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        etqDay.setForeground(new java.awt.Color(255, 255, 255));
        etqDay.setText("HOY ES {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(etqDay, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqDay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        panelmuestra.setBackground(new java.awt.Color(255, 255, 255));
        panelmuestra.setLayout(new java.awt.BorderLayout());

        mensaje.setBackground(new java.awt.Color(25, 118, 210));
        mensaje.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(panelmuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelmuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TABLA_SINTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TABLA_SINTAActionPerformed
        ShowJPanel(new Tabla_sintactica());
    }//GEN-LAST:event_TABLA_SINTAActionPerformed

    private void btn_incadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_incadActionPerformed
        ShowJPanel(new Proceso());
    }//GEN-LAST:event_btn_incadActionPerformed

    private void btn_tokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tokenActionPerformed
        ShowJPanel(new p_token());
    }//GEN-LAST:event_btn_tokenActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sinat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sinat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sinat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sinat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sinat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TABLA_SINTA;
    private javax.swing.JLabel appName;
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_incad;
    private javax.swing.JButton btn_token;
    private javax.swing.JLabel etqDay;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel navText;
    private static javax.swing.JPanel panelmuestra;
    // End of variables declaration//GEN-END:variables
}
