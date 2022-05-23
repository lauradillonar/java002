<%@page import="logica.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar datos de la Persona</title>
    </head>
    <body>
        <h1>Editar datos de la persona</h1>
        <form action="SvEditar" method="POST">
            <% 
                HttpSession miSession = request.getSession();
                Persona per = (Persona) miSession.getAttribute("persona");
            %>
            <input type="hidden" name="id" value="<%=per.getId() %>">
            <p><label>DNI: </label><input type="text" name="dni" value="<%= per.getDni() %>"></p>
            <p><label>Nombre: </label><input type="text" name="nombre" value="<%=per.getNombre() %>"></p>
            <p><label>Apellido: </label><input type="text" name="apellido" value="<%=per.getApellido() %>"></p>
            <p><label>Telefono: </label><input type="text" name="telefono" value="<%=per.getTelefono() %>"></p>
            <p><button type="submit">Guardar cambios</button></p>
        </form>
    </body>
</html>
