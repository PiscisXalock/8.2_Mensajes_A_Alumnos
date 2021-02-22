<%-- 
    Document   : pueblos
    Created on : 25-ene-2021, 21:17:32
    Author     : DAW2-PROFESOR
--%>

<%@page import="Modelo.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%--@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #form1 { border:2px solid red; padding:20px;}
            #form2 { border:2px solid blue; padding:20px}
            
        </style>
    </head>
    <body>
        <h1>Mensaje a alumnos</h1>
        <% 
            String grupoActivo = ( String ) request.getAttribute("grupo");
            ArrayList<String> grupos = ( ArrayList<String> ) request.getAttribute("grupos");
            ArrayList<Alumno> alumnos = ( ArrayList<Alumno> ) request.getAttribute("alumnos");
         %>
         Grupo Seleccionado: <%=grupoActivo%> <br>
         <form action="servletAlumnos" method="get" id="form1">
         Grupo: <select name="grupo">
             
             <% 
                 
                 for ( String p: grupos){
                // for ( int i=0;i<provincias.size(); i++ ) { 
                 String textoSelected="";
                 if ( p.equals(grupoActivo)) {
                     textoSelected = " selected";
                 }
                 %>
                     <option <%=textoSelected%> value="<%=p%>"><%=p%></option>
             <% } %>
         </select>
         <br>
         <input type="submit" value="Seleccionar">
         </form>
        
         <form id="form2" action="servletAlumnos" method="post">
         Grupo seleccionado: <input type="text" name="grupoSeleccionado" value="<%=grupoActivo%>">
        
        <table border="1">
         <% for ( Alumno al: alumnos) { %>
           <tr>
               <td>
                   <%=al.getNombre() %>
               </td>
               <td>
                  <%=al.getApellidos()  %>
               </td>
               <td>
                  <%=al.getEmail()  %>
               </td>
               <td>
                   <input type="checkbox"  value="1" name="<%=al.getId()%>">
               </td>
           </tr>          
            <% } %>
          </table>
          <input type="submit" value="Enviar">
          </form>
          
    </body>
</html>
