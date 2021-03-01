package com.example.snake;

import android.graphics.Canvas;

public class Display {
    public void CreateMap(Canvas canvas){
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), Content.paints.background_paint);
        canvas.drawRect(0, 1400, canvas.getWidth(), 1440, Content.paints.edge_paint);
        canvas.drawRect(0, 120, 40, 1440, Content.paints.edge_paint);
        canvas.drawRect(canvas.getWidth() - 40, 120, canvas.getWidth(), 1440, Content.paints.edge_paint);
        canvas.drawRect(0, 120, canvas.getWidth(), 160, Content.paints.edge_paint);
    }

    public void Text_display(Canvas canvas){
        if (!Content.game_methods.pause_flag) {
            canvas.drawText("Scores: " + Content.snake.score, 40, 90, Content.paints.score_paint);
            canvas.drawText(Content.snake.themes[Content.snake.theme], 400, 90, Content.paints.theme_paint);
            canvas.drawText("Speed: " + Content.snake.lv, 800, 90, Content.paints.speed_paint);
        }
        else {
            canvas.drawText("Pause", 450, 90, Content.paints.pause_paint);
        }
    }

    public void Food_display(Canvas canvas){
        canvas.drawRect(Content.food.x, Content.food.y, Content.food.x + 40, Content.food.y + 40, Content.paints.food_paint);
    }

    public void Snake_display(Canvas canvas){
        for (int i = 0; i < Content.snake.length; i++){
            canvas.drawRect(Content.snake.xy[i][0], Content.snake.xy[i][1], Content.snake.xy[i][0] + 40, Content.snake.xy[i][1] + 40, Content.paints.snake_fill_paint);
        }
        for (int i = 0; i < Content.snake.length; i++){
            canvas.drawRect(Content.snake.xy[i][0], Content.snake.xy[i][1], Content.snake.xy[i][0] + 40, Content.snake.xy[i][1] + 40, Content.paints.snake_stroke_paint);
        }
    }
}
