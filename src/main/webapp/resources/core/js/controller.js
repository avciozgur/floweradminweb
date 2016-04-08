 $(document).ready(function(){
	 navigateToHome();
 });
 

function navigateToHome() {
	 $('#content').load('/floweradminweb/resources/templates/home.html');
}

function navigateToBouquetAdmin() {
	 $('#content').load('/floweradminweb/resources/templates/bouquetadmin.html');
}

function navigateToContact() {
	 $('#content').load('/floweradminweb/resources/templates/contact.html');
}