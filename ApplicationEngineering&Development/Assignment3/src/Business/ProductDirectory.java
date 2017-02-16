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
public class ProductDirectory {

    private ArrayList<Product> productList;

    public ProductDirectory() {
        this.productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Product addProduct() {
        Product p = new Product();
        productList.add(p);
        return p;
    }

    public void deleteProduct(Product p) {
        productList.remove(p);
    }

    public ArrayList<Product> searchProducts(String name, String vendorName) {
        ArrayList<Product> list = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().startsWith(name) && p.getVendorName().equals(vendorName)) {
                list.add(p);
            }
        }
        return list;
    }

    public ArrayList<Product> searchProductsByCust(String name, String category) {
        ArrayList<Product> list = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().startsWith(name) && p.getCategory().equals(category)) {
                list.add(p);
            }
        }
        return list;
    }

    public ArrayList<Product> searchProductsByVendorName(String vendorName, String category) {
        ArrayList<Product> list = new ArrayList<>();
        for (Product p : productList) {
            if (p.getVendorName().equals(vendorName) && p.getCategory().equals(category)) {
                list.add(p);
            }
        }
        return list;
    }

    public ArrayList<Product> searchGeneric(String criteria, String value, String category) {
        ArrayList<Product> list = new ArrayList<>();
        for (Product p : productList) {
            switch (criteria) {
                case "Product Name":
                    if (p.getName().contains(value) && p.getCategory().equals(category)) {
                        list.add(p);
                    }   break;
                case "Product Model":
                    if (p.getModelNumber().contains(value) && p.getCategory().equals(category)) {
                        list.add(p);
                    }   break;
                case "Product Description Keyword":
                    if (p.getDescStatemnt().contains(value) && p.getCategory().equals(category)) {
                        list.add(p);
                    }   break;
                case "Product Benefit Keyword":
                    if (p.getProductBenefits().contains(value) && p.getCategory().equals(category)) {
                        list.add(p);
                    }   break;
                case "Brand Name":
                    if (p.getVendorName().contains(value) && p.getCategory().equals(category)) {
                        list.add(p);
                    }   break;
                default:
                    break;
            }

        }
        return list;
    }
}
