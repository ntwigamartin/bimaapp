<%@ page import="com.bimaapp.utils.RenderHtmlForm, com.bimaapp.database.Database, 
java.util.List, com.bimaapp.model.Client, com.bimaapp.bean.ClientSearchBean"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="views/css/app.css?version=3">
</head>
<body>

<jsp:include page="menu_bar.jsp"/>

<div class="main">
  <h1> Client Search</h1>
  <div class="search">
    <form action="./clients" method="GET">
      <input type="text" name="query" placeholder="Search Client">
      <button type="submit">Search</button>
    </form>
  </div>
  <div class="form">
    <button id="openFormBtn">Add New Client</button>
    <div class="form-container" id="formContainer">
      <h2>Add New Client</h2>
      <form action="./clients" method="POST">
        <%= RenderHtmlForm.renderForm(com.bimaapp.model.Client.class)%>
      </form>
      <button id="closeFormBtn">Close</button>
    </div>
    <div class="overlay" id="overlay"></div>
  </div>
 
  <table>
    <tr>
      <th>National ID</th>
      <th>Name</th>
      <th>Telephone Number</th>
      <th>Email</th>
      <th>Address</th>
      <%
      String searchQuery = request.getParameter("query");
      List<Client> clients;

      if (searchQuery != null && !searchQuery.isEmpty()) {
          clients = new ClientSearchBean().searchClients(searchQuery);
      } else {
          clients = Database.getDbInstance().getClients();
      }

      for (Client client : clients) {
      %>
      <tr>
          <td><a href="./client?national_id=<%= client.getNationalId() %>"><%= client.getNationalId() %></a></td>
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
<jsp:include page="script.jsp"/>
</body>
</html>