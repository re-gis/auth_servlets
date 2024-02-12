<!DOCTYPE html>
<html>
  <head>
    <title>Register</title>
  </head>
  <body>
    <h2>Register</h2>
    <form action="register" method="post">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required /><br />
      <label for="email">Email:</label>
      <input type="email" name="email" id="email" required /><br />
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required /><br />
      <input type="number" id="age" name="age" required /><br />
      <input type="submit" value="Register" />
    </form>
    <% if (request.getParameter("error") != null) { %>
    <p style="color: red">Registration failed. Please try again.</p>
    <% } %>
    <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
  </body>
</html>
