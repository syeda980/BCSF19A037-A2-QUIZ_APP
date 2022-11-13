package com.myapplication.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView question, totalQuestion,remQues,correctRes,wrongRes,selectedAns,correctAns,exit;
    Button btnA, btnB, btnC, btnD, btnSubmit,restartBtn,summary,next;
    int correct = 0,counter=0;
    int j=0;
    int wrong_Answer = 0;
    int totalQuestions = QuestionData.questions.length;
    int remQuestions=totalQuestions;
    int currentQuestion = 0, qNo = 0,index=0;
    String answer = "",selectedAnswer="";
    ArrayList<Integer>numbers=shuffleQuestionList();
    ArrayList<String>selectedAnswers=new ArrayList<>();
    ArrayList<Integer>Qnumbers=new ArrayList<>();

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
        summary=findViewById(R.id.summary);
        next=findViewById(R.id.Next);
        correctAns=findViewById(R.id.CorrectAnswer);
        selectedAns=findViewById(R.id.SelectedAnswer);
        exit=findViewById(R.id.Exit);

        correctRes.setVisibility(View.INVISIBLE);
        wrongRes.setVisibility(View.INVISIBLE);
        restartBtn.setVisibility(View.INVISIBLE);
        summary.setVisibility(View.INVISIBLE);
        next.setVisibility(View.GONE);
        correctAns.setVisibility(View.GONE);
        selectedAns.setVisibility(View.GONE);
        exit.setVisibility(View.INVISIBLE);


        btnA.setOnClickListener(this);
        restartBtn.setOnClickListener(this);
        summary.setOnClickListener(this);

        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        next.setOnClickListener(this);
        exit.setOnClickListener(this);

        totalQuestion.setText("Total Question: " + totalQuestions);
        remQues.setText("Remaining: "+remQuestions);

        generateMCQ();
    }


    @Override
    public void onClick(View view) {
        btnA.setBackgroundColor(Color.WHITE);
        btnB.setBackgroundColor(Color.WHITE);
        btnC.setBackgroundColor(Color.WHITE);
        btnD.setBackgroundColor(Color.WHITE);
        restartBtn.setBackgroundColor(Color.rgb(76,175,80));
        summary.setBackgroundColor(Color.rgb(157,76,175));
        next.setBackgroundColor(Color.rgb(157,76,175));


        Button clicked=(Button)view;
        if(view.getId()==R.id.restart)
        {
            numbers=shuffleQuestionList();
            restartQuiz();
        }

        if(clicked.getId()==R.id.submit)
        {
            if(selectedAnswer.equals(answer))
            {
                correct++;
            }
            else {
                wrong_Answer++;
            }
            remQuestions--;
            remQues.setText("Remaining: "+remQuestions);
            currentQuestion++;
            generateMCQ();
        }
        else{
            selectedAnswer=clicked.getText().toString();
            selectedAnswers.add(selectedAnswer);
            clicked.setBackgroundColor(Color.LTGRAY);
        }
        if(view.getId()==R.id.summary)
        {
            viewSummary();
        }
        if(view.getId()==R.id.Next)
        {
            if(counter!=9) {
                viewSummary();
            }
            else
            {
                next.setVisibility(View.INVISIBLE);
                exit.setVisibility(View.VISIBLE);
            }
        }
        if(view.getId()==R.id.Exit)
        {
            System.exit(0);
        }

    }
    public ArrayList<Integer> shuffleOptionList() {
        ArrayList numbers = new ArrayList();
        for (int i = 0; i < 4; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;

    }
    public ArrayList<Integer> shuffleQuestionList() {
        ArrayList numbers = new ArrayList();
        for (int i = 0; i < QuestionData.questions.length; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
    public void generateQuestion(int index)
    {
        question.setText(QuestionData.questions[qNo]);
        answer = QuestionData.answers[qNo];
        ArrayList<Integer>numbers1=new ArrayList<Integer>();
        numbers1=shuffleOptionList();
        btnA.setText(QuestionData.questionsOptions[qNo][(int) (numbers1.get(0))]);
        btnB.setText(QuestionData.questionsOptions[qNo][(int) (numbers1.get(1))]);
        btnC.setText(QuestionData.questionsOptions[qNo][(int) (numbers1.get(2))]);
        btnD.setText(QuestionData.questionsOptions[qNo][(int) (numbers1.get(3))]);
        currentQuestion++;
    }
    private void generateMCQ() {
        if(remQuestions==0)
        {
            showResult();
            return;
        }
        //Random rnd = new Random();
        qNo=numbers.get(index);
        index++;
        Qnumbers.add(qNo);
        switch (qNo) {
            case 0:
                generateQuestion(qNo);
            case 1:
              //  Qnumbers.add(qNo);
                generateQuestion(qNo);

            case 2:
             //   Qnumbers.add(qNo);
                generateQuestion(qNo);
            case 3:
             //   Qnumbers.add(qNo);
                generateQuestion(qNo);
            case 4:
            //    Qnumbers.add(qNo);
                generateQuestion(qNo);
            case 5:
            //    Qnumbers.add(qNo);
                generateQuestion(qNo);
            case 6:
            //    Qnumbers.add(qNo);
                generateQuestion(qNo);
            case 7:
           //     Qnumbers.add(qNo);
                generateQuestion(qNo);
            case 8:
            //    Qnumbers.add(qNo);
                generateQuestion(qNo);
            case 9:
            //    Qnumbers.add(qNo);
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
        exit.setVisibility(View.INVISIBLE);
        btnSubmit.setVisibility(View.INVISIBLE);
        correctRes.setVisibility(View.VISIBLE);
        wrongRes.setVisibility(View.VISIBLE);
        correctRes.setText("CORRECT: "+correct);
        wrongRes.setText("WRONG: "+wrong_Answer);
        summary.setVisibility(View.VISIBLE);
        restartBtn.setVisibility(View.VISIBLE);
          }
    void restartQuiz(){
        currentQuestion=0;
        remQuestions=totalQuestions;
        correct=0;
        wrong_Answer=0;
        index=0;
        question.setVisibility(View.VISIBLE);
        btnA.setVisibility(View.VISIBLE);
        btnB.setVisibility(View.VISIBLE);
        btnC.setVisibility(View.VISIBLE);
        btnD.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);
        correctRes.setVisibility(View.INVISIBLE);
        wrongRes.setVisibility(View.INVISIBLE);
        restartBtn.setVisibility(View.INVISIBLE);
        summary.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        remQues.setText("Remaining: "+remQuestions);
        generateMCQ();
    }
    void viewSummary()
    {
        question.setVisibility(View.INVISIBLE);
        btnSubmit.setVisibility(View.INVISIBLE);
        summary.setVisibility(View.INVISIBLE);
        restartBtn.setVisibility(View.INVISIBLE);
        correctRes.setVisibility(View.INVISIBLE);
        wrongRes.setVisibility(View.INVISIBLE);
        totalQuestion.setVisibility(View.INVISIBLE);
        remQues.setVisibility(View.INVISIBLE);


            question.setVisibility(View.VISIBLE);
            question.setText(QuestionData.questions[Qnumbers.get(counter)]);
            selectedAns.setVisibility(View.VISIBLE);
            selectedAns.setText("Selected Answer :"+selectedAnswers.get(counter));
            if(selectedAnswers.get(counter)==QuestionData.answers[Qnumbers.get(counter)])
            {
                selectedAns.setBackgroundColor(Color.GREEN);
            }
            else
            {
                selectedAns.setBackgroundColor(Color.RED);
            }
            correctAns.setVisibility(View.VISIBLE);
            correctAns.setText("Correct Answer: "+QuestionData.answers[Qnumbers.get(counter)]);
            next.setVisibility(View.VISIBLE);
            counter++;

    }

}
