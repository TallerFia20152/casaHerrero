$(document).ready(function() {

	
	var comboDistrito = $("#comboDistrito").distritoSelectize();
	var comboEspecial = $("#comboEspecialidad").especialidadSelectize();
	var comboModalidad = $("#comboModalidad").modalidadSelectize();
	var comboSexo = $("#sexo").sexoSelectize();

	
	comboDistrito.enable(comboDistrito.cargarDistrito('1'));
	comboEspecial.enable(comboEspecial.cargarEspecialidad('9'));
	comboModalidad.enable(comboModalidad.cargarModalidad());
	comboSexo.enable(comboSexo.cargarSexo());

	$(document).on("submit", '#login', function(event) {
		event.preventDefault();

		var ajaxdata = {
			'f' : 'registrarAlumno',
			'id' : $('#id').val(),
			'nom' : $('#nom').val(),
			'apepat' : $('#apepat').val(),
			'apemat' : $('#apemat').val(),
			'sexo' : $('#sexo').val(),
			'dni' : $('#dni').val(),
			'fecnac' : $('#fecnac').val(),
			'dir' : $('#dir').val(),
			'numcel' : $('#numcel').val(),
			'numcas' : $('#numcas').val(),
			'mod' : comboModalidad.getValue(),
			'dis' : comboDistrito.getValue(),
			'especialidad' : comboEspecial.getValue()
		// ,'universidad':comboUniversidad.getValue()

		};

		console.log(JSON.stringify(ajaxdata));
		$.ajax({
			url : "../registrodatos",
			data : ajaxdata,
			dataType : 'json',
			type : 'POST',
			success : function(datos) {
				if (datos == "OK") {
					console.log(datos);
					 toastr["success"]("Registro Exitoso");
				} else {
					console.log(datos);
					toastr["warning"]("Error al Registrar");
				}
			}
		});

	});
	function soloNumeros(tecla) {
		if(tecla.charCode < 48 || tecla.charCode > 57) return false;
	}

	$('#numcel').on('keypress',function(event){
		soloNumeros(event);
	});
	$('#id').on('keypress',function(event){
		soloNumeros(event);
	});
	$('#numcas').on('keypress',function(event){
		soloNumeros(event);
	});
	$('#dni').on('keypress',function(event){
		soloNumeros(event);
	});
	
    toastr.options = {
            "timeOut": 3000,
            newestOnTop: false,
            hideDuration: 500,
            "extendedTimeOut": 4000,
            "closeButton": true,
            "positionClass": "toast-bottom-right",
            "debug": false,
            "tapToDismiss": false
        };
});
