package org.vaadin.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.Lumo;

public class ModifyGameDialog {
    public void openModifyGameDialog(int theme) {
        Dialog modifyGameDialog = new Dialog();
        modifyGameDialog.setWidth("55%");
        modifyGameDialog.setHeightFull();
        modifyGameDialog.setClassName("viewStyle");

        // Create Main View Layouts
        VerticalLayout viewLayout = new VerticalLayout();

        // Dark Mode
        if (theme == 1) {
            modifyGameDialog.getElement().getThemeList().add(Lumo.DARK);
        } else {
            modifyGameDialog.getElement().getThemeList().remove(Lumo.DARK);
        }

        // Header
        HorizontalLayout headerLayout = new HorizontalLayout();
        H1 header = new H1("Spiel bearbeiten");
        headerLayout.setPadding(true);
        headerLayout.setWidth("100%");
        headerLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        Div spacer = new Div();
        spacer.setWidth("100%");
        spacer.setHeight("20px");

        headerLayout.add(header);
        viewLayout.add(headerLayout, spacer);

        // Edit Game Form

        // Form Header
        HorizontalLayout formHeaderLayout = new HorizontalLayout();
        HorizontalLayout actionsLayout = new HorizontalLayout();

        H2 formHeader = new H2("Spiel");

        H3 actionsHeader1 = new H3("ändern");
        H3 actionsHeader2 = new H3("löschen");

        formHeaderLayout.setWidth("95%");
        formHeaderLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        actionsLayout.add(actionsHeader1, actionsHeader2);
        formHeaderLayout.add(formHeader, actionsLayout);
        viewLayout.add(formHeaderLayout);

        // Played Games Form
        HorizontalLayout playedGamesLayout = new HorizontalLayout();
        playedGamesLayout.setWidth("95%");

        HorizontalLayout playedGamesInputRow1 = new HorizontalLayout();
        playedGamesInputRow1.setWidth("100%");
        playedGamesInputRow1.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField team1 = new TextField();
        H3 symbol1 = new H3(":");
        TextField team2 = new TextField();
        H3 symbol2 = new H3("-");
        TextField goals1 = new TextField();
        H3 symbol3 = new H3(":");
        TextField goals2 = new TextField();

        team1.setWidth("15%");
        team2.setWidth("15%");
        goals1.setWidth("7%");
        goals2.setWidth("7%");

        team1.setValue("FC Basel");
        team2.setValue("FC Zürich");
        goals1.setValue("2");
        goals2.setValue("1");

        playedGamesInputRow1.add(team1, symbol1, team2, symbol2, goals1, symbol3, goals2);

        HorizontalLayout playedGamesCheckboxesRow1 = new HorizontalLayout();
        Checkbox modifyCheckboxRow1 = new Checkbox();
        Checkbox deleteCheckboxRow1 = new Checkbox();

        playedGamesCheckboxesRow1.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        playedGamesCheckboxesRow1.setWidth("20%");
        playedGamesCheckboxesRow1.add(modifyCheckboxRow1, deleteCheckboxRow1);
        playedGamesInputRow1.add(playedGamesCheckboxesRow1);

        playedGamesLayout.add(playedGamesInputRow1);
        viewLayout.add(playedGamesLayout);

        // Info
        HorizontalLayout infoLayout = new HorizontalLayout();
        Paragraph info = new Paragraph();
        info.setText("""
                *um zu bearbeiten Eintrag ändern und "ändern"\s
                anwählen und speichern. Danach wird der Eintrag\s
                geändert. Wenn "löschen" angewählt wird, wird das
                Spiel nach dem speichern gelöscht!""");

        infoLayout.add(info);
        viewLayout.add(infoLayout);

        // Buttons
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        Button cancelButton = new Button("Abbrechen");
        Button saveButton = new Button("Speichern");
        cancelButton.addClickListener(e -> modifyGameDialog.close());
        saveButton.addClickListener(e -> modifyGameDialog.close());

        cancelButton.addClassName("buttonStyle");
        saveButton.addClassName("buttonStyle");

        buttonsLayout.setWidth("100%");
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        buttonsLayout.add(cancelButton, saveButton);
        viewLayout.add(buttonsLayout);

        modifyGameDialog.add(viewLayout);
        modifyGameDialog.open();
    }
}
