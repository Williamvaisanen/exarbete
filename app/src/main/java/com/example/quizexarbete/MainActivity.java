package com.example.quizexarbete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.LayoutInflater;


import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;

    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0;
    int questionsAttempted = 0;
    int currentPos; // random


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionTV = findViewById(R.id.idQuestions);
        questionNumberTV = findViewById(R.id.idQuestionsAttempted);
        option1Btn = findViewById(R.id.idBtnoption1);
        option2Btn = findViewById(R.id.idBtnoption2);
        option3Btn = findViewById(R.id.idBtnoption3);
        option4Btn = findViewById(R.id.idBtnoption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);

        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // trim = removes spaces
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;

                }
                questionsAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });


    }


    private void showBottomSheet(){



       BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = getLayoutInflater().from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));

        TextView scoreTV = bottomSheetView.findViewById(R.id.idScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);

        if(currentScore > 8) {

            scoreTV.setText("Well done! Your score is: \n"+currentScore +"/10");
        }
            else if(currentScore < 4){
                scoreTV.setText("You can do better. Your score is: \n"+currentScore +"/10");
            }else {
                scoreTV.setText("Your score is: \n"+currentScore +"/10");
            }



        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionsAttempted = 0;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                currentScore = 0;
                bottomSheetDialog.dismiss();


            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }


    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted : "+questionsAttempted + "/10");

        if(questionsAttempted == 10){
         showBottomSheet();

            }else{

    questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
    option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
    option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());

    option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
    option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());

}

    }
    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList){


        quizModelArrayList.add(new QuizModel("How many countries are there in North America?","3","14","9","23","23")); // opt4
        quizModelArrayList.add(new QuizModel("What is the official languages of Belgium?","French","Dutch","German","All Above","All Above")); // opt 4
        quizModelArrayList.add(new QuizModel("What is the capital city of Sweden?","Stockholm","Gothenburg","Malmö","Örebro","Stockholm")); // opt1
        quizModelArrayList.add(new QuizModel("What is the most spoken language in Europe?","French","Spanish","English","German","English")); //opt 3
        quizModelArrayList.add(new QuizModel("How many people live in Rwanda?","12.6 millions","14 millions","11.5 millions","9.1 millions","12.6 millions")); // opt 1
        quizModelArrayList.add(new QuizModel("What is the national dish of Pakistan?","Nihari","Chicken tikka Masala","Biryani","Pakoras","Nihari")); // opt 1
        quizModelArrayList.add(new QuizModel("What country is the safest in the world?","Canada","Singapore","Denmark","Iceland","Iceland")); // opt 4
        quizModelArrayList.add(new QuizModel("How many people live in Brazil?","185 millions","211 millions","273.5 millions","288 millions","211 millions")); // opt 2
        quizModelArrayList.add(new QuizModel("What country has the most islands in the world?","Finland","The Philippines","Sweden","Indonesia","Sweden")); // opt 3
        quizModelArrayList.add(new QuizModel("What is the biggest country in the world?","Brazil","Russia","Australia","China","Russia")); // opt 2
        quizModelArrayList.add(new QuizModel("What country has the most billionaires per capita?","India","China","Germany","USA","USA")); //opt 4
        quizModelArrayList.add(new QuizModel("What country holds the most silver production in the world?","USA","Mexico","Bolivia","Peru","Mexico")); // opt 2
        quizModelArrayList.add(new QuizModel("What is the Earth's largest continent?","Africa","Asia","Antarctica","Europe","Asia")); //opt 2
        quizModelArrayList.add(new QuizModel("Which African nation has the most pyramids?","Sudan","Libya","Egypt","Algeria","Sudan")); // opt 1
        quizModelArrayList.add(new QuizModel("What is the smallest independent country on Earth?","Monaco","Nauru","Grenada","Vatican City","Vatican City")); //opt 4
        quizModelArrayList.add(new QuizModel("What is the most populated country in Africa?","Ghana","Ethiopia","Nigeria","South Africa","Nigeria")); // opt 3
        quizModelArrayList.add(new QuizModel("What is the least populated state in USA?","Wyoming","Delaware","Montana","Rhode Island","Wyoming")); //opt 1
        quizModelArrayList.add(new QuizModel("What is the highest waterfall in Europe?","Kjelfossen","Krimml","Triberg","Rhine","Krimml")); // opt 2
        quizModelArrayList.add(new QuizModel("What is the capital of Australia?","Sydney","Perth","Melbourne","Canberra","Canberra")); //opt 4
        quizModelArrayList.add(new QuizModel("What is the fastest flowing river in the world?","Congo River","Yangtze","Amazon River","Tapajos","Amazon River")); // opt 3
        quizModelArrayList.add(new QuizModel("What is the smallest country in South America?","Suriname","Bolivia","Guyana","Ecuador","Suriname")); //opt 1
        quizModelArrayList.add(new QuizModel("What is the oldest city in India?","Mumbai","Varanasi","Nagpur","Hyderabad","Varanasi")); // opt 2





    }
}
