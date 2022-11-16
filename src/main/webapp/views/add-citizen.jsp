<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add Citizen</title>
	<style type="text/css">
		html,body{
			margin: 0;
			width: 100%;
		}
		.formdiv{
			padding: 8px;
			border: 1px solid black;
			display: inline-block;

			margin: auto;
			/*width: 50%;*/
		}

		.input{
			height: 20px;
			width: 300px;
		}
	</style>
</head>
<body>
	<div class="formdiv">
		<form action="add" method="POST">
			<table>
				<thead>
					<tr>
						<th><h3>Add new Citizen</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label for="citizen_name">Citizen Name</label>
						</td>
						<td>
							<input type="text" id="citizen_name" class="input" name="citizen_name">
						</td>
					</tr>
					<tr>
						<td>
							<label for="citizen_city">Citizen City</label>
						</td>
						<td>
							<select id="citizen_city" name="citizen_city" class="input">
                                <option value="">Select city</option>
                                <c:forEach items="${cities}" var="city">
                                    <option value="${city}">${city}</option>
                                </c:forEach>
                            </select>
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="citizen_center">Citizen City</label>
                        </td>
                        <td>
                            <select id="citizen_center" name="citizen_center" class="input">
                                <option value="1">PQR</option>
                                <option value="2">ABC</option>
                                <option value="3">Central</option>
                                <option value="4">PQR</option>
                            </select>
                        </td>
                    </tr>
					<tr>
						<td><button type="submit">Submit</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>