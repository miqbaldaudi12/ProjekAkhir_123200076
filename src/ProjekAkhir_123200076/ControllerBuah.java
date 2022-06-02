/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjekAkhir_123200076;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author Lenovo
 */
public class ControllerBuah {
    ModelBuah modelContact;
    ViewBuah ViewBuah;
    public String data;
    public ControllerBuah(ModelBuah modelContact, ViewBuah ViewBuah){
        this.modelContact = modelContact;
        this.ViewBuah = ViewBuah;
        
        if (modelContact.getBanyakData()!=0) {
            String dataMovie[][] = modelContact.readContact();
            ViewBuah.tabel.setModel((new JTable(dataMovie, ViewBuah.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         ViewBuah.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String NamaBuah = ViewBuah.getNamaBuah();
                String TujuanDistribusi = ViewBuah.getTujuanDistribusi();
                double HargaPerKilo = Double.parseDouble(ViewBuah.getHargaPerKilo());
                double BanyakDistribusi = Double.parseDouble(ViewBuah.getBanyakDistribusi());
                double TotalHarga = HargaPerKilo*BanyakDistribusi;
                modelContact.insertData(NamaBuah, TujuanDistribusi, HargaPerKilo, BanyakDistribusi, TotalHarga);
         
                String dataMovie[][] = modelContact.readContact();
                ViewBuah.tabel.setModel((new JTable(dataMovie, ViewBuah.namaKolom)).getModel());
            }
        });
         
          ViewBuah.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String NamaBuah = ViewBuah.getNamaBuah();
                String TujuanDistribusi = ViewBuah.getTujuanDistribusi();
                double HargaPerKilo = Double.parseDouble(ViewBuah.getHargaPerKilo());
                double BanyakDistribusi = Double.parseDouble(ViewBuah.getBanyakDistribusi());
                double TotalHarga = HargaPerKilo*BanyakDistribusi/3;
                modelContact.updateData(NamaBuah, TujuanDistribusi, HargaPerKilo, BanyakDistribusi, TotalHarga);

                String dataMovie[][] = modelContact.readContact();
                ViewBuah.tabel.setModel((new JTable(dataMovie, ViewBuah.namaKolom)).getModel());
            }
        });
         
          ViewBuah.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                ViewBuah.tfNamaBuah.setText("");
                ViewBuah.tfTujuanDistribusi.setText("");
                ViewBuah.tfHargaPerKilo.setText("");
                ViewBuah.tfBanyakDistribusi.setText("");
            }
        });
        
    
          ViewBuah.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = ViewBuah.tabel.getSelectedRow();
                data = ViewBuah.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = ViewBuah.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = ViewBuah.tabel.getValueAt(baris, 1).toString();
                
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          ViewBuah.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus Data Distribusi " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelContact.deleteContact(data);
                String dataMovie[][] = modelContact.readContact();
                ViewBuah.tabel.setModel((new JTable(dataMovie, ViewBuah.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }

}
