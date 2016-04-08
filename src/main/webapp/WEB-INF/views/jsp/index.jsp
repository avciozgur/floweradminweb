<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="adminApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flower Administration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="<spring:url value="/resources/core/js/controller.js"/>"></script>
<script src="<spring:url value="/resources/core/js/services.js"/>"></script>

</head>

<body>

<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Administration</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li data-toggle="collapse" data-target=".navbar-collapse"><a href="#" onclick="navigateToHome()">Home</a></li>
            <li data-toggle="collapse" data-target=".navbar-collapse"><a href="#about" onclick="navigateToBouquetAdmin()">Bouquets</a></li>
            <li data-toggle="collapse" data-target=".navbar-collapse"><a href="#contact" onclick="navigateToContact()">Contact</a></li>
            
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    


<div  id="content">
</div>

</body>
</html>