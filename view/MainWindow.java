package view;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MainWindow {

    String[] columnNames = {"ID", "Фамилия", "Разряд", "Должность", "Профсоюз"};
    protected Table table = new Table(columnNames);

    protected JFrame frame = new JFrame();
    protected JButton btnAdd = new JButton("Add");
    protected JButton btnDel = new JButton("Delete");
    protected JButton btnSearch = new JButton("Search");
    protected JButton btnEdit = new JButton("Edit");

    protected JButton btnTariff = new JButton("Tariffs");
    protected JButton btnEmployee = new JButton("Employees");
    protected JButton btnSalary = new JButton("Salaries");
    protected JButton btnPayroll = new JButton("Payroll");






    MainWindow (){
        this.createAndShowGUI(frame);

    }

    public void createAndShowGUI(JFrame frame) {


        JPanel tablePanel = new JPanel(new BorderLayout());

        tablePanel.add(new JScrollPane(table.table));
        JPanel panel = new JPanel(new GridLayout(2, 5, 2, 2));
        tablePanel.add(panel,BorderLayout.SOUTH);

        for (JComponent r : Arrays.asList(btnAdd, btnDel, btnSearch, btnEdit, btnTariff,  btnEmployee, btnSalary, btnPayroll)) {
            panel.add(r);
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(tablePanel);
        frame.setSize(450, 240);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JFrame getFrame(){
        return frame;
    }


}
