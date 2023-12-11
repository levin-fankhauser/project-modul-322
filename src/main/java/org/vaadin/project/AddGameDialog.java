package org.vaadin.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.Lumo;

public class AddGameDialog {
    public void openGameDialog(int theme) {
        Dialog addGameDialog = new Dialog();
        addGameDialog.setWidth("50%");
        addGameDialog.setHeightFull();
        addGameDialog.setClassName("viewStyle");

        // Create Main View Layouts
        VerticalLayout viewLayout = new VerticalLayout();

        // Dark Mode
        if (theme == 1) {
            addGameDialog.getElement().getThemeList().add(Lumo.DARK);
        } else {
            addGameDialog.getElement().getThemeList().remove(Lumo.DARK);
        }

        // Header
        HorizontalLayout headerLayout = new HorizontalLayout();
        H1 header = new H1("Spiel hinzufügen");
        headerLayout.setPadding(true);
        headerLayout.setWidth("100%");
        headerLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        Div spacer = new Div();
        spacer.setWidth("100%");
        spacer.setHeight("20px");

        headerLayout.add(header);
        viewLayout.add(headerLayout, spacer);

        // Passed Game Form
        H2 passedGameHeader = new H2("Vergangenes Spiel hinzufügen:");

        HorizontalLayout passedGameLabelLayout = new HorizontalLayout();
        passedGameLabelLayout.setWidth("95%");
        passedGameLabelLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        H3 passedGameLabelTeam1 = new H3("Mannschaft 1");
        H3 passedGameLabelTeam2 = new H3("Mannschaft 2");
        H3 passedGameLabelGoals1 = new H3("Tore 1");
        H3 passedGameLabelGoals2 = new H3("Tore 2");
        passedGameLabelLayout.add(passedGameLabelTeam1, passedGameLabelTeam2, passedGameLabelGoals1, passedGameLabelGoals2);

        HorizontalLayout passedGameInputLayout = new HorizontalLayout();
        passedGameInputLayout.setWidth("95%");
        passedGameInputLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField passedGameTextFieldTeam1 = new TextField();
        TextField passedGameTextFieldTeam2 = new TextField();
        TextField passedGameTextFieldGoals1 = new TextField();
        TextField passedGameTextFieldGoals2 = new TextField();

        passedGameTextFieldTeam1.setPlaceholder("z.B. FC Basel");
        passedGameTextFieldTeam2.setPlaceholder("z.B. FC Zürich");
        passedGameTextFieldGoals1.setPlaceholder("z.B. 2");
        passedGameTextFieldGoals2.setPlaceholder("z.B. 1");

        passedGameTextFieldTeam1.setWidth("30%");
        passedGameTextFieldTeam2.setWidth("30%");
        passedGameTextFieldGoals1.setWidth("20%");
        passedGameTextFieldGoals2.setWidth("20%");

        VerticalLayout newPassedGameInputLayout = new VerticalLayout();
        newPassedGameInputLayout.setPadding(false);

        Button newPassedGameInputButton = new Button(new Icon("vaadin", "plus"));
        newPassedGameInputButton.addClickListener(e -> newPassedGameInputLayout.add(newPassedGameInputLayout()));

        passedGameInputLayout.add(passedGameTextFieldTeam1, passedGameTextFieldTeam2, passedGameTextFieldGoals1, passedGameTextFieldGoals2);

        viewLayout.add(passedGameHeader, passedGameLabelLayout, passedGameInputLayout, newPassedGameInputLayout, newPassedGameInputButton);

        // Upcoming Game Form
        Div spacer2 = new Div();
        spacer2.setWidth("100%");
        spacer2.setHeight("10px");

        H2 upcomingGameHeader = new H2("Bevorstehendes Spiel hinzufügen:");

        HorizontalLayout upcomingGameLabelLayout = new HorizontalLayout();
        upcomingGameLabelLayout.setWidth("95%");
        upcomingGameLabelLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        H3 upcomingGameLabelTeam1 = new H3("Mannschaft 1");
        H3 upcomingGameLabelSymbol = new H3(":");
        H3 upcomingGameLabelTeam2 = new H3("Mannschaft 2");

        upcomingGameLabelLayout.add(upcomingGameLabelTeam1, upcomingGameLabelSymbol, upcomingGameLabelTeam2);

        HorizontalLayout upcomingGameInputLayout = new HorizontalLayout();
        upcomingGameInputLayout.setWidth("95%");
        upcomingGameInputLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField upcomingGameTextFieldTeam1 = new TextField();
        TextField upcomingGameTextFieldTeam2 = new TextField();

        upcomingGameTextFieldTeam1.setPlaceholder("z.B. FC Basel");
        upcomingGameTextFieldTeam2.setPlaceholder("z.B. FC Zürich");

        upcomingGameTextFieldTeam1.setWidth("50%");
        upcomingGameTextFieldTeam2.setWidth("50%");

        VerticalLayout newUpcomingGameInputLayout = new VerticalLayout();
        newUpcomingGameInputLayout.setPadding(false);

        Button newUpcomingGameInputButton = new Button(new Icon("vaadin", "plus"));
        newUpcomingGameInputButton.addClickListener(e -> newUpcomingGameInputLayout.add(newUpcomingGameInputLayout()));

        upcomingGameInputLayout.add(upcomingGameTextFieldTeam1, upcomingGameTextFieldTeam2);

        viewLayout.add(spacer2, upcomingGameHeader, upcomingGameLabelLayout, upcomingGameInputLayout, newUpcomingGameInputLayout, newUpcomingGameInputButton);


        // Buttons
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        Button cancelButton = new Button("Abbrechen");
        Button saveButton = new Button("Speichern");
        cancelButton.addClickListener(e -> addGameDialog.close());
        saveButton.addClickListener(e -> addGameDialog.close());

        buttonsLayout.setWidth("100%");
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        buttonsLayout.add(cancelButton, saveButton);
        viewLayout.add(buttonsLayout);

        // Add Layouts to View and open
        addGameDialog.add(viewLayout);
        addGameDialog.open();
    }

