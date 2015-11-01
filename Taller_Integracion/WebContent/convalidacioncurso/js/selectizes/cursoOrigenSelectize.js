(function($) {
	$.fn.cursoOrigenSelectize = function(options) {
		var $root = this;
//solo cursos que faltan convalidar
		var defaultOptions = {
			valueField : 'codigo',
			labelField : 'nombre',
			searchField : [ 'codigo', 'nombre' ],
			sortField : 'nombre',
			options : [],
			maxItems : 1
		};

		var comboCursosOrigen = $root.selectize($.extend(defaultOptions,options))[0].selectize;

		var methods = {
			"cargarCursosOrigen" : function(codcli) {

				var xhr;
				comboCursosOrigen.unlock();
				comboCursosOrigen.clearOptions();
				comboCursosOrigen.load(function(callback) {
					//console.log({'f':'obtenerCursosOrigen','codcli':codcli});
					xhr=$.ajax({
                    	url:"../convalidacion",
                    	data:{'f':'obtenerCursosOrigen','codcli':codcli},
                    	datatype:'json',
                    	method:'POST',
                    	success:function(convcurs){
                    	//	console.log(convcurs);
                    		
                    		if(convcurs!=null){
                    			var Array=[];
                    		$.each(convcurs, function (index, curcon) {
                    			Array.push({
                    				'codigo':curcon.cursoorigencodigo,
                    				'nombre':curcon.cursoorigennombre});
                    			 
                    		 });
                    		callback(Array);
                    		}
                    	}
                    	
                    });
					
					
					});
				
				return xhr;
			},
			"cargarCursos" : function(listacursos) {

				var xhr;
				comboCursosOrigen.unlock();
				comboCursosOrigen.clearOptions();
				comboCursosOrigen.load(function(callback) {
					xhr = callback(listacursos);
					});
				
				return xhr;
			}
			
			
		};
		return $.extend(comboCursosOrigen, methods);
	};
})(jQuery);