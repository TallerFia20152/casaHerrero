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
                    $('#apellidos').empty().append(datos.persona.apellido_paterno + ' '+datos.persona.apellido_materno);
                    $('#nombres').empty().append(datos.persona.nombre);
                    $('#documentos').empty().append(datos.dni);
                    $('#domicilio').empty().append(datos.direccion);
                    $('#telefonos').empty().append(datos.numero_casa + ' - ' +datos.numero_celular);
                    $('#correos').empty().append(datos.persona.email);
                    $('#fecnac').empty().append(datos.fecha_nacimiento);
                    $('#sexcli').empty().append(datos.persona.sexo);
                    
                }
            });
        }else{
                    console.log(JSON.stringify("datos"));
        }
    });


});


