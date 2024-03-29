package org.vaadin.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.theme.lumo.Lumo;

public class AddTeamDialog extends VerticalLayout {
    public void openTeamDialog(int theme) {
        Dialog addTeamDialog = new Dialog();
        addTeamDialog.setWidth("50%");
        //addTeamDialog.setHeightFull();
        addTeamDialog.setClassName("viewStyle");

        // Create Main View Layouts
        VerticalLayout viewLayout = new VerticalLayout();
        viewLayout.setAlignItems(Alignment.CENTER);

        // Dark Mode
        if (theme == 1) {
            addTeamDialog.getElement().getThemeList().add(Lumo.DARK);
        } else {
            addTeamDialog.getElement().getThemeList().remove(Lumo.DARK);
        }

        // Header
        HorizontalLayout headerLayout = new HorizontalLayout();
        H1 header = new H1("Mannschaft hinzufügen");
        headerLayout.setPadding(true);

        headerLayout.add(header);
        viewLayout.add(headerLayout);

        // Form
        HorizontalLayout firstLine = new HorizontalLayout();
        firstLine.setWidth("95%");
        firstLine.setJustifyContentMode(JustifyContentMode.BETWEEN);

        Upload upload = new Upload();
        Button uploadButton = new Button("Bild hochladen");
        uploadButton.addClassName("buttonStyle");

        upload.setUploadButton(uploadButton);

        TextArea news = new TextArea();
        news.setLabel("News");
        news.setPlaceholder("z.B. Der Fc Basel hat...");
        news.setWidth("100%");
        news.setRequired(true);

        firstLine.add(upload, news);
        viewLayout.add(firstLine);

        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setWidth("100%");
        formLayout.setAlignItems(Alignment.CENTER);


        TextField teamName = new TextField();
        teamName.setLabel("Mannschaftsname");
        teamName.setPlaceholder("z.B. FC Basel");
        teamName.setRequired(true);
        teamName.setWidth("100%");

        NumberField wins = new NumberField();
        wins.setLabel("Anz. Siege");
        wins.setPlaceholder("z.B. 10");
        wins.setRequired(true);
        wins.setWidth("100%");

        NumberField draws = new NumberField();
        draws.setLabel("Anz. Unentschieden");
        draws.setPlaceholder("z.B. 2");
        draws.setRequired(true);
        draws.setWidth("100%");

        NumberField losses = new NumberField();
        losses.setLabel("Anz. Niederlagen");
        losses.setPlaceholder("z.B. 3");
        losses.setRequired(true);
        losses.setWidth("100%");

        NumberField scoredGoals = new NumberField();
        scoredGoals.setLabel("Anz. geschossene Tore");
        scoredGoals.setPlaceholder("z.B. 30");
        scoredGoals.setRequired(true);
        scoredGoals.setWidth("100%");

        NumberField receivedGoals = new NumberField();
        receivedGoals.setLabel("Anz. kassierte Tore");
        receivedGoals.setPlaceholder("z.B. 20");
        receivedGoals.setRequired(true);
        receivedGoals.setWidth("100%");

        formLayout.add(teamName, wins, draws, losses, scoredGoals, receivedGoals);
        viewLayout.add(formLayout);

        // Buttons
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        Button cancelButton = new Button("Abbrechen");
        Button saveButton = new Button("Speichern");
        cancelButton.addClickListener(e -> addTeamDialog.close());
        saveButton.addClickListener(e -> addTeamDialog.close());

        cancelButton.addClassName("buttonStyle");
        saveButton.addClassName("buttonStyle");

        buttonsLayout.setWidth("95%");
        buttonsLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);

        buttonsLayout.add(cancelButton, saveButton);
        viewLayout.add(buttonsLayout);

        // Add Layouts to View and open
        addTeamDialog.add(viewLayout);

        addTeamDialog.open();
    }

}
