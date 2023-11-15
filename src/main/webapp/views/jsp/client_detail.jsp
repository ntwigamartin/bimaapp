<%@ page import="com.bimaapp.model.Client, java.util.List, com.bimaapp.bean.PolicySearchBean, 
com.bimaapp.model.Policy, com.bimaapp.bean.ClientSearchBean, com.bimaapp.utils.RenderHtmlForm"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" ><link rel="stylesheet" href="views/css/app.css">
</head>
<body>

<jsp:include page="menu_bar.jsp"/>

<div class="main">
    <div class="client_detail">
        <h1> Client Details</h1>
        <% Client client = new ClientSearchBean().getClient(request.getParameter("national_id"));%>
        <h3>NAME:</h3> <span> <%=client.getName()%> </span>
        <h3>NATIONAL ID:</h3> <span> <%=client.getNationalId()%> </span>
        <h3>TELEPHONE NUMBER:</h3> <span> <%=client.getTelephoneNumber()%> </span>
        <h3>EMAIL:</h3> <span> <%=client.getEmail()%> </span>
        <h3>ADDRESS:</h3> <span> <%=client.getAddress()%> </span>
        
    </div>
    <div class="">
            <h2>Add New POlicy</h2>
            <form action="./client?national_id=<%= request.getParameter("national_id")%>" method="POST">
            
                <label for="policy_type">Policy Type:</label>
                <select id="dropdown" name="policy_type">
                    <option value="private">Private</option>
                    <option value="commercial">Commercial</option>
                </select>

                <%= RenderHtmlForm.renderForm(com.bimaapp.model.Policy.class)%>
            </form>
    </div>
    <div class="">
        <table>
            <tr>
                <th>Policy Number</th>
                <th>Policy Type</th>
                <th>Start Date</th>
                <th>End Date</th>
            </tr>
            <%
            List<Policy> policies = new PolicySearchBean().getClientPolicies(request.getParameter("national_id"));

                for (Policy policy : policies) {
            %>
            <tr>
                <td><a href="./policy?policy_num=<%= policy.getNumber() %>"><%= policy.getNumber() %></a></td>
                <td><%= policy.getPolicyType() %></td>
                <td><%= policy.getStartDate() %></td>
                <td><%= policy.getEndDate() %></td>
            </tr>
            <%
              }
            %>
        </table>
    </div>
</div>     
</body>
</html>