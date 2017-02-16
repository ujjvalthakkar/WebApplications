/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Ujjval
 */
public class VendorDirectory {

    private ArrayList<Vendor> vendorList;

    public VendorDirectory() {
        vendorList = new ArrayList<>();
    }

    public ArrayList<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(ArrayList<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    public Vendor addVendor() {
        Vendor v = new Vendor();
        vendorList.add(v);
        return v;
    }

    public void deleteVendor(Vendor v) {
        vendorList.remove(v);
    }
    
    public Vendor searchVendor(String vendorName) {
         for (Vendor v : vendorList) {
            if (v.getName().equals(vendorName)) {
                return v;
            }
        }
        return null;
    }

}
