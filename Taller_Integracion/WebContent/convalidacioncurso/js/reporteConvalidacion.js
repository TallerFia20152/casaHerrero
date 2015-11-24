jQuery(function ($) {

	var comboAlumno = $("#comboAlumno").alumnoSelectize("dynamicOptionsAlumno");
    comboAlumno.enable();

    var ArrayCursosOrigen=[];
    $(document).ajaxStop($.unblockUI);
    //var ArrayCursosConvalidados=[];
    //var ArrayCursosNoConvalidados=[];
    
    
    
    $(document).on("change", '#comboAlumno', function (event) {

    	var codcli = $(this).val();
                 if (codcli.length) {
                	 $.ajax({
                     	url:"../convalidacion",
                     	async:false,
                     	data:{'f':'obtenerCursosOrigen','codcli':comboAlumno.getValue()},
                     	datatype:'json',
                     	method:'POST',
                     	success:function(convcurs){
                     		//console.log(convcurs);
                     		if(convcurs!=null){
                     		var nuevafila="";
                     		$.each(convcurs, function (index, curcon) {
                     		nuevafila = nuevafila + "<tr data-object='"+JSON.stringify(curcon)+"'>";
                			nuevafila = nuevafila + "<td style='width: 110px;text-align:center;' >"+curcon.cursoorigencodigo +"</td>";
                			nuevafila = nuevafila + "<td class='nombrecursoorigen' style='cursor:pointer;'>"+curcon.cursoorigennombre +"</td>";
                			nuevafila = nuevafila + "<td style='cursor:pointer;text-align:center;'>"+curcon.nota +"</td>";
                			nuevafila = nuevafila + "</tr>";
                     		});
                     		$("#cursosorigen").empty().append(nuevafila);

                     		
                     		
                     		
                     	}
                     	
                     }
                	 });
 						console.log("datos a enviar");
 						console.log({'f':'listarCursosConvalidados','codalu':comboAlumno.getValue()});
                	 $.ajax({
                      	url:"../convalidacion",
                      	async:false,
                      	data:{'f':'listarCursosConvalidados','codalu':comboAlumno.getValue()},
                      	datatype:'json',
                      	method:'POST',
                      	success:function(convcurs){
                      		console.log(convcurs);
                      		if(convcurs!=null){
                      		var nuevafila="";
                      		$.each(convcurs, function (index, curcon) {
                      		nuevafila = nuevafila + "<tr data-object='"+JSON.stringify(curcon)+"'>";
                 			nuevafila = nuevafila + "<td style='text-align:center;' >"+curcon.cursoorigencodigo +"</td>";
                 			nuevafila = nuevafila + "<td style='cursor:pointer;'>"+curcon.cursoorigennombre +"</td>";
                 			nuevafila = nuevafila + "<td style='cursor:pointer;text-align:center;'>"+curcon.curso.id +"</td>";
                 			nuevafila = nuevafila + "<td style='cursor:pointer;text-align:center;'>"+curcon.curso.nombre +"</td>";
                 			nuevafila = nuevafila + "</tr>";
                 			
                 			
                 			
                      		});
                      		$("#convalidados").empty().append(nuevafila);

                      		
                      		
                      		
                      	}
                      	
                      }
                 	 });
                	 
                	 
              	   $.blockUI({
                       message: "<p>Cargando datos del alumno</p>"
                   });

                	 
                	 
                     $.ajax({
                         url: "../convalidacion",
                         async:false,
                         data: {'f': 'obtenerDatosAlumno','codalu':codcli},
                         dataType: 'json',
                         method: 'POST',
                         success: function (datos) {
                             //console.log(JSON.stringify(datos));
                             $('#codigo').empty().append(datos.persona.id);
                             $('#apellidos').empty().append(datos.persona.apellidopaterno + ' '+datos.persona.apellidomaterno);
                             $('#nombres').empty().append(datos.persona.nombre);
                             $('#facultad').empty().append(datos.facultad.nombre);
                             $('#escuela').empty().append(datos.especialidad.nombre);
                             $('#nomplan').empty().append('PLAN DE ESTUDIOS DE '+datos.especialidad.nombre);
                         }
                     });
//                     // empieza carga de plan
//                     	CargarPlanEstudios(codcli);
                     	
                     
                 }

    });
    comboAlumno.on("clear", function () {
        
    	ArrayCursosOrigen=[];
    	$("#cursosorigen").empty();
    	$('#cursosplan').empty();
    	 $('#codigo').empty();
         $('#apellidos').empty();
         $('#nombres').empty();
         $('#facultad').empty();
         $('#escuela').empty();
         $('#nomplan').empty();
    	
    });
	
});


