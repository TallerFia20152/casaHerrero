$(document).ready(function () {
	  $('.mitooltip').tooltip();
	var comboAlumno = $("#comboAlumno").alumnoSelectize("dynamicOptionsAlumno");
    comboAlumno.enable();
    var comboUniversidad = $("#comboUniversidad").universidadSelectize();
    
    $(document).on("change", '#comboAlumno', function (event) {
        var codcli = $(this).val();
        if (codcli.length) {
        	
            $.ajax({
                url: "../convalidacion",
                data: {'f': 'obtenerDatosAlumno','codalu':codcli},
                dataType: 'json',
                method: 'POST',
                success: function (datos) {
                    console.log(JSON.stringify(datos));
                    $('#codigo').empty().append(datos.persona.id);
                    $('#apellidos').empty().append(datos.persona.apellidopaterno + ' '+datos.persona.apellidomaterno);
                    $('#nombres').empty().append(datos.persona.nombre);
                    $('#facultad').empty().append(datos.facultad.nombre);
                    $('#escuela').empty().append(datos.especialidad.nombre);
                }
            });
            comboUniversidad.enable(comboUniversidad.cargarUniversidades());
            
        }else{
                    console.log(JSON.stringify("datos"));
        }
    });

    $(document).on('click', '#agregarcurso', function() {
        var nuevoForm= "";
        nuevoForm+='<div  class="row">';
        nuevoForm+='<div class="col-md-3 col-xs-10 col-sm-3">';
        nuevoForm+='<input type="text" class="codigocurso form-control" placeholder="Codigo de Curso" />';
        nuevoForm+='</div>';
        nuevoForm+='<div class="col-md-4 col-xs-12 col-sm-4">';
        nuevoForm+='<input type="text" class="nombrecurso form-control" placeholder="Nombre de Curso" />';
        nuevoForm+='</div>';
        nuevoForm+='<div class="col-md-2 col-xs-3 col-sm-2">';
        nuevoForm+='<input type="text" class="notacurso form-control" placeholder="Nota" />';
        nuevoForm+='</div>';
        nuevoForm+='<div class="col-md-1 col-xs-1 col-sm-1">';
        nuevoForm+='<button type="button" class="borrar btn btn-danger mitooltip"  data-placement="bottom" title="ELIMINAR CURSO">x</button>';
        nuevoForm+='</div>';
        nuevoForm+='<hr style="visibility: hidden">';
        nuevoForm+='</div>';
        $('.mitooltip').tooltip();
        $('#cursosaprobados').append(nuevoForm);
        });

    $(document).on('click', '.borrar', function() {
        //$(this).parent().prev().children("input").remove();
        $(this).parent().parent().remove();
    });
    
    $(document).on("submit", '#form', function(event) {
    	event.preventDefault();
    	var convalidacionalumno=[];
    	$("#cursosaprobados .row").each(function(){
    		convalidacionalumno.push({
    			'cursoorigencodigo':$(this).find('.codigocurso').val(),
    			'cursoorigennombre':$(this).find('.nombrecurso').val(),
    			'alumno':comboAlumno.getValue(),
    			'nota':$(this).find('.notacurso').val(),
    			'universidadorigen':comboUniversidad.getValue()
    		});
    		
    	});
    	var ajaxdata={'f':'registrarCursos','convalidaciones':JSON.stringify(convalidacionalumno)};
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


