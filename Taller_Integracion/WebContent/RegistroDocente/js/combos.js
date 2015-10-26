$( document ).ready(function() {
	var global_coddpto="";
	var optionVacio='<option value="0" selected="true" disabled="disabled">Seleccionar</option>';
	var TotalGrupoCombos = $("select[id*='combo_']").length/3;

	//cargar combo departamentos
		$.ajax({
		  url: "ubigeo",
		  method: "POST",
		  data: { f : "listarDepartamentos" },
		  dataType: "json",
		  
		}).done(function( departamentos ) {
			
			for(var i=1; i<=TotalGrupoCombos;i++){
			
			var combo_departamento = $('#combo_departamentos_'+i);
				
				$(departamentos).each(function(y, v){
					if(y==0)
					$('#combo_departamentos_'+i).append(optionVacio);
					$('#combo_departamentos_'+i).append('<option value="' + v.coddpto + '">' + v.nombre + '</option>');
	            })
			}
			
		});
		
	//cargar combo provincias
	$("select[id*='combo_departamento']").on('change', function() {
	global_coddpto=this.value;
	var grupo=this.id.slice(20);
	var combo_provincias=$('#combo_provincias_'+grupo);
	var combo_distritos=$('#combo_distritos_'+grupo);
		$.ajax({
				  url: "ubigeo",
				  method: "POST",
				  data: { f : "listarProvincias",
					  coddpto:global_coddpto},
				  dataType: "json",
				  
		}).done(function( provincias ) {
			combo_distritos.find('option').remove();
			combo_distritos.prop('disabled', true);
			combo_provincias.find('option').remove();;
			combo_provincias.prop('disabled', false);
			$(provincias).each(function(i, v){ 
				{
					if(i==0){
						combo_provincias.append(optionVacio);
						combo_distritos.append(optionVacio);
					}
				}
				combo_provincias.append('<option value="' + v.codprov + '">' + v.nombre + '</option>');
				});
			});
	});
// carga combo distritos
	$("select[id*='combo_provincias']").on('change', function() {

		var grupo=this.id.slice(17);
		var combo_distritos=$('#combo_distritos_'+grupo);
		console.log(grupo);
		$.ajax({
				  url: "ubigeo",
				  method: "POST",
				  data: { f : "listarDistritos",
					  coddpto:global_coddpto,
					  codprov:this.value},
				  dataType: "json",
				  
		}).done(function( distritos ) {
			combo_distritos.prop('disabled', false);
			combo_distritos.find('option').remove();
			$(distritos).each(function(i, v){ 
				if(i==0)
					combo_distritos.append(optionVacio);
					combo_distritos.append('<option value="' + v.coddist + '">' + v.nombre + '</option>');
				});
			});
	});
	
	
});

