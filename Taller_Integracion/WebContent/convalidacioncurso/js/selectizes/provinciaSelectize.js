
(function ($) {
    
    $.fn.provinciaSelectize = function (options) {
        var $root = this;

        var defaultOptions = {
            valueField: 'id',
            labelField: 'nombre',
            searchField: ['id', 'nombre'],
            sortField: 'nombre',
            options: [],
            maxItems: 1
        };

        var comboProvincia = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
            "cargarProvincia": function (coddep) {
                var xhr;
                comboProvincia.clearOptions();
                comboProvincia.load(function (callback) {
                    xhr = $.getJSON('../convalidacion?f=listarprovincias&coddep='+coddep
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

        return $.extend(comboProvincia, methods);
    };
})(jQuery);
