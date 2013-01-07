<%--
    Author     : Alejandro
    Description: Redirecciona a error404.jsp.
--%>

<%	
    System.out.println("HTTP Error 500: " + request.getAttribute("javax.servlet.error.request_uri"));
%>

<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<c:redirect url="/comun/httpError/error500.jsp" />
