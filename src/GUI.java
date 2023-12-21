import java.awt.*;

public class GUI extends javax.swing.JFrame implements Observer {

    public javax.swing.JTextField BREWINGfield;
    public javax.swing.JTextField DONEfield;
    public javax.swing.JButton FilledButton;
    public javax.swing.JTextField FilledField;
    public javax.swing.JTextField IDLEfield;
    public javax.swing.JButton ResetButton;
    public javax.swing.JButton TotalCupsButton;
    public javax.swing.JPanel firstRow;
    public javax.swing.JButton StartButton;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JTextField ErrorField;
    public javax.swing.JPanel mainFrame;
    public javax.swing.JPanel middleRow;
    public javax.swing.JTextField totalNumberOfCups;

    public GUI() {
        this.setVisible(true);
        this.setTitle("Coffee Maker");
        mainFrame = new javax.swing.JPanel();
        firstRow = new javax.swing.JPanel();
        FilledButton = new javax.swing.JButton();
        FilledField = new javax.swing.JTextField();
        middleRow = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        BREWINGfield = new javax.swing.JTextField();
        IDLEfield = new javax.swing.JTextField();
        DONEfield = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        totalNumberOfCups = new javax.swing.JTextField();
        TotalCupsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ErrorField = new javax.swing.JTextField();
        ResetButton = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstRow.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        FilledButton.setText("FILLED");

        FilledField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout firstRowLayout = new javax.swing.GroupLayout(firstRow);
        firstRow.setLayout(firstRowLayout);
        firstRowLayout.setHorizontalGroup(firstRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(firstRowLayout.createSequentialGroup().addComponent(FilledButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0).addComponent(FilledField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)));
        firstRowLayout.setVerticalGroup(firstRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(firstRowLayout.createSequentialGroup().addGroup(firstRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(FilledButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(FilledField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(0, 0, Short.MAX_VALUE)));

        middleRow.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        StartButton.setText("START");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        BREWINGfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BREWINGfield.setText("BREWING");

        IDLEfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDLEfield.setText("IDLE");

        DONEfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DONEfield.setText("DONE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(DONEfield, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(IDLEfield, javax.swing.GroupLayout.Alignment.LEADING).addComponent(BREWINGfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(IDLEfield, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0).addComponent(BREWINGfield, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0).addComponent(DONEfield, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        totalNumberOfCups.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TotalCupsButton.setText("TOTAL CUPS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(TotalCupsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0).addComponent(totalNumberOfCups)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(TotalCupsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE).addComponent(totalNumberOfCups));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        ErrorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ErrorField.setText("Messages/Warnings");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 0).addComponent(ErrorField).addGap(0, 0, 0)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(ErrorField, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE));

        ResetButton.setText("Reset");

        javax.swing.GroupLayout middleRowLayout = new javax.swing.GroupLayout(middleRow);
        middleRow.setLayout(middleRowLayout);
        middleRowLayout.setHorizontalGroup(middleRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(middleRowLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(middleRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(ResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(middleRowLayout.createSequentialGroup().addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(0, 0, 0)));
        middleRowLayout.setVerticalGroup(middleRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(middleRowLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(middleRowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(StartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(0, 0, Short.MAX_VALUE).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0).addComponent(ResetButton).addGap(0, 0, 0).addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0)));

        javax.swing.GroupLayout mainFrameLayout = new javax.swing.GroupLayout(mainFrame);
        mainFrame.setLayout(mainFrameLayout);
        mainFrameLayout.setHorizontalGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainFrameLayout.createSequentialGroup().addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainFrameLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(middleRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(firstRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(0, 0, Short.MAX_VALUE)));
        mainFrameLayout.setVerticalGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(mainFrameLayout.createSequentialGroup().addComponent(firstRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, 0).addComponent(middleRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(mainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(mainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }

    @Override
    public void update(State state) {
        DatabaseController database = DatabaseController.getInstance();
        if (state instanceof idleState) {
            IDLEfield.setBackground(Color.yellow);
        } else if (state instanceof brewingState) {
            IDLEfield.setBackground(Color.white);
            DONEfield.setBackground(Color.white);
            BREWINGfield.setBackground(Color.RED);
            FilledField.setText(String.valueOf(database.getStock()));
            totalNumberOfCups.setText(String.valueOf(database.getSold()));
            ((brewingState) state).brew();
        } else if (state instanceof doneState) {
            IDLEfield.setBackground(Color.white);
            BREWINGfield.setBackground(Color.white);
            DONEfield.setBackground(Color.green);
        } else if (state instanceof emptyState) {
            DONEfield.setBackground(Color.white);
            IDLEfield.setBackground(Color.white);
            FilledField.setText(String.valueOf(database.getStock()));
            totalNumberOfCups.setText(String.valueOf(database.getSold()));
        }
    }
}
