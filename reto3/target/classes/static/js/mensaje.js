
/**
 * FUNCIONES MENSAJE
 */

function formularioMensajes() {
    $.ajax({
        action: $('#divRegMensajes').show(),
        action: $('#divRegClientes').hide(),
        action: $('#divTablaDisfraz').hide(),
        action: $('#divRegCategorias').hide(),
        action: $('#divRegReservaciones').hide(),
    }
    );
}

function limpiarCeldasM(){
    var message;
    message = {
        idMessage: $("#idMessage").val(""),
        messagetext:  $("#MessageText").val(""),
    }
    datosEnvio = JSON.stringify(message);
}

function consultarMensajes() {
    $.ajax({
        url: "http://localhost:8080/api/Message/all",
        type: "GET",
        dataType: "json",
        success: function (items) {
            $("#idDivConsultaMensajes").empty();
            $("#idDivConsultaMensajes").append("<table>");
            $("#idDivConsultaMensajes").append("<tr><th>MENSAJE</th></tr>");
            for (i = 0; i < items.length; i++) {
                $("#idDivConsultaMensajes").append("<tr>");
                $("#idDivConsultaMensajes").append("<td hidden>"+items[i].idMessage+"</td>");
                $("#idDivConsultaMensajes").append("<td>"+items[i].messageText+"</td>");
                $("#idDivConsultaMensajes").append('<td><button onclick="cargarMensaje(' + items[i].idMessage + ')">Cargar</button></td>');
                $("#idDivConsultaMensajes").append("</tr>");
            }
            $("#idDivConsultaMensajes").append("</table>");
        },
        error: function (xhr, status) {
            console.log(xhr);
        }
    });
}

function cargarMensaje(idItem) {
    $.ajax({
        dataType: 'json',
        url: "http://localhost:8080/api/Message/" + idItem,
        type: 'GET',
        success: function (response) {
            $("#idMessage").val(response.idMessage);
            $("#MessageText").val(response.messageText);
        },
        error: function (xhr, status) {
            console.log(xhr);
        }
    }
    );
}

function crearMensaje() {
    var data;
    data = { messageText: $("#MessageText").val(), };
    var dataToSend=JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Message/save",
        type: "POST",
        data: dataToSend,
        contentType:'application/json',
        success: function (response) {
            console.log(response);
            alert("Mensaje creado exitosamente");
        },
        error: function (xhr, status) {
            console.log(xhr);
            alert("Mensaje no pudo ser creado");
        }
    });
    limpiarCeldasM();
}

function actualizarMensaje() {
    var data;
    data = {
        idMessage: $("#idMessage").val(),
        messageText: $("#MessageText").val(),
    }
    datosEnvio = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Message/update",
        type: "PUT",
        data: datosEnvio,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        },
        error: function (xhr, status) {
            console.log(xhr);
            alert("Mensaje no pudo ser actualizado");
        }
    });
    consultarMensajes();
    limpiarCeldasM();
}

function eliminarMensaje() {
    var dato, datosEnvio;
    dato = { idMessage:$("#idMessage").val()};
    datosEnvio = JSON.stringify(dato);
    $.ajax({
        url: "http://localhost:8080/api/Message/" + dato.idMessage,
        type: "DELETE",
        data: datosEnvio,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        },
        error: function (xhr, status) {
            console.log(xhr);
            alert("Mensaje no pudo ser eliminado");
        }
    });
    consultarMensajes();
    limpiarCeldasM();
}