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

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


//***Log details/

public class MultiPlayerGame extends AppCompatActivity {

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
    TextView textViewPlayer2;
    String player1Name;
    String player2Name;
    Boolean isTurn;//true=X's turn, false=O'S turn

    AlertDialog.Builder builder;

    //***This displays the initial layout of the game.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_player_game_activity_3);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        textViewPlayer1 = (TextView) findViewById(R.id.counter_X);
        textViewPlayer2 = (TextView) findViewById(R.id.counter_Y);
        playerTurn = (TextView) findViewById(R.id.player);
        builder = new AlertDialog.Builder(this);
        Intent intent = getIntent();
        player1Name = intent.getExtras().getString("Player 1");
        player2Name = intent.getExtras().getString("Player 2");
        grid = findViewById(R.id.Grid);
        displayTurn = player1Name + "'s turn (X)";
        playerTurn.setText(displayTurn);


        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                mPlayBoard[a][b] = (Button) grid.getChildAt(3 * a + b);


            }
        }

    }

    public void clickMove(View view) {
        int index = grid.indexOfChild(view);
        int a = index / 3;
        int b = index % 3;
        flag = 0;
        if (turn == 1 && gameOver == 0
                && !(mPlayBoard[a][b].getText().toString().equals("X"))
                && !(mPlayBoard[a][b].getText().toString().equals("O"))) {

            if (flipValue == 0) {
                displayTurn = player2Name + "'s turn (O)";
                playerTurn.setText(displayTurn);
            } else if (flipValue == 1) {
                displayTurn = player1Name + "'s turn (O)";
                playerTurn.setText(displayTurn);
            }
            mPlayBoard[a][b].setText("X");
            turn = 2;
        } else if (turn == 2 && gameOver == 0
                && !(mPlayBoard[a][b].getText().toString().equals("X"))
                && !(mPlayBoard[a][b].getText().toString().equals("O"))) {
            if (flipValue == 0) {
                displayTurn = player1Name + "'s turn (X)";
                playerTurn.setText(displayTurn);
            } else if (flipValue == 1) {
                displayTurn = player2Name + "'s turn (X)";
                playerTurn.setText(displayTurn);
            }
            mPlayBoard[a][b].setText("O");
            turn = 1;
        }
        checkWin();
        if (gameOver == 1) {
            if (win == 1) {
                builder.setMessage(player1Name + " wins!").setTitle("Game over");
                updatePointsText();
                if (flagEndGame == 0) {
                    player1Win++;
                    roundCount++;
                }
            } else if (win == 2) {
                builder.setMessage(player2Name + " wins!").setTitle("Game over");
                updatePointsText();
                if (flagEndGame == 0) {
                    player2Win++;
                    roundCount++;
                }

            }
            flagEndGame = 1;
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    newGame(new View(getApplicationContext()));
                    if (roundCount == number) {
                        Intent intent = new Intent(getApplicationContext(), Stats.class);
                        intent.putExtra("Player 1 Wins", player1Win);
                        intent.putExtra("Player 2 Wins", player2Win);
                        intent.putExtra("Draws", draw);
                        intent.putExtra("Player 1 Name", player1Name);
                        intent.putExtra("Player 2 Name", player2Name);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                            finish();
                        }

                    }
                }

            });
            AlertDialog dialog = builder.create();
            dialog.show();


        }
        if (gameOver == 0) {
            for (a = 0; a < 3; a++) {
                for (b = 0; b < 3; b++) {
                    if (!mPlayBoard[a][b].getText().toString().equals("X")
                            && !mPlayBoard[a][b].getText().toString().equals("O")) {
                        flag = 1;
                        break;

                    }
                }
            }
            if (flag == 0) {
                builder.setMessage("It's a draw!").setTitle("Game over");
                if (flagEndGame == 0) {
                    roundCount++;
                    draw++;
                }
                flagEndGame = 1;
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        newGame(new View(getApplicationContext()));
                        if (roundCount == number) {
                            Intent intent = new Intent(getApplicationContext(), Stats.class);
                            intent.putExtra("Player 1 Wins", player1Win);
                            intent.putExtra("Player 2 Wins", player2Win);
                            intent.putExtra("Draws", draw);
                            intent.putExtra("Player 1 Name", player1Name);
                            intent.putExtra("Player 2 Name", player2Name);
                            if (intent.resolveActivity(getPackageManager()) != null) {
                                startActivity(intent);
                                finish();
                            }

                        }
                    }

                });
                AlertDialog dialog = builder.create();
                dialog.show();


            }



        }


    }

    private void updatePointsText() {
        textViewPlayer1.setText(Integer.toString(player1Win));
        textViewPlayer2.setText(Integer.toString(player2Win));
    }


    public void newGame(View view) {

        win = 0;
        gameOver = 0;
        turn = 1;
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                mPlayBoard[a][b].setText(" ");
                mPlayBoard[a][b].setTextColor(Color.BLUE);
            }
        }

        if (flipValue == 0) {
            if (flagEndGame == 1) {
                flipValue = 1;
                displayTurn = player1Name + "'s turn (X)";
                playerTurn.setText(displayTurn);
            } else {
                displayTurn = player2Name + "'s turn (X)";
                playerTurn.setText(displayTurn);
            }


        } else if (flipValue == 1) {
            if (flagEndGame == 1) {
                flipValue = 0;
                displayTurn = player1Name + "'s turn (X)";
                playerTurn.setText(displayTurn);
            } else {
                displayTurn = player2Name + "'s turn (X)";
                playerTurn.setText(displayTurn);
            }


        }
        flagEndGame = 0;
    }

    public void checkWin() {
        for (int a = 0; a < 3; a++) {
            if (mPlayBoard[a][0].getText().toString().equals(mPlayBoard[a][1].getText().toString())
                    && mPlayBoard[a][0].getText().toString().equals(mPlayBoard[a][2].getText().toString())) {
                if (mPlayBoard[a][0].getText().toString().equals("X")) {
                    gameOver = 1;
                    if (flipValue == 0)
                        win = 1;
                    else if (flipValue == 1)
                        win = 2;


                } else if (mPlayBoard[a][0].getText().toString().equals("O")) {
                    gameOver = 1;
                    if (flipValue == 0)
                        win = 2;
                    else if (flipValue == 1)
                        win = 1;

                }
                if (!mPlayBoard[a][0].getText().toString().equals(" ")) {
                    mPlayBoard[a][0].setTextColor(Color.BLUE);
                    mPlayBoard[a][1].setTextColor(Color.BLUE);
                    mPlayBoard[a][2].setTextColor(Color.BLUE);
                }

            }
            if (mPlayBoard[0][a].getText().toString().equals(mPlayBoard[1][a].getText().toString())
                    && mPlayBoard[0][a].getText().toString().equals(mPlayBoard[2][a].getText().toString())) {
                if (mPlayBoard[0][a].getText().toString().equals("X")) {
                    gameOver = 1;
                    if (flipValue == 0)
                        win = 1;
                    else if (flipValue == 1)
                        win = 2;


                } else if (mPlayBoard[0][a].getText().toString().equals("O")) {
                    gameOver = 1;
                    if (flipValue == 0)
                        win = 2;
                    else if (flipValue == 1)
                        win = 1;

                }
                if (!mPlayBoard[0][a].getText().toString().equals(" ")) {
                    mPlayBoard[0][a].setTextColor(Color.BLUE);
                    mPlayBoard[1][a].setTextColor(Color.BLUE);
                    mPlayBoard[2][a].setTextColor(Color.BLUE);
                }

            }


        }
        if (mPlayBoard[0][0].getText().toString().equals(mPlayBoard[1][1].getText().toString())
                && mPlayBoard[0][0].getText().toString()
                .equals(mPlayBoard[2][2].getText().toString())) {
            if (mPlayBoard[0][0].getText().toString().equals("X")) {
                gameOver = 1;
                if (flipValue == 0)
                    win = 1;
                else if (flipValue == 1)
                    win = 2;


            } else if (mPlayBoard[0][0].getText().toString().equals("O")) {
                gameOver = 1;
                if (flipValue == 0)
                    win = 2;
                else if (flipValue == 1)
                    win = 1;

            }
            if (!mPlayBoard[0][0].getText().toString().equals(" ")) {
                mPlayBoard[0][0].setTextColor(Color.BLUE);
                mPlayBoard[1][1].setTextColor(Color.BLUE);
                mPlayBoard[2][2].setTextColor(Color.BLUE);
                mPlayBoard[2][2].setTextColor(Color.BLUE);
            }


        }
        if (mPlayBoard[0][2].getText().toString().equals(mPlayBoard[1][1].getText().toString())
                && mPlayBoard[0][2].getText().toString()
                .equals(mPlayBoard[2][0].getText().toString())) {
            if (mPlayBoard[0][2].getText().toString().equals("X")) {
                gameOver = 1;
                if (flipValue == 0)
                    win = 1;
                else if (flipValue == 1)
                    win = 2;


            } else if (mPlayBoard[0][2].getText().toString().equals("O")) {
                gameOver = 1;
                if (flipValue == 0)
                    win = 2;
                else if (flipValue == 1)
                    win = 1;

            }
            if (!mPlayBoard[2][0].getText().toString().equals(" ")) {
                mPlayBoard[2][0].setTextColor(Color.BLUE);
                mPlayBoard[1][1].setTextColor(Color.BLUE);
                mPlayBoard[0][2].setTextColor(Color.BLUE);
            }



        }
    }



    private ImageButton mExit, mRestart;
    private int mExitCounter = 0;


    public void onEClick(View v) {
        mExit = (ImageButton) findViewById(R.id.exit);
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExitCounter == 1) {
                    finish();
                    System.exit(0);
                } else {
                    mExitCounter++;
                    Toast.makeText(getApplicationContext(), "Click again to exit", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void onRClick(View v) {
        mRestart = (ImageButton) findViewById(R.id.replay);
        mRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Button", "The user clicked on Reset Button");
                Intent start = getIntent();
                finish();
                start.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                Toast.makeText(MultiPlayerGame.this, "Game Restarted!", Toast.LENGTH_SHORT).show();
                startActivity(start);

            }
        });
    }

    }




