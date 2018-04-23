package com.gongloroth.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

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

    private ArrayAdapter<CharSequence> adapter;

    private ImageView imageViewA;
    private ImageView imageViewB;

    ArrayList<Integer> myImageList = new ArrayList<>(Arrays.asList(
            R.drawable.barcelona_icon,
            R.drawable.real_madrid_icon,
            R.drawable.manchester_icon,
            R.drawable.juventus_icon,
            R.drawable.chelsea_icon
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageViewA = (ImageView) findViewById(R.id.team_a_image);
        imageViewB = (ImageView) findViewById(R.id.team_b_image);

        adapter = createAdapter();

        spinnerA = createSpinner(imageViewA, R.id.team_a_spinner, adapter, 0);
        spinnerB = createSpinner(imageViewB, R.id.team_b_spinner, adapter, 1);

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


    public Spinner createSpinner(ImageView imageView, int spinnerId ,ArrayAdapter<CharSequence> adapter, int select){
        Spinner spinner = (Spinner) findViewById(spinnerId);
        spinner.setAdapter(adapter);
        spinner.setSelection(select);
        spinner.setOnItemSelectedListener(new TeamSpinner(imageView));
        return spinner;
    }

    public ArrayAdapter<CharSequence> createAdapter() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }


    class TeamSpinner implements AdapterView.OnItemSelectedListener{

        ImageView imageView;

        public TeamSpinner(ImageView imageView){
            this.imageView = imageView;
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            imageView.setImageResource(myImageList.get(adapterView.getSelectedItemPosition()));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}

