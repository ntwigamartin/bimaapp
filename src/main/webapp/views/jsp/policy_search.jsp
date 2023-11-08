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
  <h2>Add New POlicy</h2>
  <form action="./policies" method="POST">
    <label for="policy_type">Policy Type:</label>
    <select id="dropdown" name="policy_type">
        <option value="private">Private</option>
        <option value="commercial">Commercial</option>
    </select>
    <label for="start_date">Start Date:</label>
    <input id="start_date" type="date" name="start_date" class="form__input" placeholder="Start Date" required>
    <label for="end_date">End Date:</label>
    <input id="end_date" type="date" name="end_date" class="form__input" placeholder="End Date" required>
    <label for="national_id">National Id:</label>
    <input id="national_id" type="number" name="national_id" class="form__input" placeholder="National ID" required>
    <input type="submit" value="Submit">
  </form>

  <table>
    <tr>
      <th>Policy Number</th>
      <th>Policy Type</th>
      <th>Start Date</th>
      <th>End Date</th>
      <th>Client Name</th>
      
      <%
      List<Policy> policies = Database.getDbInstance().getPolicies();
      for (Policy policy : policies) {
      %>
      <tr>
          <td><%= policy.getNumber() %></td>
          <td><%= policy.getPolicyType() %></td>
          <td><%= policy.getStartDate() %></td>
          <td><%= policy.getEndDate() %></td>
          <td><%= policy.getClient().getName() %></td>
      </tr>
      <%
          }
      %>
    </tr>
  </table>
</div>
     
</body>
</html>