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
        <h2>Citizens</h2>
        <table>
    		<thead>
    			<tr>
    				<th>ID</th>
    				<th>Name</th>
    				<th>City</th>
    				<th>No. Of Doses</th>
    				<th>Vaccination Center</th>
                    <th>Action</th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>${citizens[0].citizenId}</td>
    				<td>${citizens[0].citizenName}</td>
    				<td>${citizens[0].citizenCity}</td>
    				<td>${citizens[0].citizenDoses}</td>
    				<td>${citizens[0].centerId}</td>
                    <td>
                        <a href="edit-citizen"><button>Edit</button></a>
                        <button>Delete</button>
                    </td>
    			</tr>
    		</tbody>
    	</table>
    </body>
</html>