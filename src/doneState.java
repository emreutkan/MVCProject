import javax.swing.*;

public class doneState  implements State{

    @Override
    public void startButtonPressed() {
        if (model.getStock() == 0){
            controller.view.ErrorField.setText("Out of Stock");
            model.setState(model.returnEmptyState());
        }
        else {
            model.setStock(model.getStock()-1);
            model.setSold(model.getSold()+1);
            model.setState(model.returnBrewingState());

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
        controller.view.ErrorField.setText("Machines Stock updated with " + stock + " amount of coffee capsules");
        controller.view.FilledField.setText(String.valueOf(model.getStock()));
    }

    @Override
    public void ResetButton() {
        model.setSold(0);
        model.setStock(0);
        model.setState(model.returnEmptyState());
    }


}
