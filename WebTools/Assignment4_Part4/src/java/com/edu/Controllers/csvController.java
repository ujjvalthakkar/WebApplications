/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.Controllers;

import com.edu.Beans.SalesOrder;
import com.edu.Dao.ConnDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author ujjva
 */
public class csvController extends AbstractController {

    public csvController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        //DataSource ds = (DataSource) this.getApplicationContext().getBean("myDataSource");
        //QueryRunner run = new QueryRunner(ds);
        String path = "";
        if (request.getParameter("path").equals("1")) {
            path = "2";
            String csvName = request.getParameter("csvName");
            String csvPath = "C:\\Users\\ujjva\\OneDrive\\Documents\\NetBeansProjects\\CSVFile";
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + csvPath);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet results = stmt.executeQuery("SELECT * FROM " + csvName);
                ArrayList<SalesOrder> salesList = new ArrayList<>();
                int i=0;
                while (results.next()) {
                    if(i>2)break;
                    SalesOrder s = new SalesOrder();
                    s.setSalesOrderID(results.getString("SalesOrderID"));
                    s.setRevisionNumber(results.getString("RevisionNumber"));
                    s.setOrderDate(results.getString("OrderDate"));
                    s.setDueDate(results.getString("DueDate"));
                    s.setShipDate(results.getString("ShipDate"));
                    s.setStatus(results.getString("Status"));
                    s.setOnlineOrderFlag(results.getString("OnlineOrderFlag"));
                    s.setSalesOrderID(results.getString("SalesOrderNumber"));
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
                request.setAttribute("salesList", salesList);
                request.setAttribute("path", path);
                mv.setViewName("index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (request.getParameter("path").equals("addSales")) {
            path="3";
            Connection conn = ConnDAO.getConnection();
            conn.setAutoCommit(false);
            int size = Integer.parseInt(request.getParameter("size"));
            String query = "INSERT INTO sales(SalesOrderID,RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,SalesOrderNumber,PurchaseOrderNumber,AccountNumber,CustomerID,SalesPersonID,TerritoryID,BillToAddressID,ShipToAddressID,ShipMethodID,CreditCardID,CreditCardApprovalCode,CurrencyRateID,SubTotal,TaxAmt,Freight,TotalDue,Comment,ModifiedDate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            for (int i = 1; i <= 3; i++) {
                pst.setString(1, request.getParameter("salesOrderID" + i));
                pst.setString(2, request.getParameter("revisionNumber" + i));
                pst.setString(3, request.getParameter("orderDate" + i));
                pst.setString(4, request.getParameter("dueDate" + i));
                pst.setString(5, request.getParameter("shipDate" + i));
                pst.setString(6, request.getParameter("status" + i));
                pst.setString(7, request.getParameter("onlineOrderFlag" + i));
                pst.setString(8, request.getParameter("salesOrderNumber" + i));
                pst.setString(9, request.getParameter("purchaseOrderNumber" + i));
                pst.setString(10, request.getParameter("accountNumber" + i));
                pst.setString(11, request.getParameter("customerID" + i));
                pst.setString(12, request.getParameter("salesPersonID" + i));
                pst.setString(13, request.getParameter("territoryID" + i));
                pst.setString(14, request.getParameter("billToAddressID" + i));
                pst.setString(15, request.getParameter("shipToAddressID" + i));
                pst.setString(16, request.getParameter("shipMethodID" + i));
                pst.setString(17, request.getParameter("creditCardID" + i));
                pst.setString(18, request.getParameter("creditCardApprovalCode" + i));
                pst.setString(19, request.getParameter("currencyRateID" + i));
                pst.setString(20, request.getParameter("subTotal" + i));
                pst.setString(21, request.getParameter("taxAmt" + i));
                pst.setString(22, request.getParameter("freight" + i));
                pst.setString(23, request.getParameter("totalDue" + i));
                pst.setString(24, request.getParameter("comment" + i));
                pst.setString(25, request.getParameter("modifiedDate" + i));
                pst.addBatch();
            }
            int[] x=pst.executeBatch();
            conn.setAutoCommit(true);
            request.setAttribute("path", path);
            mv.setViewName("index");
        }
        return mv;
    }

}
