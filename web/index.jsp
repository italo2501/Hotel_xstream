
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">Hotel</h3>
        
                                   
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form name="formLogin" class="form" action="logar.jsp" method="post">
                            <h3 class="text-center text-info">Hotel</h3>
                            <div class="form-group">
                                
                                
                                <label for="username" class="text-info">Nome:</label><br>
                                <input type="text" name="login" id="username" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Senha:</label><br>
                                <input type="password" name="senha" id="password" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="Entrar" class="btn btn-info btn-md" value="Entrar" style="width: 300px; height: 50px;"/>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
