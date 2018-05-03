<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">

  <jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
  <jsp:output omit-xml-declaration="true" />
  <jsp:output doctype-root-element="HTML"
              doctype-system="about:legacy-compat" />
<html lang="en">
  <head>
    <title>Hello World</title>
    <c:url var="faviconUrl" value="/resources/img/favicon.ico"/>
    <link rel="icon" type="image/x-icon" href="${faviconUrl}"/>
    <c:url var="bootstrapUrl" value="/resources/css/bootstrap.css"/>
    <link href="${bootstrapUrl}" rel="stylesheet"></link>
    <c:url var="bootstrapResponsiveUrl" value="/resources/css/bootstrap-responsive.css"/>
    <link href="${bootstrapResponsiveUrl}" rel="stylesheet"></link>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>

  <body>
    <div class="container">
        <h1>TODO Secure this</h1>
        <p>We would like to secure this page</p>
		    <h1>This is secured!</h1>
		    <p>
		      Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>
        </p>
		    <p>
		      Hello <b><c:out value="${pageContext.request.userPrincipal}"/></b>
        </p>
		    <form class="form-inline" action="logout" method="post">
		      <input type="submit" value="Log out" />
		      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    </form>
    </div>
</body>
</html>
</jsp:root>
