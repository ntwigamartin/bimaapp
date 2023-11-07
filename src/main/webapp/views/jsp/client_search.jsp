<%@ page import="com.bimaapp.database.Database, java.util.List, com.bimaapp.model.Client"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" ><link rel="stylesheet" href="views/css/app.css">
</head>
<body>

<div class="sidebar">
  <a href="./home"><i class="fa fa-fw fa-home"></i> Home</a>
  <a href="./clients"><i class="fa fa-fw fa-user"></i> Clients</a>
  <a href="#policy"><i class="fa fa-fw fa-wrench"></i> Policy</a>
  <a href="#claims"><i class="fa fa-fw fa-wrench"></i> Claims</a>
  <a href="./logout"><i class="fa fa-fw fa-sign-out"></i> Logout</a>
</div>

<div class="main">
  <h2>Add New Client</h2>
  <form action="./clients" method="POST">
    <label for="national_id">National Id:</label>
    <input id="national_id" type="number" name="national_id" class="form__input" placeholder="National Id" required>
    <label for="client_name">Client Name:</label>
    <input id="client_name" type="text" name="client_name" class="form__input" placeholder="Client Name" required>
    <label for="telephone_number">Telephone Number:</label>
    <input id="telephone_number" type="text" name="telephone_number" class="form__input" placeholder="Telephone Number" required>
    <label for="email">Email:</label>
    <input id="email" type="text" name="email" class="form__input" placeholder="Email" required>
    <label for="address">Address:</label>
    <input id="address" type="text" name="address" class="form__input" placeholder="Address" required>
    <input type="submit" value="Submit">
  </form>

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
          <td><%= client.getEmail() %></td>
          <td><%= client.getTelephoneNumber() %></td>
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