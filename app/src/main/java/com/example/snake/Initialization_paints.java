package com.example.snake;

import android.graphics.Color;
import android.graphics.Paint;

public class Initialization_paints {

    public void Create_score_paint(Paint p){
        p.setTextSize(Content.value.text_size);
        p.setAntiAlias(true);
        p.setColor(Color.parseColor(Content.colors.text_color));
    }

    public void Create_theme_paint(Paint p){
        p.setTextSize(Content.value.text_size);
        p.setAntiAlias(true);
        p.setColor(Color.parseColor(Content.colors.text_color));
    }

    public void Create_speed_paint(Paint p){
        p.setTextSize(Content.value.text_size);
        p.setAntiAlias(true);
        p.setColor(Color.parseColor(Content.colors.text_color));
    }

    public void Create_snake_stroke_paint(Paint p){
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(3);
        p.setColor(Color.parseColor(Content.snake.stroke_color));
    }

    public void Create_snake_fill_paint(Paint p){
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.parseColor(Content.snake.fill_color[Content.snake.theme]));
    }

    public void Create_background_paint(Paint p){
        p.setColor(Color.parseColor("#231F20"));
    }

    public void Create_edge_paint(Paint p){
        p.setColor(Color.GRAY);
    }

    public void Create_food_paint(Paint p){
        p.setColor(Color.parseColor(Content.food.food_color));
    }

    public void Create_pause_paint(Paint p){
        p.setTextSize(Content.value.text_pause_size);
        p.setAntiAlias(true);
        p.setColor(Color.parseColor(Content.colors.text_color));
    }
}
