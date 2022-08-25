<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
//    Long id = Long.valueOf(request.getParameter("id"));
//    Customer customer = customerService.findOne(id);
%>
<form action="/customers" method="post">
<fieldset>
    <legend>Customer Information</legend>
    <input type="hidden" name="id" value="<c:out value="${id}"></c:out>">
    <table>
        <tr>
            <td>Id</td>
            <td>
                <c:out value="${id}"></c:out>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" value="<c:out value="${customer.getName()}"></c:out>">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" value="<c:out value="${customer.getEmail()}"></c:out>">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" name="address" value=" <c:out value="${customer.getAddress()}"></c:out>">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</fieldset>
</form>
<a href="/customers">Back to list</a>.