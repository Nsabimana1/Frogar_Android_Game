package com.nsabimanainnocent1.frogar.movement;

public class ProgressBar {
    public int  health = 4;


    //This method gets called whenever score is Subtracted
    public int LoseLife(){
        return health-1;
    }

    // All of the progress bar images will be in the same place
    // But they will be hidden and unhidden based on the health.

    public void ProgressLoser() {
        if (health == 3) {
            //switch to image view of progress bar 2
        }
        if (health == 2) {
            //switch to image view of  progress bar 3
        }
        else{
            //switch to image view of  progress bar 4
        }
    }


}
