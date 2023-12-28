import javax.swing.*;

public class idleState implements State {

    @Override
    public void startButtonPressed() {
        model.setStock(model.getStock() - 1);
        model.setSold(model.getSold() + 1);
        controller.setState(controller.returnBrewingState());
    }

    public void fillButton(int stock) {
        if (model.getStock() == stock) {
            // was it an accident?
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int response = JOptionPane.showConfirmDialog(frame, "Did you click by accident?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                System.out.println("accidental fill button click was made");
            } else if (response == JOptionPane.NO_OPTION) {
                model.setStock(stock + model.getStock());
            }
        } else {
            model.setStock(stock + model.getStock());
        }

        controller.gui.ErrorField.setText("Machines Stock updated with " + stock + " amount of coffee capsules");
        controller.gui.FilledField.setText(String.valueOf(model.getStock()));
    }

    @Override
    public void ResetButton() {
        model.setSold(0);
        model.setStock(0);
        controller.setState(controller.returnEmptyState());
    }


}
