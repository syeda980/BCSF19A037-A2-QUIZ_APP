package com.myapplication.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView question, totalQuestion,remQues,correctRes,wrongRes;
    Button btnA, btnB, btnC, btnD, btnSubmit,restartBtn;
    int correct = 0;
    int j=0;
    int wrong_Answer = 0;
    int totalQuestions = QuestionData.questions.length;
    int remQuestions=totalQuestions;
    int currentQuestion = 0, qNo = 0,index=0;
    String answer = "",selectedAnswer="";
    ArrayList<Integer>numbers=shuffleQuestionList();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestion = findViewById(R.id.totalQuestion);
        question = findViewById(R.id.QuestionText);
        btnA = findViewById(R.id.AnswerA);
        btnB = findViewById(R.id.AnswerB);
        btnC = findViewById(R.id.AnswerC);
        btnD = findViewById(R.id.AnswerD);
        btnSubmit = findViewById(R.id.submit);
        remQues=findViewById(R.id.remainingQues);
        restartBtn=findViewById(R.id.restart);
        correctRes=findViewById(R.id.Correct);
        wrongRes=findViewById(R.id.Wrong);
        correctRes.setVisibility(View.INVISIBLE);
        wrongRes.setVisibility(View.INVISIBLE);
        restartBtn.setVisibility(View.INVISIBLE);


        btnA.setOnClickListener(this);
        restartBtn.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        totalQuestion.setText("Total Question: " + totalQuestions);
        remQues.setText("Remaining: "+remQuestions);

        generateMCQ();
    }


    @Override
    public void onClick(View view) {


    }
    public void generateQuestion(int index)
    {}
    private void generateMCQ() {
        if(remQuestions==0)
        {
            showResult();
            return;
        }
        qNo=numbers.get(index);
        index++;
        switch (qNo) {
            case 0:
                generateQuestion(qNo);
            case 1:
                generateQuestion(qNo);

            case 2:
                generateQuestion(qNo);
            case 3:
                generateQuestion(qNo);
            case 4:
                generateQuestion(qNo);
            case 5:
                generateQuestion(qNo);
            case 6:
                generateQuestion(qNo);
            case 7:
                generateQuestion(qNo);
            case 8:
                generateQuestion(qNo);
            case 9:
                generateQuestion(qNo);


        }
    }
    void showResult()
    {
        question.setVisibility(View.INVISIBLE);
        btnA.setVisibility(View.INVISIBLE);
        btnB.setVisibility(View.INVISIBLE);
        btnC.setVisibility(View.INVISIBLE);
        btnD.setVisibility(View.INVISIBLE);
        btnSubmit.setVisibility(View.INVISIBLE);
        correctRes.setVisibility(View.VISIBLE);
        wrongRes.setVisibility(View.VISIBLE);
        correctRes.setText("CORRECT: "+correct);
        wrongRes.setText("WRONG: "+wrong_Answer);
        restartBtn.setVisibility(View.VISIBLE);



    }    void restartQuiz(){

    }

}