    private HorizontalLayout newUpcomingGameInputLayout() {
        HorizontalLayout newUpcomingGameInputLayout = new HorizontalLayout();
        newUpcomingGameInputLayout.setWidth("95%");
        newUpcomingGameInputLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField newUpcomingGameTextFieldTeam1 = new TextField();
        TextField newUpcomingGameTextFieldTeam2 = new TextField();

        newUpcomingGameTextFieldTeam1.setPlaceholder("z.B. FC Basel");
        newUpcomingGameTextFieldTeam2.setPlaceholder("z.B. FC Zürich");

        newUpcomingGameTextFieldTeam1.setWidth("50%");
        newUpcomingGameTextFieldTeam2.setWidth("50%");

        newUpcomingGameInputLayout.add(newUpcomingGameTextFieldTeam1, newUpcomingGameTextFieldTeam2);
        return newUpcomingGameInputLayout;
    }

    public HorizontalLayout newPassedGameInputLayout() {
        HorizontalLayout newPassedGameInputLayout = new HorizontalLayout();
        newPassedGameInputLayout.setWidth("95%");
        newPassedGameInputLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        TextField newPassedGameTextFieldTeam1 = new TextField();
        TextField newPassedGameTextFieldTeam2 = new TextField();
        TextField newPassedGameTextFieldGoals1 = new TextField();
        TextField newPassedGameTextFieldGoals2 = new TextField();

        newPassedGameTextFieldTeam1.setPlaceholder("z.B. FC Basel");
        newPassedGameTextFieldTeam2.setPlaceholder("z.B. FC Zürich");
        newPassedGameTextFieldGoals1.setPlaceholder("z.B. 2");
        newPassedGameTextFieldGoals2.setPlaceholder("z.B. 1");

        newPassedGameTextFieldTeam1.setWidth("30%");
        newPassedGameTextFieldTeam2.setWidth("30%");
        newPassedGameTextFieldGoals1.setWidth("20%");
        newPassedGameTextFieldGoals2.setWidth("20%");

        newPassedGameInputLayout.add(newPassedGameTextFieldTeam1, newPassedGameTextFieldTeam2, newPassedGameTextFieldGoals1, newPassedGameTextFieldGoals2);
        return newPassedGameInputLayout;
    }
}
