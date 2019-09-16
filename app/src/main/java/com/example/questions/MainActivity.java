package com.example.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ArrayList <Question> questionsList;
    private RadioGroup radioGroup;
    TextView question,feedback;
    Button back,next;
    int index;
    private int nomOfQuestions = 8;
    RadioButton choiceA,choiceB,choiceC,choiceD;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionsList=new ArrayList<>();
        question=findViewById(R.id.question);
        feedback=findViewById(R.id.feedback);
        back=findViewById(R.id.back);
        next=findViewById(R.id.next);
        radioGroup = findViewById(R.id.radioGroup);
        choiceA=findViewById(R.id.choiceA);
        choiceB=findViewById(R.id.choiceB);
        choiceC=findViewById(R.id.choiceC);
        choiceD=findViewById(R.id.choiceD);
        exit=findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(index==0){
                    back.setVisibility(View.VISIBLE);
                }
                if(index==questionsList.size()-2){
                    next.setVisibility(View.INVISIBLE);
                }

                ++index;
                loadQuestion();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(index==1){
                    back.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }

                else if(index==questionsList.size()-1)
                    next.setVisibility(View.VISIBLE);

                --index;
                loadQuestion();

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=radioGroup.findViewById(i);
                String choice=radioButton.getText().toString();
                if(choice.equals(questionsList.get(index).getAnswer())){
                    Toast.makeText(MainActivity.this, "Excellent", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
        initQuestions();
        loadQuestion();
    }

    private void loadQuestion() {

        if (questionsList.size()==1){
            next.setVisibility(View.INVISIBLE);
        }


        Question questions = questionsList.get(index);
        question.setText(questions.getQuestion());
        feedback.setText(questions.getFeedback());
        choiceA.setText(questions.getChoiceA());
        choiceB.setText(questions.getChoiceB());
        choiceC.setText(questions.getChoiceC());
        choiceD.setText(questions.getChoiceD());



    }

    private void initQuestions() {
        int base = R.array.question0;
        for(int i=0;i<nomOfQuestions;i++){
            String qStr[]=getResources().getStringArray(base);
            Question question = new Question(qStr[0],qStr[1],qStr[2],qStr[3],qStr[4],qStr[5],qStr[6]);
            questionsList.add(question);
            base++;
        }

    }
}
