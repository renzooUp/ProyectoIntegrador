$(document).ready(function () {
    listar();
});
function listar() {
    $.ajax({
        url: "/persona/all",
        type: 'GET',
        success: function (x) {
            $("#table tbody tr").remove();
            x.forEach((item, index, array) => {
                $("#table").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.persNombres + "</td>\n\
                            <td>" + item.persApPaterno + "</td>\n\
                            <td>" + item.persApMaterno + "</td>\n\
                            <td>" + item.tipoDocumento.tidoNombre + "</td>\n\
                            <td>" + item.persDni + "</td>\n\
                            <td>" + item.persTelefono + "</td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='editar(" + item.persId + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a>\n\
                            </td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='eliminar(" + item.persId + ")'><i class='fa-solid fa-trash-can red'></i></a>\n\
                            </td>\n\
                        </tr>");

            });
        }
    });
}

function listarTipoDocumento(selected) {
    $.ajax({
        url: "/tipoDocumento/all",
        type: 'GET',
        success: function (x) {
            $(".tipoDoc option").remove();
            $(".tipoDoc").append("<option>Seleccione</option>");
            x.forEach((item, index, array) => {
                if (item.tidoId === selected) {
                    $(".tipoDoc").append("<option selected value=" + item.tidoId + ">" + item.tidoNombre + "</option>");
                } else {
                    $(".tipoDoc").append("<option value=" + item.tidoId + ">" + item.tidoNombre + "</option>");
                }
            });
        }
    });
}

$("#nuevo").click(function () {
    listarTipoDocumento(0);
});
 
function editar(id) {
    $.ajax({
        url: "/persona/" + id,
        type: 'GET',
        success: function (w) {
            $("#edit_persId").val(w.persId);
            $("#edit_apPaterno").val(w.persApPaterno);
            $("#edit_apMaterno").val(w.persApMaterno);
            $("#edit_nombres").val(w.persNombres);
            $("#edit_dni").val(w.persDni);
            $("#edit_telefono").val(w.persTelefono);
            listarTipoDocumento(w.tipoDocumento.tidoId);
        }
    });
    $("#editarModal").modal('show');
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
                    url: "/persona/" + id,
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
$("#guardar").click(function () {
    $.ajax({
        url: "/persona/save",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            persApPaterno: $("#apPaterno").val(),
            persApMaterno: $("#apMaterno").val(),
            persNombres: $("#nombres").val(),
            persDni: $("#dni").val(),
            persTelefono: $("#telefono").val(),
            persEstado: true,
            tipoDocumento: {
                tidoId: $("#tipoDoc").val()
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
function limpiar() {
    $("#apPaterno").val('');
    $("#apMaterno").val('');
    $("#nombres").val('');
    $("#dni").val('');
    $("#telefono").val('');
}

$("#modificar").click(function () {
    $.ajax({
        url: "/persona/update",
        type: 'PUT',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            persId: $("#edit_persId").val(),
            persApPaterno: $("#edit_apPaterno").val(),
            persApMaterno: $("#edit_apMaterno").val(),
            persNombres: $("#edit_nombres").val(),
            persDni: $("#edit_dni").val(),
            persTelefono: $("#edit_telefono").val(),
            tipoDocumento: {
                tidoId: $("#edit_tipoDoc").val()
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