import javax.swing.*;

public class doneState  implements State{

    Model model;
    Controller controller;

    public doneState(Controller controller) {
        this.controller = controller;
        this.model = controller.model;
    }

    @Override
    public void startButtonPressed() {
        if (controller.model.getStock() == 0){
            this.controller.gui.ErrorField.setText("Out of Stock");
            this.controller.setState(controller.returnEmptyState());
        }
        else {
            model.setStock(model.getStock()-1);
            model.setSold(model.getSold()+1);
            this.controller.setState(controller.returnBrewingState());

        }
    }

    @Override
    public void fillButton(int stock) {
        if (model.getStock() == stock){
            // was it an accident?
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int response = JOptionPane.showConfirmDialog(frame, "Did you click by accident?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                System.out.println("accidental fill button click was made");
            } else if (response == JOptionPane.NO_OPTION) {
                model.setStock(stock+model.getStock());
            }
        }
        else {
            model.setStock(stock+model.getStock());
        }
        // Example of controller updating the view
        this.controller.gui.ErrorField.setText("Machines Stock updated with " + stock + " amount of coffee capsules");
        this.controller.gui.FilledField.setText(String.valueOf(model.getStock()));
    }

    @Override
    public void ResetButton() {
        model.setSold(0);
        model.setStock(0);
        this.controller.setState(controller.returnEmptyState());
    }


}
