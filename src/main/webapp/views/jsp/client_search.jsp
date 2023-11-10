<%@ page import="com.bimaapp.utils.RenderHtmlForm, com.bimaapp.database.Database, java.util.List, com.bimaapp.model.Client"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" ><link rel="stylesheet" href="views/css/app.css">
</head>
<body>

<jsp:include page="menu_bar.jsp"/>

<div class="main">
  <h2>Add New Client</h2>
  <%= RenderHtmlForm.renderForm(com.bimaapp.model.Client.class)%>
  <table>
    <tr>
      <th>National ID</th>
      <th>Name</th>
      <th>Telephone Number</th>
      <th>Email</th>
      <th>Address</th>
      <%
      List<Client> clients = Database.getDbInstance().getClients();
      for (Client client : clients) {
      %>
      <tr>
          <td><%= client.getNationalId() %></td>
          <td><%= client.getName() %></td>
          <td><%= client.getTelephoneNumber() %></td>
          <td><%= client.getEmail() %></td>
          <td><%= client.getAddress() %></td>
      </tr>
      <%
          }
      %>
    </tr>
  </table>
</div>
     
</body>
</html>