/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjekAkhir_123200076;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ViewBuah view = new ViewBuah();
        ModelBuah model = new ModelBuah();
        ControllerBuah controller = new ControllerBuah(model, view);
        
    }
    
}
