<%--
    Author     : Alejandro
    Description: Redirecciona a error404.jsp.
--%>

<%	
    System.out.println("HTTP Error 404: " + request.getAttribute("javax.servlet.error.request_uri"));
%>

<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<c:redirect url="/comun/httpError/error404.jsp" />
