$(document).ready(function () {
    var ArregloConvalidacion = [];

    $.ajax({
        url: "../convalidacion",
        data: {'f': 'convalidacion'},
        dataType: 'json',
        method: 'POST',
        success: function (cursosjson) {
            //console.log(JSON.stringify(cursosjson));
            var nuevafila;
            var ciclo = '00';
            $.each(cursosjson, function (index, curso) {
                //console.log(JSON.stringify(cursosjson));
                nuevafila = nuevafila + (ciclo !== curso.tipo ? "<tr data-object='{id:00}'><td colspan='3' style='text-align:center;'>" + curso.tipo + "</td></tr>" : "");
                ciclo = curso.tipo;
                nuevafila = nuevafila + "<tr   data-object='" + JSON.stringify(curso) + "' style='font-size:14px;'>";
                nuevafila = nuevafila + "<td style='text-align:center;'>" + curso.id + "</td><td style='cursor:pointer'>" + curso.nombre + "</td>";
                nuevafila = nuevafila + "<td style='text-align:center;'>" + curso.estado + "</td>";
                nuevafila = nuevafila + "</tr>";
            });
            $('#cursosplan').empty().append(nuevafila);
        },
        error: function (res) {
            //toastr["error"]("Ocurrió un error al obtener Estado");
            console.log(res);
        }
    });
    var cursosuni = [];
    cursosuni.push({
        'codcur': 'CB-101',
        'descur': 'Geometría Analítica',
        'crecur': 3,
        'curcon': '090663'
    });
    cursosuni.push({
        'codcur': 'CB-121',
        'descur': 'Cálculo Diferencial',
        'crecur': 5,
        'curcon': ''
    });
    cursosuni.push({
        'codcur': 'CB-201',
        'descur': 'Química General',
        'crecur': 4,
        'curcon': '090663'
    });
    cursosuni.push({
        'codcur': 'CB-501',
        'descur': 'Dibujo de Ingeniería',
        'crecur': 3,
        'curcon': '090663'
    });
    cursosuni.push({
        'codcur': 'HS-101',
        'descur': 'Desarrollo Personal',
        'crecur': 2,
        'curcon': '090663'
    });
    cursosuni.push({
        'codcur': 'HS-111',
        'descur': 'Técnicas de Comunicación',
        'crecur': 3,
        'curcon': '090709'
    });
    cursosuni.push({
        'codcur': 'ST-101',
        'descur': 'Introducción a la Ing. de Sistemas',
        'crecur': 3,
        'curcon': '091113'
    });
    function llenarcursosOrigen() {
        var nuevafila = "";
        $.each(cursosuni, function (index, curso) {
            //console.log(JSON.stringify(cursosuni));
            nuevafila = nuevafila + "<tr   data-object='" + JSON.stringify(curso) + "' class='origencurso' style='font-size:14px;'>";
            nuevafila = nuevafila + "<td style='text-align:center;'>" + curso.codcur + "</td><td class='nombrecurso' style='cursor:pointer'>" + curso.descur + "</td>";
            nuevafila = nuevafila + "<td style='text-align:center;'>" + curso.crecur + "</td>";
            nuevafila = nuevafila + "<td style='text-align:center; '><input class='form-control' type='text' value='" + curso.curcon + "'" + (curso.curcon.length > 0 ? " disabled='true' " : "") + "size='6' /></td>";
            //nuevafila = nuevafila + "<td><input type='button' class='btn btn-primary agregar' value='+'/></td>";
            nuevafila = nuevafila + "</tr>";
        });
        $('#cursosorigen').empty().append(nuevafila);
    }
    ;
    llenarcursosOrigen();
    $('.nombrecurso').on('click', function () {
        console.log(($(this).parent()).data('object').curcon);
    });

    function VerSilabo(codigo) {
        console.log(codigo);
    }
    function PintarFila(codigo) {
        //console.log(codigo);
        $('#cursosplan tr').each(function () {
            if ($(this).data("object").id === codigo) {
                $(this).addClass('info');
            }
        });
    }
    $('.origencurso').on('mouseover', function () {
        var cursosombreado = $(this).data('object');

        if (cursosombreado.curcon.length > 0) {
            PintarFila(cursosombreado.curcon);
        }

    });
    $('.origencurso').on('mouseout', function () {
        $('#cursosplan tr').each(function () {
            $(this).removeClass('info');
        });
    });
    function AgregarConvalidacion(cursoOrigen, cursoUsmp) {
        console.log(cursoOrigen);
        console.log(cursoUsmp);
        ArregloConvalidacion.push({
            'asignaturaOrigen': cursoOrigen,
            'asignaturaUsmp': cursoUsmp
        });
        console.log(ArregloConvalidacion);
    }
    function ActualizarTabla() {
        var nuevafila = "";
        $.each(ArregloConvalidacion, function (index, convalidacion) {
            nuevafila = nuevafila + "<tr>";
            nuevafila = nuevafila + "<td style='text-align:center;'>" + convalidacion.asignaturaOrigen.descur + "</td>";
            nuevafila = nuevafila + "<td style='text-align:center;'>" + ">>>>" + "</td>";
            nuevafila = nuevafila + "<td style='text-align:center;'>" + convalidacion.asignaturaUsmp.descur + "</td>";
            nuevafila = nuevafila + "<td style='text-align:center;'>" + convalidacion.asignaturaUsmp.crecur + "</td>";
            nuevafila = nuevafila + "</tr>";
        });
        $('#convalidaciones').empty().append(nuevafila);
    }

    $('.agregar').on('click', function () {
        var cursoOrigen = ($(this).parent().parent()).data('object');
        var cursoUsmp;
        $('#cursosplan tr').each(function () {
            //console.log($(this).data('object'));
            if ($(this).data('object').codcur === cursoOrigen.curcon) {
                cursoUsmp = $(this).data('object');
            }
        });
        AgregarConvalidacion(cursoOrigen, cursoUsmp);
        ActualizarTabla();
    });
    $('terminar').on('click', function () {

    });
});


