package com.example.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.labo3.utils.AppConstant;

public class MainActivity extends AppCompatActivity {

    private EditText mEdit;
    private Button mButton, mButtonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit = findViewById(R.id.et_text);
        mButton = findViewById(R.id.btn_send);
        mButtonShare = findViewById(R.id.btn_share);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEdit.getText().toString();
                Intent mInten = new Intent(MainActivity.this,NewActivity.class);
                mInten.putExtra(AppConstant.TEXT_KEY,text);
                startActivity(mInten);
            }
        });

        mButtonShare.setOnClickListener( v -> {
            String text= mEdit.getText().toString();
            Intent mIntent = new Intent();
            mIntent.setType("text/plain");
            mIntent.setAction(Intent.ACTION_SEND);
            mIntent.putExtra(Intent.EXTRA_TEXT, text);

            startActivity(mIntent);
        });
    }
}
