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
                $("#table_persona").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.persApPaterno + " " + item.persApMaterno + "</td>\n\
                            <td>" + item.persNombres + "</td>\n\
                            <td>" + item.tipoDocumento.tidoNombre + "</td>\n\
                            <td>" + item.persDni + "</td>\n\
                            <td>" + item.persTelefono + "</td>\n\
                        </tr>");

            });
        }
    });
}


