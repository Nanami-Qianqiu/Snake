package com.example.snake;

public class Food {
    int x, y;
    int food_symbol = 0;
    String food_color = "#FF2970";

    public void CreateFood(){
        if (food_symbol == 0) {
            int min_x = 40;
            int max_x = 1000;
            int min_y = 160;
            int max_y = 1400;
            x = min_x + (int) (Math.random() * (max_x - min_x + 1));
            y = min_y + (int) (Math.random() * (max_y - min_y + 1));
            x = x / 40 * 40;
            y = y / 40 * 40;
            food_symbol = 1;

            for (int i = 0; i < Content.snake.length; i++) {
                if (x == Content.snake.xy[i][0] && y == Content.snake.xy[i][1]) {
                    x = min_x + (int) (Math.random() * (max_x - min_x + 1));
                    y = min_y + (int) (Math.random() * (max_y - min_y + 1));
                    x = x / 40 * 40;
                    y = y / 40 * 40;
                }
            }
        }
    }
}
