package application;

import java.io.File;

public class StackController {
    private StackGui gui;
    private StackManager stackManager;
    
    public StackController(StackGui gui) {
        this.gui = gui;
        this.stackManager = StackPersistence.buildStackManager(gui.inFile);
    }
    
    public void addUser(String id) {
        StackIdStatus stackMessage = StackValidator.isIdValid(id);
        
        if (stackMessage.isValid() && !stackManager.containsStack(id)) {
            addUserToStack(id);
        } else {
            handleInvalidId(id, stackMessage);
        }
    }

    private void addUserToStack(String id) {
        StackUser user = new StackUser(id);
        stackManager.addStack(user);
        updateViewAfterUserAdded(user);
    }

    private void handleInvalidId(String id, StackIdStatus stackMessage) {
        gui.txId.requestFocus();
        gui.txaResults.setText(String.format("Stack with id: %s not added%nerror message=%s", id, stackMessage.getErrorMessage()));
    }

    private void updateViewAfterUserAdded(StackUser user) {
        gui.txID.setText("");
        gui.txID.requestFocus();
        gui.txaResults.setText(String.format("Stack user with id %s added", user.getId()));
    }

    public void reset() {
        stackManager.clear();
        gui.txfID.setText("");
        gui.txfID.requestFocus();
        gui.txaResults.setText("All Stack users removed");
    }

    public void showAll() {
        gui.txaResults.setText(stackManager.toString());
    }

    public void save() {
        StackPersistence.saveStacks(gui.outFile, stackManager);
        gui.txaResults.setText("Stack users saved to file");
    }

    public static void main(String[] args) {
        // Create a StackGui object and a StackController object to start your application
        StackGui gui = new StackGui(); // Assuming you have a StackGui class
        StackController controller = new StackController(gui);
    }
}
