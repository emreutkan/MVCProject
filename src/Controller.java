
public class Controller  {
    Model model;
    View view = View.getInstance();

    private Controller(Model model) {
        this.model = model;
        initializeActionListeners();
    }
    private static Controller ControllerSingleton = null;

    public static synchronized Controller getInstance() {
        if (ControllerSingleton == null){
            Model model = Model.getInstance();
            ControllerSingleton = new Controller(model);
        }
        return ControllerSingleton;
    }


    public void initializeActionListeners() {
        view.FilledButton.addActionListener(e -> filledButtonPressed());
        view.StartButton.addActionListener(e -> StartButtonPressed());
        view.ResetButton.addActionListener(e -> ResetButtonPressed());
    }
    public void StartButtonPressed() {
        model.state.startButtonPressed();
    }

    public void filledButtonPressed() {
        int givenStock;
        try {
            givenStock = Integer.parseInt(view.FilledField.getText());
            if (givenStock == 0) {
                view.ErrorField.setText("You cant give 0 as an input for Filled field");
            } else if (givenStock < 0) {
                view.ErrorField.setText("You cant give negative number as an input for Filled field");
            } else {
                model.state.fillButton(givenStock);
            }
        } catch (NumberFormatException e) {
            view.ErrorField.setText("input for Filled field must be a positive number");
        }

    }

    public void ResetButtonPressed(){
        model.state.ResetButton();
    }

    public void BrewButtonPressed(){

    }


    public Model getModelInstance() {
        return this.model;
    }
}
