package com.example.snake;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Button;

import androidx.core.content.ContextCompat;

public class DrawThread extends Thread{

    private SurfaceHolder surfaceHolder;

    Paint backgroundPaint = new Paint();
    Paint edge = new Paint();
    Paint snake_stroke = new Paint();
    Paint snake_fill = new Paint();
    Paint food_paint = new Paint();
    Paint score_paint = new Paint();
    Paint theme_paint = new Paint();
    Paint speed_paint = new Paint();
    String text_score = "Score: ";
    String text_color = "#64C7FF";
    int text_size = 60;

    private volatile boolean running = true;

    @SuppressLint("ResourceAsColor")
    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        // snake color
        Content.snake.colors();
        Content.snake.CreateThemes();
        // initialization paint
        backgroundPaint.setColor(Color.parseColor("#231F20"));
        edge.setColor(Color.GRAY);

        score_paint.setTextSize(text_size);
        score_paint.setAntiAlias(true);
        score_paint.setColor(Color.parseColor(text_color));

        theme_paint.setTextSize(text_size);
        theme_paint.setAntiAlias(true);
        theme_paint.setColor(Color.parseColor(text_color));

        speed_paint.setTextSize(text_size);
        speed_paint.setAntiAlias(true);
        speed_paint.setColor(Color.parseColor(text_color));

        snake_stroke.setStyle(Paint.Style.STROKE);
        snake_stroke.setStrokeWidth(3);
        snake_stroke.setColor(Color.parseColor(Content.snake.stroke_color));

        snake_fill.setStyle(Paint.Style.FILL);
        snake_fill.setColor(Color.parseColor(Content.snake.fill_color[Content.snake.theme]));

        food_paint.setColor(Color.parseColor(Content.food.food_color));
        // create snake
        Content.snake.CreateSnake();

    }

    public void requestStop() {
        running = false;
    }

    public void gameover(Canvas canvas) throws InterruptedException {
        Content.snake.CreateSnake();
        Content.food.CreateFood();
        Thread.sleep(500);
    }

    public void HitWall(Canvas canvas) throws InterruptedException {
        if (Content.snake.xy[0][0] < 40 || Content.snake.xy[0][0] > canvas.getWidth() - 80 || Content.snake.xy[0][1] < 160 || Content.snake.xy[0][1] > 1360){
            gameover(canvas);
        }
    }

    public void HitBody(Canvas canvas) throws InterruptedException {
        for (int i = 1; i < Content.snake.length; i++){
            if (Content.snake.xy[0][0] == Content.snake.xy[i][0] && Content.snake.xy[0][1] == Content.snake.xy[i][1]){
                gameover(canvas);
            }
        }
    }

    @Override
    public void run(){
        while (running) {
            Log.d("r","runrunrun");
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {

                    // create map
                    canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
                    canvas.drawRect(0, 1400, canvas.getWidth(), 1440, edge);
                    canvas.drawRect(0, 120, 40, 1440, edge);
                    canvas.drawRect(canvas.getWidth() - 40, 120, canvas.getWidth(), 1440, edge);
                    canvas.drawRect(0, 120, canvas.getWidth(), 160, edge);
                    Content.snake.EatFood();
                    Content.snake.Move();
                    HitWall(canvas);
                    HitBody(canvas);

                    // text
                    canvas.drawText(text_score + Content.snake.score, 40, 90, score_paint);
                    canvas.drawText(Content.snake.themes[Content.snake.theme], 400, 90, theme_paint);
                    canvas.drawText("Speed: " + Content.snake.lv, 800, 90, speed_paint);


                    if (Content.food.foodsymbol == 0) Content.food.CreateFood();

                    // draw food
                    canvas.drawRect(Content.food.x, Content.food.y, Content.food.x + 40, Content.food.y + 40, food_paint);

                    // draw snake
                    snake_fill.setColor(Color.parseColor(Content.snake.fill_color[Content.snake.theme]));
                    for (int i = 0; i < Content.snake.length; i++){
                        canvas.drawRect(Content.snake.xy[i][0], Content.snake.xy[i][1], Content.snake.xy[i][0] + 40, Content.snake.xy[i][1] + 40, snake_fill);
                    }
                    for (int i = 0; i < Content.snake.length; i++){
                        canvas.drawRect(Content.snake.xy[i][0], Content.snake.xy[i][1], Content.snake.xy[i][0] + 40, Content.snake.xy[i][1] + 40, snake_stroke);
                    }

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
