<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            The session counter is <b>${sessionCounter.count}</b>.
        </p>
        <p>
            The application counter is <b>${globalCounter.count}</b>.
        </p>
        
        <a href="/maze/reset">Clear the session </a>
    </body>
</html>
