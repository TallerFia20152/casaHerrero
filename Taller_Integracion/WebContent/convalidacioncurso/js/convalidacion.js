$(document).ready(function () {
	
	var comboAlumno = $("#comboAlumno").alumnoSelectize("dynamicOptionsAlumno");
    comboAlumno.enable();
    
    
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
    
            
        }else{
                    console.log(JSON.stringify("datos"));
        }
    });
    
    
});


