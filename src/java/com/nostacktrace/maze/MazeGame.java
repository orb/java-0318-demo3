package com.nostacktrace.maze;

import java.io.Serializable;

public class MazeGame 
   implements Serializable
{
    public enum Tile {
        EMPTY,
        WALL,
        PLAYER,
        GOAL
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private final int MAZE_HEIGHT = 10;
    private final int MAZE_WIDTH = 20;

    private int steps = 0;
    
    Tile maze[][];
    int playerX = 1;
    int playerY = 1;

    public MazeGame() {
        this.maze = new Tile[MAZE_HEIGHT][MAZE_WIDTH];
        for (int x = 0; x < MAZE_HEIGHT; x++) {
            for (int y = 0; y < MAZE_WIDTH; y++) {
                maze[x][y] = Tile.EMPTY;
            }
        }

        maze[0][3] = Tile.WALL;
        maze[1][3] = Tile.WALL;
        maze[2][3] = Tile.WALL;
        maze[3][3] = Tile.WALL;
        maze[4][3] = Tile.WALL;

        maze[4][12] = Tile.WALL;
        maze[5][12] = Tile.WALL;
        maze[6][12] = Tile.WALL;
        maze[7][12] = Tile.WALL;
        maze[8][12] = Tile.WALL;
        maze[9][12] = Tile.WALL;

        maze[8][15] = Tile.GOAL;
    }

    public int getMazeHeight() {
        return MAZE_HEIGHT;
    }

    public int getMazeWidth() {
        return MAZE_WIDTH;
    }
    
    public int getSteps() {
        return this.steps;
    }

    public boolean atGoal() {
        return this.maze[playerY][playerX] == Tile.GOAL;
    }
    
    public Tile tileAt(int x, int y) {
        if (x == this.playerX && y == this.playerY) {
            return Tile.PLAYER;
        } else {
            return this.maze[y][x];
        }
    }

    private void moveTo(int x, int y) {
        if (x >= 0 && x < MAZE_WIDTH
                && y >= 0 && y < MAZE_HEIGHT
                && this.maze[y][x] != Tile.WALL) {
            this.playerX = x;
            this.playerY = y;
            this.steps ++;
        }

    }

    public void move(Direction direction) {
        switch (direction) {
            case UP: {
                moveTo(playerX, playerY - 1);
                break;
            }
            case DOWN: {
                moveTo(playerX, playerY + 1);
                break;
            }
            case LEFT: {
                moveTo(playerX - 1, playerY);
                break;
            }
            case RIGHT: {
                moveTo(playerX + 1, playerY);
                break;
            }
        }

    }
}
