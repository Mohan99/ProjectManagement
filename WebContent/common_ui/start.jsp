<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class='row'>
<%@include file="header.jsp"%>
</div>
<div class='row'>

<div class='col-md-3'>
<c:if test="${roleID eq 1}">
<%@include file="menu.jsp"%>
</c:if>


<c:if test="${roleID eq 2}">
<%@include file="pm_menu.jsp"%>
</c:if>



<c:if test="${roleID eq 3}">
<%@include file="tl_menu.jsp"%>
</c:if>

<c:if test="${roleID eq 4}">
<%@include file="dev_menu.jsp"%>
</c:if>


</div><!-- 
style="overflow: scroll; height" -->
<div class='col-md-9' id='vp-div' >
