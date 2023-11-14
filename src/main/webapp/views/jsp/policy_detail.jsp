<%@ page import="com.bimaapp.database.Database, com.bimaapp.model.CoverDetail, java.util.List, com.bimaapp.model.Policy, com.bimaapp.bean.PolicySearchBean"%>

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
        <h1> Policy Details</h1>
        <% Policy policy = new PolicySearchBean().getPolicy(request.getParameter("policy_num"));%>
        <h3>Client NAME:</h3> <span> <%=policy.getClient().getName()%> </span>
        <h3>Policy Number:</h3> <span> <%=policy.getNumber()%> </span>
        <h3>Start Date:</h3> <span> <%=policy.getStartDate()%> </span>
        <h3>End Date:</h3> <span> <%=policy.getEndDate()%> </span>
        <h3>Policy Class:</h3> <span> <%=policy.getPolicyType()%> </span>
        
    </div>
    <div class="">
            <h2>Add New Policy Detail</h2>
            <form action="./policy?policy_num=<%= request.getParameter("policy_num")%>" method="POST">
                <label for="vehicleReg">vehicle Reg:</label>
                <input id="vehicleReg" type="text" name="vehicleReg" class="form__input" placeholder="vehicle Reg" required>
                <label for="vehicleMake">vehicle Make:</label>
                <input id="vehicleMake" type="text" name="vehicleMake" class="form__input" placeholder="vehicle Make" required>
                <label for="vehicleValue">vehicle Value:</label>
                <input id="vehicleValue" type="number" name="vehicleValue" class="form__input" placeholder="vehicle Value" required>
                <label for="cover_type">Cover Type:</label>
                <select id="dropdown" name="cover_type">
                    <option value="thirdparty">Third Party</option>
                    <option value="comprehensive">Comprehensive</option>
                </select>
                <label for="terms">Terms:</label>
                <input id="terms" type="text" name="terms" class="form__input" placeholder="Terms" required>
                <input type="submit" value="Submit">
            </form>
    </div>
    <div class="">
        <table>
            <tr>
                <th>Vehicle Reg</th>
                <th>Vehicle Make</th>
                <th>Vehicle Value</th>
                <th>Cover Type</th>
                <th>Premium</th>
            </tr>
            <%
            List<CoverDetail> policyCoverDetails = new PolicySearchBean().getPolicyCoverDetails(request.getParameter("policy_num"));

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

     
</body>
</html>