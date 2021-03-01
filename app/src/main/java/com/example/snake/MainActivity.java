package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button up, down, left, right;
    ImageButton pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = findViewById(R.id.Up);
        down = findViewById(R.id.Down);
        left = findViewById(R.id.Left);
        right = findViewById(R.id.Right);
        pause = findViewById(R.id.Pause);

        // pause button
        pause.setOnClickListener(v -> {
            if (!Content.game_methods.pause_flag) Content.game_methods.pause_flag = true;
            else Content.game_methods.pause_flag = false;
        });
        // up button
        up.setOnClickListener(v -> {
            if (Content.snake.position != 'd' && !Content.game_methods.pause_flag) Content.snake.position = 'u';
        });
        // down button
        down.setOnClickListener(v -> {
            if (Content.snake.position != 'u' && !Content.game_methods.pause_flag) Content.snake.position = 'd';
        });
        // left button
        left.setOnClickListener(v -> {
            if (Content.snake.position != 'r' && !Content.game_methods.pause_flag) Content.snake.position = 'l';
        });
        // right button
        right.setOnClickListener(v -> {
            if (Content.snake.position != 'l' && !Content.game_methods.pause_flag) Content.snake.position = 'r';
        });
    }
}