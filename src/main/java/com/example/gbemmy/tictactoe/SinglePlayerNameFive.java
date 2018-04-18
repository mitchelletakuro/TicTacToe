//Copyright 2018 The Android Open Source Project
//Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

//Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
//limitations under the License.


package com.example.gbemmy.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gbemmy on 13/04/2018.
 */

public class SinglePlayerNameFive extends AppCompatActivity {

    EditText sPlayer1,sPlayer2;
    Button sRoundcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
        setContentView(R.layout.single_player_name_five);
        setTitle("TicTacToe - Input your details");


    }
    public void Submit(View view) {
        EditText Player1Name =(EditText) findViewById(R.id.sPlayer1);
        EditText Player2Name =(EditText) findViewById(R.id.sPlayer2);
        EditText RoundCount = (EditText) findViewById(R.id.sRoundcount);
        String Player1NameText= Player1Name.getText().toString();
        String Player2NameText= Player2Name.getText().toString();
        String RoundCountnumber= RoundCount.getText().toString();


        if(RoundCountnumber.length()>3){
            RoundCountnumber="999";
            RoundCount.setText(R.string.default_max_games);
        }

        if(RoundCountnumber.equals("") || Integer.parseInt(RoundCountnumber)<=0){
            RoundCount.setText(R.string.default_min_games);
            RoundCountnumber="1";
        }

        if(Player1NameText.equals("")){
            Player1NameText="Player 1";
            Player1Name.setText(R.string.player_1_default_name);
        }
        if(Player2NameText.equals("")){
            Player2NameText="Player 2";
            Player2Name.setText(R.string.player_2_default_name);
        }

        if(Player1NameText.equals("")||Player2NameText.equals("")){
            toastMessage("Please enter names of both the players");
            return;
        }
        Intent intent = new Intent(this,SinglePlayerGame5.class);
        intent.putExtra("Player 1",Player1NameText);
        intent.putExtra("Player 2",Player2NameText);
        intent.putExtra("RoundCount",RoundCountnumber);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
            finish();
        }
    }
    private void toastMessage(String string)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, string,duration);
        toast.show();
    }

}


















