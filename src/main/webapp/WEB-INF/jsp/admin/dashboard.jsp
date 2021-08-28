<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/fontawesome/css/all.css">
    <title>Dashboard</title>
</head>
<body>
    <!-- Main Page Header -->
    <header class="main-page-header">

        <!-- Header Elements Container -->
        <div class="container d-flex">
            <!-- Main Navigation -->
            <nav class="main-nav mr-2 d-flex align-items-center">
                <li> <i class="fa fa-desktop"></i> <a href="/admin/dashboard" class=" text-light">Dashboard</a></li>
                <li> <i class="fa fa-user"></i> <a href="/admin/add_user" class=" text-light">Users</a></li>
                <li><i class="fa fa-cogs"></i> Setting </li>
                <li> <i class="fa fa-clipboard-check"></i>  Analytics</li>
            </nav>
            <!-- End Of Main Navigation -->

            <!-- Inline Form -->
            <form id="search-form" action="" class=" form-inline">
                <input type="text" name="" class="form-control form-control-sm" id="" placeholder="Search...">
                <button class="btn btn-sm btn-info">Search</button>
            </form>
            <!-- End Of Inline Form -->

            <!-- Login Identifier -->
            <div class="login-identifier alert alert-success py-1 px-1">
                Logged in as: <strong>${user.user_type}</strong>
            </div>
            <!-- End Of Login Identifier -->

            <!-- Username Display-->
            <div class="username-display d-flex align-items-center ml-auto">
                Welcome: <span class="text-light ml-2">${user.first_name} ${user.last_name}</span>
            </div>
            <!-- End Of Username Display-->

            <!-- Logout Button -->
            <div class="d-flex align-items-center ml-auto">
                <a href="/logout" class="btn btn-sm btn-outline-info">Logout</a>
            </div>
            <!-- End Of Logout Button -->

        </div>
        <!-- End Of Header Elements Container -->
    </header>
    <!-- End of Main Page Header -->

    <!-- Container -->
    <div class="container py-3 d-flex">
        <b>User Details</b> <a href="/admin/add_user" role="button" class="btn btn-sm btn-primary ml-auto">Add users</a>
    </div>
    <!-- End of Container -->

    <!-- Container: User Card -->
    <div class="container">
        <!-- Card -->
        <div class="card">
            <!-- Card Header -->
            <div class="card-header bg-info py-2 text-white">
                <i class="fa fa-user mr-2"></i> User Information
            </div>
            <!-- End Of Card Header -->

                <!-- User Details Display -->
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"> <b>First Name</b>: ${user.first_name}</li>
                    <li class="list-group-item"> <b>Last Name</b>: ${user.last_name}</li>
                    <li class="list-group-item"> <b>Email</b>: ${user.email}</li>
                    <li class="list-group-item"> <b>User Type</b>: ${user.user_type}</li>
                </ul>
                <!-- User Details Display -->

            <!-- card footer -->
            <div class="card-footer">
                <div class="card-text text-muted">
                    <b>Date Registered:</b> ${user.created_at}
                </div>
            </div>
        </div>
        <!-- End of Card -->
    </div>
    <!-- End Of Container: User Card -->

    <!-- Container: Footer -->
    <div class="container text-center text-muted py-4">
        <b>&copy Copy Right 2021. All Rights Reserved.</b>
    </div>
    <!-- End Of Container: Footer -->

</body>
</html>