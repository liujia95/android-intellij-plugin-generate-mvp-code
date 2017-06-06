package me.liujia95;

import org.apache.http.util.TextUtils;

import javax.swing.*;
import java.awt.event.*;

public class GenerateCodeDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextPane editTP;
    private JCheckBox cbFragment;
    private JCheckBox cbPresenter;
    private JCheckBox cbContract;
    private JCheckBox cbModel;
    private JCheckBox cbApi;
    private JTextField tfKwClassName;
    private JTextField tfLayoutName;
    //    private JButton formatBtn;

    public GenerateCodeDialog(){}

    public GenerateCodeDialog(String path) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setAlwaysOnTop(true);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(path);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        initListener();
    }

    private void initListener() {
//        formatBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String json = editTP.getText();
//                json = json.trim();
//                try{
//                    if (json.startsWith("{")) {
//                        JSONObject jsonObject = new JSONObject(json);
//                        String formatJson = jsonObject.toString(4);
//                        editTP.setText(formatJson);
//                    } else if (json.startsWith("[")) {
//                        JSONArray jsonArray = new JSONArray(json);
//                        String formatJson = jsonArray.toString(4);
//                        editTP.setText(formatJson);
//                    }
//                }catch (JSONException ex){
//
//                }
//            }
//        });
    }

    private void onOK(String path) {
        // add your code here
        String json = editTP.getText();
        OptionsBean options = new OptionsBean();
        options.hasContract = cbContract.isSelected();
        options.hasFragment = cbFragment.isSelected();
        options.hasModel = cbModel.isSelected();
        options.hasPresenter = cbPresenter.isSelected();
        options.hasApi = cbApi.isSelected();
        options.kwClassName = tfKwClassName.getText();
        if(TextUtils.isEmpty(options.kwClassName)){
            return;
        }
        options.layoutName = tfLayoutName.getText();
        if(options.hasFragment && TextUtils.isEmpty(options.kwClassName)){
            return;
        }
        GenerateMvpCode.execute(json,path,options);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        GenerateCodeDialog dialog = new GenerateCodeDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
