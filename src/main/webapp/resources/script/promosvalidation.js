/**
 * Script to validate dates and ages before submit
 */

window.onload = ahivamos();
	
	
function ahivamos(){


	alert("hola");

	//Agregar promociones nuevas
	$("#minordate").change(function(){

		if($("#minordate").val() > $("#majordate").val()){
			$("#okbutton").attr("disabled",true);
			console.log("1 disable");
			alert("1 disable");

			if(($("#minordate").val() != "") && ($("#majordate").val() != "")){
				alert("La fecha de inicio de la promoción debe ser igual o mayor a la de vencimiento.");
			}

		}

		if(($("#minordate").val() <= $("#majordate").val())){
			alert("paso el primero " + ($("#minordate").val() <= $("#majordate").val()));
			if(($("#minorage").val() <= $("#majorage").val())){
				$("#okbutton").attr("disabled",false);
				console.log("1 enable");
				alert("1 enable");
			}
		}


	});

	$("#majordate").change(function(){

		if($("#minordate").val() > $("#majordate").val()){
			$("#okbutton").attr("disabled",true);

			console.log("2 diasble");
			alert("2 diasble");
			
			if(($("#minordate").val() != "") && ($("#majordate").val() != "")){
				alert("La fecha de inicio de la promoción debe ser igual o mayor a la de vencimiento.");
			}

		}

		if(($("#minordate").val() <= $("#majordate").val())){
			alert("paso el segundo " + ($("#minordate").val() <= $("#majordate").val()));
			if(($("#minorage").val() <= $("#majorage").val())){
				$("#okbutton").attr("disabled",false);
				console.log("2 enable");
				alert("2 enable");
			}
		}

	});

	$("#minorage").change(function(){

		if($("#minorage").val() > $("#majorage").val()){
			$("#okbutton").attr("disabled",true);

			console.log("3 disable");
			
			if(($("#minorage").val() != "") && ($("#majorage").val() != "")){
				alert("La edad mínima de la promoción debe ser igual o mayor a la máxima.");
			}

		}
		if(($("#minorage").val() <= $("#majorage").val())){
			alert("paso el tercero " + ($("#minorage").val() <= $("#majorage").val()));
			if(($("#minordate").val() <= $("#majordate").val())){
				$("#okbutton").attr("disabled",false);
				console.log("3 enable");
			}
		}

	});

	$("#majorage").change(function(){

		if($("#minorage").val() > $("#majorage").val()){
			$("#okbutton").attr("disabled",true);

			console.log("4 disable");
			
			if(($("#minorage").val() != "") && ($("#majorage").val() != "")){
				alert("La edad mínima de la promoción debe ser igual o mayor a la máxima.");
			}

		}
		if(($("#minorage").val() <= $("#majorage").val())){
			alert("paso el tercero " + ($("#minorage").val() <= $("#majorage").val()));
			if(($("#minordate").val() <= $("#majordate").val())){
				$("#okbutton").attr("disabled",false);
				console.log("4 enable");
			}
		}


	});
	/////////////////////////////////////////////////////////////////////////////////////////////

	//Modificar promociones existentes
	$("#edit-promoSince").change(function(){

		if($("#edit-promoSince").val() > $("#edit-promoTo").val()){
			$("#submit").attr("disabled",true);

			if(($("#edit-promoSince").val() != "") && ($("#edit-promoTo").val() != "")){
				alert("La fecha de inicio de la promoción debe ser igual o mayor a la de vencimiento.");
			}

		}
		if($("#edit-promoSince").val() <= $("#edit-promoTo").val()){
			$("#submit").attr("disabled",false);
		}

	});

	$("#edit-promoTo").change(function(){

		if($("#edit-promoSince").val() > $("#edit-promoTo").val()){
			$("#submit").attr("disabled",true);

			if(($("#edit-promoSince").val() != "") && ($("#edit-promoTo").val() != "")){
				alert("La fecha de inicio de la promoción debe ser igual o mayor a la de vencimiento.");
			}

		}
		if($("#edit-promoSince").val() <= $("#edit-promoTo").val()){
			$("#submit").attr("disabled",false);
		}

	});

	$("#edit-promoMinAge").change(function(){

		if($("#edit-promoMinAge").val() > $("#edit-promoMaxAge").val()){
			$("#submit").attr("disabled",true);

			if(($("#edit-promoMinAge").val() != "") && ($("#edit-promoMaxAge").val() != "")){
				alert("La edad mínima de la promoción debe ser igual o mayor a la máxima.");
			}

		}
		if($("#edit-promoMinAge").val() <= $("#edit-promoMaxAge").val()){
			$("#submit").attr("disabled",false);
		}

	});
	$("#edit-promoMaxAge").change(function(){

		if($("#edit-promoMinAge").val() > $("#edit-promoMaxAge").val()){
			$("#submit").attr("disabled",true);

			if(($("#edit-promoMinAge").val() != "") && ($("#edit-promoMaxAge").val() != "")){
				alert("La edad mínima de la promoción debe ser igual o mayor a la máxima.");
			}

		}
		if($("#edit-promoMinAge").val() <= $("#edit-promoMaxAge").val()){
			$("#submit").attr("disabled",false);
		}

	});
	/////////////////////////////////////////////////////////////////////////////////////////////

}
