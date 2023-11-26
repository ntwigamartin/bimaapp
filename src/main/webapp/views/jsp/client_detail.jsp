<%@ page import="com.bimaapp.app.model.Client, java.util.List, com.bimaapp.app.bean.policybean.PolicySearchBean, 
com.bimaapp.app.model.Policy, com.bimaapp.app.bean.clientbean.ClientSearchBean, com.bimaapp.utils.RenderHtmlForm"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="views/css/app.css?version=2">
</head>
<body>

<jsp:include page="menu_bar.jsp"/>

<div class="main">
    <h1> Client Details</h1>
    <div class="detail">
        <% Client client = new ClientSearchBean().getClient(request.getParameter("national_id"));%>
        <h3>NAME:<span> <%=client.getName()%> </span></h3> 
        <h3>NATIONAL ID: <span> <%=client.getNationalId()%> </span></h3> 
        <h3>TELEPHONE NUMBER: <span> <%=client.getTelephoneNumber()%> </span></h3>
        <h3>EMAIL: <span> <%=client.getEmail()%> </span></h3>
        <h3>ADDRESS: <span> <%=client.getAddress()%> </span></h3>
    </div>
    <div class="form">
        <button id="openFormBtn">Add New Policy</button>
        <div class="form-container" id="formContainer">
            <h2>Add New Policy</h2>
            <form action="./client?national_id=<%= request.getParameter("national_id")%>" method="POST">
            
                <label for="policy_type">Policy Type:</label>
                <select id="dropdown" name="policy_type">
                    <option value="PRIVATE">Private</option>
                    <option value="COMMERCIAL">Commercial</option>
                </select>

                <%= RenderHtmlForm.renderForm(com.bimaapp.app.model.Policy.class)%>
            </form>
            <button id="closeFormBtn">Close</button>
        </div>
        <div class="overlay" id="overlay"></div>
    </div>
    <div class="table">
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
<jsp:include page="script.jsp"/>     
</body>
</html>