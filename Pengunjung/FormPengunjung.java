package Pengunjung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Pengunjung.koneksi.CONNECTION;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Komang Agus Anjas Putra
 * NIM     : 2201010760
 * Tanggal : 26 Juni 2024
 */
public class FormPengunjung extends javax.swing.JFrame {
    DefaultTableModel PG = new DefaultTableModel();

    /**
     * Creates new form jForm1
     * @throws java.sql.SQLException
     */
    public FormPengunjung() throws SQLException {
        initComponents();
        jTable2.setModel(PG);
        PG.addColumn("id");
        PG.addColumn("nama_pengunjung");
        PG.addColumn("alamat");
        PG.addColumn("tujuan");
        PG.addColumn("email");
        PG.addColumn("no_hp");
        
        List_All();
        EMPTY();
    }
    
    private void List_All() throws SQLException{
        PG.getDataVector().removeAllElements();
        PG.fireTableDataChanged();
        
        Connection cnn = CONNECTION();
        if( !cnn.isClosed() ){
            
            String sql = "SELECT * FROM tb_pengunjung;";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            while( rs.next() ){
                Object[] data = new Object[6];
                data[0] = rs.getInt("id");
                data[1] = rs.getString("nama_pengunjung");
                data[2] = rs.getString("alamat");
                data[3] = rs.getString("tujuan");
                data[4] = rs.getString("email");
                data[5] = rs.getString("no_hp");
                
                PG.addRow(data);
            }
        }
        
    }
    
