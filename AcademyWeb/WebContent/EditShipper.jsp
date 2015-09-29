<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="javax.naming.InitialContext, project.business.ShipperBeanLocal, project.entity.Shipper, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getParameter("id") == null) {
			out.println("Invalid Navigation");
		} else {
			int shipperid = Integer.parseInt(request.getParameter("id"));
			InitialContext context = new InitialContext();
			ShipperBeanLocal bean = (ShipperBeanLocal)context.lookup("java:comp/env/ejb/Shipper");
			Shipper s = new Shipper();
			s.setShipperid(shipperid);
			Shipper sAdd = bean.findShipper(s);
	%>
	<h4>Enter Shipper Details</h4>
	<form action="DatabaseServlet" method="get">
	<table>
	<tr>
		<td>ID</td><td><%=sAdd.getShipperid() %></td>
	</tr>
	<tr>
		<td>Shipper Name</td><td><input type="text" name="txtShipper" value="<%=sAdd.getCompanyname() %>" /></td>
	</tr>
	<tr>
		<td>Phone</td><td><input type="text" name="txtPhone" value="<%=sAdd.getPhone() %>"/>
		<input type="hidden" name="txtId" value="<%=sAdd.getShipperid() %>" />
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Edit Shipper" /></td>
	</tr>
	</table>
	</form>
	<%
		}
	%>
</body>
</html>