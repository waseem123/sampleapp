<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Registration</title>
	<style type="text/css">
		table,td{
            border: 1px solid black;
            border-collapse: collapse;
            padding:24px;
            text-align: center;
        }
        .formdiv{
            padding: 8px;
            border: 1px solid black;
            display: inline-block;
            margin-top: 24px;
        }

		.input{
			height: 20px;
			width: 300px;
		}
	</style>
</head>
<body>
    <h2>Admin Registration</h2>
	<div class="formdiv">
		<form action="register" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Registration</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label for="user_name">Name</label>
						</td>
						<td>
							<input type="text" id="user_name" class="input" name="user_name">
						</td>
					</tr>
					<tr>
						<td>
							<label for="user_email">Email</label>
						</td>
						<td>
							<input type="text" id="user_email" class="input" name="user_email">
						</td>
					</tr>
					<tr>
						<td>
							<label for="user_password">Password</label>
						</td>
						<td>
							<input type="password" id="user_password" class="input" name="user_password">
						</td>
					</tr>
					<tr>
						<td colspan="2"><button type="submit">Register</button></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
</body>
</html>