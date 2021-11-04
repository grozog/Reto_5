
/**
 * FUNCIONES DISFRAZ
 */

function formularioDisfraz() {
    $.ajax({
        action: $('#divRegMensajes').hide(),
        action: $('#divRegClientes').hide(),
        action: $('#divTablaDisfraz').show(),
        action: $('#divRegCategorias').hide(),
        action: $('#divRegReservaciones').hide(),
    }
    );
}

function limpiarCeldasD(){
    var costume;
    costume = {
        id: $("#idDisfraz").val(""),
        name: $("#NameDisfraz").val(""),
        brand:  $("#Brand").val(""),
        year: $("#Year").val(""),
        description: $("#Description").val(""),
    }
    datosEnvio = JSON.stringify(costume);
}

function consultarDisfraces() {
    $.ajax({
        url: "http://localhost:8080/api/Costume/all",
        type: "GET",
        dataType: "json",
        success: function (items) {
            $("#idDivConsultaDisfraz").empty();
            $("#idDivConsultaDisfraz").append("<table>");
            $("#idDivConsultaDisfraz").append("<tr><th>NOMBRE</th><th>MARCA</th><th>AÑO</th><th>DESCRIPCION</th></tr>");
            for (i = 0; i < items.length; i++) {
                $("#idDivConsultaDisfraz").append("<tr>");
                $("#idDivConsultaDisfraz").append("<td hidden>"+items[i].id+"</td>");
                $("#idDivConsultaDisfraz").append("<td>"+items[i].name+"</td>");
                $("#idDivConsultaDisfraz").append("<td>"+items[i].brand+"</td>");
                $("#idDivConsultaDisfraz").append("<td>"+items[i].year+"</td>");
                $("#idDivConsultaDisfraz").append("<td>"+items[i].description+"</td>");
                $("#idDivConsultaDisfraz").append('<td><button onclick="cargarDisfraz(' + items[i].id + ')">Cargar</button></td>');
                $("#idDivConsultaDisfraz").append("</tr>");
            }
            $("#idDivConsultaDisfraz").append("</table>");
        },
        error: function (xhr, status) {
            console.log(xhr);
        }
    });
}

function cargarDisfraz(idItem) {
    $.ajax({
        dataType: 'json',
        url: "http://localhost:8080/api/Costume/" + idItem,
        type: 'GET',
        success: function (response) {
            $("#idDisfraz").val(response.id);
            $("#NameDisfraz").val(response.name);
            $("#Brand").val(response.brand);
            $("#Year").val(response.year);
            $("#Description").val(response.description);
        },
        error: function (xhr, status) {
            console.log(xhr);
        }
    }
    );
}

function ingresarDisfraz() {
    var costume;
    costume = { name: $("#NameDisfraz").val(), 
                brand: $("#Brand").val(), 
                year: $("#Year").val(), 
                description: $("#Description").val() };
    var dataToSend=JSON.stringify(costume);
    $.ajax({
        url: "http://localhost:8080/api/Costume/save",
        type: "POST",
        data: dataToSend,
        contentType:'application/json',
        success: function (response) {
            console.log(response);
            alert("Disfraz creado exitosamente");
        },
        error: function (xhr, status) {
            console.log(xhr);
            alert("Disfraz no pudo ser creado");
        }
    });
    limpiarCeldasD();
}

function actualizarDisfraz() {
    var costume;
    costume = {
        id: $("#idDisfraz").val(),
        name:  $("#NameDisfraz").val(),
        brand:  $("#Brand").val(),
        year: $("#Year").val(),
        description: $("#Description").val(),
    }
    datosEnvio = JSON.stringify(costume);
    $.ajax({
        url: "http://localhost:8080/api/Costume/update",
        type: "PUT",
        data: datosEnvio,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        },
        error: function (xhr, status) {
            console.log(xhr);
            alert("Disfraz no pudo ser actualizado");
        }
    });
    consultarDisfraces();
    limpiarCeldasD();
}

function eliminarDisfraz() {
    var dato, datosEnvio;
    dato = { id:$("#idDisfraz").val()};
    datosEnvio = JSON.stringify(dato);
    $.ajax({
        url: "http://localhost:8080/api/Costume/" + dato.id,
        type: "DELETE",
        data: datosEnvio,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        },
        error: function (xhr, status) {
            console.log(xhr);
            alert("Disfraz no pudo ser eliminado");
        }
    });
    consultarDisfraces();
    limpiarCeldasD();
}