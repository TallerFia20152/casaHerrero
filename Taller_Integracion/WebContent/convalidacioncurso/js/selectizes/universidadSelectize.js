(function($) {
	$.fn.universidadSelectize = function(options) {
		var $root = this;

		var defaultOptions = {
			valueField : 'id',
			labelField : 'nombre',
			searchField : [ 'id', 'nombre' ],
			sortField : 'nombre',
			options : [],
			maxItems : 1
		};

		var comboUniversidades = $root.selectize($.extend(defaultOptions,
				options))[0].selectize;

		var methods = {
			"cargarUniversidades" : function() {

				var xhr;
				comboUniversidades.unlock();
				comboUniversidades.clearOptions();
				comboUniversidades.load(function(callback) {
					xhr = $.getJSON('../convalidacion?f=listarUniversidades')
							.done(function(datos) {
								callback(datos);
							}).fail(function(error) {
								if (error)
									console.log(error);
								callback();
							});
				}

				);
				
				return xhr;
			}
		};
		return $.extend(comboUniversidades, methods);
	};
})(jQuery);