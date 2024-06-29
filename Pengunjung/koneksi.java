package Pengunjung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Komang Agus Anjas Putra
 * NIM     : 2201010760
 * Tanggal : 26 Juni 2024
 */
public class koneksi {
    public static Connection CONNECTION(){
        Connection cnn = null;
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pengunjung","root","");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Koneksi ke DBMS MySQL gagal Total ayok coba lagi");
        }
        return cnn;
    }
}
