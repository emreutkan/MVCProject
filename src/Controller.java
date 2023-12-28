
public class Controller  {

    Model model = Model.getInstance();

    GUI gui = GUI.getInstance();


    private static Controller ControllerSingleton = null;

    public static synchronized Controller getInstance() {
        if (ControllerSingleton == null){
            ControllerSingleton = new Controller();
        }
        return ControllerSingleton;
    }

    private Controller() {
        initializeActionListeners();
    }

    public void initializeActionListeners() {
        gui.FilledButton.addActionListener(e -> filledButtonPressed());
        gui.StartButton.addActionListener(e -> StartButtonPressed());
        gui.ResetButton.addActionListener(e -> ResetButtonPressed());
    }
    public void StartButtonPressed() {
        model.state.startButtonPressed();
    }

    public void filledButtonPressed() {
        int givenStock;
        try {
            givenStock = Integer.parseInt(gui.FilledField.getText());
            if (givenStock == 0) {
                gui.ErrorField.setText("You cant give 0 as an input for Filled field");
            } else if (givenStock < 0) {
                gui.ErrorField.setText("You cant give negative number as an input for Filled field");
            } else {
                model.state.fillButton(givenStock);
            }
        } catch (NumberFormatException e) {
            gui.ErrorField.setText("input for Filled field must be a positive number");
        }

    }

    public void ResetButtonPressed(){
        model.state.ResetButton();
    }



}
