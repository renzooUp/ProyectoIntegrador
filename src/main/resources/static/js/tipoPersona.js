$(document).ready(function () {
    listar();
});

function listar() {
    $.ajax({
        url: "/tipo-persona/all",
        type: 'GET',
        success: function (x) {
            $("#table tbody tr").remove();
            x.forEach((item, index, array) => {
                $("#table").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.tipeNombre + "</td>\n\
                            <td>" + item.tipeDescripcion + "</td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='editar(" + item.tipeId + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a>\n\
                            </td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='eliminar(" + item.tipeId + ")'><i class='fa-solid fa-trash-can red'></i></a>\n\
                            </td>\n\
                        </tr>");

            });
        }
    });
}

function editar(id) {
    $.ajax({
        url: "/tipo-persona/" + id,
        type: 'GET',
        success: function (w) {
            $("#edit_TpId").val(w.tipeId);
            $("#edit_nombre").val(w.tipeNombre);
            $("#edit_description").val(w.tipeDescripcion);
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
                    url: "/tipo-persona/" + id,
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
        url: "/tipo-persona/save",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            tipeNombre: $("#nombre").val(),
            tipeDescripcion: $("#description").val()
            
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
    $("#nombre").val('');
    $("#description").val('');
}

$("#modificar").click(function () {
    $.ajax({
        url: "/tipo-persona/update",
        type: 'PUT',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            tipeId: $("#edit_TpId").val(),
            tipeNombre: $("#edit_nombre").val(),
            tipeDescripcion: $("#edit_description").val()
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


