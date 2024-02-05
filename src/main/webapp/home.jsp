<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("email") %></h1>
    <form action="logout" method="get">
        <input type="submit" value="Logout">
    </form>
</body>
</html>