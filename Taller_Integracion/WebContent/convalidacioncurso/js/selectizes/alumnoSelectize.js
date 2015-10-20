(function ($) {
    $.fn.alumnoSelectize = function (options) {
        var $root = this;

        if (typeof options == "string") {
            options = AlumnoOptionsTemplates[options];
        }
        ;

        var defaultOptions = {
            valueField: 'id',
            labelField: 'nomcom',
            searchField: ['nomcom', 'id'],
            sortField: 'nomcom'
        };

        var comboAlumno = $root.selectize($.extend(defaultOptions, options))[0].selectize;

        var methods = {
        };

        return $.extend(comboAlumno, methods);

    };

    var AlumnoOptionsTemplates = (function () {
        var my = {};

        my.dynamicOptionsAlumno = {
            maxItems: 1,
            options: [],
            selectOnTab: true,
            openOnFocus: false,
            load: function (query, callback) {
                if (!query.length) {
                    this.clearOptions();
                    this.refreshOptions();
                    return callback();
                }

                if (query.match(/^[0-9]{10}$/)) {
                    $.ajax({
                        url: "../convalidacion",
                        data: {'f': 'listarAlumnos', 'codigo': query},
                        dataType: 'json',
                        method: 'POST',
                        error: function () {
                            callback();
                        },
                        success: function (res) {
                            var lista = [];
                            $.each(res, function (index,alumno) {
                                lista.push({
                                    'id': alumno.persona.id,
                                    'nomcom': alumno.persona.nomcom
                                });
                            });
                            //console.log(JSON.stringify(lista));
                            callback(lista);
                        }
                    });
                }
                else if (query.match(/^[a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜ_\s]+$/)) {
                    $.ajax({
                        url: "../convalidacion",
                        data: {'f': 'listarAlumnos', 'nombre': query},
                        dataType: 'json',
                        method: 'POST',
                        error: function () {
                            callback();
                        },
                        success: function (res) {
                            
                            var lista = [];
                            $.each(res, function (index,alumno) {
                                lista.push({
                                    'id': alumno.persona.id,
                                    'nomcom': alumno.persona.nomcom
                                });
                            });
                            //console.log(JSON.stringify(res));
                            callback(lista);
                        }
                    });
                } else {
                    this.clearOptions();
                    this.refreshOptions();
                    callback([]);
                }
            },
            render: {
                option: function (item, escape) {
                    return '<div class=option>' +
//                            '<span class="label">' + escape(item.nomcom) + '</span><br>' +
                            '<span >' + escape(item.nomcom) + '</span><br>' +
//                            '<span class="caption">' + escape(item.id) + '</span><br>' +
                            '<span >' + escape(item.id) + '</span><br>' +
                            //'<span class="caption"><small>' + escape(item.escuela.desesc) + ' - ' + escape(item.facultad.desfacres) + '</small></span>' +
                            '</div>';
                }
            }
        };

        return my;
    }());
})(jQuery);