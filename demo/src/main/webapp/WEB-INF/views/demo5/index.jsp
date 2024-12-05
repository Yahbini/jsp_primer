<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>

<form method="get" action="${pageContext.request.contextPath}/demo5">
    Keyword <input type="text" name="keyword">
    <br>
    <button type="submit">Search</button>
    <input type="hidden" name="action" value="search-by-keyword">
</form>

<h3>Search by price</h3>
<form method="get" action="${pageContext.request.contextPath}/demo5">
    Min <input type="text" name="min">
    <br>
    Max <input type="text" name="max">
    <br>
    <button type="submit">Search</button>
    <input type="hidden" name="action" value="search-by-price">
</form>

<h3>Login</h3>
<form method="post" action="${pageContext.request.contextPath}/demo5">
    Username <input type="text" name="username">
    <br>
    Password <input type="password" name="password">
    <br>
    <button type="submit">Login</button>
    <input type="hidden" name="action" value="login">
</form>

<h3>Find By Date</h3>
<form method="post"
      action="${pageContext.request.contextPath}/demo5?action=find-by-date">
    From <input type="text" name="from" id="from">
    <br>
    To <input type="text" name="to" id="to">
    <br>
    <button type="submit">Search</button>
</form>

<h3>Upload file</h3>
<form method="post"
      action="${pageContext.request.contextPath}/demo5?action=upload"
      enctype="multipart/form-data">
    File <input type="file" name="file">
    <br>
    <button type="submit" name="action" value="upload">Upload</button>
</form>

<h3>Upload files</h3>
<form method="post"
      action="${pageContext.request.contextPath}/demo5?action=uploads"
      enctype="multipart/form-data">
    File <input type="file" name="files" multiple="multiple">
    <br>
    Fullname <input type="text" name="fullName">
    <br>
    Email <input type="text" name="email">
    <br>
    <button type="submit" value="upload">Upload</button>
</form>

<link rel="stylesheet"
      href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
<script>
    $(function () {
        var dateFormat = "dd/mm/yyyy",
            from = $("#from")
                .datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    numberOfMonths: 1,
                    dateFormat: dateFormat
                })
                .on("change", function () {
                    to.datepicker("option", "minDate", getDate(this));
                }),
            to = $("#to").datepicker({
                defaultDate: "+1w",
                changeMonth: true,
                numberOfMonths: 1,
                dateFormat: dateFormat
            })
                .on("change", function () {
                    from.datepicker("option", "maxDate", getDate(this));
                });

        function getDate(element) {
            var date;
            try {
                date = $.datepicker.parseDate(dateFormat, element.value);
            } catch (error) {
                date = null;
            }

            return date;
        }
    });
</script>
