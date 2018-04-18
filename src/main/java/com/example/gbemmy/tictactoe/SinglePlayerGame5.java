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

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;


//**Log Details
public class SinglePlayerGame5 extends Activity {

    private Button mPlayBoard[][] = new Button[3][3];
    private int player1Win = 0, player2Win = 0, draw = 0;
    private int roundCount = 0;
    private int turn = 1;
    private int win = 0;
    private int gameOver = 0;
    private int flagEndGame = 0;
    private int flag;
    int number;
    int flipValue = 0;
    String displayTurn;
    GridLayout grid;
    TextView playerTurn;
    TextView textViewPlayer1;
    TextView Computer;
    String player1Name;

    AlertDialog.Builder builder;

    //***This creates the activity when it is created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player_game_5);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);


    }
}

