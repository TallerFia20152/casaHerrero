
(function ($) {
    
    $.fn.modalidadSelectize = function (options) {
        var $root = this;

        var defaultOptions = {
            valueField: 'id',
            labelField: 'descripcion',
            searchField: ['id', 'descripcion'],
            sortField: 'descripcion',
            options: [],
            maxItems: 1
        };

        var comboModalidad = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
            "cargarModalidad": function () {
                var xhr;
                comboModalidad.clearOptions();
                comboModalidad.load(function (callback) {
                    xhr = $.getJSON('../convalidacion?f=listarmodalidades')
                            .done(function (modalidades) {
                                callback(modalidades);
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

        return $.extend(comboModalidad, methods);
    };
})(jQuery);