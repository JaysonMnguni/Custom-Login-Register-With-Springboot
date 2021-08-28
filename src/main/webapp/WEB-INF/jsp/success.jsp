<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.css">
    <title>Error</title>
</head>
<body>

    <!-- Fake Navigation -->
    <nav class="fake-nav">
        <li>Home</li>
        <li>About</li>
        <li>Services</li>
        <li>Contact</li>
    </nav>
    <!-- End Of Fake Navigation -->

    <!-- Login Button -->
    <a id="login-btn" href="/" role="button" class="btn btn-sm">Back to Home</a>
    <!-- End Of Login Button -->

    <!-- Card -->
    <div id="login-card" class="card col-sm-3 px-0 alert alert-success border border-success">
        <!-- Card Body -->
        <div class="card-body">
            <!-- Card Title -->
            <div class="card-title">
                <i class="fa fa-check-square"></i> SUCCESS
            </div>
            <!-- End Of Card Title -->
            <hr>
                <!-- Display Messages -->
                <c:if test="${requestScope.success != null}">
                    <p class="card-text">
                        <b>${success}</b>
                    </p>
                   <!-- End of Card Text -->
                </c:if>
                <!-- End Of Display Messages -->
        </div>
        <!-- End of Card Body -->
    </div>
    <!-- End of Card -->


</body>
</html>