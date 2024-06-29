package Pengunjung;

import java.sql.SQLException;

/**
 *
 * @author Komang Agus Anjas Putra
 * NIM     : 2201010760
 * Tanggal : 26 Juni 2024
 */
public class Pengunjung {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        FormPengunjung jf = new FormPengunjung();
        jf.setResizable(false);
        jf.setAlwaysOnTop(true);
        jf.setVisible(true);
    }
    
}
