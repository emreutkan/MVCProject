public interface State {
    
    Controller controller = Controller.getInstance();
    Model model = Model.getInstance();

    void startButtonPressed();

    void fillButton(int stock);

    void ResetButton();

}
