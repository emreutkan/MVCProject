
public class Controller implements Subject {

    DatabaseController database = DatabaseController.getInstance();
    GUI gui;
    State state;
    State doneState;
    State emptyState;
    State idleState;
    State brewingState;


    public Controller(GUI gui) {
        database.InitializeTable();

        this.gui = gui;
        addObserver(this.gui);

        doneState = new doneState(this);
        emptyState = new emptyState(this);
        idleState = new idleState(this);
        brewingState = new brewingState(this);
        this.state = emptyState;
        notifyObservers();

        initializeActionListeners();
    }

    public void initializeActionListeners() {
        gui.FilledButton.addActionListener(e -> filledButtonPressed());
        gui.StartButton.addActionListener(e -> StartButtonPressed());
        gui.ResetButton.addActionListener(e -> ResetButtonPressed());
    }
    public void StartButtonPressed() {
        this.state.startButtonPressed();
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
                this.state.fillButton(givenStock);
            }
        } catch (NumberFormatException e) {
            gui.ErrorField.setText("input for Filled field must be a positive number");
        }

    }

    public void ResetButtonPressed(){
        this.state.ResetButton();
    }

    void setState(State state) {
        this.state = state;
        notifyObservers();
    }

    State returnDoneState() {
        return doneState;
    }

    State returnEmptyState() {
        return emptyState;
    }

    State returnIdleState() {
        return idleState;
    }

    State returnBrewingState() {
        return brewingState;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.state);
        }
    }
}
