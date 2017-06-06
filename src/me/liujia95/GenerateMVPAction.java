package me.liujia95;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class GenerateMVPAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        VirtualFile selectedFile = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());

//        VirtualFile drawableFolder = selectedFile.getParent().findChild(Constants.EXPORT_FOLDER);
//        if(drawableFolder==null || !drawableFolder.exists()){
//            try {
//                drawableFolder = selectedFile.getParent().createChildDirectory(null, Constants.EXPORT_FOLDER);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }
        GenerateCodeDialog dialog = new GenerateCodeDialog(selectedFile.getPath());
        dialog.setSize(800, 720);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void showInfoDialog(String text, AnActionEvent e) {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(DataKeys.PROJECT.getData(e.getDataContext()));

        if (statusBar != null) {
            JBPopupFactory.getInstance()
                    .createHtmlTextBalloonBuilder(text, MessageType.INFO, null)
                    .setFadeoutTime(10000)
                    .createBalloon()
                    .show(RelativePoint.getCenterOf(statusBar.getComponent()),
                            Balloon.Position.atRight);
        }
    }
}
