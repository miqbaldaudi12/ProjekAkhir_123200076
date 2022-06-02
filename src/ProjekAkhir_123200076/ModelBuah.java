/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjekAkhir_123200076;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class ModelBuah {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/buah_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public ModelBuah() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readContact(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][5]; 
            
            String query = "SELECT * FROM buah"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("NamaBuah"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getString("TujuanDistribusi"));                
                data[jmlData][2] = String.valueOf(resultSet.getDouble("HargaPerKilo"));
                data[jmlData][3] = String.valueOf(resultSet.getDouble("BanyakDistribusi"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("TotalHarga"));
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void insertData(String NamaBuah, String TujuanDistribusi, double HargaPerKilo, double BanyakDistribusi, double TotalHarga){
        int jmlData=0;
        
        try {
           String query = "SELECT * FROM buah WHERE NamaBuah='" + NamaBuah+"'"; 
           System.out.println(NamaBuah + " " + TujuanDistribusi + " " + HargaPerKilo + " " + BanyakDistribusi);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO buah(NamaBuah,TujuanDistribusi,HargaPerKilo,BanyakDistribusi,TotalHarga) VALUES('"+NamaBuah+"','"+TujuanDistribusi+"','"+HargaPerKilo+"','"+BanyakDistribusi+"','"+TotalHarga+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String NamaBuah, String TujuanDistribusi, double HargaPerKilo, double BanyakDistribusi, double TotalHarga){
        int jmlData=0;
         try {
           String query = "SELECT * FROM buah WHERE NamaBuah='" + NamaBuah+"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE buah SET TujuanDistribusi='" + TujuanDistribusi + "', HargaPerKilo='" + HargaPerKilo + "', BanyakDistribusi='"+ BanyakDistribusi+"' WHERE NamaBuah='" + NamaBuah+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM buah";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteContact (String NamaBuah) {
        try{
            String query = "DELETE FROM buah WHERE NamaBuah = '"+NamaBuah+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
}
