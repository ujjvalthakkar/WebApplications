<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <title>Sales</title>
    </head>

    <body style="background-color:#DCE775 ">

        <c:if test="${empty requestScope.salesList}">
            <div class="container">
                <h1>Welcome, Please fill the following</h1>
                <form class="well form-horizontal" method="POST" action="csv.htm" style="background-color: #EFEBE9;">
                    <div class="form-group">
                        <div class="col-md-8">
                            <label class="col-md-4 control-label">Enter the name of the CSV file:</label>
                            <div class="col-md-4 ">
                                <input type="text" name="csvName" value="" required/>
                                <input type="hidden" name="path" value="1" /><br>
                            </div>
                            <input class="btn btn-primary" type="submit" value="Submit" /> 
                        </div>
                    </div>
                </form>
            </div>
        </c:if>
        <c:if test="${not empty requestScope.salesList and requestScope.path=='2'}">
            <div class="container">
                <h1>The following is the CSV data</h1>
                <form class="well form-horizontal" action="csv.htm" method="POST" style="overflow: auto" style="background-color: #EFEBE9;">
                    <input type="hidden" name="path" value="addSales" />
                    <table class="table table-hover table-condensed" border="1">
                        <thead>
                            <tr>
                                <th>SalesOrderID</th>
                                <th>RevisionNumber</th>
                                <th>OrderDate</th>
                                <th>DueDate</th>
                                <th>ShipDate</th>
                                <th>Status</th>
                                <th>OnlineOrderFlag</th>
                                <th>SalesOrderNumber</th>
                                <th>PurchaseOrderNumber</th>
                                <th>AccountNumber</th>
                                <th>CustomerID</th>
                                <th>SalesPersonID</th>
                                <th>TerritoryID</th>
                                <th>BillToAddressID</th>
                                <th>ShipToAddressID</th>
                                <th>ShipMethodID</th>
                                <th>CreditCardID</th>
                                <th>CreditCardApprovalCode</th>
                                <th>CurrencyRateID</th>
                                <th>SubTotal</th>
                                <th>TaxAmt</th>
                                <th>Freight</th>
                                <th>TotalDue</th>
                                <th>Comment</th>
                                <th>ModifiedDate</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.salesList}" var="sale" varStatus="status">
                                <tr>
                                    <td><input type="text" name="salesOrderID${status.count}" value="<c:if test="${sale.salesOrderID=='NULL'}"></c:if><c:if test="${sale.salesOrderID!='NULL'}">${sale.salesOrderID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="revisionNumber${status.count}" value="<c:if test="${sale.revisionNumber=='NULL'}"></c:if><c:if test="${sale.revisionNumber!='NULL'}">${sale.revisionNumber}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="orderDate${status.count}" value="<c:if test="${sale.orderDate=='NULL'}"></c:if><c:if test="${sale.orderDate!='NULL'}">${sale.orderDate}</c:if>" readonly="readonly" /></td>
                                    <td><input type="text" name="dueDate${status.count}" value="<c:if test="${sale.dueDate=='NULL'}"></c:if><c:if test="${sale.dueDate!='NULL'}">${sale.dueDate}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="shipDate${status.count}" value="<c:if test="${sale.shipDate=='NULL'}"></c:if><c:if test="${sale.shipDate!='NULL'}">${sale.shipDate}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="status${status.count}" value="<c:if test="${sale.status=='NULL'}"></c:if><c:if test="${sale.status!='NULL'}">${sale.status}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="onlineOrderFlag${status.count}" value="<c:if test="${sale.onlineOrderFlag=='NULL'}"></c:if><c:if test="${sale.onlineOrderFlag!='NULL'}">${sale.onlineOrderFlag}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="salesOrderNumber${status.count}" value="<c:if test="${sale.salesOrderNumber=='NULL'}"></c:if><c:if test="${sale.salesOrderNumber!='NULL'}">${sale.salesOrderNumber}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="purchaseOrderNumber${status.count}" value="<c:if test="${sale.purchaseOrderNumber=='NULL'}"></c:if><c:if test="${sale.purchaseOrderNumber!='NULL'}">${sale.purchaseOrderNumber}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="accountNumber${status.count}" value="<c:if test="${sale.accountNumber=='NULL'}"></c:if><c:if test="${sale.accountNumber!='NULL'}">${sale.accountNumber}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="customerID${status.count}" value="<c:if test="${sale.customerID=='NULL'}"></c:if><c:if test="${sale.customerID!='NULL'}">${sale.customerID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="salesPersonID${status.count}" value="<c:if test="${sale.salesPersonID=='NULL'}"></c:if><c:if test="${sale.salesPersonID!='NULL'}">${sale.salesPersonID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="territoryID${status.count}" value="<c:if test="${sale.territoryID=='NULL'}"></c:if><c:if test="${sale.territoryID!='NULL'}">${sale.territoryID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="billToAddressID${status.count}" value="<c:if test="${sale.billToAddressID=='NULL'}"></c:if><c:if test="${sale.billToAddressID!='NULL'}">${sale.billToAddressID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="shipToAddressID${status.count}" value="<c:if test="${sale.shipToAddressID=='NULL'}"></c:if><c:if test="${sale.shipToAddressID!='NULL'}">${sale.shipToAddressID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="shipMethodID${status.count}" value="<c:if test="${sale.shipMethodID=='NULL'}"></c:if><c:if test="${sale.shipMethodID!='NULL'}">${sale.shipMethodID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="creditCardID${status.count}" value="<c:if test="${sale.creditCardID=='NULL'}"></c:if><c:if test="${sale.creditCardID!='NULL'}">${sale.creditCardID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="creditCardApprovalCode${status.count}" value="<c:if test="${sale.creditCardApprovalCode=='NULL'}"></c:if><c:if test="${sale.creditCardApprovalCode!='NULL'}">${sale.creditCardApprovalCode}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="currencyRateID${status.count}" value="<c:if test="${sale.currencyRateID=='NULL'}"></c:if><c:if test="${sale.currencyRateID!='NULL'}">${sale.currencyRateID}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="subTotal${status.count}" value="<c:if test="${sale.subTotal=='NULL'}"></c:if><c:if test="${sale.subTotal!='NULL'}">${sale.subTotal}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="taxAmt${status.count}" value="<c:if test="${sale.taxAmt=='NULL'}"></c:if><c:if test="${sale.taxAmt!='NULL'}">${sale.taxAmt}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="freight${status.count}" value="<c:if test="${sale.freight=='NULL'}"></c:if><c:if test="${sale.freight!='NULL'}">${sale.freight}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="totalDue${status.count}" value="<c:if test="${sale.totalDue=='NULL'}"></c:if><c:if test="${sale.totalDue!='NULL'}">${sale.totalDue}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="comment${status.count}" value="<c:if test="${sale.comment=='NULL'}"></c:if><c:if test="${sale.comment!='NULL'}">${sale.comment}</c:if>" readonly="readonly"/></td>
                                    <td><input type="text" name="modifiedDate${status.count}" value="<c:if test="${sale.modifiedDate=='NULL'}"></c:if><c:if test="${sale.modifiedDate!='NULL'}">${sale.modifiedDate}</c:if>" readonly="readonly"/></td>
                                    </tr>
                                    <input type="hidden" name="size" value="${status.count}" />
                        </c:forEach>
                        </tbody>
                    </table><br>
                    <input class="btn btn-primary" type="submit" value="Submit" />
                </form>
            </div>
        </c:if> 
        <c:if test="${requestScope.path=='3'}">
            <div class="container">
                <h3>Update successfull!</h3>
            </div>
        </c:if>

    </body>
</html>
