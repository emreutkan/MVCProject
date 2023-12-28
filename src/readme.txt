When a button is clicked in a GUI, the following steps typically occur:

1. The button click event is detected by the view, which includes the button.

2. The view forwards this event to the controller, indicating which button was clicked.

3. The controller processes the event, which involve invoking methods on the model to update data or perform some action.

4. The controller also update the view to reflect changes in the model or provide feedback to the user.