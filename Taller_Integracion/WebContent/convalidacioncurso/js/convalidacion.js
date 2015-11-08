jQuery(function ($) {
	//var app = angular.module('myApp',['ngDragDrop']);
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
                			nuevafila = nuevafila + "<td style='width: 110px;' ><div class='contenedor dropado'><div class='movible' style='cursor:pointer;'>"+curcon.cursoorigencodigo +"</div></div></td>";
                			nuevafila = nuevafila + "<td class='nombrecursoorigen' style='cursor:pointer;'>"+curcon.cursoorigennombre +"</td>";
                			nuevafila = nuevafila + "</tr>";
                			
                			ArrayCursosOrigen.push({
                				'codigo':curcon.cursoorigencodigo,
                				'nombre':curcon.cursoorigennombre
                			});
                			
                     		});
                     		$("#cursosorigen").empty().append(nuevafila);

                     		
                     		
                     		$(".movible").draggable({ 
                     			 
                     			cursorAt: { top: 8, left: 50 },
                     			revert:true,
                     			start: function( event, ui ) {
                     				var idcuerpo=$(this).parent().parent().parent().attr("id");
                     				if(idcuerpo=='cursosorigen'){
            	            			console.log('idcuerpo');
            	            		}else{
            	            			$(this).parent().removeClass("dropado").addClass('dropvacio');
            	            		}
                     			},
                     			stop: function( event, ui ) {
                     				//var idcuerpo=$(this).parent().parent().parent().attr("id");
                     					$(this).parent().removeClass("dropvacio").addClass('dropado');
                     			},
//                     			cursor: "move",
                     			helper:"original",
                     			revertDuration: 0,
                     			scrollSpeed: 0
                     				
                     		});
                     		
                     	     var nav = $('#navcur');
                             var pos = nav.offset();
                             var h = $('#navcur').height();
                             var w = $('#navcur').width();
                             $('#navcur').css("height", h);
                             $('#navcur').css("width", w);
                             $(window).on('scroll', function() {
                             	//console.log($(this).scrollTop());
                             	//console.log(pos.top);
                                 if ($(this).scrollTop() >= (pos.top - 73)) {
                                     nav.addClass('fijocur');
                                 } else {
                                     nav.removeClass('fijocur');
                                 }
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
                             //barra estatica
                             var nav = $('#datosalumno');
                             var pos = nav.offset();
                             var h = $('#datosalumno').height();
                             //var w = $('#datosalumno').width();
                             $('#datosalumno').css("height", h);
                             $('#datosalumno').css("width", "100%");
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
    
    $(document).on('mouseover', '.movible', function (event) {
        ($(this)).addClass("over");
    });
    $(document).on('mouseout', '.movible', function (event) {
        ($(this)).removeClass("over");
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
	                nuevafila = nuevafila + "<td style='text-align:center;'><div class='contenedor dropvacio' id='curusmp"+index+"'></div></td>";
	                //nuevafila = nuevafila + "<td style='text-align:center;width:400px;'>" + "<select class='ccOrigen' id='cursosorigen"+index+"'> </select>" + "</td>";
	                nuevafila = nuevafila + "</tr>";
	                
	                
	            });
	            $('#cursosplan').empty().append(nuevafila);
	            
	            
	            
	            $(".contenedor").droppable({
	            	tolerance:'intersect',
	            	accept:'.movible',
	            	drop:function(event,ui){
	            		var idcuerpo=$(this).parent().parent().parent().attr("id");
	            		//si drop en tabla derecha
	            		if(idcuerpo=='cursosorigen'){
	            			var curact = ($(this).parent().parent()).data('object');
	            			// si pertenece a ese tdt
	            			if(curact.cursoorigencodigo==ui.draggable.html()){
	            				//si esta vacio
	            				if($(this).children().length==0){
	    	            			$(this).removeClass("dropvacio").addClass("dropado");
	    		            		$(this).append(ui.draggable);	
	    	            		}
	            			}
	            			
	            		}else{
	            			 //si esta vacio
	            			if($(this).children().length==0){
		            			$(this).removeClass("dropvacio").addClass("dropado");
			            		$(this).append(ui.draggable);	
		            		}
	            		}
	            		
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
    	$('#cursosplan .contenedor').each(function (){

    		var detalle = ($(this).parent().parent()).data("object");
    		var divorigen = $(this).children();
        	//console.log(detalle);
    		
        	if(divorigen.length==1){
    		ajaxdata.push({
        			'plancurricular':detalle.plancurricular.id
        			,
        			'curso':detalle.curso.id
        			,
        			'codigocursoorigen':divorigen.text().trim(),
        			'alumno':comboAlumno.getValue()
        	});
        	}
    	});
    	console.log(ajaxdata);
    	if(ajaxdata.length>=1){
    		 $.blockUI({
    	           message: "<p>Registrando Convalidaciones</p>"
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
            			toastr["error"]("Error al registrar");
            		}
            	}	
        		
        	});
    	}else{
    		toastr["warning"]("Verifique los datos");
    	}
   
    	
    	
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


