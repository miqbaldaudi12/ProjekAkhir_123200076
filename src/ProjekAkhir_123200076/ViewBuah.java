/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjekAkhir_123200076;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class ViewBuah extends JFrame {
    JLabel lNamaBuah = new JLabel("Nama Buah");
    JLabel lTujuanDistribusi = new JLabel("Tujuan Distribusi");
    JLabel lHargaPerKilo = new JLabel("Harga per kilogram");
    JLabel lBanyakDistribusi = new JLabel("Berat Buah (kilogram)");
    
    public JTextField tfNamaBuah = new JTextField();
    public JTextField tfTujuanDistribusi = new JTextField();
    public JTextField tfHargaPerKilo = new JTextField();
    public JTextField tfBanyakDistribusi = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Hapus");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nama Buah ","Tujuan Distribusi ","Harga per Kilogram ","Berat Total(Kilogram) ","Total Harga "};
    
    public ViewBuah() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle ("Data Distribusi Buah");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(750,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lNamaBuah);
        lNamaBuah.setBounds(510, 20, 140, 20);
        add(tfNamaBuah);
        tfNamaBuah.setBounds(510, 40, 170, 20);
        
        add(lTujuanDistribusi);
        lTujuanDistribusi.setBounds(510, 60, 140, 20);
        add(tfTujuanDistribusi);
        tfTujuanDistribusi.setBounds(510, 80, 170, 20);
        
        add(lHargaPerKilo);
        lHargaPerKilo.setBounds(510, 100, 140, 20);
        add(tfHargaPerKilo);
        tfHargaPerKilo.setBounds(510, 120, 170, 20);
        
        add(lBanyakDistribusi);
        lBanyakDistribusi.setBounds(510, 140, 140, 20);
        add(tfBanyakDistribusi);
        tfBanyakDistribusi.setBounds(510, 160, 170, 20);
        
        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
    }
    
    public String getNamaBuah(){
        return tfNamaBuah.getText();
    }
    
    public String getTujuanDistribusi(){
        return tfTujuanDistribusi.getText();
    }
    
    public String getHargaPerKilo(){
        return tfHargaPerKilo.getText();
    }
    
    public String getBanyakDistribusi(){
        return tfBanyakDistribusi.getText();
    }
}