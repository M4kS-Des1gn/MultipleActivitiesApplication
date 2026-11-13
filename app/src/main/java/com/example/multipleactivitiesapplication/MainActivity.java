package com.example.multipleactivitiesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_COUNT = "com.example.multipleactivitiesapplication.COUNT";
    private static final String STATE_COUNT = "count";
    private int count;
    private TextView showCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });
        showCount = findViewById(R.id.showCount);
        count = savedInstanceState == null ? 0 : savedInstanceState.getInt(STATE_COUNT, 0);
        showCount.setText(String.valueOf(count));
    }
    public void countUp(View view) {
        count++;
        showCount.setText(String.valueOf(count));
    }

    public void goToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_COUNT, count);
        startActivity(intent);
    }

    public void goToThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(EXTRA_COUNT, count);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_COUNT, count);
        super.onSaveInstanceState(outState);
    }
}
