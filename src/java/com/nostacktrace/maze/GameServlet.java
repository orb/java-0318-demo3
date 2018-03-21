package com.nostacktrace.maze;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class GameServlet extends HttpServlet {

    protected <T> T pickOne(T[] valuesToPickFrom) {
        return valuesToPickFrom[new Random().nextInt(valuesToPickFrom.length)];
    }

    public MazeGame.Direction directionFromString(String directionName) {
        if ("random".equals(directionName)) {
            return pickOne(MazeGame.Direction.values());
        }
        return MazeGame.Direction.valueOf(directionName);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MazeGame currentGame = (MazeGame) request.getSession().getAttribute("maze");
        if (currentGame == null) {
            currentGame = new MazeGame();
            request.getSession().setAttribute("maze", currentGame);
        }

        if (currentGame.atGoal()) {
            getServletContext().getRequestDispatcher("/WEB-INF/done.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/maze.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        MazeGame currentGame = (MazeGame) request.getSession().getAttribute("maze");

        if (currentGame != null) {
            currentGame.move(directionFromString(request.getParameter("direction")));
        }

        resp.sendRedirect("/maze/");
    }
}
