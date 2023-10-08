<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="assets/style_login_page/fonts/icomoon/style.css">

        <link rel="stylesheet" href="assets/style_login_page/css/owl.carousel.min.css">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assets/style_login_page/css/bootstrap.min.css">

        <!-- Style -->
        <link rel="stylesheet" href="assets/style_login_page/css/style.css">
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.0/mdb.min.css"
            rel="stylesheet"
            />
        <title>Login</title>
    </head>
    <body>



        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <img src="assets/img/undraw_remotely_2j6y.png" alt="Image" class="img-fluid">
                    </div>
                    <div class="col-md-6 contents">
                        <div class="row justify-content-center">
                            <div class="col-md-8">
                                <div class="mb-4">
                                    <h3>Sign In</h3>
                                    <p class="mb-4">Welcome to FCourse.</p>
                                </div>
                                <form action="login" method="post">
                                    <div class="form-group first">
                                        <label for="username" >Username or Email </label>
                                        <input type="text" class="form-control" id="username" name="username">
                                    </div>
                                    <div class="form-group last mb-4">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" id="password" name="password">
                                    </div>
                                    <div class="d-flex mb-5 align-items-center">
                                        <span class="d-block text-left my-4 text-muted"><a href="register" class="forgot-pass">Register</a></span> 
                                        <span class="ml-auto  my-4 text-muted">
                                            <a href="forgotPassword">Forgot Password</a>
                                        </span>
                                    </div>
                                    <p class="text-danger">${mess}</p>
                                    <input type="submit" value="Log In" class="btn btn-block btn-success">

                                    <span class="d-block text-left my-4 text-muted">&mdash; or login with &mdash;</span>
                                    <div class="social-login">  
                                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:9999/SWP391/LoginGoogleHandler&response_type=code
                                           &client_id=791103805368-o93k73dnt4ts1fq8k10jnuekjf4cg956.apps.googleusercontent.com&approval_prompt=force" class="google">
                                            <span class="icon-google mr-3"></span> 
                                        </a>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>


        <script src="assets/style_login_page/js/jquery-3.3.1.min.js"></script>
        <script src="assets/style_login_page/js/popper.min.js"></script>
        <script src="assets/style_login_page/js/bootstrap.min.js"></script>
        <script src="assets/style_login_page/js/main.js"></script>
        <script src="assets/style_login_page/js/check-email.js"></script>
        <!-- MDB -->
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.0/mdb.min.js"
        ></script>
    </body>
</html>