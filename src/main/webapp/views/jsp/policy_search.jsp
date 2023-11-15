<%@ page import="com.bimaapp.database.Database, java.util.List, com.bimaapp.model.Policy"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" ><link rel="stylesheet" href="views/css/app.css">
</head>
<body>

<jsp:include page="menu_bar.jsp"/>

<div class="main">
  <h2>Search Policy</h2>
  <form action="./policies" method="POST">
    <input id="search" type="text" name="search" class="form__input" placeholder="search policy" required>
    <input type="submit" value="Submit">
  </form>

  <table>
    <tr>
      <th>Policy Number</th>
      <th>Policy Type</th>
      <th>Start Date</th>
      <th>End Date</th>
      <th>Client Name</th>
    </tr>
      <%
      List<Policy> policies = Database.getDbInstance().getPolicies();
        for (Policy policy : policies) {
      %>
      <tr>
          <td><a href="./policy?policy_num=<%= policy.getNumber() %>"><%= policy.getNumber() %></a></td>
          <td><%= policy.getPolicyType() %></td>
          <td><%= policy.getStartDate() %></td>
          <td><%= policy.getEndDate() %></td>
          <td><%= policy.getClient().getName() %></td>
      </tr>
      <%
        }
      %>
  </table>
</div>
     
</body>
</html>