<html>
<body>
<h2>Hello World!</h2>
<form action="PersonServlet" method="post" >
<%session.setAttribute("formName", "AddPersonForm"); %>
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit!"></td>
			</tr>

		</table>
	</form>
</body>
</html>
