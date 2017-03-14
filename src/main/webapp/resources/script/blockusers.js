/**
 * Script enable block button if no changes happen 
 */

function verificarBloquear(elemento){
	
	if( typeof verificarBloquear.contador == 'undefined'){
		verificarBloquear.contador = 0;
	}
	
	if(elemento.checked == true){
		console.log(verificarBloquear.contador += 1);
		$("#BotonBloquear").attr("disabled", false);
	}
	
	if(elemento.checked == false){
		console.log(verificarBloquear.contador -= 1);
	}
	
	if(verificarBloquear.contador != 0){
		$("#BotonBloquear").attr("disabled", false);
	} else {
		$("#BotonBloquear").attr("disabled", true);
	}
	
}

function verificarDesbloquear(elemento){
	
	if( typeof verificarDesbloquear.contador == 'undefined'){
		verificarDesbloquear.contador = 0;
	}
	
	if(elemento.checked == true){
		console.log(verificarDesbloquear.contador += 1);
		$("#BotonDesbloquear").attr("disabled", false);
	}
	
	if(elemento.checked == false){
		console.log(verificarDesbloquear.contador -= 1);
	}
	
	if(verificarDesbloquear.contador != 0){
		$("#BotonDesbloquear").attr("disabled", false);
	} else {
		$("#BotonDesbloquear").attr("disabled", true);
	}
	
}

/*Código para generar variables estáticas en javaScript
function countMyself() {
    // Check to see if the counter has been initialized
    if ( typeof countMyself.counter == 'undefined' ) {
        // It has not... perform the initialization
        countMyself.counter = 0;
    }

    // Do something stupid to indicate the value
    alert(++countMyself.counter);
}
*/
