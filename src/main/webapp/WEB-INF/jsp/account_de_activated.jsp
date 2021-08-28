<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.css">
    <title>Account De-activate</title>
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
    <div id="login-card" class="card col-sm-4 px-0">
        <!-- Card Body -->
        <div class="card-body">
            <!-- Card Title -->
            <div class="card-title text-center">
                <i class="fa fa-user"></i> ACCOUNT DE-ACTIVATED
            </div>
            <!-- End Of Card Title -->

            <!-- Card Text -->
            <div class="card-text alert alert-warning border border-warning">
                <ul>
                    <li>Your account has been de-activated</li>
                    <li>Please enter your registered email address in the form below</li>
                    <li>An email notification will be sent to the email provided below with instructions to activate account</li>
                    <li>Please review and proceed with instructions</li>
                </ul>
            </div>
            <!-- End of Card Text -->

            <!-- Login Form -->
            <form action="/account_de_activated" method="post">
                <!-- Form Group -->
                <div class="form-group">
                    <label for="">Email</label>
                    <input type="email" class="form-control" name="email" id="" placeholder="Please Enter Email...">
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