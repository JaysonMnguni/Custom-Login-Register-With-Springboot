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
    <title>Verify Account</title>
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
    <a id="login-btn" href="/login" role="button" class="btn btn-sm">Back to Login</a>
    <!-- End Of Login Button -->

    <!-- Card -->
    <div id="login-card" class="card col-sm-3 px-0">
        <!-- Card Body -->
        <div class="card-body">
            <!-- Card Title -->
            <div class="card-title text-center">
                <i class="fa fa-user"></i> VERIFY ACCOUNT
            </div>
            <!-- End Of Card Title -->

                <!-- Display Messages -->
                <c:if test="${requestScope.passwordsDontMatch != null}">
                <div class="alert alert-danger text-center">
                    <b>${passwordsDontMatch}</b>
                </div>
                </c:if>
                <!-- End Of Display Messages -->

            <!-- Card Text -->
            <p class="card-text alert alert-info border border-info">
                <b>Please complete the below form to verify your account</b>
            </p>
            <!-- End of Card Text -->

            <!-- Login Form -->
            <form action="/verify_account" method="post">
                <!-- Form Group -->
                <div class="form-group">
                    <label for="">Password</label>
                    <input type="password" class="form-control" name="password" id="" placeholder="Please Enter Password...">
                </div>
                <!-- Form Group -->

                <!-- Form Group -->
                <div class="form-group">
                    <label for="">Confirm Password</label>
                    <input type="password" class="form-control" name="confirm_password" id="" placeholder="Please Confirm Password...">
                </div>
                <!-- Form Group -->

                <!-- Form Group -->
                <div class="form-group">
                    <input type="hidden" class="form-control" name="verification_token" id="" value='<c:out value="${param.verification_token}"/>'>
                    <input type="hidden" class="form-control" name="email" id="" value='<c:out value="${param.email}"/>'>
                </div>
                <!-- Form Group -->

                <!-- Form Group -->
                <div class="form-group">

                    <button class="submit-btn btn btn-md">Submit</button>
                </div>
                <!-- Form Group -->


            </form>
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