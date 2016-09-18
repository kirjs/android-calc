package com.kirjs.numbers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.kirjs.numbers.questions.MultiplyQuestion;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MultiplyQuestion question = new MultiplyQuestion();
        displayQuestion(question.next());

        TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(question.validate(s.toString())){
                    displayQuestion(question.next());
                }
            }
        };
        getAnswerField().addTextChangedListener(fieldValidatorTextWatcher);

    }



    public void displayQuestion(String question) {
        getAnswerField().getText().clear();
        getQuestion().setText(question);
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
