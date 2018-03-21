<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A Silly Game</title>
        <link rel="stylesheet" href="/maze/css/game.css" />
    </head>
    <body>   
        <h1>Find the treasure!</h1>
        <c:forEach begin="0" end="${maze.mazeHeight-1}" var="y">
            <div class="map-row">
                <c:forEach begin="0" end="${maze.mazeWidth-1}" var="x">
                    <c:choose>
                        <c:when test="${maze.tileAt(x,y)== 'PLAYER'}">
                            <div class="map-tile map-empty">
                                <img src="/maze/images/hero-32.png" width="32" height="32" />
                            </div>
                        </c:when>
                        <c:when test="${maze.tileAt(x,y)== 'GOAL'}">
                            <div class="map-tile map-empty">
                                <img src="/maze/images/chest.png" width="32" height="32" />
                            </div>
                        </c:when>
                        <c:when test="${maze.tileAt(x,y)== 'WALL'}">
                            <div class="map-tile map-wall"></div>
                        </c:when>
                        <c:otherwise>
                            <div class="map-tile map-empty"></div>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </div>
        </c:forEach>

        <hr />
        <div>
            <p>Steps Taken: ${maze.steps}</p>
        </div>    


        <form method="POST" action="/maze/">
            <input type="submit" name="direction" value="UP" />
            <input type="submit" name="direction" value="DOWN" />
            <input type="submit" name="direction" value="LEFT" />
            <input type="submit" name="direction" value="RIGHT" />

            <input type="submit" name="direction" value="random" />
        </form>




</html>
