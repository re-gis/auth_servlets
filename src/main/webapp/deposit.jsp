<!DOCTYPE html>
<html>
<head>
    <title>Deposit Form</title>
</head>
<body>
    <h2>Deposit Form</h2>
    <form action="deposit" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="account_number" required><br><br>

        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required><br><br>

        <input type="submit" value="Deposit"><br/>
        <a href="/authapp/withdraw">Withdraw here</a><br/>
        <a href="/authapp/home">Home</a><br/>
        <a href="/authapp/logout">Logout</a>
    </form>
</body>
</html>