    private void StoreData() throws SQLException{
        Connection cnn = CONNECTION();
        String NM = NAMAPENGUNJUNG.getText();
        String AL = ALAMAT.getText();
        String TJ = TUJUAN.getText();
        String TL = EMAIL.getText();
        String HP = NOHP.getText();
        
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("INSERT INTO tb_pengunjung(nama_pengunjung,alamat,tujuan,email,no_hp) VALUES(?,?,?,?,?);");
            PS.setString(1, NM);
            PS.setString(2, AL);
            PS.setString(3, TJ);
            PS.setString(4, TL);
            PS.setString(5, HP);
            PS.executeUpdate();
        }
    }
    private void UpdateData() throws SQLException{
        Connection cnn = CONNECTION();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("UPDATE tb_pengunjung SET nama_pengunjung=?, alamat=?, tujuan=?, email=?, no_hp=? WHERE id=?;");
            PS.setString(1, NAMAPENGUNJUNG.getText() );
            PS.setString(2, ALAMAT.getText() );
            PS.setString(3, TUJUAN.getText() );
            PS.setString(4, EMAIL.getText() );
            PS.setString(5, NOHP.getText() );
            PS.setString(6, ID.getText() );
            PS.executeUpdate();
            cnn.close();
        }
    }
    private void DestroyData() throws SQLException{
        Connection cnn = CONNECTION();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("DELETE FROM tb_pengunjung WHERE id=?;");
            PS.setString(1, ID.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
    private void EMPTY(){
        ID.setText("");
        NAMAPENGUNJUNG.setText("");
        ALAMAT.setText("");
        TUJUAN.setText("");
        EMAIL.setText("");
        NOHP.setText("");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NAMAPENGUNJUNG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ALAMAT = new javax.swing.JTextField();
        TUJUAN = new javax.swing.JTextField();
        NOHP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        BTNTUTUP = new javax.swing.JButton();
        BTNTAMBAH = new javax.swing.JButton();
        BTNEDIT = new javax.swing.JButton();
        BTNHAPUS = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        EMAIL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PENCATATAN PENGUNJUNG");

        jLabel2.setText("Nama Pengunjung");

        NAMAPENGUNJUNG.setText("jTextField1");

        jLabel3.setText("Alamat");

        jLabel4.setText("Tujuan");

        jLabel5.setText("No HP");

        ALAMAT.setText("jTextField2");

        TUJUAN.setText("jTextField3");

        NOHP.setText("jTextField4");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        BTNTUTUP.setBackground(new java.awt.Color(153, 153, 153));
        BTNTUTUP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNTUTUP.setForeground(new java.awt.Color(255, 255, 255));
        BTNTUTUP.setText("TUTUP");
        BTNTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNTUTUPActionPerformed(evt);
            }
        });

        BTNTAMBAH.setBackground(new java.awt.Color(0, 102, 204));
        BTNTAMBAH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNTAMBAH.setForeground(new java.awt.Color(255, 255, 255));
        BTNTAMBAH.setText("TAMBAH");
        BTNTAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNTAMBAHActionPerformed(evt);
            }
        });

        BTNEDIT.setBackground(new java.awt.Color(255, 204, 0));
        BTNEDIT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNEDIT.setForeground(new java.awt.Color(255, 255, 255));
        BTNEDIT.setText("EDIT");
        BTNEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEDITActionPerformed(evt);
            }
        });

        BTNHAPUS.setBackground(new java.awt.Color(204, 51, 0));
        BTNHAPUS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNHAPUS.setForeground(new java.awt.Color(255, 255, 255));
        BTNHAPUS.setText("HAPUS");
        BTNHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHAPUSActionPerformed(evt);
            }
        });

        jLabel6.setText("Email");

        EMAIL.setText("jTextField5");

        jLabel7.setText("ID Pengunjung");

        ID.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NOHP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(TUJUAN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ALAMAT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NAMAPENGUNJUNG, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EMAIL)
                            .addComponent(ID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BTNHAPUS, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(BTNTUTUP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(BTNEDIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNTAMBAH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NAMAPENGUNJUNG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TUJUAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(NOHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNTAMBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTNTUTUP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void BTNTAMBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNTAMBAHActionPerformed
        if(BTNTAMBAH.getText().equals("TAMBAH")){
            BTNTAMBAH.setText("SIMPAN");
            BTNTUTUP.setText("BATAL");
            EMPTY();
            jTable2.setEnabled(false);
        }else{
            BTNTAMBAH.setText("TAMBAH");
            BTNTUTUP.setText("TUTUP");
            jTable2.setEnabled(true);
            try {
                StoreData();
                List_All();
            } catch (SQLException ex) {
                Logger.getLogger(FormPengunjung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BTNTAMBAHActionPerformed

    private void BTNTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNTUTUPActionPerformed
        if(BTNTUTUP.getText().equals("TUTUP")){
            dispose();
        }else{
            BTNTUTUP.setText("TUTUP");
            BTNTAMBAH.setText("TAMBAH");
        }
    }//GEN-LAST:event_BTNTUTUPActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        ID.setText( jTable2.getValueAt( jTable2.getSelectedRow(),0 ).toString() );
        NAMAPENGUNJUNG.setText( jTable2.getValueAt( jTable2.getSelectedRow(), 1).toString() );
        ALAMAT.setText( jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString() );
        TUJUAN.setText( jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString() );
        EMAIL.setText( jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString() );
        NOHP.setText( jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString() );
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void BTNEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEDITActionPerformed
        try {
            UpdateData();
            List_All();
            JOptionPane.showMessageDialog(this,"Data Telah di Edit");
        } catch (SQLException ex) {
            Logger.getLogger(FormPengunjung.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BTNEDITActionPerformed

    private void BTNHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHAPUSActionPerformed
        try {
            int jwb = JOptionPane.showOptionDialog(
                    this, 
                    "Yakin akan menghapus data "+NAMAPENGUNJUNG.getText()+"?", 
                    "Hapus Data", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, 
                    null, 
                    null, 
                    null);
            if(jwb == JOptionPane.YES_OPTION){
                DestroyData();
                List_All();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPengunjung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTNHAPUSActionPerformed

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
            java.util.logging.Logger.getLogger(FormPengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPengunjung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormPengunjung().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormPengunjung.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ALAMAT;
    private javax.swing.JButton BTNEDIT;
    private javax.swing.JButton BTNHAPUS;
    private javax.swing.JButton BTNTAMBAH;
    private javax.swing.JButton BTNTUTUP;
    private javax.swing.JTextField EMAIL;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField NAMAPENGUNJUNG;
    private javax.swing.JTextField NOHP;
    private javax.swing.JTextField TUJUAN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
