package com.example.snake;

public class Snake {
    int [][] xy = new int[200][2];
    int length;
    char position;
    int theme = 0;
    int score = 0;
    int speed = 200;
    int lv = 1;

    String stroke_color = "#D7FFFE";
    String [] fill_color = new String [11];
    String [] themes = new String [11];

    public void CreateThemes(){
        themes[0] = "Dust Snake";
        themes[1] = "Green Snake";
        themes[2] = "Sea Snake";
        themes[3] = "Fire Snake";
        themes[4] = "Poison Snake";
        themes[5] = "Golden Snake";
        themes[6] = "Rune Snake";
        themes[7] = "Error Snake";
        themes[8] = "Code Snake";
        themes[9] = "Sky Snake";
        themes[10] = "Time Snake";
    }

    public void Create_colors(){
        fill_color[0] = "#6D6E71";
        fill_color[1] = "#BEF761";
        fill_color[2] = "#64C7FF";
        fill_color[3] = "#FF0000";
        fill_color[4] = "#4D8802";
        fill_color[5] = "#FBFF00";
        fill_color[6] = "#51EAFF";
        fill_color[7] = "#231F20";
        fill_color[8] = "#5BFF62";
        fill_color[9] = "#E4FFF9";
        fill_color[10] = "#A400FF";
    }

    public void CreateSnake(){
        xy[0][0] = 600;
        xy[0][1] = 800;
        xy[1][0] = 640;
        xy[1][1] = 800;
        xy[2][0] = 680;
        xy[2][1] = 800;
        position = 'l';
        length = 3;
        speed = 200;
        score = 0;
        theme = 0;
        lv = 1;
    }

    public void Move(){
        if (!Content.game_methods.pause_flag) {    // 暂停判断
            for (int i = length - 1; i > 0; i--) {
                xy[i][0] = xy[i - 1][0];
                xy[i][1] = xy[i - 1][1];
            }

            switch (position) {
                case 'u':
                    xy[0][1] -= 40;
                    break;
                case 'd':
                    xy[0][1] += 40;
                    break;
                case 'l':
                    xy[0][0] -= 40;
                    break;
                case 'r':
                    xy[0][0] += 40;
                    break;
            }
        }
    }

    public void EatFood(){
        if (xy[0][0] == Content.food.x && xy[0][1] == Content.food.y){
            length++;
            Content.food.food_symbol = 0;
            score += 10;
            if (speed > 50) speed -= 5;
            if (theme + 1 == 11) theme = 0;
            else theme++;
            if (lv <= 30) lv++;
        }
    }
}
