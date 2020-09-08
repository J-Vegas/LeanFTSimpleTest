package com.company;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import unittesting.UnitTestClassBase;

import java.io.IOException;

import static com.company.Steps.*;

public class LeanFtTest extends UnitTestClassBase {

    @BeforeClass
    public void beforeClass() throws Exception {
        runApp();
        accept();
    }

    @AfterClass
    public void afterClass() throws Exception {
        closeApp();
    }

    @Test
    public void test() throws GeneralLeanFtException, IOException, InterruptedException {
        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("АСУ ЕИРЦ: ЦАО-Т (Тест ЭМ) Веблоджик").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Подключение к АСУ ЕИРЦ").build()).describe(Editor.class, new EditorDescription.Builder()
                .attachedText("Пароль").build()).setText("Anna12");

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("АСУ ЕИРЦ: ЦАО-Т (Тест ЭМ) Веблоджик").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Подключение к АСУ ЕИРЦ").build()).describe(Button.class, new ButtonDescription.Builder()
                .label("Подключиться").build()).click();

//        Desktop.describe(Window.class, new WindowDescription.Builder()
//                .title("АСУ ЕИРЦ: ЦАО-Т (Тест ЭМ) Веблоджик (Основной сервер)").build()).describe(Button.class, new ButtonDescription.Builder()
//                .label("passports").build()).exists();

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("АСУ ЕИРЦ: ЦАО-Т (Тест ЭМ) Веблоджик (Основной сервер)").build()).describe(Menu.class, new MenuDescription.Builder()
                .label("Модули").build()).selectSubMenu("Физические лица");

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(List.class, new ListDescription.Builder()
                .attachedText("Улица").build()).select("Арбат ул.");

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(List.class, new ListDescription.Builder()
                .attachedText("Дом").build()).select("19");

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(List.class, new ListDescription.Builder()
                .attachedText("Квартира").build()).select("10");

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Button.class, new ButtonDescription.Builder()
                .label("Картотека").build()).click();

        if (Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .nativeClass("javax.swing.JViewport").index(0).build()).isVisible()) {
            Thread.sleep(5000);
        }

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Table.class, new TableDescription()).isFocused();

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Table.class, new TableDescription()).selectRows(1);

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Button.class, new ButtonDescription.Builder()
                .label("Корректировать").build()).click();

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Карточка регистрации").build()).exists();

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Карточка регистрации").build()).describe(Editor.class, new EditorDescription.Builder()
                .attachedText("Область (край, республика)").nativeClass("javax.swing.JTextField").index(0).build()).setText("АЛТАЙ");

        Thread.sleep(1000);

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Карточка регистрации").build()).describe(Editor.class, new EditorDescription.Builder()
                .attachedText("Район").nativeClass("javax.swing.JTextField").index(0).build()).setText("ЛЕНИНСКИЙ");

        Thread.sleep(1000);

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Карточка регистрации").build()).describe(Editor.class, new EditorDescription.Builder()
                .attachedText("Село, деревня").nativeClass("javax.swing.JTextField").index(0).build()).setText("ВЕСЕЛОЕ");

        Thread.sleep(1000);

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Карточка регистрации").build()).describe(Editor.class, new EditorDescription.Builder()
                .attachedText("Прочее").nativeClass("javax.swing.JTextField").index(0).build()).setText("ТЕБЕ ЭТО СНИТСЯ!");

        Thread.sleep(3000);

        Desktop.describe(Window.class, new WindowDescription.Builder()
                .title("Физические лица").build()).describe(Dialog.class, new DialogDescription.Builder()
                .title("Карточка регистрации").build()).describe(Button.class, new ButtonDescription.Builder()
                .label("Выход").build()).click();
    }
}