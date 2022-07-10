$(document).ready(function () {
    listar();
});
function listar() {
    $.ajax({
        url: "/taller/all",
        type: 'GET',
        success: function (x) {
            $("#table tbody tr").remove();
            x.forEach((item, index, array) => {
                $("#table").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.programa.progNombre + "</td>\n\
                            <td>" + item.tallTema + "</td>\n\
                            <td>" + fechaText(item.tallFecha) + "</td>\n\
                            <td>" + item.tallHora + "</td>\n\
                            <td>" + item.tallLugar + "</td>\n\
                            <td>" + item.tallDireccion + "</td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='editar(" + item.tallId + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a>\n\
                            </td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' title='Organizadores del taller' onclick='asignar(" + item.tallId + ")'><i class='fa-solid fa-people-group yelow'></i></a>\n\
                            </td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='eliminar(" + item.tallId + ")'><i class='fa-solid fa-trash-can red'></i></a>\n\
                            </td>\n\
                        </tr>");

            });
        }
    });
}

function listarPersonasTaller(id) {
    $.ajax({
        url: "/persona-taller/taller/" + id,
        type: 'GET',
        success: function (x) {
            $("#tableAsig tbody tr").remove();
            x.forEach((item, index, array) => {
                $("#tableAsig").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.persona.persApPaterno + " " + item.persona.persApMaterno + " " + item.persona.persNombres + "</td>\n\
                            <td>" + item.tipoPersona.tipeNombre + "</td>\n\
                            <td>" + item.petaCarrera + "</td>\n\
                            <td>" + item.petaCiclo + "</td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' title='Eliminar' onclick='eliminarParticipante(" + item.petaId + "," + item.taller.tallId + ")'><i class='fa-solid fa-trash-can red'></i></a>\n\
                            </td>\n\
                        </tr>");

            });
        }
    });
}

function listarPrograma(selected) {
    $.ajax({
        url: "/programa/all",
        type: 'GET',
        success: function (x) {
            $(".progId option").remove();
            $(".progId").append("<option>Seleccione</option>");
            x.forEach((item, index, array) => {
                if (item.progId === selected) {
                    $(".progId").append("<option selected value=" + item.progId + ">" + item.progNombre + "</option>");
                } else {
                    $(".progId").append("<option value=" + item.progId + ">" + item.progNombre + "</option>");
                }
            });
        }
    });
}

function listarTipoPersona() {
    $.ajax({
        url: "/tipo-persona/all",
        type: 'GET',
        success: function (x) {
            $(".tipoPers option").remove();
            $(".tipoPers").append("<option  value=''>Seleccione</option>");
            x.forEach((item, index, array) => {
                $(".tipoPers").append("<option value=" + item.tipeId + ">" + item.tipeNombre + "</option>");
            });
        }
    });
}

$("#nuevo").click(function () {
    listarPrograma(0);
});

function editar(id) {
    $.ajax({
        url: "/taller/" + id,
        type: 'GET',
        success: function (w) {
            $("#edit_tallId").val(w.tallId);
            $("#edit_tema").val(w.tallTema);
            $("#edit_fecha").val(fechaText(w.tallFecha));
            $("#edit_hora").val(w.tallHora);
            $("#edit_lugar").val(w.tallLugar);
            $("#edit_direccion").val(w.tallDireccion);
            listarPrograma(w.programa.progId);
        }
    });
    $("#editarModal").modal('show');
}


function asignar(id) {
    $.ajax({
        url: "/taller/" + id,
        type: 'GET',
        success: function (w) {
            $("#asig_tallId").val(w.tallId);
            $("#asig_tema").val(w.tallTema);
            $("#asig_programa").val(w.programa.progNombre);
            listarTipoPersona();
            listarPersonasTaller(w.tallId);
        }
    });
    $("#asignarModal").modal('show');
}
function eliminar(id) {
    bootbox.confirm({
        message: "¿Está seguro que desea eliminar el registro?",
        closeButton: false,
        title: "Eliminar",
        buttons: {
            confirm: {
                label: 'Eliminar',
                className: 'btn-primary'
            },
            cancel: {
                label: 'Cancelar',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/taller/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        var dialog = bootbox.dialog({
                            message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Eliminado Correctamente.</p>',
                            closeButton: false
                        });
                        setTimeout(function () {
                            dialog.modal('hide');
                        }, 1500);
                        listar();
                    }
                });
            } else {
                var dialog = bootbox.dialog({
                    message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro no Eliminado.</p>',
                    closeButton: false
                });
                setTimeout(function () {
                    dialog.modal('hide');
                }, 1500);
            }
        }
    });
}

