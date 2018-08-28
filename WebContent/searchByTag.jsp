<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<header>
	  <div class="container">
	  
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>PUBHUB <small>Books By Tag</small></h1>
		<hr class="book-primary">
		
		<form action="BooksByTag" method="get" class="form-horizontal">
		 
		 <div class="form-group">
		 	<label for="Tag" class="col-sm-4 control-label">Tag</label>
		 	<div class="col-sm-5">
		      <input type="text" class="form-control" id="tag" name="tag" placeholder="Tag" required="required" />
		 	</div>
		 </div>
		 <div class="form-group">
			<button type="submit" class="btn btn-primary">Submit</button>
		 </div>
		</form>
	  </div>
	</header>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
