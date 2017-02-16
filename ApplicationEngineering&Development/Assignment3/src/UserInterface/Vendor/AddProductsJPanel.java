/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Vendor;

import Business.Product;
import Business.ProductDirectory;
import Business.Vendor;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ujjval
 */
public class AddProductsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddProductsJPanel
     */
    private ProductDirectory prodList;
    private Vendor vendor;
    private JPanel userProcessContainer;

    public AddProductsJPanel(JPanel userProcessContainer, Vendor vendor, ProductDirectory prodList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.vendor = vendor;
        this.prodList = prodList;
        lblVendorNameReplace.setText(vendor.getName());
    }

    public boolean mandValidations() {
        boolean mandStatus = true;
        if (txtProdName.getText().isEmpty() || txtProdBasePrice.getText().isEmpty() || txtProdCeildPrice.getText().isEmpty()) {
            mandStatus = false;
        }
        if (txtProdDescStatement.getText().isEmpty() || txtProdFloorPrice.getText().isEmpty() || txtProdModelNumb.getText().isEmpty()) {
            mandStatus = false;
        }
        if (dropDownCategory.getSelectedIndex() == 0) {
            mandStatus = false;
        }
        return mandStatus;
    }

    public void clearFields() {
        txtProdName.setText("");
        txtProdModelNumb.setText("");
        txtProdBasePrice.setText("");
        txtProdCeildPrice.setText("");
        txtProdFloorPrice.setText("");
        txtProdDescStatement.setText("");
        dropDownCategory.setSelectedIndex(0);
        txtProdBenefits.setText("");
        txtProdFeatures.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        lblProdName = new javax.swing.JLabel();
        lblProdModelNumb = new javax.swing.JLabel();
        lblProdVendorName = new javax.swing.JLabel();
        lblProdDescStmnt = new javax.swing.JLabel();
        lblProdBasePrice = new javax.swing.JLabel();
        lblProdFloorPrice = new javax.swing.JLabel();
        lblProdCeilPrice = new javax.swing.JLabel();
        lblProdFeatures = new javax.swing.JLabel();
        lblProdBenefits = new javax.swing.JLabel();
        lblProdCategory = new javax.swing.JLabel();
        lblVendorNameReplace = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        txtProdBasePrice = new javax.swing.JTextField();
        txtProdModelNumb = new javax.swing.JTextField();
        txtProdCeildPrice = new javax.swing.JTextField();
        txtProdFloorPrice = new javax.swing.JTextField();
        dropDownCategory = new javax.swing.JComboBox<>();
        btnAddProduct = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProdFeatures = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProdBenefits = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtProdDescStatement = new javax.swing.JTextArea();
        lblMandFields = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblHeader.setText("Add Product");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 11, -1, -1));

        lblProdName.setText("Product Name:*");
        add(lblProdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 62, -1, -1));

        lblProdModelNumb.setText("Model Number:*");
        add(lblProdModelNumb, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 100, -1, -1));

        lblProdVendorName.setText("Vendor Name:");
        add(lblProdVendorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 146, -1, -1));

        lblProdDescStmnt.setText("Description Statement:*");
        add(lblProdDescStmnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 306, -1, -1));

        lblProdBasePrice.setText("Base Price:*");
        add(lblProdBasePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 178, -1, -1));

        lblProdFloorPrice.setText("Floor Price:*");
        add(lblProdFloorPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 255, -1, -1));

        lblProdCeilPrice.setText("Ceiling Price:*");
        add(lblProdCeilPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 218, -1, -1));

        lblProdFeatures.setText("Features:");
        add(lblProdFeatures, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 59, -1, -1));

        lblProdBenefits.setText("Benefits:");
        add(lblProdBenefits, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 146, -1, -1));

        lblProdCategory.setText("Category:*");
        add(lblProdCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 373, -1, -1));

        lblVendorNameReplace.setText("<<Vendor Name will be replaced Here>>");
        add(lblVendorNameReplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 146, -1, -1));
        add(txtProdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 59, 121, -1));

        txtProdBasePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProdBasePriceKeyTyped(evt);
            }
        });
        add(txtProdBasePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 178, 121, -1));
        add(txtProdModelNumb, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 97, 121, -1));

        txtProdCeildPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProdCeildPriceKeyTyped(evt);
            }
        });
        add(txtProdCeildPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 216, 121, -1));

        txtProdFloorPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProdFloorPriceKeyTyped(evt);
            }
        });
        add(txtProdFloorPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 254, 121, -1));

        dropDownCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SelectCategory", "Computer", "Printer", "Hardware Part", "Software" }));
        add(dropDownCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 370, -1, -1));

        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        txtProdFeatures.setColumns(20);
        txtProdFeatures.setRows(5);
        jScrollPane1.setViewportView(txtProdFeatures);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 59, 205, 69));

        txtProdBenefits.setColumns(20);
        txtProdBenefits.setRows(5);
        jScrollPane2.setViewportView(txtProdBenefits);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 146, 205, 69));

        txtProdDescStatement.setColumns(20);
        txtProdDescStatement.setRows(5);
        jScrollPane3.setViewportView(txtProdDescStatement);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 290, 205, 69));

        lblMandFields.setText("Fields marked (*) are mandatory");
        add(lblMandFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 34, -1, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        boolean check = mandValidations();
        if (check == true) {
            Product p = prodList.addProduct();
            p.setName(txtProdName.getText());
            p.setModelNumber(txtProdModelNumb.getText());
            p.setVendorName(vendor.getName());
            p.setBasePrice(txtProdBasePrice.getText());
            p.setCeilingPrice(txtProdCeildPrice.getText());
            p.setFloorPrice(txtProdFloorPrice.getText());
            p.setDescStatemnt(txtProdDescStatement.getText());
            p.setCategory(dropDownCategory.getSelectedItem().toString());
            p.setProductBenefits(txtProdBenefits.getText());
            p.setProductFeatures(txtProdFeatures.getText());
            JOptionPane.showMessageDialog(this, "The Product was Added successfully!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter all the mandatory fields!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtProdBasePriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdBasePriceKeyTyped
        // TODO add your handling code here:
        char charEntered = evt.getKeyChar();
        // Allows only numbers,backspace and Delete 
        if ((!Character.isDigit(charEntered)) || (charEntered=='.') || (charEntered == KeyEvent.VK_BACK_SPACE) || (charEntered == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProdBasePriceKeyTyped

    private void txtProdCeildPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdCeildPriceKeyTyped
        // TODO add your handling code here:
        char charEntered = evt.getKeyChar();
        if ((!Character.isDigit(charEntered)) || (charEntered=='.') || (charEntered == KeyEvent.VK_BACK_SPACE) || (charEntered == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProdCeildPriceKeyTyped

    private void txtProdFloorPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdFloorPriceKeyTyped
        // TODO add your handling code here:
        char charEntered = evt.getKeyChar();
        if ((!Character.isDigit(charEntered)) || (charEntered=='.') || (charEntered == KeyEvent.VK_BACK_SPACE) || (charEntered == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProdFloorPriceKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> dropDownCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblMandFields;
    private javax.swing.JLabel lblProdBasePrice;
    private javax.swing.JLabel lblProdBenefits;
    private javax.swing.JLabel lblProdCategory;
    private javax.swing.JLabel lblProdCeilPrice;
    private javax.swing.JLabel lblProdDescStmnt;
    private javax.swing.JLabel lblProdFeatures;
    private javax.swing.JLabel lblProdFloorPrice;
    private javax.swing.JLabel lblProdModelNumb;
    private javax.swing.JLabel lblProdName;
    private javax.swing.JLabel lblProdVendorName;
    private javax.swing.JLabel lblVendorNameReplace;
    private javax.swing.JTextField txtProdBasePrice;
    private javax.swing.JTextArea txtProdBenefits;
    private javax.swing.JTextField txtProdCeildPrice;
    private javax.swing.JTextArea txtProdDescStatement;
    private javax.swing.JTextArea txtProdFeatures;
    private javax.swing.JTextField txtProdFloorPrice;
    private javax.swing.JTextField txtProdModelNumb;
    private javax.swing.JTextField txtProdName;
    // End of variables declaration//GEN-END:variables
}