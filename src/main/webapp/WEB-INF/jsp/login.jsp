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
    <title>Login</title>
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
    <div id="login-card" class="card col-sm-3 px-0">
        <!-- Card Body -->
        <div class="card-body">
            <!-- Card Title -->
            <div class="card-title text-center">
                <i class="fa fa-user"></i> SIGN IN
            </div>
            <!-- End Of Card Title -->

                <!-- Display Messages -->
                <c:if test="${requestScope.LoginSuccess != null}">
                <div class="alert alert-success text-center">
                    <b>${LoginSuccess}</b>
                </div>
                </c:if>
                <!-- End Of Display Messages -->

                <!-- Display Messages -->
                <c:if test="${requestScope.incorrectDetails != null}">
                <div class="alert alert-danger text-center">
                    <b>${incorrectDetails}</b>
                </div>
                </c:if>
                <!-- End Of Display Messages -->

                <!-- Display Messages -->
                <c:if test="${requestScope.logoutSuccess != null}">
                <div class="alert alert-info text-center">
                    <b>${logoutSuccess}</b>
                </div>
                </c:if>
                <!-- End Of Display Messages -->

            <!-- Login Form -->
            <form:form action="/login" method="post" modelAttribute="userLogin">
                <!-- Form Group -->
                <div class="form-group">
                    <label for="">Email</label>
                    <form:input type="email" cssClass="form-control" path="email" id="" placeholder="Please Enter Email..."/>
                    <form:errors path="email" cssClass="text-danger"/>
                </div>
                <!-- Form Group -->

                <!-- Form Group -->
                <div class="form-group">
                    <label for="">Password</label>
                    <form:input type="password" class="form-control" path="password" id="" placeholder="Please Enter Password..."/>
                    <form:errors path="password" cssClass="text-danger"/>
                </div>
                <!-- Form Group -->


                <!-- Form Group -->
                <div class="form-group">
                    <input type="hidden" name="_token" id="" value="${requestScope.tokenFromController}"/>
                </div>
                <!-- Form Group -->

                <!-- Form Group -->
                <div class="form-group">

                    <button class="submit-btn btn btn-md">Login</button>
                </div>
                <!-- Form Group -->


            </form:form>
            <!-- End of Login Form -->
        </div>
        <!-- End of Card Body -->

        <!-- Form / Card Footer -->
        <div id="login-form-footer" class="card-footer text-center">
            <!-- Fake Disclaimer -->
            <h5 class="card-text text-muted">
                <b>Disclaimer</b>
            </h5>
            <!-- End of Fake Disclaimer -->

            <!-- Fake Discription -->
            <p class="card-text text-muted">
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Mollitia odit libero itaque culpa perspiciatis aliquam.
            </p>
            <!-- End of Fake Discription -->


        </div>
        <!-- End of Form / Card Footer -->

    </div>
    <!-- End of Card -->


</body>
</html>