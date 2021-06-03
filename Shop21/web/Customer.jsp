<%-- 
    Document   : Customer
    Created on : 28-May-2021, 17:10:14
    Author     : Snowyy
--%>

<%@page import="Model.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
            <tr>
                <td style="text-align:center">STT</td>
                <td style="text-align:center">Họ tên</td>
                <td style="text-align:center">SĐT</td>
                <td style="text-align:center">Địa chỉ</td>
                <td style="text-align:center">Số CMND/CCCD</td>
                <td>Thao tác</td>
            </tr>
            <%!int i = 1;%>
            <%
                List<Customer> employees = (List<Customer>) request.getAttribute("lstCustomer");

                for (Customer e : employees) {
            %>
            <tr>
                <td><%= i++%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getPhone()%></td>
                <td><%=e.getAddress()%></td>
                <td><%=e.getCertificate()%></td>
                <td>
                    <button type="button" onclick="openedit('<%=e.getId()%>', '<%=e.getName()%>', '<%=e.getPhone()%>', '<%=e.getAddress()%>', '<%=e.getCertificate()%>')" >Sửa</button>
                    <button type="button" onclick="confirmremove('<%=e.getId()%>')" >Xóa</button>
                </td>
            </tr>

            <%
                }
            %>
            <div hidden><%= i = 1%></div>
        </table>
        <div id="AddCustomer">
            <form action="AddCustomer" method="get">
                <input id="name" name="name"/>
                <input id="phone" name="phone"/>
                <input id="address" name="address"/>
                <input id="certificate" name="certificate"/>
                <button type="submit">Thêm Khách hàng</button>
            </form>
        </div>
        <div id="DeleteCustomer">
            <form action="DeleteCustomer" method="get">
                <input id="iddelete" name="iddelete"/>
                <button type="submit">Xóa Khách hàng</button>
            </form> 
        </div>
        <div id="EditCustomer">
            <form action="EditCustomer" method="get">
                <input id="idedit" name="idedit"/>
                <input id="nameedit" name="nameedit"/>
                <input id="phoneedit" name="phoneedit"/>
                <input id="addressedit" name="addressedit"/>
                <input id="certificateedit" name="certificateedit"/>
                <button type="submit">Sửa Khách hàng</button>
            </form>
        </div>
    </body>
</html>
<script>
    function openedit(id, name, phone, address, certificate) {
    $('#idedit').val(id);
            $('#nameedit').val(name);
            $('#phoneedit').val(phone);
            $('#addressedit').val(address);
            $('#certificateedit').val(certificate);
            ;}
    function confirmremove(id) {
            $('#iddelete').val(id);
            }
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>