
(function ($) {
    // replace comboSeccion.rs() -> comboSeccion (43 matches)
    $.fn.seccionSelectize = function (options) {
        var $root = this;

        var defaultOptions = {
            valueField: 'consec',
            labelField: 'codsec',
            searchField: ['consec', 'codsec'],
            sortField: 'codsec',
            options: [],
            maxItems: 1
        };

        var comboSeccion = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
            "cargarSeccion": function (codcur) {
                var xhr;
                comboSeccion.clearOptions();
                comboSeccion.load(function (callback) {
                    xhr = $.getJSON('llenarcomboseccion2', {
                        'seccion.curso.codcur': codcur
                    })
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
            },
            "cargarSeccionRep": function (codcur, codfac, codesc) {
                var xhr;
                comboSeccion.clearOptions();
                comboSeccion.load(function (callback) {
                    xhr = $.getJSON('carcbosec2', {
                        'curso.codcur': codcur,
                        'curso.facultad.codfac': codfac,
                        'curso.escuela.codesc': codesc
                    })
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
            },
            "cargarSeccionJus": function (codcur, codfac, codesc) {
                var xhr;
                comboSeccion.clearOptions();
                comboSeccion.load(function (callback) {
                    xhr = $.getJSON('repcbosecjus', {
                        'curso.codcur': codcur,
                        'curso.facultad.codfac': codfac,
                        'curso.escuela.codesc': codesc
                    })
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

        return $.extend(comboSeccion, methods);
    };
})(jQuery);
