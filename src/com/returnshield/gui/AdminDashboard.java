package com.returnshield.gui;

import com.returnshield.models.ReturnRequest;
import com.returnshield.services.AppData;
import com.returnshield.services.FraudDetectionService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminDashboard extends JFrame {

    JTable fraudTable;

    DefaultTableModel model;

    public AdminDashboard() {

        setTitle("Admin Dashboard");

        setSize(1100, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(30,30,30));

        JPanel sidebar = new JPanel();

        sidebar.setPreferredSize(new Dimension(220,650));

        sidebar.setBackground(new Color(18,18,18));

        sidebar.setLayout(null);

        JLabel menuTitle =
                new JLabel("ReturnShield");

        menuTitle.setForeground(Color.WHITE);

        menuTitle.setFont(
                new Font("Arial",
                        Font.BOLD,
                        24));

        menuTitle.setBounds(25,30,200,40);

        sidebar.add(menuTitle);

        JButton addReturnBtn =
                new JButton("Add Return");

        addReturnBtn.setBounds(30,120,150,40);

        sidebar.add(addReturnBtn);

        JButton refreshBtn =
                new JButton("Refresh Table");

        refreshBtn.setBounds(30,190,150,40);

        sidebar.add(refreshBtn);

        JButton processBtn =
                new JButton("Process Request");

        processBtn.setBounds(30,260,150,40);

        sidebar.add(processBtn);

        JButton undoBtn =
                new JButton("Undo Action");

        undoBtn.setBounds(30,330,150,40);

        sidebar.add(undoBtn);

        add(sidebar, BorderLayout.WEST);

        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(
                new Color(35,35,35));

        mainPanel.setLayout(null);

        JLabel heading =
                new JLabel(
                        "Fraud Monitoring Dashboard"
                );

        heading.setForeground(Color.WHITE);

        heading.setFont(
                new Font("Arial",
                        Font.BOLD,
                        28));

        heading.setBounds(40,20,500,40);

        mainPanel.add(heading);

        JPanel card1 =
                createCard(
                        "Pending Requests",
                        "LIVE",
                        40,
                        90
                );

        JPanel card2 =
                createCard(
                        "Fraud Queue",
                        "ACTIVE",
                        320,
                        90
                );

        JPanel card3 =
                createCard(
                        "Undo System",
                        "ENABLED",
                        600,
                        90
                );

        mainPanel.add(card1);

        mainPanel.add(card2);

        mainPanel.add(card3);

        String[] columns = {
                "Customer",
                "Product",
                "Fraud Score",
                "Risk Level"
        };

        model =
                new DefaultTableModel(columns,0);

        fraudTable =
                new JTable(model);

        fraudTable.setRowHeight(30);

        JScrollPane pane =
                new JScrollPane(fraudTable);

        pane.setBounds(40,240,760,260);

        mainPanel.add(pane);

        add(mainPanel, BorderLayout.CENTER);

        addReturnBtn.addActionListener(
                e -> new ReturnRequestForm()
        );

        refreshBtn.addActionListener(
                e -> refreshTable()
        );

        processBtn.addActionListener(
                e -> processRequest()
        );

        undoBtn.addActionListener(
                e -> undoAction()
        );

        setVisible(true);
    }

    private JPanel createCard(String title,
                              String value,
                              int x,
                              int y) {

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(
                new Color(50,50,50));

        panel.setBounds(x,y,220,100);

        JLabel t = new JLabel(title);

        t.setForeground(Color.WHITE);

        t.setBounds(20,15,180,30);

        JLabel v = new JLabel(value);

        v.setForeground(Color.CYAN);

        v.setFont(
                new Font("Arial",
                        Font.BOLD,
                        24));

        v.setBounds(20,45,180,40);

        panel.add(t);

        panel.add(v);

        return panel;
    }

    private void refreshTable() {

        model.setRowCount(0);

        for(ReturnRequest request :
                AppData.returnQueueManager
                        .getReturnQueue()) {

            model.addRow(new Object[]{

                    request.getCustomer().getName(),

                    request.getProduct()
                            .getProductName(),

                    request.getFraudScore(),

                    FraudDetectionService
                            .getFraudLevel(
                            request.getFraudScore()
                    )
            });
        }
    }

    private void processRequest() {

        ReturnRequest request =
                AppData.returnQueueManager
                        .processRequest();

        if(request == null) {

            JOptionPane.showMessageDialog(this,
                    "No Requests Available");

            return;
        }

        String action =
                "Processed Request of "
                        + request.getCustomer()
                        .getName();

        AppData.undoManager
                .saveAction(action);

        JOptionPane.showMessageDialog(this,
                action);

        refreshTable();
    }

    private void undoAction() {

        String action =
                AppData.undoManager
                        .undoAction();

        JOptionPane.showMessageDialog(this,
                "Undo: " + action);
    }
}