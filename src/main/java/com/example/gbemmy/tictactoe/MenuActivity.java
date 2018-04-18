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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Created by Gbemmy on 12/04/2018.
 */


//This refers to the navigation pane of the menu buttons

public class MenuActivity extends AppCompatActivity {

    final Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setTitle("TicTacToe - Select Game Type");

    }

    public void SinglePlayerGame(View view){
        Intent intent = new Intent(this,Computer_board_pref.class);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }



    public void MultiPlayerGame(View view){
        Intent intent = new Intent(this,Human_board_pref.class);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }
    public void onAboutClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog show = builder
                .setTitle("About")
                .setMessage("Simplified TicTacToe game.")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("Close", null)
                .show();
}

    public void Instructions(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( context);
        alertDialogBuilder.setTitle("How To Play TicTacToe");
        alertDialogBuilder.setMessage("Tic-tac-toe (also known as Xs and Os) is a simple game comprising of single and two players," + "who can choose between X and O." + "Each player take turns marking the spaces in the board size they choose which could either be 3 or 5."+"The player who is able to link up his marks in any of the board size,"+"wins the game.");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
         @Override public void onClick(DialogInterface dialog, int id) {
            }
            //Close the dialog once clicked and resume current activity
        });
        alertDialogBuilder.setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //close the dialogonce clicked and take no action
                dialog.cancel();

            }
        });

        AlertDialog alertDialog =alertDialogBuilder.create();
        alertDialog.show();
    }

    public  void OnExitClick(View view){
        finish();
        System.exit(0);
    }
}



