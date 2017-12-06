package com.gongloroth.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    private int cornerTeamA = 0;
    private int yellowCardTeamA = 0;
    private int redCardTeamA = 0;

    private int cornerTeamB = 0;
    private int yellowCardTeamB = 0;
    private int redCardTeamB = 0;

    private Spinner spinnerA;
    private Spinner spinnerB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        createSpinnerA();
        createSpinnerB();


    }

    public void onSaveInstanceState(Bundle outState) {

        outState.putInt("scoreTeamA_KEY", scoreTeamA);
        outState.putInt("scoreTeamB_KEY", scoreTeamB);

        outState.putInt("cornerTeamA_KEY", cornerTeamA);
        outState.putInt("cornerTeamB_KEY", cornerTeamB);

        outState.putInt("yellowCardTeamA_KEY", yellowCardTeamA);
        outState.putInt("yellowCardTeamB_KEY", yellowCardTeamB);

        outState.putInt("redCardTeamA_KEY", redCardTeamA);
        outState.putInt("redCardTeamB_KEY", redCardTeamB);


        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        scoreTeamA = savedInstanceState.getInt("scoreTeamA_KEY");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB_KEY");

        cornerTeamA = savedInstanceState.getInt("cornerTeamA_KEY");
        cornerTeamB = savedInstanceState.getInt("cornerTeamB_KEY");

        yellowCardTeamA = savedInstanceState.getInt("yellowCardTeamA_KEY");
        yellowCardTeamB = savedInstanceState.getInt("yellowCardTeamB_KEY");

        redCardTeamA = savedInstanceState.getInt("redCardTeamA_KEY");
        redCardTeamB = savedInstanceState.getInt("redCardTeamB_KEY");

        displayAll();

    }

    /**
     * Displays the given scoreTeamA for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayCornerA(int score) {
        TextView cornerView = (TextView) findViewById(R.id.corner_text_a);
        cornerView.setText(String.valueOf(score));
    }

    public void displayYellowA(int score) {
        TextView yellowView = (TextView) findViewById(R.id.yellow_text_a);
        yellowView.setText(String.valueOf(score));
    }

    public void displayRedA(int score) {
        TextView redView = (TextView) findViewById(R.id.red_text_a);
        redView.setText(String.valueOf(score));
    }

    public void scorePlusA(View view){
        scoreTeamA +=1;
        displayForTeamA(scoreTeamA);
    }

    public void cornerPlusA(View view){
        cornerTeamA +=1;
        displayCornerA(cornerTeamA);
    }

    public void yellowPlusA(View view){
        yellowCardTeamA +=1;
        displayYellowA(yellowCardTeamA);
    }

    public void redPlusA(View view){
        redCardTeamA +=1;
        displayRedA(redCardTeamA);
    }


    /**
     * Displays the given scoreTeamA for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayCornerB(int score) {
        TextView cornerView = (TextView) findViewById(R.id.corner_text_b);
        cornerView.setText(String.valueOf(score));
    }

    public void displayYellowB(int score) {
        TextView yellowView = (TextView) findViewById(R.id.yellow_text_b);
        yellowView.setText(String.valueOf(score));
    }

    public void displayRedB(int score) {
        TextView redView = (TextView) findViewById(R.id.red_text_b);
        redView.setText(String.valueOf(score));
    }

    public void scorePlusB(View view){
        scoreTeamB +=1;
        displayForTeamB(scoreTeamB);
    }

    public void cornerPlusB(View view){
        cornerTeamB +=1;
        displayCornerB(cornerTeamB);
    }

    public void yellowPlusB(View view){
        yellowCardTeamB +=1;
        displayYellowB(yellowCardTeamB);
    }

    public void redPlusB(View view){
        redCardTeamB +=1;
        displayRedB(redCardTeamB);
    }

    public void displayAll(){
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        displayCornerA(cornerTeamA);
        displayYellowA(yellowCardTeamA);
        displayRedA(redCardTeamA);

        displayCornerB(cornerTeamB);
        displayYellowB(yellowCardTeamB);
        displayRedB(redCardTeamB);

    }

    public void reset(View view){
        scoreTeamB = 0;
        scoreTeamA = 0;

        cornerTeamA = 0;
        yellowCardTeamA = 0;
        redCardTeamA = 0;

        cornerTeamB = 0;
        yellowCardTeamB = 0;
        redCardTeamB = 0;

        displayAll();
    }


    public void createSpinnerA(){
        spinnerA = (Spinner) findViewById(R.id.team_a_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterA = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerA.setAdapter(adapterA);
        spinnerA.setOnItemSelectedListener(new TeamASpinner());
    }

    public void createSpinnerB(){
        spinnerB = (Spinner) findViewById(R.id.team_b_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterB = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerB.setAdapter(adapterB);
        spinnerB.setSelection(1);
        spinnerB.setOnItemSelectedListener(new TeamBSpinner());
    }

    class TeamASpinner implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            ImageView imageA = (ImageView) findViewById(R.id.team_a_image);

            switch (adapterView.getSelectedItemPosition()) {
                case 0:
                    imageA.setImageResource(R.drawable.barcelona_icon);
                    break;

                case 1:
                    imageA.setImageResource(R.drawable.real_madrid_icon);
                    break;

                case 2:
                    imageA.setImageResource(R.drawable.manchester_icon);
                    break;

                case 3:
                    imageA.setImageResource(R.drawable.juventus_icon);
                    break;

                case 4:
                    imageA.setImageResource(R.drawable.chelsea_icon);
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    class TeamBSpinner implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            ImageView imageB = (ImageView) findViewById(R.id.team_b_image);

            switch (adapterView.getSelectedItemPosition()) {
                case 0:
                    imageB.setImageResource(R.drawable.barcelona_icon);
                    break;

                case 1:
                    imageB.setImageResource(R.drawable.real_madrid_icon);
                    break;

                case 2:
                    imageB.setImageResource(R.drawable.manchester_icon);
                    break;

                case 3:
                    imageB.setImageResource(R.drawable.juventus_icon);
                    break;

                case 4:
                    imageB.setImageResource(R.drawable.chelsea_icon);
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}