function eliminarParticipante(id, idTaller) {
    bootbox.confirm({
        message: "¿Está seguro que desea eliminar el registro?",
        closeButton: false,
        title: "Eliminar",
        buttons: {
            confirm: {
                label: 'Eliminar',
                className: 'btn-primary'
            },
            cancel: {
                label: 'Cancelar',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/persona-taller/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        var dialog = bootbox.dialog({
                            message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Eliminado Correctamente.</p>',
                            closeButton: false
                        });
                        setTimeout(function () {
                            dialog.modal('hide');
                        }, 1200);
                        listarPersonasTaller(idTaller);
                    }
                });
            } else {
                var dialog = bootbox.dialog({
                    message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro no Eliminado.</p>',
                    closeButton: false
                });
                setTimeout(function () {
                    dialog.modal('hide');
                }, 1200);
            }
        }
    });
}
$("#guardar").click(function () {
    fechaFormat($("#fecha").val())
    $.ajax({
        url: "/taller/save",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            tallId: $("#tallId").val(),
            tallTema: $("#tema").val(),
            tallFecha: fechaFormat($("#fecha").val()),
            tallHora: $("#hora").val(),
            tallLugar: $("#lugar").val(),
            tallDireccion: $("#direccion").val(),
            programa: {
                progId: $("#progId").val()
            }
        }),
        cache: false,
        success: function (w) {
            var dialog = bootbox.dialog({
                message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Guardado Correctamente.</p>',
                closeButton: false
            });
            setTimeout(function () {
                dialog.modal('hide');
            }, 1500);
            limpiar();
            listar();
        }
    });
    $("#exampleModal").modal('hide');
});

$("#asignar").click(function () {
    $.ajax({
        url: "/persona-taller/save",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            petaCarrera: $("#asig_carrera").val(),
            petaCiclo: $("#asig_ciclo").val(),
            taller: {
                tallId: $("#asig_tallId").val()
            },
            persona: {
                persDni: $("#asig_dni").val()
            },
            tipoPersona: {
                tipeId: $("#tipoPers").val()
            }
        }),
        cache: false,
        success: function (w) {
            console.log(w);
            if (w === null || w === '') {
                var dialog = bootbox.dialog({
                    message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> DNI no existe.</p>',
                    closeButton: false
                });
                setTimeout(function () {
                    dialog.modal('hide');
                }, 1500);
            } else {
                var dialog = bootbox.dialog({
                    message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Guardado Correctamente.</p>',
                    closeButton: false
                });
                setTimeout(function () {
                    dialog.modal('hide');
                }, 1500);
                limpiarPeta();
                listarPersonasTaller(w.taller.tallId);
            }
        }
    });
});

function limpiar() {
    $("#tema").val('');
    $("#fecha").val('');
    $("#hora").val('');
    $("#lugar").val('');
    $("#direccion").val('');
}

function limpiarPeta() {
    $("#asig_dni").val('');
    $("#tipoPers").val('').change();
    $("#asig_carrera").val('');
    $("#asig_ciclo").val('');
}

$("#modificar").click(function () {
    $.ajax({
        url: "/taller/update",
        type: 'PUT',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            tallId: $("#edit_tallId").val(),
            tallTema: $("#edit_tema").val(),
            tallFecha: fechaFormat($("#edit_fecha").val()),
            tallHora: $("#edit_hora").val(),
            tallLugar: $("#edit_lugar").val(),
            tallDireccion: $("#edit_direccion").val(),
            programa: {
                progId: $("#edit_progId").val()
            }
        }),
        cache: false,
        success: function (w) {
            var dialog = bootbox.dialog({
                message: '<p class="text-center mb-0"><i class="fa fa-spin fa-spinner"></i> Registro Modificado Correctamente.</p>',
                closeButton: false
            });
            setTimeout(function () {
                dialog.modal('hide');
            }, 1500);
            listar();
        }
    });
    $("#editarModal").modal('hide');
});

function fechaFormat(fecha) {
    if (fecha === null)
        return;
    const [day, month, year] = fecha.split('/');
    return new Date(+year, +month - 1, +day);
}

function fechaText(fecha) {
    if (fecha === null)
        return;
    const [year, month, day] = fecha.substring(0, 10).split('-');
    return day + "/" + month + "/" + year;
}