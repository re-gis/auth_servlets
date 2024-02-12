<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("email") %></h1>
    <form action="logout" method="get">
        <a href="/authapp/deposit">Deposit here</a><br/>
        <a href="/authapp/logout">Withdraw here</a><br/>
        <input type="submit" value="Logout">
    </form>
</body>
</html>