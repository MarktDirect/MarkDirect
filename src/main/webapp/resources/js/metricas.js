/**
 * 
 */

//Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['corechart']});

//Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

//Callback that creates and populates a data table, 
//instantiates the pie chart, passes in the data and
//draws it.
function drawChart() {
	alert("Estoy en la función drawChart");
	
	var jsonData = {
        url: "/usersByGender",
        type: "get",
        dataType: "json",
        async: false,
        };
	alert(jsonData);
	$ajax(jsonData);
	
	 var data = google.visualization.arrayToDataTable([
         ['Género', 'Nº de usuarios'],
         ['Mujeres', 2],
         ['Hombres', 1],
       ]);
       

	        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));

	        chart.draw(data);

	/*// Create our data table out of JSON data loaded from server.
    var data = new google.visualization.DataTable(data);

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, {width: 400, height: 240});*/

}