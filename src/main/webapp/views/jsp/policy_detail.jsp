<%@ page import="com.bimaapp.app.bean.coverdetail.CoverDetailSearchBean, com.bimaapp.app.model.CoverDetail, 
java.util.List, com.bimaapp.app.model.Policy, com.bimaapp.app.bean.policy.PolicySearchBean, com.bimaapp.utils.RenderHtmlForm"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="views/css/app.css?version=13">
</head>
<body>

<jsp:include page="menu_bar.jsp"/>

<div class="main">
    <h1> Policy Details</h1>
    <div class="detail">
        <% Policy policy = new PolicySearchBean().getPolicy(request.getParameter("policy_num"));%>
        <h3>Client NAME: <span> <%=policy.getClient().getName()%> </span></h3> 
        <h3>Policy Number: <span> <%=policy.getNumber()%> </span></h3>
        <h3>Start Date: <span> <%=policy.getStartDate()%> </span></h3>
        <h3>End Date: <span> <%=policy.getEndDate()%> </span></h3>
        <h3>Policy Class: <span> <%=policy.getPolicyType()%> </span></h3>
    </div>
    <div class="form">
        <button id="openFormBtn">Add New Cover Detail</button>
        <div class="form-container" id="formContainer">
            <h2>Add New Cover Detail</h2>
            <form action="./policy?policy_num=<%= request.getParameter("policy_num")%>" method="POST">

                <label for="cover_type">Cover Type:</label>
                <select id="dropdown" name="cover_type">
                    <option value="thirdparty">Third Party</option>
                    <option value="comprehensive">Comprehensive</option>
                </select>

                <%= RenderHtmlForm.renderForm(com.bimaapp.app.model.CoverDetail.class)%>
            </form>
            <button id="closeFormBtn">Close</button>
        </div>
        <div class="overlay" id="overlay"></div>
    </div>
    <div class="table">
        <table>
            <tr>
                <th>Vehicle Reg</th>
                <th>Vehicle Make</th>
                <th>Vehicle Value</th>
                <th>Cover Type</th>
                <th>Premium</th>
            </tr>
            <%
            List<CoverDetail> policyCoverDetails = new CoverDetailSearchBean().getPolicyCoverDetails(request.getParameter("policy_num"));

                for (CoverDetail coverDetail : policyCoverDetails) {
            %>
            <tr>
                <td><%= coverDetail.getVehicleReg() %></td>
                <td><%= coverDetail.getVehicleMake() %></td>
                <td><%= coverDetail.getVehicleValue() %></td>
                <td><%= coverDetail.getCoverType() %></td>
                <td><%= coverDetail.getPremium() %></td>
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