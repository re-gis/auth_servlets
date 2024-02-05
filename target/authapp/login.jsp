<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <h2>Login</h2>
    <form action="login" method="post">
      <label for="email">Email:</label>
      <input type="text" name="email" id="email" required /><br />
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required /><br />
      <input type="submit" value="Login" />
    </form>
    <% if (request.getParameter("error") != null) { %>
    <p style="color: red">Invalid email or password</p>
    <% } %>
    <p>No account yet? <a href="register.jsp">Register here</a>.</p>
  </body>
</html>
