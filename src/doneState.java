import javax.swing.*;

public class doneState  implements State{

    Controller controller;

    public doneState(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void startButtonPressed() {
        if (controller.database.getStock() == 0){
            this.controller.gui.ErrorField.setText("Out of Stock");
            this.controller.setState(controller.returnEmptyState());
        }
        else {
            this.controller.database.setStock(this.controller.database.getStock()-1);
            this.controller.database.setSold(this.controller.database.getSold()+1);
            this.controller.setState(controller.returnBrewingState());

        }
    }

    @Override
    public void fillButton(int stock) {
        if (controller.database.getStock() == stock){
            // was it an accident?
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int response = JOptionPane.showConfirmDialog(frame, "Did you click by accident?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                System.out.println("accidental fillbutton click was made");
            } else if (response == JOptionPane.NO_OPTION) {
                controller.database.setStock(stock+controller.database.getStock());
            }
        }
        else {
            controller.database.setStock(stock+controller.database.getStock());
        }

        this.controller.gui.ErrorField.setText("Machines Stock updated with " + stock + " amount of coffe capsules");
        this.controller.gui.FilledField.setText(String.valueOf(controller.database.getStock()));
    }

    @Override
    public void ResetButton() {
        this.controller.database.setSold(0);
        this.controller.database.setStock(0);
        this.controller.setState(controller.returnEmptyState());
    }


}
