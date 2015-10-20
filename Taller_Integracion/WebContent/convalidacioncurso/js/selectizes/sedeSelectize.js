
(function ($) {
    $.fn.sedeSelectize = function (options) {
        var $root = this;

        var defaultOptions = {
            valueField: 'id',
            labelField: 'nombre',
            searchField: ['id', 'nombre'],
            sortField: 'nombre',
            options: [],
            maxItems: 1
        };

        var comboDepartamentos = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
            "cargarDepartamentos": function () {

                var xhr;
                comboDepartamentos.unlock();
                comboDepartamentos.clearOptions();
                comboDepartamentos.load(function (callback) {
                    xhr = $.getJSON('listarDepartamentos')
                            .done(function (sedes) {
                                callback(sedes);
                            })
                            .fail(function (error) {
                                if (error)
                                    console.log(error);
                                callback();
                            });
                });
                comboDepartamentos.on("load", function (data) {
                    if (data.length === 1) {
                        comboDepartamentos.addItem(data[0].codsed);
                        comboDepartamentos.lock();
                    }
                });
                return xhr;
            }
        };
        return $.extend(comboDepartamentos, methods);
    };
})(jQuery);