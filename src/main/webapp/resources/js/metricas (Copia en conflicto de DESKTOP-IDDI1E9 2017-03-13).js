/**
 * 
 */
//Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['corechart']});

//Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChartUsersByGender);
google.charts.setOnLoadCallback(drawChartUsersByAgeAndGender);
google.charts.setOnLoadCallback(drawChartProductWomen);
google.charts.setOnLoadCallback(drawChartProductMen);
google.charts.setOnLoadCallback(drawChartPromoByGender);
google.charts.setOnLoadCallback(drawChartBrandWomen);
google.charts.setOnLoadCallback(drawChartBrandMen);
google.charts.setOnLoadCallback(drawChartLevel1ByAge);

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
}function drawChartUsersByAgeAndGender() {
//	Hacemos la petición a nuestro Controlador
	$.ajax({
		url: "usersByAgeAndGender",
		dataType: "json",
		success: getResponse
	});
	
	function getResponse(response) {
		var array = [];
		var rango1 = ['18-25', response[0].dataValue,response[5].dataValue,''];
		var rango2 = ['26-35', response[1].dataValue, response[6].dataValue,''];
		var rango3 = ['36-45', response[2].dataValue, response[7].dataValue,''];
		var rango4 = ['46-55', response[3].dataValue, response[8].dataValue,''];
		var rango5 = ['+55', response[4].dataValue, response[9].dataValue,''];
		
		var data = new google.visualization.arrayToDataTable([
	        ['Género', 'Hombres', 'Mujeres', { role: 'annotation' } ],
	           rango1, rango2, rango3, rango4, rango5
	         ]);
		var options = {
		        width: 390,
		        height: 170,
		        legend: { position: 'top', maxLines: 1 },
		        bar: { groupWidth: '75%' },
		        isStacked: true,
		        colors:['#002C73', '#99cccc']
		      };
		var chart = new google.visualization.ColumnChart(document.getElementById("columnchart"));
		//dibujamos el chart
		chart.draw(data, options);
	}
}

function drawChartProductWomen() {
	$.ajax({
		url: "productWomen",
		dataType: "json",
		success: getResponse
	});
	
	function getResponse(response) {
		var array = [];
		var data = new google.visualization.DataTable();
		//Añadimos los nombre de las columnas
		data.addColumn("string", 'Producto');
		data.addColumn("number", 'Veces enviado');
		//Por cada elemento en la consulta, creamos un nuevo array con los datos correspondientes
		//Después introducimos dicho array en un array superior que es el que pasaremos al chart
		for(var element in response) {
			var arrayData = [response[element].Producto, response[element].Veces];
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
		var chart = new google.visualization.PieChart(document.getElementById('chartproductW'));
		//dibujamos el chart
		chart.draw(data, options);
	}
	
}

function drawChartProductMen() {
	$.ajax({
		url: "productMan",
		dataType: "json",
		success: getResponse
	});
	
	function getResponse(response) {
		var array = [];
		var data = new google.visualization.DataTable();
		//Añadimos los nombre de las columnas
		data.addColumn("string", 'Producto');
		data.addColumn("number", 'Veces enviado');
		//Por cada elemento en la consulta, creamos un nuevo array con los datos correspondientes
		//Después introducimos dicho array en un array superior que es el que pasaremos al chart
		for(var element in response) {
			var arrayData = [response[element].Producto, response[element].Veces];
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
		var chart = new google.visualization.PieChart(document.getElementById('chartproductM'));
		//dibujamos el chart
		chart.draw(data, options);
	}
	
}

function drawChartPromoByGender() {
//	Hacemos la petición a nuestro Controlador
	$.ajax({
		url: "sentPromosByGender",
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
		var chart = new google.visualization.PieChart(document.getElementById('chartPromosByGender'));
		//dibujamos el chart
		chart.draw(data, options);
	}
	
}

function drawChartBrandWomen() {
	$.ajax({
		url: "brandWomen",
		dataType: "json",
		success: getResponse
	});
	
	function getResponse(response) {
		var array = [];
		var data = new google.visualization.DataTable();
		//Añadimos los nombre de las columnas
		data.addColumn("string", 'Marca');
		data.addColumn("number", 'Veces enviado');
		//Por cada elemento en la consulta, creamos un nuevo array con los datos correspondientes
		//Después introducimos dicho array en un array superior que es el que pasaremos al chart
		for(var element in response) {
			var arrayData = [response[element].Marca, response[element].Veces];
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
		var chart = new google.visualization.PieChart(document.getElementById('chartbrandW'));
		//dibujamos el chart
		chart.draw(data, options);
	}
}

function drawChartBrandMen() {
	$.ajax({
		url: "brandMen",
		dataType: "json",
		success: getResponse
	});
	
	function getResponse(response) {
		var array = [];
		var data = new google.visualization.DataTable();
		//Añadimos los nombre de las columnas
		data.addColumn("string", 'Marca');
		data.addColumn("number", 'Veces enviado');
		//Por cada elemento en la consulta, creamos un nuevo array con los datos correspondientes
		//Después introducimos dicho array en un array superior que es el que pasaremos al chart
		for(var element in response) {
			var arrayData = [response[element].Marca, response[element].Veces];
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
		var chart = new google.visualization.PieChart(document.getElementById('chartbrandM'));
		//dibujamos el chart
		chart.draw(data, options);
	}
}

function drawChartLevel1ByAge() {
//	Hacemos la petición a nuestro Controlador
	$.ajax({
		url: "level1ByAge",
		dataType: "json",
		success: getResponse
	});

	function getResponse(response) {
		for (var element in response) {
			if(response[element].dataValue == 0) {
				response[element].dataName = 'Sin datos';
			}
		}
		var array = [];
		var rango1 = ['18-25', response[0].dataValue, response[0].dataName];
		var rango2 = ['26-35', response[1].dataValue, response[1].dataName];
		var rango3 = ['36-45', response[2].dataValue, response[2].dataName];
		var rango4 = ['46-55', response[3].dataValue, response[3].dataName];
		var rango5 = ['+55', response[4].dataValue, response[4].dataName];
	
		var data = new google.visualization.arrayToDataTable([
	        ['Categorías nivel 1', 'Veces', { role: 'annotation' } ],
	           rango1, rango2, rango3, rango4, rango5
	         ]);
		var options = {
		        width: 390,
		        height: 170,
		        legend: { position: 'top', maxLines: 1 },
		        bar: { groupWidth: '75%' },
		        isStacked: true,
		        colors:['#002C73', '#99cccc', '#f9e553']
		      };
		var chart = new google.visualization.ColumnChart(document.getElementById("columnchartLevel1"));
		//dibujamos el chart
		chart.draw(data, options);
	}
	
}