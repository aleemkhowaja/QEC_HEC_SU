<%@page isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Realstate Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
  

  
</head>

<body>


  

  <div class="cont">
  <div class="demo">
  
  
    <div class="login">
	    
	<c:if test="${not empty error}">
	    <center>
		<div class="error" style="color:red;font-size:15px">${error}</div>
		</center>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>   

	
	 
	  <form name='login' action="<c:url value='/loginPages' />" method="GET">
  
      <div class="login__form">
        <div class="login__row">
          
          <input type="text" class="login__input name" placeholder="Username" name="username" />
        </div>
        <div class="login__row">
          
          <input type="password" class="login__input pass" placeholder="Password" name="password" />
        </div>
        
        <button type="submit" class="login__submit">LOGIN</button>
        <!-- <p class="login__signup"><a>Forgot Password?</a></p> -->
        
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </div>
      	</form> 
    </div>

	
	
 
  </div>
</div>

    

</body>
</html>