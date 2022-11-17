<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>${pageTitle}</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: center;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h2>Citizens</h2>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <table>
    		<thead>
    		    <tr>
    		        <td colspan="7"><a href="citizens/add-new" style="float:right"><button>Add New Citizen</button></a></td>
    		    </tr>
    			<tr>
    				<th>ID</th>
    				<th>Name</th>
    				<th>City</th>
    				<th>No. Of Doses</th>
    				<th>Vaccination Status</th>
    				<th>Vaccination Center</th>
                    <th>Action</th>
    			</tr>
    		</thead>
    		<tbody>
    		    <c:forEach items="${citizens}" var="citizen">
    			<tr>
    				<td>${citizen.citizenId}</td>
    				<td>${citizen.citizenName}</td>
    				<td>${citizen.citizenCity}</td>
    				<td>${citizen.citizenDoses}</td>
    				<td>
                        <c:if test="${citizen.citizenDoses == 0}">
                            Not Vaccinated
                        </c:if>
                        <c:if test="${citizen.citizenDoses == 1}">
                            Partially Vaccinated
                        </c:if>
                        <c:if test="${citizen.citizenDoses == 2}">
                            Fully Vaccinated
                        </c:if>
                    </td>
    				<td>${citizen.citizenCenter}</td>
                    <td>
                        <a href="citizens/${citizen.citizenId}"><button>View</button></a>
                        <a href="citizens/edit-citizen/${citizen.citizenId}"><button>Edit</button></a>
                        <a href="citizens/delete/${citizen.citizenId}"><button>Delete</button></a>
                    </td>
    			</tr>
    			</c:forEach>
    		</tbody>
    		<tfoot>
    		    <tr>
    		        <td colspan="7">${message}</td>
    		    </tr>
    		</tfoot>
    	</table>
    </body>
</html>