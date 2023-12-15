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
        // Row1
        HorizontalLayout playedGamesLayoutRow1 = new HorizontalLayout();
        playedGamesLayoutRow1.setWidth("95%");

        HorizontalLayout playedGamesInputRow1 = new HorizontalLayout();
        playedGamesInputRow1.setWidth("100%");
        playedGamesInputRow1.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField team1Row1 = new TextField();
        H3 symbol1Row1 = new H3(":");
        TextField team2Row1 = new TextField();
        H3 symbol2Row1 = new H3("-");
        TextField goals1Row1 = new TextField();
        H3 symbol3Row1 = new H3(":");
        TextField goals2Row1 = new TextField();

        team1Row1.setWidth("15%");
        team2Row1.setWidth("15%");
        goals1Row1.setWidth("7%");
        goals2Row1.setWidth("7%");

        team1Row1.setValue("FC Basel");
        team2Row1.setValue("FC Zürich");
        goals1Row1.setValue("3");
        goals2Row1.setValue("2");

        playedGamesInputRow1.add(team1Row1, symbol1Row1, team2Row1, symbol2Row1, goals1Row1, symbol3Row1, goals2Row1);

        HorizontalLayout playedGamesCheckboxesRow1 = new HorizontalLayout();
        Checkbox modifyCheckboxRow1 = new Checkbox();
        Checkbox deleteCheckboxRow1 = new Checkbox();

        playedGamesCheckboxesRow1.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        playedGamesCheckboxesRow1.setWidth("20%");
        playedGamesCheckboxesRow1.add(modifyCheckboxRow1, deleteCheckboxRow1);
        playedGamesInputRow1.add(playedGamesCheckboxesRow1);

        playedGamesLayoutRow1.add(playedGamesInputRow1);

        // Row2
        HorizontalLayout playedGamesLayoutRow2 = new HorizontalLayout();
        playedGamesLayoutRow2.setWidth("95%");
        HorizontalLayout playedGamesInputRow2 = new HorizontalLayout();
        playedGamesInputRow2.setWidth("100%");
        playedGamesInputRow2.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField team1Row2 = new TextField();
        H3 symbol1Row2 = new H3(":");
        TextField team2Row2 = new TextField();
        H3 symbol2Row2 = new H3("-");
        TextField goals1Row2 = new TextField();
        H3 symbol3Row2 = new H3(":");
        TextField goals2Row2 = new TextField();

        team1Row2.setWidth("15%");
        team2Row2.setWidth("15%");
        goals1Row2.setWidth("7%");
        goals2Row2.setWidth("7%");
        team1Row2.setValue("Fc Luzern");
        team2Row2.setValue("Fc Sion");
        goals1Row2.setValue("1");
        goals2Row2.setValue("3");

        playedGamesInputRow2.add(team1Row2, symbol1Row2, team2Row2, symbol2Row2, goals1Row2, symbol3Row2, goals2Row2);

        HorizontalLayout playedGamesCheckboxesRow2 = new HorizontalLayout();
        Checkbox modifyCheckboxRow2 = new Checkbox();
        Checkbox deleteCheckboxRow2 = new Checkbox();

        playedGamesCheckboxesRow2.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        playedGamesCheckboxesRow2.setWidth("20%");
        playedGamesCheckboxesRow2.add(modifyCheckboxRow2, deleteCheckboxRow2);
        playedGamesInputRow2.add(playedGamesCheckboxesRow2);

        playedGamesLayoutRow2.add(playedGamesInputRow2);

        // Row3
        HorizontalLayout playedGamesLayoutRow3 = new HorizontalLayout();
        playedGamesLayoutRow3.setWidth("95%");
        HorizontalLayout playedGamesInputRow3 = new HorizontalLayout();
        playedGamesInputRow3.setWidth("100%");
        playedGamesInputRow3.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField team1Row3 = new TextField();
        H3 symbol1Row3 = new H3(":");
        TextField team2Row3 = new TextField();
        H3 symbol2Row3 = new H3("-");
        TextField goals1Row3 = new TextField();
        H3 symbol3Row3 = new H3(":");
        TextField goals2Row3 = new TextField();

        team1Row3.setWidth("15%");
        team2Row3.setWidth("15%");
        goals1Row3.setWidth("7%");
        goals2Row3.setWidth("7%");
        team1Row3.setValue("BSC Young Boys");
        team2Row3.setValue("FC Thun");
        goals1Row3.setValue("1");
        goals2Row3.setValue("1");

        playedGamesInputRow3.add(team1Row3, symbol1Row3, team2Row3, symbol2Row3, goals1Row3, symbol3Row3, goals2Row3);

        HorizontalLayout playedGamesCheckboxesRow3 = new HorizontalLayout();
        Checkbox modifyCheckboxRow3 = new Checkbox();
        Checkbox deleteCheckboxRow3 = new Checkbox();
        
        playedGamesCheckboxesRow3.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        playedGamesCheckboxesRow3.setWidth("20%");
        playedGamesCheckboxesRow3.add(modifyCheckboxRow3, deleteCheckboxRow3);
        playedGamesInputRow3.add(playedGamesCheckboxesRow3);

        playedGamesLayoutRow3.add(playedGamesInputRow3);

        Div spacer2 = new Div();
        spacer2.setWidth("100%");
        spacer2.setHeight("20px");

        viewLayout.add(playedGamesLayoutRow1, playedGamesLayoutRow2, playedGamesLayoutRow3, spacer2);

        // Upcoming Games Form
        // Row1
        HorizontalLayout upcomingGamesLayoutRow1 = new HorizontalLayout();
        upcomingGamesLayoutRow1.setWidth("95%");
        HorizontalLayout upcomingGamesInputRow1 = new HorizontalLayout();
        upcomingGamesInputRow1.setWidth("100%");
        upcomingGamesInputRow1.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField team1Row1Upcoming = new TextField();
        H3 symbol1Row1Upcoming = new H3(":");
        TextField team2Row1Upcoming = new TextField();
        H3 symbol2Row1Upcoming = new H3("-");
        TextField goals1Row1Upcoming = new TextField();
        H3 symbol3Row1Upcoming = new H3(":");
        TextField goals2Row1Upcoming = new TextField();

        team1Row1Upcoming.setWidth("15%");
        team2Row1Upcoming.setWidth("15%");
        goals1Row1Upcoming.setWidth("7%");
        goals2Row1Upcoming.setWidth("7%");
        team1Row1Upcoming.setValue("FC Basel");
        team2Row1Upcoming.setValue("FC Sion");

        upcomingGamesInputRow1.add(team1Row1Upcoming, symbol1Row1Upcoming, team2Row1Upcoming, symbol2Row1Upcoming, goals1Row1Upcoming, symbol3Row1Upcoming, goals2Row1Upcoming);

        HorizontalLayout upcomingGamesCheckboxesRow1 = new HorizontalLayout();
        Checkbox modifyCheckboxRow1Upcoming = new Checkbox();
        Checkbox deleteCheckboxRow1Upcoming = new Checkbox();

        upcomingGamesCheckboxesRow1.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        upcomingGamesCheckboxesRow1.setWidth("20%");
        upcomingGamesCheckboxesRow1.add(modifyCheckboxRow1Upcoming, deleteCheckboxRow1Upcoming);
        upcomingGamesInputRow1.add(upcomingGamesCheckboxesRow1);
        
        upcomingGamesLayoutRow1.add(upcomingGamesInputRow1);

        // Row2
        HorizontalLayout upcomingGamesLayoutRow2 = new HorizontalLayout();
        upcomingGamesLayoutRow2.setWidth("95%");
        HorizontalLayout upcomingGamesInputRow2 = new HorizontalLayout();
        upcomingGamesInputRow2.setWidth("100%");
        upcomingGamesInputRow2.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField team1Row2Upcoming = new TextField();
        H3 symbol1Row2Upcoming = new H3(":");
        TextField team2Row2Upcoming = new TextField();
        H3 symbol2Row2Upcoming = new H3("-");
        TextField goals1Row2Upcoming = new TextField();
        H3 symbol3Row2Upcoming = new H3(":");
        TextField goals2Row2Upcoming = new TextField();

        team1Row2Upcoming.setWidth("15%");
        team2Row2Upcoming.setWidth("15%");
        goals1Row2Upcoming.setWidth("7%");
        goals2Row2Upcoming.setWidth("7%");
        team1Row2Upcoming.setValue("Fc Luzern");
        team2Row2Upcoming.setValue("Fc Thun");

        upcomingGamesInputRow2.add(team1Row2Upcoming, symbol1Row2Upcoming, team2Row2Upcoming, symbol2Row2Upcoming, goals1Row2Upcoming, symbol3Row2Upcoming, goals2Row2Upcoming);

        HorizontalLayout upcomingGamesCheckboxesRow2 = new HorizontalLayout();
        Checkbox modifyCheckboxRow2Upcoming = new Checkbox();
        Checkbox deleteCheckboxRow2Upcoming = new Checkbox();
        
        upcomingGamesCheckboxesRow2.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        upcomingGamesCheckboxesRow2.setWidth("20%");
        upcomingGamesCheckboxesRow2.add(modifyCheckboxRow2Upcoming, deleteCheckboxRow2Upcoming);
        upcomingGamesInputRow2.add(upcomingGamesCheckboxesRow2);

        upcomingGamesLayoutRow2.add(upcomingGamesInputRow2);

        // Row3
        HorizontalLayout upcomingGamesLayoutRow3 = new HorizontalLayout();
        upcomingGamesLayoutRow3.setWidth("95%");
        HorizontalLayout upcomingGamesInputRow3 = new HorizontalLayout();
        upcomingGamesInputRow3.setWidth("100%");
        upcomingGamesInputRow3.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField team1Row3Upcoming = new TextField();
        H3 symbol1Row3Upcoming = new H3(":");
        TextField team2Row3Upcoming = new TextField();
        H3 symbol2Row3Upcoming = new H3("-");
        TextField goals1Row3Upcoming = new TextField();
        H3 symbol3Row3Upcoming = new H3(":");
        TextField goals2Row3Upcoming = new TextField();

        team1Row3Upcoming.setWidth("15%");
        team2Row3Upcoming.setWidth("15%");
        goals1Row3Upcoming.setWidth("7%");
        goals2Row3Upcoming.setWidth("7%");
        team1Row3Upcoming.setValue("BSC Young Boys");
        team2Row3Upcoming.setValue("Fc Zürich");

        upcomingGamesInputRow3.add(team1Row3Upcoming, symbol1Row3Upcoming, team2Row3Upcoming, symbol2Row3Upcoming, goals1Row3Upcoming, symbol3Row3Upcoming, goals2Row3Upcoming);

        HorizontalLayout upcomingGamesCheckboxesRow3 = new HorizontalLayout();
        Checkbox modifyCheckboxRow3Upcoming = new Checkbox();
        Checkbox deleteCheckboxRow3Upcoming = new Checkbox();

        upcomingGamesCheckboxesRow3.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        upcomingGamesCheckboxesRow3.setWidth("20%");
        upcomingGamesCheckboxesRow3.add(modifyCheckboxRow3Upcoming, deleteCheckboxRow3Upcoming);
        upcomingGamesInputRow3.add(upcomingGamesCheckboxesRow3);

        upcomingGamesLayoutRow3.add(upcomingGamesInputRow3);

        viewLayout.add(upcomingGamesLayoutRow1, upcomingGamesLayoutRow2, upcomingGamesLayoutRow3);

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
