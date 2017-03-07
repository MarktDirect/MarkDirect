/**
 * Script to charge content and validations for the form 
 */


var app = angular.module("promoModulo", []);
	app.controller("promoControlador",["$http", "$scope", controladorPrincipal]);

function controladorPrincipal($http, $scope){
	
	var vm = this;
	
	vm.listaCategorias2 = [];
	vm.listaCategorias1 = [];
	vm.listaProductos = [];
	
	vm.cargarDatos = function(){
		cargarCategorias2();
		cargarCategorias1();
		cargarProductos();
	};
	
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
			if (item.id_catNivel2 == cat2){
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
			if (item.id_catNivel1 == cat1){
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