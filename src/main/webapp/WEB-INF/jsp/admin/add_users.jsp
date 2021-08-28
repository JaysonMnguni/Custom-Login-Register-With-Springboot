<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/fontawesome/css/all.css">
    <title>Add Users</title>
</head>
<body>
    <!-- Main Page Header -->
    <header class="main-page-header">

        <!-- Header Elements Container -->
        <div class="container d-flex">
            <!-- Main Navigation -->
            <nav class="main-nav mr-2 d-flex align-items-center">
                <li> <i class="fa fa-desktop"></i> <a href="/admin/dashboard" class=" text-light">Dashboard</a></li>
                <li> <i class="fa fa-user"></i> <a href="/admin/add_users" class=" text-light">Users</a></li>
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
        <b>Add New User</b> <a href="/admin/dashboard" role="button" class="btn btn-sm btn-light border border-dark ml-auto">Back to Home</a>
    </div>
    <!-- End of Container -->

    <!-- Container: User Card -->
    <div class="container">
        <!-- Card -->
        <div class="card">

            <!-- Card Header -->
            <div class="card-header bg-primary text-white">
               <i class="fa fa-users mr-2"></i> Please fill in the form below  to add a new user:
            </div>
            <!-- End of Card Header -->

            <!-- card body -->
            <div class="card-body">
                <!-- Display Messages -->
                <c:if test="${requestScope.RegistrationSuccess != null}">
                <div class="alert alert-success text-center">
                    <b>${RegistrationSuccess}</b>
                </div>
                </c:if>
                <!-- End Of Display Messages -->

                <!-- Display Messages -->
                <c:if test="${requestScope.PasswordMisMatch != null}">
                <div class="alert alert-danger text-center">
                    <b>${PasswordMisMatch}</b>
                </div>
                </c:if>
                <!-- End Of Display Messages -->

                <!-- Display Messages -->
                <c:if test="${requestScope.RegisterError != null}">
                <div class="alert alert-danger text-center">
                    <b>${RegisterError}</b>
                </div>
                </c:if>
                <!-- End Of Display Messages -->

                <!-- Add User Form -->
                <form:form action="/admin/add_user" modelAttribute="registerUser">
                    <!-- Row -->
                    <div class="row">
                        <!-- Form Group -->
                        <div class="form-group col">
                            <label for=""> First name</label>
                            <form:input type="text" path="first_name" cssClass="form-control" id="" placeholder="Please Enter First Name..."/>
                            <form:errors path="first_name" cssClass="text-danger"/>
                        </div>
                        <!-- End of Form Group -->

                        <!-- Form Group -->
                        <div class="form-group col">
                            <label for=""> Last name</label>
                            <form:input type="text" path="last_name" cssClass="form-control" id="" placeholder="Please Enter Last Name..."/>
                            <form:errors path="last_name" cssClass="text-danger"/>
                        </div>
                        <!-- End of Form Group -->
                    </div>
                    <!-- Row -->

                    <!-- Form Group -->
                    <div class="form-group">
                        <label for=""> Email </label>
                        <form:input path="email" class="form-control" id="" placeholder="Please Enter Email.."/>
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>
                    <!-- End of Form Group -->

                    <!-- Row -->
                    <div class="row">
                        <!-- Form Group -->
                        <div class="form-group col">
                            <label for=""> Password</label>
                            <form:input type="password" path="password" cssClass="form-control" id="" placeholder="Please Enter Password..."/>
                            <form:errors path="password" cssClass="text-danger"/>
                        </div>
                        <!-- End of Form Group -->

                        <!-- Form Group -->
                        <div class="form-group col">
                            <label for=""> Confirm Password</label>
                            <form:input type="password" path="confirm_password" class="form-control" id="" placeholder="Please Confirm Password..."/>
                            <form:errors path="confirm_password" cssClass="text-danger"/>
                        </div>
                        <!-- End of Form Group -->
                    </div>
                    <!-- Row -->

                    <!-- Form Group -->
                    <div class="form-group">
                        <label for=""> User Type </label>
                        <form:select path="user_type" items="${user_types}" cssClass="form-control"/>
                        <form:errors path="user_type" cssClass="text-danger"/>
                        <!--<select name="user_type" class="form-control" id="">
                            <option value="">-- Select User Type --</option>
                            <option value="">Admin</option>
                            <option value=""> User</option>
                        </select>-->
                    </div>
                    <!-- End of Form Group -->

                    <!-- Form Group -->
                    <div class="form-group">
                        <button class="btn btn-md btn-success">Add User</button>
                    </div>
                    <!-- End of Form Group -->

                </form:form>
                <!-- End of Add User Form -->
            </div>
            <!-- card body -->

            <!-- card footer -->
            <div class="card-footer">
                <div class="card-text text-muted">
                    Lorem ipsum dolor sit amet.
                </div>
            </div>
        </div>
        <!-- End of Card -->
    </div>
    <!-- End Of Container: User Card -->

</body>
</html>