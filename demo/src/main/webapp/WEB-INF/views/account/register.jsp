<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<h1>Register</h1>

${msg}
<form method="post"
      action="${pageContext.request.contextPath}/account?action=register">
  <table>
      <tr>
          <td>Username</td>
          <td>
              <input type="text" name="username" value="${account.username}">
          </td>
      </tr>
      <tr>
          <td>Password</td>
          <td>
              <input type="password" name="password">
          </td>
      </tr>
      <tr>
          <td>&nbsp;</td>
          <td>
              <button type="submit">Submit</button>
          </td>
      </tr>
  </table>
</form>