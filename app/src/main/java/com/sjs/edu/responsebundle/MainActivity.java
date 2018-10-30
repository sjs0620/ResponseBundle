package com.sjs.edu.responsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonAFirst);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextName = findViewById(R.id.editTextName);
        String text = editTextName.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("singleName",text);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,Activity.RESULT_FIRST_USER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(data.hasExtra("resultValue")){
            TextView textView = findViewById(R.id.textViewAResult);
            textView.setText(data.getStringExtra("resultValue"));
        }
    }
}
