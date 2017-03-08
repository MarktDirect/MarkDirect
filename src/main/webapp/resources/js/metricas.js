/**
 * 
 */
//Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['corechart']});

//Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChartUsersByGender);

function drawChartUsersByGender() {
	
//	Hacemos la petición a nuestro Controlador
	$.ajax({
		url: "usersByGender",
		dataType: "json",
		success: getResponse
	});

	function getResponse(response) {
		var array = [];
		var data = new google.visualization.DataTable();
		//Añadimos los nombre de las columnas
		data.addColumn("string", 'dataName');
		data.addColumn("number", 'dataValue');
		//Por cada elemento en la consulta, creamos un nuevo array con los datos correspondientes
		//Después introducimos dicho array en un array superior que es el que pasaremos al chart
		for(var element in response) {
			var arrayData = [response[element].dataName, response[element].dataValue];
			array.push(arrayData);
		}
		data.addRows(array);
		var options = {
		          legend: 'none',
		          width: 170,
		          height: 170,
		          chartArea: {bottom: 0,top:0,width:'80%',height:'80%'},
		          colors:['#002C73', '#99cccc']
		        };
		var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		//dibujamos el chart
		chart.draw(data, options);
	}
}