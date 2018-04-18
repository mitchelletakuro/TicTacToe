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
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Gbemmy on 12/04/2018.
 */

//The board size would be chosen//

public class Computer_board_pref extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computer_board_preferences);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
    }

    public void Board3(View view) {
        Intent intent = new Intent(this, SinglePlayerName.class);
        if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
    }

    public void Board5(View view) {
        Intent intent = new Intent(this, SinglePlayerNameFive.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
