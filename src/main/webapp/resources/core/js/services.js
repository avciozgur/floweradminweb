function saveBouquet () {
	
	 alert('girdim');
     var bouquet = {};
     bouquet.name = $('#name').val();
     bouquet.description = $('#description').val();
     //bouquet.price = $('#price').val();
     alert(JSON.stringify(bouquet));
     
     $.ajax({
         type: "POST",
         url: "http://localhost:8080/floweradminweb/bouquet",
         data: JSON.stringify(bouquet),
         contentType: "application/json"     
     }).done( function(data,textStatus,jqXHR) {
    	 alert('SUCCESS'+data);
     }).fail( function(jqXHR, textStatus, errorThrown) {
    	 alert('FAIL'+errorThrown);
     });
}