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
            	<p class="user-text"><i class="fa fa-users" aria-hidden="true"></i> Usuarios</p>
            	<p class="user-number"><c:out value="${sessionScope.averageAge}"/></p>
            	<p class="user-text"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> Edad media</p>
            </div>
          </div>
          <div class="col-md-3 col-xs-6 container-userStatistics" id="user-averageAge">
          	<div class="user-data" align="center">
          		<p class="user-text" style="margin-top: 10px; font-size: 16px;">Usuarios por género <i class="fa fa-male" aria-hidden="true"></i><i class="fa fa-female" aria-hidden="true"></i></p>
          		<div id="chart_div"></div>
          	</div>
          </div>
          <div class="col-md-6 col-xs-12 container-userStatistics" id="user-byGender">
          		<div class="big-user-data" align="center">
          			<p class="user-text" style="margin-top: 10px; font-size: 16px;">Usuarios por edad & género <i class="fa fa-male" aria-hidden="true"></i><i class="fa fa-female" aria-hidden="true"></i></p>
          			<div id="columnchart"></div>
          		</div>
          </div>
        </div>
        </div>
	</div>
	<div align="center" class="home-header" style="margin-top: 60px;"><h4>Promociones</h4></div>
		<div class="section promo-statistics">
	<div class="container">
        <div class="row" style="height: 220px">
          <div id="promo-totalSent" class="col-md-3 col-xs-6 container-promoStatistics">
            <div class="promo-data" align="center">
           		<p class="promo-number"><c:out value="${sessionScope.totalSentPromos}"/></p>
            	<p class="promo-text"><i class="fa fa-tags fa-lg" aria-hidden="true"></i> Promociones enviadas</p>
            	<p class="promo-text">
            	<c:out value="${sessionScope.totalGenericPromos}"/>
            	genéricas <i class="fa fa-mobile" aria-hidden="true"></i></p> 
            	<p class="promo-text">
            	<c:out value="${sessionScope.totalLocationPromos}"/>
            	de localización <i class="fa fa-location-arrow" aria-hidden="true"></i></p>
            </div>
          </div>
          <div class="col-md-3 col-xs-6 container-userStatistics" id="user-averageAge">
          	<div class="promo-data" align="center">
          		<p class="promo-text" style="margin-top: 10px; font-size: 16px">Enviadas por género <i class="fa fa-male" aria-hidden="true"></i><i class="fa fa-female" aria-hidden="true"></i></p>
          		<div id="chartPromosByGender"></div>
          	</div>
          </div>
          <div class="col-md-6 col-xs-12 container-userStatistics" id="user-byGender">
          		<div class="big-promo-data" align="center">
          			<p class="user-text" style="margin-top: 10px; font-size: 16px;">Categorías de nivel 1 más enviadas <i class="fa fa-asterisk" aria-hidden="true"></i></p>
          			<div id="columnchartLevel1"></div>
          		</div>
          </div>
        </div>
        </div>
	</div>
	<div class="section promo-statistics">
	<div class="container">
		<div class="row home-header" align="center">
			<div class="col-md-6"><h4>Productos por género</h4></div>
			<div class="col-md-6"><h4>Marcas por género</h4></div>
		</div>
        <div class="row" id="promo-statistics" style="height: 220px">
          <div class="col-md-3 col-xs-6 container-promoStatistics">
            <div class="promo-data" align="center">
            	<p class="promo-text" style="margin-top: 10px; font-size: 16px;">Mujeres <i class="fa fa-female" aria-hidden="true"></i></p>
            	<div id="chartproductW"></div>
            </div>
          </div>
          <div class="col-md-3 col-xs-6 container-promoStatistics">
          	<div class="promo-data" align="center">
          		<p class="promo-text" style="margin-top: 10px; font-size: 16px;">Hombres <i class="fa fa-male" aria-hidden="true"></i></p>
          		<div id="chartproductM"></div>
          	</div>
          </div>
          <div class="col-md-3 col-xs-6 container-promoStatistics">
          	<div class="promo-data" align="center">
          		<p class="promo-text" style="margin-top: 10px; font-size: 16px;">Mujeres <i class="fa fa-female" aria-hidden="true"></i></p>
          		<div id="chartbrandW"></div>
          	</div>
          </div>
          <div class="col-md-3 col-xs-6 container-promoStatistics">
          	<div class="promo-data" align="center">
          		<p class="promo-text" style="margin-top: 10px; font-size: 16px;">Hombres <i class="fa fa-male" aria-hidden="true"></i></p>
          		<div id="chartbrandM"></div>
          	</div>
          </div>
        </div>
        </div>
	</div>
	<footer>
	</footer>
</body>
</html>
