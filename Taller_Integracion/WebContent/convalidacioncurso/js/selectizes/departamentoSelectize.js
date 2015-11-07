
(function ($) {
    
    $.fn.departamentoSelectize = function (options) {
        var $root = this;

        var defaultOptions = {
            valueField: 'id',
            labelField: 'nombre',
            searchField: ['id', 'nombre'],
            sortField: 'nombre',
            options: [],
            maxItems: 1
        };

        var comboDepartamento = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
            "cargarDepartamento": function () {
                var xhr;
                comboDepartamento.clearOptions();
                comboDepartamento.load(function (callback) {
                    xhr = $.getJSON('../convalidacion?f=listardepartamentos'
                    )
                            .done(function (secciones) {
                                callback(secciones);
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

        return $.extend(comboDepartamento, methods);
    };
})(jQuery);
