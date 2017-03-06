package com.edu.tags;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.edu.Beans.SalesOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ujjva
 */
public class tagHandler extends SimpleTagSupport {

    private String csvName;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            String csvName = this.csvName;
            String csvPath = "C:\\Users\\ujjva\\OneDrive\\Documents\\NetBeansProjects\\CSVFile";
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + csvPath);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet results = stmt.executeQuery("SELECT * FROM " + csvName);
                ArrayList<SalesOrder> salesList = new ArrayList<>();
                int i = 0;
                while (results.next()) {
                    if (i > 2) {
                        break;
                    }
                    SalesOrder s = new SalesOrder();
                    s.setSalesOrderID(results.getString("SalesOrderID"));
                    s.setRevisionNumber(results.getString("RevisionNumber"));
                    s.setOrderDate(results.getString("OrderDate"));
                    s.setDueDate(results.getString("DueDate"));
                    s.setShipDate(results.getString("ShipDate"));
                    s.setStatus(results.getString("Status"));
                    s.setOnlineOrderFlag(results.getString("OnlineOrderFlag"));
                    s.setSalesOrderNumber(results.getString("SalesOrderNumber"));
                    s.setPurchaseOrderNumber(results.getString("PurchaseOrderNumber"));
                    s.setAccountNumber(results.getString("AccountNumber"));
                    s.setCustomerID(results.getString("CustomerID"));
                    s.setSalesPersonID(results.getString("SalesPersonID"));
                    s.setTerritoryID(results.getString("TerritoryID"));
                    s.setBillToAddressID(results.getString("BillToAddressID"));
                    s.setShipToAddressID(results.getString("ShipToAddressID"));
                    s.setShipMethodID(results.getString("ShipMethodID"));
                    s.setCreditCardID(results.getString("CreditCardID"));
                    s.setCreditCardApprovalCode(results.getString("CreditCardApprovalCode"));
                    s.setCurrencyRateID(results.getString("CurrencyRateID"));
                    s.setSubTotal(results.getString("SubTotal"));
                    s.setTaxAmt(results.getString("TaxAmt"));
                    s.setFreight(results.getString("Freight"));
                    s.setTotalDue(results.getString("TotalDue"));
                    s.setComment(results.getString("Comment"));
                    s.setModifiedDate(results.getString("ModifiedDate"));
                    salesList.add(s);
                    i++;
                }
                out.println("<h1>The following is the CSV data</h1>");
                out.println("<form class=\"well form-horizontal\" style=\"overflow: auto\" style=\"background-color: #EFEBE9;\" action=\"csv.htm\" method=\"POST\">\n"
                        + "                <input type=\"hidden\" name=\"path\" value=\"addSales\" />\n"
                        + "                <table class=\"table table-hover table-condensed\" border=\"1\">\n"
                        + "                    <thead>\n"
                        + "                        <tr>\n"
                        + "                            <th>SalesOrderID</th>\n"
                        + "                            <th>RevisionNumber</th>\n"
                        + "                            <th>OrderDate</th>\n"
                        + "                            <th>DueDate</th>\n"
                        + "                            <th>ShipDate</th>\n"
                        + "                            <th>Status</th>\n"
                        + "                            <th>OnlineOrderFlag</th>\n"
                        + "                            <th>SalesOrderNumber</th>\n"
                        + "                            <th>PurchaseOrderNumber</th>\n"
                        + "                            <th>AccountNumber</th>\n"
                        + "                            <th>CustomerID</th>\n"
                        + "                            <th>SalesPersonID</th>\n"
                        + "                            <th>TerritoryID</th>\n"
                        + "                            <th>BillToAddressID</th>\n"
                        + "                            <th>ShipToAddressID</th>\n"
                        + "                            <th>ShipMethodID</th>\n"
                        + "                            <th>CreditCardID</th>\n"
                        + "                            <th>CreditCardApprovalCode</th>\n"
                        + "                            <th>CurrencyRateID</th>\n"
                        + "                            <th>SubTotal</th>\n"
                        + "                            <th>TaxAmt</th>\n"
                        + "                            <th>Freight</th>\n"
                        + "                            <th>TotalDue</th>\n"
                        + "                            <th>Comment</th>\n"
                        + "                            <th>ModifiedDate</th>\n"
                        + "                        </tr>\n"
                        + "                    </thead>\n"
                        + "                    <tbody>\n");
                int n = 1;
                String salesOrderID;
                String revisionNumber;
                String orderDate;
                String dueDate;
                String shipDate;
                String status;
                String onlineOrderFlag;
                String salesOrderNumber;
                String purchaseOrderNumber;
                String accountNumber;
                String customerID;
                String salesPersonID;
                String territoryID;
                String billToAddressID;
                String shipToAddressID;
                String shipMethodID;
                String creditCardID;
                String creditCardApprovalCode;
                String currencyRateID;
                String subTotal;
                String taxAmt;
                String freight;
                String totalDue;
                String comment;
                String modifiedDate;
                for (SalesOrder s : salesList) {
                    salesOrderID = s.getSalesOrderID().equalsIgnoreCase("null")?"":s.getSalesOrderID();
                    revisionNumber = s.getRevisionNumber().equalsIgnoreCase("null")?"":s.getRevisionNumber();
                    orderDate = s.getOrderDate().equalsIgnoreCase("null")?"":s.getOrderDate();
                    dueDate = s.getDueDate().equalsIgnoreCase("null")?"":s.getDueDate();
                    shipDate = s.getShipDate().equalsIgnoreCase("null")?"":s.getShipDate();
                    status = s.getStatus().equalsIgnoreCase("null")?"":s.getStatus();
                    onlineOrderFlag = s.getOnlineOrderFlag().equalsIgnoreCase("null")?"":s.getOnlineOrderFlag();
                    salesOrderNumber = s.getSalesOrderNumber().equalsIgnoreCase("null")?"":s.getSalesOrderNumber();
                    purchaseOrderNumber = s.getPurchaseOrderNumber().equalsIgnoreCase("null")?"":s.getPurchaseOrderNumber();
                    accountNumber = s.getAccountNumber().equalsIgnoreCase("null")?"":s.getAccountNumber();
                    customerID = s.getCustomerID().equalsIgnoreCase("null")?"":s.getCustomerID();
                    salesPersonID = s.getSalesPersonID().equalsIgnoreCase("null")?"":s.getSalesPersonID();
                    territoryID = s.getTerritoryID().equalsIgnoreCase("null")?"":s.getTerritoryID();
                    billToAddressID = s.getBillToAddressID().equalsIgnoreCase("null")?"":s.getBillToAddressID();
                    shipToAddressID = s.getShipToAddressID().equalsIgnoreCase("null")?"":s.getShipToAddressID();
                    shipMethodID = s.getShipMethodID().equalsIgnoreCase("null")?"":s.getShipMethodID();
                    creditCardID = s.getCreditCardID().equalsIgnoreCase("null")?"":s.getCreditCardID();
                    creditCardApprovalCode = s.getCreditCardApprovalCode().equalsIgnoreCase("null")?"":s.getCreditCardApprovalCode();
                    currencyRateID = s.getCurrencyRateID().equalsIgnoreCase("null")?"":s.getCurrencyRateID();
                    subTotal = s.getSubTotal().equalsIgnoreCase("null")?"":s.getSubTotal();
                    taxAmt = s.getTaxAmt().equalsIgnoreCase("null")?"":s.getTaxAmt();
                    freight = s.getFreight().equalsIgnoreCase("null")?"":s.getFreight();
                    totalDue = s.getTotalDue().equalsIgnoreCase("null")?"":s.getTotalDue();
                    comment = s.getComment().equalsIgnoreCase("null")?"":s.getComment();
                    modifiedDate = s.getModifiedDate().equalsIgnoreCase("null")?"":s.getModifiedDate();
                    out.println("<tr>");
                    out.println("<td><input type=\"text\" name=\"salesOrderID" + n + "\" value=\"" + salesOrderID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"revisionNumber" + n + "\" value=\"" + revisionNumber + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"orderDate" + n + "\" value=\"" + orderDate + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"dueDate" + n + "\" value=\"" + dueDate + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"shipDate" + n + "\" value=\"" + shipDate + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"status" + n + "\" value=\"" + status + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"onlineOrderFlag" + n + "\" value=\"" + onlineOrderFlag + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"salesOrderNumber" + n + "\" value=\"" + salesOrderNumber + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"purchaseOrderNumber" + n + "\" value=\"" + purchaseOrderNumber + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"accountNumber" + n + "\" value=\"" + accountNumber + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"customerID" + n + "\" value=\"" + customerID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"salesPersonID" + n + "\" value=\"" + salesPersonID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"territoryID" + n + "\" value=\"" + territoryID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"billToAddressID" + n + "\" value=\"" + billToAddressID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"shipToAddressID" + n + "\" value=\"" + shipToAddressID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"shipMethodID" + n + "\" value=\"" + shipMethodID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"creditCardID" + n + "\" value=\"" + creditCardID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"creditCardApprovalCode" + n + "\" value=\"" + creditCardApprovalCode + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"currencyRateID" + n + "\" value=\"" + currencyRateID + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"subTotal" + n + "\" value=\"" + subTotal + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"taxAmt" + n + "\" value=\"" + taxAmt + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"freight" + n + "\" value=\"" + freight + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"totalDue" + n + "\" value=\"" + totalDue + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"comment" + n + "\" value=\"" + comment + "\" /></td>");
                    out.println("<td><input type=\"text\" name=\"modifiedDate" + n + "\" value=\"" + modifiedDate + "\" /></td>");
                    out.println("</tr>");
                    n++;
                }
                out.println("</tbody>\n"
                        + "                </table><br>");
                out.println("                <input class=\"btn btn-primary\" type=\"submit\" value=\"Submit\" />\n"
                        + "            </form>");
            } catch (Exception e) {
                e.printStackTrace();
            }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in tagHandler tag", ex);
        }
    }

    public void setCsvName(String csvName) {
        this.csvName = csvName;
    }

}
