import java.util.Timer;
import java.util.TimerTask;

public class brewingState implements State {

    int timeRemaining;

    public void brew() {
        timeRemaining = 5;

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (timeRemaining > 0) {
                    controller.view.ErrorField.setText("Machine is in Brewing state. Countdown: " + timeRemaining + " seconds");
                    timeRemaining--;
                } else {
                    timer.cancel();
                    controller.view.ErrorField.setText("Brewing Complete!");
                    model.setState(model.returnDoneState());
                }
            }
        }, 0, 1000);

    }


    @Override
    public void startButtonPressed() {
        controller.view.ErrorField.setText("Machine is Breawing Please Wait");
    }

    @Override
    public void fillButton(int stock) {
        controller.view.ErrorField.setText("Machine is Breawing Please Wait");
    }

    @Override
    public void ResetButton() {
        controller.view.ErrorField.setText("Machine is Breawing Please Wait");
    }


}
