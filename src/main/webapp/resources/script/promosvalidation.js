/**
 * Script to validate dates and ages before submit
 */

window.onload = promosvalidation;

function promosvalidation(){

	//Agregar promociones nuevas
	$("#minordate").change(function(){

		if($("#minordate").val() > $("#majordate").val()){
			$("#okbutton").attr("disabled",true);

			if(($("#minordate").val() != "") && ($("#majordate").val() != "")){
				alert("La fecha de inicio de la promoción debe ser igual o mayor a la de vencimiento.");
			}

		}

		if(($("#minordate").val() <= $("#majordate").val())){
			if(($("#minorage").val() <= $("#majorage").val())){

				$("#okbutton").attr("disabled",false);

			}
		}


	});

	$("#majordate").change(function(){

		if($("#minordate").val() > $("#majordate").val()){
			$("#okbutton").attr("disabled",true);

			if(($("#minordate").val() != "") && ($("#majordate").val() != "")){
				alert("La fecha de inicio de la promoción debe ser igual o mayor a la de vencimiento.");
			}

		}

		if(($("#minordate").val() <= $("#majordate").val())){
			if(($("#minorage").val() <= $("#majorage").val())){

				$("#okbutton").attr("disabled",false);

			}
		}

	});

	$("#minorage").change(function(){

		if($("#minorage").val() > $("#majorage").val()){
			$("#okbutton").attr("disabled",true);

			if(($("#minorage").val() != "") && ($("#majorage").val() != "")){
				alert("La edad mínima de la promoción debe ser igual o mayor a la máxima.");
			}

		}

		if(($("#minorage").val() <= $("#majorage").val())){
			if(($("#minordate").val() <= $("#majordate").val())){

				$("#okbutton").attr("disabled",false);

			}
		}

	});

	$("#majorage").change(function(){

		if($("#minorage").val() > $("#majorage").val()){
			$("#okbutton").attr("disabled",true);

			if(($("#minorage").val() != "") && ($("#majorage").val() != "")){
				alert("La edad mínima de la promoción debe ser igual o mayor a la máxima.");
			}

		}
		if(($("#minorage").val() <= $("#majorage").val())){
			if(($("#minordate").val() <= $("#majordate").val())){

				$("#okbutton").attr("disabled",false);

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
			if(($("#edit-promoMinAge").val() <= $("#edit-promoMaxAge").val())){
				
				$("#submit").attr("disabled",false);
				
			}
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
			if(($("#edit-promoMinAge").val() <= $("#edit-promoMaxAge").val())){
			
				$("#submit").attr("disabled",false);
				
			}
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
			if(($("#edit-promoSince").val() <= $("#edit-promoTo").val())){
			
				$("#submit").attr("disabled",false);
			
			}
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
			if(($("#edit-promoSince").val() <= $("#edit-promoTo").val())){
			
				$("#submit").attr("disabled",false);
			
			}
		}

	});
	/////////////////////////////////////////////////////////////////////////////////////////////

}

