(function($) {

	$.fn.sexoSelectize = function(options) {
		var $root = this;

		var defaultOptions = {
			valueField : 'id',
			labelField : 'nombre',
			searchField : [ 'id', 'nombre' ],
			sortField : 'nombre',
			options : [],
			maxItems : 1
		};

		var comboSexo = $root.selectize($.extend(defaultOptions, options))[0].selectize;

		var methods = {
			"cargarSexo" : function(coddep) {
				var xhr;
				comboSexo.clearOptions();
				comboSexo.load(function(callback) {
					var sexjson = [];
					sexjson.push({
						'id' : '1',
						'nombre' : 'MASCULINO'
					});
					sexjson.push({
						'id' : '2',
						'nombre' : 'FEMENINO'
					});
					xhr = callback(sexjson);
				});
				return xhr;
			}
		};

		return $.extend(comboSexo, methods);
	};
})(jQuery);
