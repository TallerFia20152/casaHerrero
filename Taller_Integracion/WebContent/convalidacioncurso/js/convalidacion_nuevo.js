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
                     	data:{'f':'obtenerCursosOrigen','codcli':codcli},
                     	datatype:'json',
                     	method:'POST',
                     	success:function(convcurs){
                     		//console.log(convcurs);
                     		if(convcurs!=null){
                     		var nuevafila="";
                     		$.each(convcurs, function (index, curcon) {
                     		nuevafila = nuevafila + "<tr data-object='"+JSON.stringify(curcon)+"'>";
                			nuevafila = nuevafila + "<td><div style='width:100px;border:solid 1px;cursor:pointer;text-align:center;' id='curori"+index+"' class='ui-widget-content movible'>"+curcon.cursoorigencodigo +"</div></td>";
                			nuevafila = nuevafila + "<td class='nombrecursoorigen' style='cursor:pointer;'>"+curcon.cursoorigennombre +"</td>";
                			nuevafila = nuevafila + "</tr>";
                			
                			ArrayCursosOrigen.push({
                				'codigo':curcon.cursoorigencodigo,
                				'nombre':curcon.cursoorigennombre
                			});
                			
                     		});
                     		$("#cursosorigen").empty().append(nuevafila);
                     		$(".movible").draggable({ 
                     			cursor: "move", 
                     			cursorAt: { top: 8, left: 50 },
                     			revert:true
                     			//helper:'clone'
                     				
                     		});
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
                             
                             var nav = $('#datosalumno');
                             var pos = nav.offset();
                             var h = $('#datosalumno').height();
                             $('#datosalumno').css("height", h);
                             $(window).on('scroll', function() {
                             	//console.log($(this).scrollTop());
                             	//console.log(pos.top);
                                 if ($(this).scrollTop() >= (pos.top)) {
                                     nav.addClass('fijo');
                                 } else {
                                     nav.removeClass('fijo');
                                 }
                             });
                         }
                     });
                     // empieza carga de plan
                     	CargarPlanEstudios(codcli);
                     	
                     
                 }

    });
  
   function CargarPlanEstudios(_codcli){
	   // blockUI
	   $.blockUI({
           message: "<p>Espere mientras cargamos los datos</p>"
       });
	   $.ajax({
	        url: "../convalidacion",
	        data: {'f': 'convalidacion','codalu':_codcli},
	        async:false,
	        dataType: 'json',
	        method: 'POST',
	        success: function (cursosjson) {
	            //console.log(JSON.stringify(cursosjson));
	            var nuevafila;
	            var ciclo = '00';
	            $.each(cursosjson, function (index, detalle) {
	                // console.log(JSON.stringify(cursosjson));
	                nuevafila = nuevafila + (ciclo !== detalle.ciclo.nombre ? "<tr data-object='{id:00}'><td colspan='3' style='text-align:center;'>" + detalle.ciclo.nombre + "</td></tr>" : "");
	                ciclo = detalle.ciclo.nombre;
	                nuevafila = nuevafila + "<tr class='condata' data-object='" + JSON.stringify(detalle) + "' style='font-size:14px;'>";
	                nuevafila = nuevafila + "<td style='text-align:center;'>" + detalle.curso.id + "</td><td style='cursor:pointer'>" + detalle.curso.nombre + "</td>";
	                nuevafila = nuevafila + "<td style='text-align:center;'>" + detalle.creditos + "</td>";
	                nuevafila = nuevafila + "<td style='text-align:center;'><div class='contenedor' id='curusmp"+index+"' style='border:dashed 1px;width:100px;height:18px;margin:2px;' ></div></td>";
	                //nuevafila = nuevafila + "<td style='text-align:center;width:400px;'>" + "<select class='ccOrigen' id='cursosorigen"+index+"'> </select>" + "</td>";
	                nuevafila = nuevafila + "</tr>";

	            });
	            $('#cursosplan').empty().append(nuevafila);
	            $(".contenedor").droppable({
	            	tolerance:'intersect',
	            	accept:'.movible',
	            	drop:function(event,ui){
	            		var id = $(ui.dragable).attr('id');
	            		var ele = $(ui.draggable).html();
	            		var container = $(this).attr('id');
	            		$("#"+id).appendChild("#"+container);
	            	}
	            });

	        },
	        error: function (res) {
	            // toastr["error"]("Ocurrió un error al obtener Estado");
	            //console.log(res);
	        }
	        
	    });
	   
	   
	   
	   //agregarCursosOrigen();
   };
      
    
   $(document).on("click", '.nombrecursoorigen', function (event) {
    
        //console.log($(this).parent().data("object"));
        VerSilabo(($(this).parent()).data("object").cursoorigencodigo);
        
    });

    function VerSilabo(codigo) {
    	alert("se mostrar&aacute; el silabo")
       // console.log(codigo);
    }
    
    $('#terminar').on('click', function () {
    		//insertamos
    	
    	var ajaxdata=[];
    	$('#cursosplan .envioterminar').each(function (){
    		var detalle = ($(this).parent()).data("object");
        	//console.log(detalle);
        	var curori=$(this).data("object");
        	if($(this).text()!=""){
        		
        	
    		ajaxdata.push({
        			'plancurricular':detalle.plancurricular.id
        			,
        			'curso':detalle.curso.id
        			,
        			'codigocursoorigen':curori.cursoorigencodigo,
        			'alumno':comboAlumno.getValue()
        	});
        	}
    	});
    	
    	$.ajax({
    		url:"../registrodatos",
        	data:{'f':'registrarConvalidacion','listadata':JSON.stringify(ajaxdata)},
        	datatype:'json',
        	method:'POST',
        	success:function(datos){
        		if(datos=="OK"){
        			toastr["success"]("Registro Exitoso");
        			comboAlumno.clear();
        	    	$('#cursosplan').empty();
        		}else{
        			toastr["warning"]("Error al registrar");
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


