$(document).ready(function () {
	
	var comboAlumno = $("#comboAlumno").alumnoSelectize("dynamicOptionsAlumno");
    comboAlumno.enable();
    var ArrayCursosOrigen=[];
    //$(document).ajaxStop($.unblockUI);
    //var ArrayCursosConvalidados=[];
    //var ArrayCursosNoConvalidados=[];
    
    $(document).on("change", '#comboAlumno', function (event) {
    	//$.blockUI({ message: "Espere mientras se cargan los datos" });
    	var codcli = $(this).val();
        //listamos los cursos registrados por el alumno
         
        //setTimeout($.unblockUI, 4000); 
    	
    	$.ajax({
    		url:"../convalidacion",
           	data:{'f':'verificarSiConvalido','codcli':codcli},
           	async:false,
           	datatype:'json',
           	method:'POST',
           	success:function(alumno){
           		console.log(alumno.persona.id+"<>"+comboAlumno.getValue());
           		if(alumno.persona.id!=comboAlumno.getValue()){
           			
           		 $.ajax({
                    	url:"../convalidacion",
                    	async:false,
                    	data:{'f':'obtenerCursosOrigen','codcli':codcli},
                    	datatype:'json',
                    	method:'POST',
                    	success:function(convcurs){
                    		//console.log(convcurs);
                    		
                    		if(convcurs!=null){
                    		$.each(convcurs, function (index, curcon) {
                    			ArrayCursosOrigen.push({
                    				'cursoorigencodigo':curcon.cursoorigencodigo,
                    				'cursoorigennombre':curcon.cursoorigennombre});
                    			 
                    		 });
                    		}else{
                    			 toastr["error"]("El alumno no tiene cursos registrados");
                    		}
                    	}
                    	
                    });
               	//console.log(ArrayCursosOrigen);	
                 
                 if (codcli.length) {
                 	
                     $.ajax({
                         url: "../convalidacion",
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
           			
           			
           			
           		}else{
           		 toastr["error"]("El alumno ya realiz&oacute; el proceso de convalidaci&oacute;n");
           		}
           	}
    	});
       

    });
    
    
    
  
   function CargarPlanEstudios(_codcli){
	   // blockUI
//	   $.blockUI({
//           message: "<p>Espere mientras hacemos la verificaci&oacute;n</p>"
//       });
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
	                // traer convalidaciones del plan existentes
	                //nuevafila = nuevafila + traerConvalidacion(detalle);
	                // fin-traer convalidaciones del plan existentes
	                nuevafila = nuevafila + "</tr>";
	            });
	            $('#cursosplan').empty().append(nuevafila);
	        },
	        error: function (res) {
	            // toastr["error"]("Ocurrió un error al obtener Estado");
	            //console.log(res);
	        }
	        
	    });
	   
	   
	   
	   agregarCursosOrigen();
   };
   function agregarCursosOrigen(){
	   $('#cursosplan .condata').each(function () {
		   var tdadd ="";
		   var contadortd=0;
		   //console.log({'codcur':$(this).data("object").curso.id,
	        //		  'codplan':$(this).data("object").plancurricular.id});
//		   $.blockUI({
//	           message: "<p>Espere mientras hacemos la verificaci&oacuete;n</p>"
//	       });
		   $.ajax({
	        	url:"../convalidacion",
	        	async:false,
	        	data:{'f':'buscarEnConvalidacion',
	        		  'codcur':$(this).data("object").curso.id,
	        		  'codplan':$(this).data("object").plancurricular.id},
	        	datatype:'json',
	        	method:'POST',
	        	success:function(datos){
	        		
	        		
	        		// traera los cursos equivalentes a este detalle
	        		if(datos.length!==0){
	        			//console.log(datos);
	        			tdadd="<td style='text-align:center;' class='envioterminar' ";	
	        		for(var j=0;j<datos.length;j++){
	        		
	        			// si está, pinta al lado y borra de lista
	        			
		        			for(var n=0;n<ArrayCursosOrigen.length;n++){
		        		//		console.log(ArrayCursosOrigen[n]+" "+datos[j]);
		        				if(datos[j].cursoorigencodigo==ArrayCursosOrigen[n].cursoorigencodigo){
		        					//pinta curso al lado
		        					tdadd = tdadd + "data-object='"+JSON.stringify(ArrayCursosOrigen[n])+"'>";
		        					tdadd = tdadd + ArrayCursosOrigen[n].cursoorigencodigo + " "+ArrayCursosOrigen[n].cursoorigennombre;
		        					//borra de la lista
		        					for(var i=0;i<ArrayCursosOrigen.length;i++){
		        						//console.log(datos[j].cursoorigencodigo+ " " +ArrayCursosOrigen[i].cursoorigencodigo);
		        			    		if(datos[j].cursoorigencodigo==ArrayCursosOrigen[i].cursoorigencodigo){
		        			    			delete ArrayCursosOrigen[i];
		        			    			ArrayCursosOrigen.splice(i,1);
		        			    			contadortd++;
		        			    		}
		        			    	}
		        					
		        					
		        				}	
		        			}
	        		 }
	        		
	        		//console.log(contadortd);
	        		//console.log(datos.length);
	        		//si es mas de un curso y el alumno no los tiene
	        		if(contadortd != datos.length && contadortd!=0 && datos.length!=0){

	        			tdadd = tdadd +"Falta(n) Curso(s) para convalidar<br/>";
	        		}
	        		tdadd = tdadd +"</td>";
	        			
	        		}
	        	}
	        });
		   //console.log(tdadd);
		   $(this).append(tdadd);

		   pintarsinhistorico();
		   //console.log(JSON.stringify(ArrayCursosOrigen));
		   
     });

	   toastr["success"]("Carga de datos Exitosa");
   };
   function pintarsinhistorico(){
	   var nuevafila="";
	   //console.log("marco");
	   //console.log(ArrayCursosOrigen);
		for(var n=0;n<ArrayCursosOrigen.length;n++){
			nuevafila = nuevafila + "<tr data-object='"+JSON.stringify(ArrayCursosOrigen[n])+"'>";
			nuevafila = nuevafila + "<td>"+ArrayCursosOrigen[n].cursoorigencodigo +"</td>";
			nuevafila = nuevafila + "<td class='nombrecursoorigen' style='cursor:pointer;'>"+ArrayCursosOrigen[n].cursoorigennombre +"</td>";
			nuevafila = nuevafila + "</tr>";
		}
		$("#cursosorigen").empty().append(nuevafila);
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


