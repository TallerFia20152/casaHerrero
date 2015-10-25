
(function ($) {
    
    $.fn.especialidadSelectize = function (options) {
        var $root = this;

        var defaultOptions = {
            valueField: 'id',
            labelField: 'nombre',
            searchField: ['id', 'nombre'],
            sortField: 'nombre',
            options: [],
            maxItems: 1
        };

        var comboEspecialidad = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
            "cargarEspecialidad": function (codfac) {
                var xhr;
                comboEspecialidad.clearOptions();
                comboEspecialidad.load(function (callback) {
                    xhr = $.getJSON('../convalidacion?f=listarespecialidades&codfac=' +codfac)
                            .done(function (especialidades) {
                                callback(especialidades);
                            })
                            .fail(function (error) {
                                if (error)
                                    console.log(error);
                                callback();
                            });
                });
                return xhr;
            }
        };

        return $.extend(comboEspecialidad, methods);
    };
})(jQuery);
