/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Ujjval
 */
public class Vendor {
    
    private String name;
    private String id;
    ProductDirectory prodList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDirectory getProdList() {
        return prodList;
    }

    public void setProdList(ProductDirectory prodList) {
        this.prodList = prodList;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
}
