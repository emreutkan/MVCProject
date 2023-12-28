public interface State {
    
    Controller controller = Controller.getInstance();
    Model model = controller.getModelInstance();

    void startButtonPressed();

    void fillButton(int stock);

    void ResetButton();

}
