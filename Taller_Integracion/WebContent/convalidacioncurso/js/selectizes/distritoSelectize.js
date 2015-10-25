
(function ($) {
    
    $.fn.distritoSelectize = function (options) {
        var $root = this;

        var defaultOptions = {
            valueField: 'id',
            labelField: 'nombre',
            searchField: ['id', 'nombre'],
            sortField: 'nombre',
            options: [],
            maxItems: 1
        };

        var comboDistrito = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
            "cargarDistrito": function (coddep) {
                var xhr;
                comboDistrito.clearOptions();
                comboDistrito.load(function (callback) {
                    xhr = $.getJSON('../convalidacion?f=listardistritos&coddep='+coddep
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

        return $.extend(comboDistrito, methods);
    };
})(jQuery);
