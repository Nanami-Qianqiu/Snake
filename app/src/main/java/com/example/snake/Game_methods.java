package com.example.snake;

import android.graphics.Canvas;

public class Game_methods {
    boolean pause_flag = false; // 暂停标志

    public void game_over() throws InterruptedException {
        Content.snake.CreateSnake();
        Content.food.CreateFood();
        Thread.sleep(500);
    }

    public void HitWall(Canvas canvas) throws InterruptedException {
        if (Content.snake.xy[0][0] < 40 || Content.snake.xy[0][0] > canvas.getWidth() - 80 || Content.snake.xy[0][1] < 160 || Content.snake.xy[0][1] > 1360){
            game_over();
        }
    }

    public void HitBody() throws InterruptedException {
        for (int i = 1; i < Content.snake.length; i++){
            if (Content.snake.xy[0][0] == Content.snake.xy[i][0] && Content.snake.xy[0][1] == Content.snake.xy[i][1]){
                game_over();
            }
        }
    }
}
