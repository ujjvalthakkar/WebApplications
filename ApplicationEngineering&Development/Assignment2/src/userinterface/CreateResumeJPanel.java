/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import business.Resume;
import business.ResumeRepository;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ujjval
 */
public class CreateResumeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateResumeJPanel
     */
    private ResumeRepository resumeRepo;
    private String imagePath;
    private Pattern pattern;
    private Matcher matcher;
    private static final String valid_email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public CreateResumeJPanel(ResumeRepository recvdResumeRepo) {
        initComponents();
        this.resumeRepo = recvdResumeRepo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerJLabel = new javax.swing.JLabel();
        firstNameJLabel = new javax.swing.JLabel();
        lastNameJLabel = new javax.swing.JLabel();
        skillJLabel = new javax.swing.JLabel();
        lastNameTxtField = new javax.swing.JTextField();
        firstNameTxtField = new javax.swing.JTextField();
        photoUploadJLabel = new javax.swing.JLabel();
        browseJbtn = new javax.swing.JButton();
        achievementsJlabel = new javax.swing.JLabel();
        objectiveJLabel = new javax.swing.JLabel();
        affiliationJLabel = new javax.swing.JLabel();
        affiliationJTextField = new javax.swing.JTextField();
        objectiveJScrollPane = new javax.swing.JScrollPane();
        objectiveJtextArea = new javax.swing.JTextArea();
        achievementJScrollPane = new javax.swing.JScrollPane();
        achievementsJTextArea = new javax.swing.JTextArea();
        experienceJScrollPane = new javax.swing.JScrollPane();
        experienceJTextArea = new javax.swing.JTextArea();
        experienceJLabel = new javax.swing.JLabel();
        dobJLabel = new javax.swing.JLabel();
        dobJTextField = new javax.swing.JTextField();
        addrLine1JLabel = new javax.swing.JLabel();
        addrLine2JLabel = new javax.swing.JLabel();
        cityJLabel = new javax.swing.JLabel();
        stateJLabel = new javax.swing.JLabel();
        countryJLabel = new javax.swing.JLabel();
        zipJLabel = new javax.swing.JLabel();
        contactJLabel = new javax.swing.JLabel();
        emailJLabel = new javax.swing.JLabel();
        emailTxtField = new javax.swing.JTextField();
        contactNumbTxtField = new javax.swing.JTextField();
        zipTxtField = new javax.swing.JTextField();
        countryTxtField = new javax.swing.JTextField();
        stateTxtField = new javax.swing.JTextField();
        cityTxtField = new javax.swing.JTextField();
        addrLine1TxtField = new javax.swing.JTextField();
        addrLine2TxtField = new javax.swing.JTextField();
        addressDetailsJLabel = new javax.swing.JLabel();
        univJLabel = new javax.swing.JLabel();
        completionYearJLabel = new javax.swing.JLabel();
        majorJLabel = new javax.swing.JLabel();
        degreeTypeJLabel = new javax.swing.JLabel();
        univNameJTextField = new javax.swing.JTextField();
        completionDateJTextField = new javax.swing.JTextField();
        majorJTextField = new javax.swing.JTextField();
        educationJLabel = new javax.swing.JLabel();
        gpaJLabel = new javax.swing.JLabel();
        gpaJTxtField = new javax.swing.JTextField();
        displayImagePathJLabel = new javax.swing.JLabel();
        createResumeJbtn = new javax.swing.JButton();
        genderJLabel = new javax.swing.JLabel();
        maleRadioBtn = new javax.swing.JRadioButton();
        femaleRadioBtn = new javax.swing.JRadioButton();
        citizenshipJLabel = new javax.swing.JLabel();
        localCitizenjRadioButton = new javax.swing.JRadioButton();
        interCitizenjRadioButton = new javax.swing.JRadioButton();
        gradStatusJLabel = new javax.swing.JLabel();
        graduatedRadioBtn = new javax.swing.JRadioButton();
        inProgressRadioBtn = new javax.swing.JRadioButton();
        javaJCheckbox = new javax.swing.JCheckBox();
        cplusJCheckbox = new javax.swing.JCheckBox();
        pythonJCheckbox = new javax.swing.JCheckBox();
        csharpJCheckbox = new javax.swing.JCheckBox();
        mysqlJCheckbox = new javax.swing.JCheckBox();
        oracleJCheckbox = new javax.swing.JCheckBox();
        madatoryJLabel = new javax.swing.JLabel();
        degreeTypeJComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(750, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headerJLabel.setText("Create Resume");
        add(headerJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        firstNameJLabel.setText("First Name:*");
        add(firstNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 85, 82, -1));

        lastNameJLabel.setText("Last Name:*");
        add(lastNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 82, -1));

        skillJLabel.setText("Skills:*");
        add(skillJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, -1, -1));

        lastNameTxtField.setNextFocusableComponent(browseJbtn);
        add(lastNameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 107, 150, -1));

        firstNameTxtField.setNextFocusableComponent(lastNameTxtField);
        add(firstNameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 81, 150, -1));

        photoUploadJLabel.setText("Upload Photo:");
        add(photoUploadJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        browseJbtn.setText("Browse..");
        browseJbtn.setNextFocusableComponent(dobJTextField);
        browseJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseJbtnActionPerformed(evt);
            }
        });
        add(browseJbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        achievementsJlabel.setText("Achievements:");
        add(achievementsJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 175, -1, -1));

        objectiveJLabel.setText("Objective Statement:*");
        add(objectiveJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 110, -1, -1));

        affiliationJLabel.setText("Affiliation:");
        add(affiliationJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 84, -1, -1));

        affiliationJTextField.setNextFocusableComponent(objectiveJtextArea);
        add(affiliationJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 81, 310, -1));

        objectiveJtextArea.setColumns(20);
        objectiveJtextArea.setLineWrap(true);
        objectiveJtextArea.setRows(5);
        objectiveJtextArea.setNextFocusableComponent(achievementsJTextArea);
        objectiveJScrollPane.setViewportView(objectiveJtextArea);

        add(objectiveJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 110, 310, 60));

        achievementsJTextArea.setColumns(20);
        achievementsJTextArea.setLineWrap(true);
        achievementsJTextArea.setRows(5);
        achievementsJTextArea.setNextFocusableComponent(experienceJTextArea);
        achievementJScrollPane.setViewportView(achievementsJTextArea);

        add(achievementJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 175, 310, 60));

        experienceJTextArea.setColumns(20);
        experienceJTextArea.setRows(5);
        experienceJTextArea.setNextFocusableComponent(univNameJTextField);
        experienceJTextArea.setPreferredSize(new java.awt.Dimension(164, 96));
        experienceJScrollPane.setViewportView(experienceJTextArea);

        add(experienceJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 245, 310, 70));

        experienceJLabel.setText("Experience:*");
        add(experienceJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 245, -1, -1));

        dobJLabel.setText("Date Of Birth:");
        add(dobJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        dobJTextField.setNextFocusableComponent(maleRadioBtn);
        add(dobJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, -1));

        addrLine1JLabel.setText("Address Line1:");
        add(addrLine1JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 110, -1));

        addrLine2JLabel.setText("Address Line2:");
        add(addrLine2JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 110, -1));

        cityJLabel.setText("City:");
        add(cityJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 82, -1));

        stateJLabel.setText("State:");
        add(stateJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 82, 20));

        countryJLabel.setText("Country:");
        add(countryJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 82, -1));

        zipJLabel.setText("Zip Code:");
        add(zipJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 82, -1));

        contactJLabel.setText("Contact Number:*");
        add(contactJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, 20));

        emailJLabel.setText("Email Id:*");
        add(emailJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 82, -1));

        emailTxtField.setNextFocusableComponent(affiliationJTextField);
        emailTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTxtFieldFocusLost(evt);
            }
        });
        add(emailTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 150, -1));

        contactNumbTxtField.setText("(Enter only phone number..)");
        contactNumbTxtField.setNextFocusableComponent(emailTxtField);
        contactNumbTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contactNumbTxtFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                contactNumbTxtFieldFocusLost(evt);
            }
        });
        contactNumbTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumbTxtFieldActionPerformed(evt);
            }
        });
        contactNumbTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactNumbTxtFieldKeyTyped(evt);
            }
        });
        add(contactNumbTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 150, -1));

        zipTxtField.setNextFocusableComponent(contactNumbTxtField);
        zipTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zipTxtFieldKeyTyped(evt);
            }
        });
        add(zipTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 150, -1));

        countryTxtField.setNextFocusableComponent(zipTxtField);
        add(countryTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 150, -1));

        stateTxtField.setNextFocusableComponent(countryTxtField);
        add(stateTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 150, -1));

        cityTxtField.setNextFocusableComponent(stateTxtField);
        add(cityTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 150, -1));

        addrLine1TxtField.setNextFocusableComponent(addrLine2TxtField);
        add(addrLine1TxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 150, -1));

        addrLine2TxtField.setNextFocusableComponent(cityTxtField);
        add(addrLine2TxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 150, -1));

        addressDetailsJLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Address Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        add(addressDetailsJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 310, 280));

        univJLabel.setText("University Name:");
        add(univJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        completionYearJLabel.setText("Date of completion:");
        add(completionYearJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        majorJLabel.setText("Major:");
        add(majorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, -1, -1));

        degreeTypeJLabel.setText("Degree Type:");
        add(degreeTypeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, -1));

        univNameJTextField.setNextFocusableComponent(completionDateJTextField);
        add(univNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 240, -1));

        completionDateJTextField.setText("(MM/DD/YYYY)");
        completionDateJTextField.setNextFocusableComponent(majorJTextField);
        completionDateJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                completionDateJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                completionDateJTextFieldFocusLost(evt);
            }
        });
        add(completionDateJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 240, -1));
        add(majorJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 240, -1));

        educationJLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Education Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        add(educationJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 480, 190));

        gpaJLabel.setText("GPA:");
        add(gpaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, -1, -1));

        gpaJTxtField.setNextFocusableComponent(javaJCheckbox);
        add(gpaJTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 240, -1));
        add(displayImagePathJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 276, 20));

        createResumeJbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createResumeJbtn.setText("Create Resume");
        createResumeJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createResumeJbtnActionPerformed(evt);
            }
        });
        add(createResumeJbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 660, -1, -1));

        genderJLabel.setText("Gender:");
        add(genderJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        maleRadioBtn.setText("Male");
        maleRadioBtn.setNextFocusableComponent(femaleRadioBtn);
        maleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioBtnActionPerformed(evt);
            }
        });
        add(maleRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        femaleRadioBtn.setText("Female");
        femaleRadioBtn.setNextFocusableComponent(localCitizenjRadioButton);
        femaleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioBtnActionPerformed(evt);
            }
        });
        add(femaleRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        citizenshipJLabel.setText("Citizenship:");
        add(citizenshipJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        localCitizenjRadioButton.setText("Local Citizen");
        localCitizenjRadioButton.setNextFocusableComponent(interCitizenjRadioButton);
        localCitizenjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localCitizenjRadioButtonActionPerformed(evt);
            }
        });
        add(localCitizenjRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        interCitizenjRadioButton.setText("International Citizen");
        interCitizenjRadioButton.setNextFocusableComponent(graduatedRadioBtn);
        interCitizenjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interCitizenjRadioButtonActionPerformed(evt);
            }
        });
        add(interCitizenjRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        gradStatusJLabel.setText("Graduation Status:*");
        add(gradStatusJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 20));

        graduatedRadioBtn.setText("Graduated");
        graduatedRadioBtn.setNextFocusableComponent(inProgressRadioBtn);
        graduatedRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduatedRadioBtnActionPerformed(evt);
            }
        });
        add(graduatedRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        inProgressRadioBtn.setText("In Progress");
        inProgressRadioBtn.setNextFocusableComponent(addrLine1TxtField);
        inProgressRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inProgressRadioBtnActionPerformed(evt);
            }
        });
        add(inProgressRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        javaJCheckbox.setText("Java");
        javaJCheckbox.setNextFocusableComponent(cplusJCheckbox);
        add(javaJCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, -1, -1));

        cplusJCheckbox.setText("C++");
        cplusJCheckbox.setNextFocusableComponent(pythonJCheckbox);
        add(cplusJCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 540, -1, -1));

        pythonJCheckbox.setText("Python");
        pythonJCheckbox.setNextFocusableComponent(csharpJCheckbox);
        add(pythonJCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, -1, -1));

        csharpJCheckbox.setText("C#");
        csharpJCheckbox.setNextFocusableComponent(mysqlJCheckbox);
        add(csharpJCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, -1, -1));

        mysqlJCheckbox.setText("MySQL");
        mysqlJCheckbox.setNextFocusableComponent(oracleJCheckbox);
        add(mysqlJCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 600, -1, -1));

        oracleJCheckbox.setText("Oracle");
        oracleJCheckbox.setNextFocusableComponent(createResumeJbtn);
        add(oracleJCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, -1, -1));

        madatoryJLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        madatoryJLabel.setText("Fields marked * are madatory");
        add(madatoryJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        degreeTypeJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High School", "Under Graduate", "Graduate" }));
        degreeTypeJComboBox.setSelectedIndex(2);
        degreeTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeTypeJComboBoxActionPerformed(evt);
            }
        });
        add(degreeTypeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    public boolean validateEmail(String recvdEmail) {

        pattern = Pattern.compile(valid_email_pattern);
        matcher = pattern.matcher(recvdEmail);
        return matcher.matches();
    }

    private boolean mandValidation() {
        //Madatory Check
        boolean mandStatus = true;
        boolean mandGradStatus = false;
        boolean mandSkillStatus = false;
        if (graduatedRadioBtn.isSelected() || inProgressRadioBtn.isSelected()) {
            mandGradStatus = true;
        }
        if (javaJCheckbox.isSelected() || cplusJCheckbox.isSelected() || csharpJCheckbox.isSelected() || pythonJCheckbox.isSelected() || oracleJCheckbox.isSelected() || mysqlJCheckbox.isSelected()) {
            mandSkillStatus = true;
        }

        if (firstNameTxtField.getText().isEmpty() || lastNameTxtField.getText().isEmpty() || objectiveJtextArea.getText().isEmpty() || experienceJTextArea.getText().isEmpty()) {
            mandStatus = false;
        }

        if (contactNumbTxtField.getText().equals("(Enter only phone number..)") || emailTxtField.getText().isEmpty()) {
            mandStatus = false;
        }

        if (mandStatus == true && mandSkillStatus == true && mandGradStatus == true) {
            return true;
        } else {
            return false;
        }

    }

    private void clearFields() {
        firstNameTxtField.setText("");
        lastNameTxtField.setText("");
        addrLine1TxtField.setText("");
        addrLine2TxtField.setText("");
        cityTxtField.setText("");
        stateTxtField.setText("");
        countryTxtField.setText("");
        zipTxtField.setText("");
        contactNumbTxtField.setText("");
        emailTxtField.setText("");
        objectiveJtextArea.setText("");
        affiliationJTextField.setText("");
        univNameJTextField.setText("");
        completionDateJTextField.setText("(MM/DD/YYYY)");
        majorJTextField.setText("");
        gpaJTxtField.setText("");
        achievementsJTextArea.setText("");
        experienceJTextArea.setText("");
        dobJTextField.setText("");
        maleRadioBtn.setSelected(false);
        femaleRadioBtn.setSelected(false);
        localCitizenjRadioButton.setSelected(false);
        interCitizenjRadioButton.setSelected(false);
        graduatedRadioBtn.setSelected(false);
        inProgressRadioBtn.setSelected(false);
        displayImagePathJLabel.setText("");
        javaJCheckbox.setSelected(false);
        cplusJCheckbox.setSelected(false);
        pythonJCheckbox.setSelected(false);
        oracleJCheckbox.setSelected(false);
        mysqlJCheckbox.setSelected(false);
        csharpJCheckbox.setSelected(false);
    }
    private void browseJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseJbtnActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null); // Browsing image from its location
        File chosenFile = fileChooser.getSelectedFile(); // selected file is obtained in File type object
        imagePath = chosenFile.getAbsolutePath();
        displayImagePathJLabel.setText(imagePath); // Inline display of selected path
    }//GEN-LAST:event_browseJbtnActionPerformed

    private void completionDateJTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_completionDateJTextFieldFocusGained
        // TODO add your handling code here:
        completionDateJTextField.setText("");
    }//GEN-LAST:event_completionDateJTextFieldFocusGained

    private void createResumeJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createResumeJbtnActionPerformed
        // TODO add your handling code here:
        //Mandatory Validation
        boolean mandStatus = mandValidation();
        if (mandStatus != true) {
            JOptionPane.showMessageDialog(this, "Please fill all the mandatory fields");
        } else {
            Resume rs = resumeRepo.addResumes();
            String firstName = firstNameTxtField.getText();
            String lastName = lastNameTxtField.getText();
            String addrLine1 = addrLine1TxtField.getText();
            String addrLine2 = addrLine2TxtField.getText();
            String city = cityTxtField.getText();
            String state = stateTxtField.getText();
            String country = countryTxtField.getText();
            String zip = zipTxtField.getText();
            String contactNumb = contactNumbTxtField.getText();
            String email = emailTxtField.getText();
            String objective = objectiveJtextArea.getText();
            String affiliation = affiliationJTextField.getText();
            String univName = univNameJTextField.getText();
            String completionDate = completionDateJTextField.getText();
            String major = majorJTextField.getText();
            String degreeType = degreeTypeJComboBox.getSelectedItem().toString();
            String gpa = gpaJTxtField.getText();
            String achievements = achievementsJTextArea.getText();
            String experience = experienceJTextArea.getText();
            String dob = dobJTextField.getText();
            String gender = "";
            if (maleRadioBtn.isSelected()) {
                gender = "Male";
            }

            if (femaleRadioBtn.isSelected()) {
                gender = "Female";
            }
            String citizenship = "";
            if (localCitizenjRadioButton.isSelected()) {
                citizenship = "Local Citizen";
            }
            if (interCitizenjRadioButton.isSelected()) {
                citizenship = "International Citizen";
            }
            String gradStatus = "";
            if (graduatedRadioBtn.isSelected()) {
                gradStatus = "Graduated";
            }
            if (inProgressRadioBtn.isSelected()) {
                gradStatus = "In Progress";
            }

            String skillSet = "";
            rs.setFirstName(firstName);
            rs.setLastName(lastName);
            rs.setAddressLine1(addrLine1);
            rs.setAddressLine2(addrLine2);
            rs.setCity(city);
            rs.setState(state);
            rs.setCountry(country);
            rs.setZipcode(zip);
            rs.setContactNumb(contactNumb);
            rs.setEmailId(email);
            rs.setObjectiveStatement(objective);
            rs.setAffiliation(affiliation);
            rs.setUnivName(univName);
            rs.setDateOfCompletion(completionDate);
            rs.setMajor(major);
            rs.setDegreeType(degreeType);
            rs.setGpa(gpa);
            if (javaJCheckbox.isSelected()) {
                skillSet = "Java, ";
            }
            if (cplusJCheckbox.isSelected()) {
                skillSet = skillSet.concat("C++, ");
            }
            if (pythonJCheckbox.isSelected()) {
                skillSet = skillSet.concat("Python, ");
            }
            if (csharpJCheckbox.isSelected()) {
                skillSet = skillSet.concat("C#, ");
            }
            if (mysqlJCheckbox.isSelected()) {
                skillSet = skillSet.concat("MySQL, ");
            }
            if (oracleJCheckbox.isSelected()) {
                skillSet = skillSet.concat("Oracle");
            }
            if(skillSet.endsWith(", "))
            {
                skillSet=skillSet.substring(0,skillSet.length()-2);
            }
            rs.setSkill(skillSet);
            rs.setAchievements(achievements);
            rs.setExperience(experience);
            rs.setDob(dob);
            rs.setImagePath(imagePath);
            rs.setGender(gender);
            rs.setCitizenship(citizenship);
            rs.setGraduationStatus(gradStatus);
            clearFields();
            JOptionPane.showMessageDialog(this, "Resume created!");
        }
    }//GEN-LAST:event_createResumeJbtnActionPerformed

    private void graduatedRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduatedRadioBtnActionPerformed
        // TODO add your handling code here:
        if (graduatedRadioBtn.isSelected()) {
            inProgressRadioBtn.setSelected(false);
        }
    }//GEN-LAST:event_graduatedRadioBtnActionPerformed

    private void femaleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioBtnActionPerformed
        // TODO add your handling code here:
        if (femaleRadioBtn.isSelected()) {
            maleRadioBtn.setSelected(false);
        }
    }//GEN-LAST:event_femaleRadioBtnActionPerformed

    private void maleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioBtnActionPerformed
        // TODO add your handling code here:
        if (maleRadioBtn.isSelected()) {
            femaleRadioBtn.setSelected(false);
        }

    }//GEN-LAST:event_maleRadioBtnActionPerformed

    private void localCitizenjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localCitizenjRadioButtonActionPerformed
        // TODO add your handling code here:
        if (localCitizenjRadioButton.isSelected()) {
            interCitizenjRadioButton.setSelected(false);
        }

    }//GEN-LAST:event_localCitizenjRadioButtonActionPerformed

    private void interCitizenjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interCitizenjRadioButtonActionPerformed
        // TODO add your handling code here:
        if (interCitizenjRadioButton.isSelected()) {
            localCitizenjRadioButton.setSelected(false);
        }

    }//GEN-LAST:event_interCitizenjRadioButtonActionPerformed

    private void inProgressRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inProgressRadioBtnActionPerformed
        // TODO add your handling code here:
        if (inProgressRadioBtn.isSelected()) {
            graduatedRadioBtn.setSelected(false);
        }

    }//GEN-LAST:event_inProgressRadioBtnActionPerformed

    private void completionDateJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_completionDateJTextFieldFocusLost
        // TODO add your handling code here:
        String textEntered = completionDateJTextField.getText();
        if (textEntered.equals("")) {
            completionDateJTextField.setText("(MM/DD/YYYY)");
        }
    }//GEN-LAST:event_completionDateJTextFieldFocusLost

    private void contactNumbTxtFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactNumbTxtFieldKeyTyped
        // TODO add your handling code here:
        char charEntered = evt.getKeyChar();
        // Allows only numbers,backspace and Delete 
        if ((!Character.isDigit(charEntered)) || (charEntered == KeyEvent.VK_BACK_SPACE) || (charEntered == KeyEvent.VK_DELETE)) {
            evt.consume();
        }

    }//GEN-LAST:event_contactNumbTxtFieldKeyTyped

    private void contactNumbTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactNumbTxtFieldFocusGained
        // TODO add your handling code here:
        contactNumbTxtField.setText("");
    }//GEN-LAST:event_contactNumbTxtFieldFocusGained

    private void contactNumbTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactNumbTxtFieldFocusLost
        // TODO add your handling code here:
        if (contactNumbTxtField.getText().equals("")) {
            contactNumbTxtField.setText("(Enter only phone number..)");
        }
    }//GEN-LAST:event_contactNumbTxtFieldFocusLost

    private void contactNumbTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumbTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumbTxtFieldActionPerformed

    private void emailTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTxtFieldFocusLost
        // TODO add your handling code here:
        String email=emailTxtField.getText();
        Boolean validEmailStatus=validateEmail(email);
        
        if(validEmailStatus == true)
            emailTxtField.setText(email);
        else 
        {
            JOptionPane.showMessageDialog(this,"Invalid Email! Please enter a valid email address!");
            emailTxtField.setText("");
        }
    }//GEN-LAST:event_emailTxtFieldFocusLost

    private void zipTxtFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zipTxtFieldKeyTyped
        // TODO add your handling code here:
        char charEntered = evt.getKeyChar();
        // Allows only numbers,backspace and Delete 
        if ((!Character.isDigit(charEntered)) || (charEntered == KeyEvent.VK_BACK_SPACE) || (charEntered == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_zipTxtFieldKeyTyped

    private void degreeTypeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreeTypeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_degreeTypeJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane achievementJScrollPane;
    private javax.swing.JTextArea achievementsJTextArea;
    private javax.swing.JLabel achievementsJlabel;
    private javax.swing.JLabel addrLine1JLabel;
    private javax.swing.JTextField addrLine1TxtField;
    private javax.swing.JLabel addrLine2JLabel;
    private javax.swing.JTextField addrLine2TxtField;
    private javax.swing.JLabel addressDetailsJLabel;
    private javax.swing.JLabel affiliationJLabel;
    private javax.swing.JTextField affiliationJTextField;
    private javax.swing.JButton browseJbtn;
    private javax.swing.JLabel citizenshipJLabel;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JTextField cityTxtField;
    private javax.swing.JTextField completionDateJTextField;
    private javax.swing.JLabel completionYearJLabel;
    private javax.swing.JLabel contactJLabel;
    private javax.swing.JTextField contactNumbTxtField;
    private javax.swing.JLabel countryJLabel;
    private javax.swing.JTextField countryTxtField;
    private javax.swing.JCheckBox cplusJCheckbox;
    private javax.swing.JButton createResumeJbtn;
    private javax.swing.JCheckBox csharpJCheckbox;
    private javax.swing.JComboBox<String> degreeTypeJComboBox;
    private javax.swing.JLabel degreeTypeJLabel;
    private javax.swing.JLabel displayImagePathJLabel;
    private javax.swing.JLabel dobJLabel;
    private javax.swing.JTextField dobJTextField;
    private javax.swing.JLabel educationJLabel;
    private javax.swing.JLabel emailJLabel;
    private javax.swing.JTextField emailTxtField;
    private javax.swing.JLabel experienceJLabel;
    private javax.swing.JScrollPane experienceJScrollPane;
    private javax.swing.JTextArea experienceJTextArea;
    private javax.swing.JRadioButton femaleRadioBtn;
    private javax.swing.JLabel firstNameJLabel;
    private javax.swing.JTextField firstNameTxtField;
    private javax.swing.JLabel genderJLabel;
    private javax.swing.JLabel gpaJLabel;
    private javax.swing.JTextField gpaJTxtField;
    private javax.swing.JLabel gradStatusJLabel;
    private javax.swing.JRadioButton graduatedRadioBtn;
    private javax.swing.JLabel headerJLabel;
    private javax.swing.JRadioButton inProgressRadioBtn;
    private javax.swing.JRadioButton interCitizenjRadioButton;
    private javax.swing.JCheckBox javaJCheckbox;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JTextField lastNameTxtField;
    private javax.swing.JRadioButton localCitizenjRadioButton;
    private javax.swing.JLabel madatoryJLabel;
    private javax.swing.JLabel majorJLabel;
    private javax.swing.JTextField majorJTextField;
    private javax.swing.JRadioButton maleRadioBtn;
    private javax.swing.JCheckBox mysqlJCheckbox;
    private javax.swing.JLabel objectiveJLabel;
    private javax.swing.JScrollPane objectiveJScrollPane;
    private javax.swing.JTextArea objectiveJtextArea;
    private javax.swing.JCheckBox oracleJCheckbox;
    private javax.swing.JLabel photoUploadJLabel;
    private javax.swing.JCheckBox pythonJCheckbox;
    private javax.swing.JLabel skillJLabel;
    private javax.swing.JLabel stateJLabel;
    private javax.swing.JTextField stateTxtField;
    private javax.swing.JLabel univJLabel;
    private javax.swing.JTextField univNameJTextField;
    private javax.swing.JLabel zipJLabel;
    private javax.swing.JTextField zipTxtField;
    // End of variables declaration//GEN-END:variables
}
