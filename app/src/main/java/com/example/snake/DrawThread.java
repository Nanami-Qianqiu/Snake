package com.example.snake;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;

public class DrawThread extends Thread{

    private SurfaceHolder surfaceHolder;

    private volatile boolean running = true;

    @SuppressLint("ResourceAsColor")
    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        // 初始化蛇的颜色
        Content.snake.Create_colors();
        Content.snake.CreateThemes();
        // 初始化画笔
        Content.init.Create_background_paint(Content.paints.background_paint); //初始化背景画笔
        Content.init.Create_edge_paint(Content.paints.edge_paint); // 初始化边框画笔
        Content.init.Create_score_paint(Content.paints.score_paint); // 初始化分数显示画笔
        Content.init.Create_theme_paint(Content.paints.theme_paint); // 初始化主题画笔
        Content.init.Create_speed_paint(Content.paints.speed_paint); // 初始化速度显示画笔
        Content.init.Create_snake_stroke_paint(Content.paints.snake_stroke_paint); // 初始化蛇的描边画笔
        Content.init.Create_snake_fill_paint(Content.paints.snake_fill_paint); // 初始化蛇的填充画笔
        Content.init.Create_food_paint(Content.paints.food_paint); // 初始化食物的画笔
        Content.init.Create_pause_paint(Content.paints.pause_paint);
        // 创建蛇
        Content.snake.CreateSnake();
    }

    public void requestStop() {
        running = false;
    }

    @Override
    public void run(){
        while (running) {
            Log.d("r","runrunrun");
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    // 创建地图
                    Content.display.CreateMap(canvas);
                    Content.snake.EatFood();
                    Content.snake.Move();
                    Content.game_methods.HitWall(canvas);
                    Content.game_methods.HitBody();

                    // 显示文字
                    Content.display.Text_display(canvas);

                    // 创建食物
                    Content.food.CreateFood();

                    // 食物显示
                    Content.display.Food_display(canvas);

                    // 蛇的填充颜色变化
                    Content.paints.snake_fill_paint.setColor(Color.parseColor(Content.snake.fill_color[Content.snake.theme]));

                    // 蛇的显示
                    Content.display.Snake_display(canvas);

                    // Thread sleep
                    Thread.sleep(Content.snake.speed);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
