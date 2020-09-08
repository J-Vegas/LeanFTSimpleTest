package com.company;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.*;

import java.io.IOException;

public class Steps {

    static void runApp() {
        final String dir = "D:\\cbs-client-cao-test-em-wls.jnlp";
        try {
            Runtime.getRuntime()
                    .exec("javaws " + dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void accept() {
        try {
            Desktop.describe(Dialog.class, new DialogDescription.Builder()
                    .title("Security Warning").build()).describe(CheckBox.class, new CheckBoxDescription.Builder()
                    .attachedText("I accept the risk and want to run this application.").build()).exists(100);
            Desktop.describe(Dialog.class, new DialogDescription.Builder()
                    .title("Security Warning").build()).describe(CheckBox.class, new CheckBoxDescription.Builder()
                    .attachedText("I accept the risk and want to run this application.").build()).click();
            Desktop.describe(Dialog.class, new DialogDescription.Builder()
                    .title("Security Warning").build()).describe(Button.class, new ButtonDescription.Builder()
                    .label("Run").build()).click();
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
    }

    static void closeApp() {
        try {
            Desktop.describe(Window.class, new WindowDescription.Builder()
                    .title("АСУ ЕИРЦ: ЦАО-Т (Тест ЭМ) Веблоджик (Основной сервер)").build()).describe(Menu.class, new MenuDescription.Builder()
                    .label("Приложение").build()).selectSubMenu("Выйти");

            Desktop.describe(Window.class, new WindowDescription.Builder()
                    .title("АСУ ЕИРЦ: ЦАО-Т (Тест ЭМ) Веблоджик (Основной сервер)").build()).describe(Dialog.class, new DialogDescription.Builder()
                    .title("Подтверждение отключения").build()).describe(Button.class, new ButtonDescription.Builder()
                    .label("Да").build()).click();
        } catch (GeneralLeanFtException e) {
            e.printStackTrace();
        }
    }

}
