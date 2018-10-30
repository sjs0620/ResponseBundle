package com.sjs.edu.responsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.buttonBMain);
        button.setOnClickListener(this);

        bundle = getIntent().getExtras();
        TextView textViewName = findViewById(R.id.textViewBSingleName);
        textViewName.setText("singleName :    " +bundle.getString("singleName","No Data"));
        TextView textViewBundle = findViewById(R.id.textViewBBundleName);
        textViewBundle.setText("BundleName :    " +bundle.hashCode());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        EditText editText = findViewById(R.id.editTextBMessage);

        Intent intent = new Intent();
        bundle = new Bundle();

        bundle.putString("resultValue",((EditText)editText).getText().toString());
        intent.putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER,intent);
        super.finish();
    }
}
