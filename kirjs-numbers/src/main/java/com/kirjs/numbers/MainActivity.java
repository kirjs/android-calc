package com.kirjs.numbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kirjs.numbers.answers.Answer;
import com.kirjs.numbers.answers.AnswerLog;
import com.kirjs.numbers.questions.MultiplyQuestion;
import com.kirjs.numbers.utils.QuestionTextWatcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "Ogogo";
    private long startTime;
    private AnswerLog answerLog = new AnswerLog();
    ArrayList<String> stats = new ArrayList<>();
    private final MultiplyQuestion question = new MultiplyQuestion();
    private ArrayAdapter<String> adapter;
    private Firebase myFirebaseRef;

    public void handleAnswer(String result) {
        Answer answer = question.validate(result);
        if (answer.isValid) {
            answer.setTime(System.currentTimeMillis() - startTime);
            answerLog.add(answer);
            adapter.clear();
            adapter.addAll(answerLog.last(10));
            displayQuestion(question.next());
            displayLog();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://kcherkashin-1.firebaseio.com/");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stats);


        new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    user.getUid();
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        displayQuestion(question.next());
        this.getStatsField().setAdapter(adapter);
        getAnswerField().addTextChangedListener(new QuestionTextWatcher(this));
        startActivityForResult(new Intent(this, AuthActivity.class), 9003);
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
