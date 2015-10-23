$(document).ready(function () {
    var comboAlumno = $("#comboAlumno").alumnoSelectize("dynamicOptionsAlumno");
    comboAlumno.enable();
    $(document).on("change", '#comboAlumno', function (event) {
        var codcli = $(this).val();
        if (codcli.length) {

            $.ajax({
                url: "../convalidacion",
                data: {'f': 'obtenerEstadoCurso','codalu':codcli},
                dataType: 'json',
                method: 'POST',
                success: function (datos) {
                    console.log(JSON.stringify(datos.persona.id));
                    
                    
                    
                }
            });
        }else{
                    console.log(JSON.stringify("datos"));
        }
    });


});
