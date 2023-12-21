import java.util.Timer;
import java.util.TimerTask;

public class brewingState implements State {

    Controller controller;

    int timeRemaining;

    public brewingState(Controller controller) {
        this.controller = controller;
    }

    public void brew() {
        timeRemaining = 5;

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (timeRemaining > 0) {
                    controller.gui.ErrorField.setText("Machine is in Brewing state. Countdown: " + timeRemaining + " seconds");
                    timeRemaining--;
                } else {
                    timer.cancel();
                    controller.gui.ErrorField.setText("Brewing Complete!");
                    controller.setState(controller.returnDoneState());
                }
            }
        }, 0, 1000);

    }


    @Override
    public void startButtonPressed() {
        this.controller.gui.ErrorField.setText("Machine is Breawing Please Wait");
    }

    @Override
    public void fillButton(int stock) {
        this.controller.gui.ErrorField.setText("Machine is Breawing Please Wait");
    }

    @Override
    public void ResetButton() {
        this.controller.gui.ErrorField.setText("Machine is Breawing Please Wait");

    }


}
