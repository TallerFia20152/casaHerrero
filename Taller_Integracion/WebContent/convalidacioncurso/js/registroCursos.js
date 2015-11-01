jQuery(function ($) {
	  $('.mitooltip').tooltip();
	var comboAlumno = $("#comboAlumno").alumnoSelectize("dynamicOptionsAlumno");
    comboAlumno.enable();
    var comboUniversidad = $("#comboUniversidad").universidadSelectize();
    //$('#comboUniversidad').parent().parent().parent().addClass("ocultar");
    $(document).on("change", '#comboAlumno', function (event) {
        var codcli = $(this).val();
        if (codcli.length) {
        	//validar que no tenga cursos registrados en t_convalidacion_alumno
        	$.ajax({
        		url:"../convalidacion",
               	data:{'f':'verificarSiConvalido','codcli':comboAlumno.getValue()},
               	async:false,
               	datatype:'json',
               	method:'POST',
               	success:function(alumno){
               		console.log(alumno.persona.id+"<>"+comboAlumno.getValue());
               		if(alumno.persona.id!=comboAlumno.getValue()){

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
			                }
			            });
			            
			            comboUniversidad.enable(comboUniversidad.cargarUniversidades());
            
               		}else{
                  		 toastr["error"]("El alumno ya registr&oacute; cursos");
                  		}
                  	}
           	});
        
        
        
        }else{
                    console.log(JSON.stringify("datos"));
        }
    });
    

    
    $(document).on("change", '#comboUniversidad', function (event) {
    	   var coduni = $(this).val();
           if (coduni.length) {
  	 $.ajax({
      	url:"../convalidacion",
      	data:{'f':'obtenerCursosUni','coduni':coduni},
      	datatype:'json',
      	method:'POST',
      	success:function(datos){
      		//console.log(convcurs);
      		
      		if(datos!=null){
      			var nuevafila="";
      		$.each(datos, function (index, curcon) {
      			nuevafila = nuevafila + "<tr data-object='"+JSON.stringify(curcon)+"'>";
      			nuevafila = nuevafila + "<td style='text-align:center;width:30px;'>"+curcon.cantconvalidacion+"</td>";
      			nuevafila = nuevafila + "<td style='text-align:center;'>"+curcon.curso.id+"</td>";
      			nuevafila = nuevafila + "<td >"+curcon.curso.nombre+"</td>";
      			nuevafila = nuevafila + "<td style='text-align:center;'>"+curcon.ciclo.nombre+"</td>";
      			nuevafila = nuevafila + "<td style='text-align:center;'>"+curcon.cursoorigencodigo+"</td>";
      			nuevafila = nuevafila + "<td>"+curcon.cursoorigennombre+"</td>";
      			nuevafila = nuevafila + "<td style='text-align:center;vertical-align: middle;'><input class='chk' type='checkbox' check='false' /></td>";
      			nuevafila = nuevafila + "<tr>";
      			 
      		 });
      		$("#cursosregistrados").empty().append(nuevafila);
      		
      		}else{
      			//$('#comboUniversidad').parent().parent().parent().removeClass("ocultar");
      			 
      			 toastr["error"]("No existen cursos registrados");
      		}
      		
      	}
      	
      });
              
               
           }else{
                       console.log(JSON.stringify("datos"));
           }
    });
       
    $(document).on("change", ':checkbox', function (event) {
    	if(this.checked){
        	//console.log('chequeado');
        		$(this).parent().after("<td class='nota' style='text-align:center;'><input type='text' style='width:30px;'  class='numeros' required='required' maxlength='2'/></td>");
        	}else{
        		console.log($(this).parent().parent().find('.nota'));
        		$(this).parent().parent().find('.nota').remove();
        		//console.log('deschequeado');
        	}
    }); 
    $(document).on("keyup",'.numeros',function(){
    	this.value = (this.value + '').replace(/[^0-9]/g, '');
    });
 

    $(document).on('click', '#agregarcurso', function() {
        var nuevodiv= "";
        nuevodiv+='<div  class="row">';
        nuevodiv+='<div class="col-md-3 col-xs-4 col-sm-3">';
        nuevodiv+='<input type="text" class="codigocurso form-control"  style="text-transform:uppercase;" required="required" placeholder="Codigo de Curso" />';
        nuevodiv+='</div>';
        nuevodiv+='<div class="col-md-4 col-xs-4 col-sm-4">';
        nuevodiv+='<input type="text" class="nombrecurso form-control" style="text-transform:uppercase;" required="required" placeholder="Nombre de Curso" />';
        nuevodiv+='</div>';
        nuevodiv+='<div class="col-md-2 col-xs-4 col-sm-2">';
        nuevodiv+='<input type="text" maxlength="2" class="numeros notacurso form-control" required="required" placeholder="Nota" />';
        nuevodiv+='</div>';
       
        nuevodiv+='<div class="col-md-2 col-xs-8 col-sm-2 mitooltip" data-placement="bottom" title="HASTA 2 MB PERMITIDO">';
        nuevodiv+='<input type="file" name="toBeUploaded" id="toBeUploaded"  class=" toBeUploaded file-loading" data-preview-file-type="any" accept="image/png,image/jpeg,image/jpg,image/bmp" />';
        //nuevodiv+='<label id="msgfile"></label>';
        nuevodiv+='</div>';
       
        nuevodiv+='<div class="col-md-1 col-xs-4 col-sm-1">';
        nuevodiv+='<button type="button" class="borrar btn btn-danger mitooltip"  data-placement="bottom" title="ELIMINAR CURSO">x</button>';
        nuevodiv+='</div>';
       
        nuevodiv+='</div>';
        nuevodiv+='<hr visibility="hidden">';
       
       
        $('#cursosaprobados').append(nuevodiv);
        $('.toBeUploaded').fileinput({
            language: "es",
            previewFileType: "image",
            browseClass: "btn btn-primary btn-block",
            showCaption: false,
            showRemove: false,
            showUpload: false,
            allowedFileExtensions : ['jpg', 'png','jpeg','bmp'],
            maxFilesNum: 1,
            showPreview:false
        });
        $('.mitooltip').tooltip();
        });

    $(document).on('click', '.borrar', function() {
        //$(this).parent().prev().children("input").remove();
        $(this).parent().parent().remove();
    });
    
    
    //envio total
    $(document).on("submit", '#form', function(event) {
    	event.preventDefault();
    	var convalidacionalumno=[];
    	var convalidacion=[];
    	//los obtenidos del historico
    	$("#cursosregistrados tr").each(function(){
    		//console.log(this);
    		if(($(this).find('.chk')).is(':checked')){
    			convalidacionalumno.push({
        			'cursoorigencodigo':$(this).data("object").cursoorigencodigo,
        			'cursoorigennombre':$(this).data("object").cursoorigennombre,
        			'alumno':comboAlumno.getValue(),
        			'nota':$(this).find('.numeros').val(),
        			'universidadorigen':comboUniversidad.getValue()
        		});
    			convalidacion.push({
    				'plancurricular':$(this).data("object").plancurricular.id
    				,
    				'curso':$(this).data("object").curso.id
    				,
    				'codigocursoorigen':$(this).data("object").cursoorigencodigo,
    				'alumno':comboAlumno.getValue()
    	    	});
    			
    		}
    		
    	});
    	//los nuevos a registrar
    	$("#cursosaprobados .row").each(function(){
    		convalidacionalumno.push({
    			'cursoorigencodigo':$(this).find('.codigocurso').val(),
    			'cursoorigennombre':$(this).find('.nombrecurso').val(),
    			'alumno':comboAlumno.getValue(),
    			'nota':$(this).find('.notacurso').val(),
    			'universidadorigen':comboUniversidad.getValue()
    		});
    		
    	});
    	
    	
    	
    	
    	var ajaxdata={'f':'registrarCursos','convalidacionesalumno':JSON.stringify(convalidacionalumno),'convalidaciones':JSON.stringify(convalidacion)};
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
					 limpiarCampos();
				} else {
					console.log(datos);
					toastr["warning"](datos);
				}
			}
		});
    	
    });
    
    function limpiarCampos(){
    	comboAlumno.clear();
    	comboUniversidad.clear();
    	comboUniversidad.disable();
    	$('#cursosregistrados').empty();
    	$('#cursosaprobados').empty();
    }
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


