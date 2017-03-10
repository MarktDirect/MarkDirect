/**
 * Script to charge content and validations for the form 
 */

var app = angular.module("promoModulo", []);
	app.controller("promoControlador",["$http", "$scope", controladorPrincipal]);

function controladorPrincipal($http, $scope){
	
	var vm = this;
	
	vm.datosCargados = false;
	vm.listaCategorias2 = [];
	vm.listaCategorias1 = [];
	vm.listaProductos = [];
	
	vm.idProductoPromo;
	
	vm.cargarDatos = function(){
		
		//encapsulamos rutina en if para que sólo se ejecute una vez mientras estemos en la página, la primera vez que se pida
		if(!vm.datosCargados){
			
			cargarCategorias2();
			cargarCategorias1();
			cargarProductos();
			vm.datosCargados = true;
			
		}
			
	};
	
	/*
	vm.cargarIdProductoPromo = function(){
		
		alert("carga nueva función");		
		alert($scope.ole);
		
	}
	*/
	
	//función que devuelve true si la id del producto es la adecuada para hacer selected en el select
	$scope.theProduct = function(idProducto){
		
		if($scope.id == idProducto){
			return true;
		}
		
	}
	
	$scope.theCategory1 = function(idCategory1){
		
		if($scope.categoria1 == idCategory1){
			return true;
		}
		
	}
	
	$scope.theCategory2 = function(idCategory2){
		
		if($scope.categoria2 == idCategory2){
			return true;
		}
		
	}
	
	/*
	vm.cargarDatosEditar = function(){
		
		vm.cargarDatos();
		vm.cargarIdProductoPromo();
		
	}
	
	*/
	
	cargarCategorias2 = function (){
		var exito = function(resp){
			vm.listaCategorias2 = resp.data;
		};
		var error = function(){
			alert("Error al cargar categorias2");
		};
		
		$http.get("http://localhost:8080/markdirect/getCatNiv2").then(exito, error);
		
	};
	
	cargarCategorias1 = function (){
		var exito = function(resp){
			vm.listaCategorias1 = resp.data;
		};
		var error = function(){
			alert("Error al cargar categorias1");
		};
		
		$http.get("http://localhost:8080/markdirect/getCatNiv1").then(exito, error);
		
	};
	
	cargarProductos = function (){
		var exito = function(resp){
			vm.listaProductos = resp.data;
		};
		var error = function(){
			alert("Error al cargar Productos");
		};
		
		$http.get("http://localhost:8080/markdirect/getProductosRed").then(exito, error);
		
	};
	
}

app.filter('filtrocat2', function(){
	
	return function(items, cat2){
		var filtered = [];
		for(var i = 0; i<items.length; i++){
			var item = items[i];
			if (item.id_level2Category == cat2){
				filtered.push(item);
			}
		}
		return filtered;
	}
	
});

app.filter('filtrocat1', function(){
	
	return function(items, cat1){
		var filtered = [];
		for(var i = 0; i<items.length; i++){
			var item = items[i];
			if (item.id_level1Category == cat1){
				filtered.push(item);
			}
		}
		return filtered;
	}
	
});

/*
 
app.filter('filtrocat1y2', function(){
	
	return function(items, cat2, cat1){
		var filtered = [];
		for(var i = 0; i<items.lenght; i++){
			var item = items[i];
			if (item.id_catNivel2 == cat2 && item.id_catNivel1 == cat1){
				filtered.push(item);
			}
		}
		return filtered;
	}
	
});
*/
