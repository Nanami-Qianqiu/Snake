package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button up, down, left, right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = findViewById(R.id.Up);
        down = findViewById(R.id.Down);
        left = findViewById(R.id.Left);
        right = findViewById(R.id.Right);
        // up button
        up.setOnClickListener(v -> {
            if (Content.snake.position != 'd') Content.snake.position = 'u';
        });
        // down button
        down.setOnClickListener(v -> {
            if (Content.snake.position != 'u') Content.snake.position = 'd';
        });
        // left button
        left.setOnClickListener(v -> {
            if (Content.snake.position != 'r') Content.snake.position = 'l';
        });
        // right button
        right.setOnClickListener(v -> {
            if (Content.snake.position != 'l') Content.snake.position = 'r';
        });
    }
}