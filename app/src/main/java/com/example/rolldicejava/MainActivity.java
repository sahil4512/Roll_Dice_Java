package com.example.rolldicejava;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private Button rollDices;
    private Button github_link;
    private ImageView imageView1, imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollDices = findViewById(R.id.rollDices);
        imageView1 = findViewById(R.id.ImageView_1);
        imageView2 = findViewById(R.id.ImageView_2);
        github_link = findViewById(R.id.github_link);


        github_link.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/sahilkumardev/Roll_Dice_Java"));
                startActivity(intent);
            }
        });

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();

                int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.rolldicejava");
                int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.rolldicejava");

                imageView1.setImageResource(res1);
                imageView2.setImageResource(res2);
            }
        });
    }

    public static int randomDiceValue(){
        return RANDOM.nextInt(6) + 1;
    }
}
