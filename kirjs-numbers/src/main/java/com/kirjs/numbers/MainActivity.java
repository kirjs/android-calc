package com.kirjs.numbers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.kirjs.numbers.answers.Answer;
import com.kirjs.numbers.answers.AnswerLog;
import com.kirjs.numbers.questions.MultiplyQuestion;
import com.kirjs.numbers.utils.QuestionTextWatcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private long startTime;
    private AnswerLog answerLog = new AnswerLog();
    ArrayList<String> stats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MultiplyQuestion question = new MultiplyQuestion();
        displayQuestion(question.next());


        stats.add("hello");
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, stats);
        this.getStatsField().setAdapter(adapter);

        getAnswerField().addTextChangedListener(new QuestionTextWatcher(result -> {
            Answer answer = question.validate(result);
            if (answer.isValid) {
                answer.setTime(System.currentTimeMillis() - startTime);
                answerLog.add(answer);
                adapter.clear();
                adapter.addAll(answerLog.last(10));
                displayQuestion(question.next());
                displayLog();
            }
        }));

    }

    private void displayLog() {

    }


    public void displayQuestion(String question) {
        startTime = System.currentTimeMillis();
        getAnswerField().getText().clear();
        getQuestionField().setText(question);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private TextView getQuestionField() {
        return (TextView) findViewById(R.id.question);
    }

    private ListView getStatsField() {
        return (ListView) findViewById(R.id.stats);
    }

    private EditText getAnswerField() {
        return (EditText) findViewById(R.id.edit_message);
    }
}
