<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>MarkDirect - Activa Juan Lucas</title>
<jsp:include page="links.jsp"></jsp:include>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="home-header">
		<div align="center">
			<h2>Estadísticas</h2>
			<hr style="backgound-color: #f9e553;"/>
			<h4>Usuarios</h4>
		</div>
	</div>
	<div class="section user-statistics">
	<div class="container">
        <div class="row" style="height: 220px">
          <div id="user-registered" class="col-md-3 col-xs-6 container-userStatistics">
            <div class="user-data" align="center">
           		<p class="user-number"><c:out value="${sessionScope.totalUsers}"/></p>
            	<p class="user-text"><i class="fa fa-users fa-2x" aria-hidden="true"></i> Usuarios</p>
            </div>
          </div>
          <div class="col-md-3 col-xs-6 container-userStatistics" id="user-averageAge">
          	<div class="user-data" align="center">
          		<p class="user-text" style="margin-top: 10px; font-size: 16px;">Usuarios por género <i class="fa fa-male" aria-hidden="true"></i><i class="fa fa-female" aria-hidden="true"></i></p>
          		<div id="chart_div"></div>
          	</div>
          </div>
          <div class="col-md-3 col-xs-6 container-userStatistics" id="user-byGender">
          	<div class="user-data">
          		<p class="user-number"><c:out value="${sessionScope.averageAge}"/></p>
          		<p class="user-text"><i class="fa fa-calendar fa-2x" aria-hidden="true"></i> Edad media</p>
          	</div>
          </div>
          <div class="col-md-3 col-xs-6 container-userStatistics" id="user-X">
          	<div class="user-data"></div>
          </div>
        </div>
        </div>
	</div>
	<div class="section promo-statistics">
	<div class="container">
		<div align="center" class="home-header"><h4>Promociones</h4></div>
        <div class="row" id="promo-statistics" style="height: 220px">
          <div class="col-md-3 col-xs-6 container-promoStatistics">
            <div class="promo-data" align="center">
            </div>
          </div>
          <div class="col-md-3 col-xs-6 container-promoStatistics">
          	<div class="promo-data" align="center">
          	</div>
          </div>
          <div class="col-md-3 col-xs-6 container-promoStatistics">
          	<div class="promo-data"></div>
          </div>
          <div class="col-md-3 col-xs-6 container-promoStatistics">
          	<div class="promo-data"></div>
          </div>
        </div>
        </div>
	</div>


	<!--Div that will hold the pie chart-->
	<!-- <div id="chart_div"></div> -->


</body>
</html>
