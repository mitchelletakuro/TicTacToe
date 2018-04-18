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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Gbemmy on 12/04/2018.
 */

public class Human_board_pref extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.human_board_preferences);
        setTitle("TicTacToe - Select Board Size");

    }
    public void HumanBoard3(View view) {
            Intent intent = new Intent(this, MultiPlayerNameThree.class);
            if (intent.resolveActivity(getPackageManager()) != null) {

                startActivity(intent);
            }
        }
    public void HumanBoard5(View view) {
            Intent intent = new Intent(this, MultiPlayerName5.class);
            if (intent.resolveActivity(getPackageManager()) != null) {

                startActivity(intent);
            }
        }
    }