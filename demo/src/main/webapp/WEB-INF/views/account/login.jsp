<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<h1>Login</h1>

${msg}
<form method="post"
      action="${pageContext.request.contextPath}/account?action=login">
    Username <input type="text" name="username">
    <br>
    Password <input type="password" name="password">
    <br>
    <button type="submit">Login</button>
    <br>
    <a href="${pageContext.request.contextPath}/account?action=register">
        Register</a>
</form>