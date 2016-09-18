package com.kirjs.numbers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateQuestion();


        TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty() && Integer.valueOf(s.toString()) == number1 * number2) {
                    generateQuestion();
                }
            }


        };
        getAnswerField().addTextChangedListener(fieldValidatorTextWatcher);

    }

    private int number1;
    private int number2;

    public void generateQuestion() {
        TextView question = getQuestion();
        number1 = 5 + (int) Math.ceil(Math.random() * 20);
        number2 = 5 + (int) Math.ceil(Math.random() * 20);
        getAnswerField().getText().clear();

        question.setText(String.valueOf(number1) + " x " + String.valueOf(number2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    private TextView getQuestion() {
        return (TextView) findViewById(R.id.question);
    }

    private EditText getAnswerField(){
        return (EditText) findViewById(R.id.edit_message);
    }
}
