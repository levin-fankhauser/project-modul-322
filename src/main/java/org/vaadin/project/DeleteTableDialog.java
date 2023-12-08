package org.vaadin.project;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class DeleteTableDialog {
    public Dialog openDeleteTableDialog() {
        Dialog deleteTableDialog = new Dialog();

        // Create Components
        H2 header = new H2("Tabelle löschen?");
        header.getStyle().set("padding-bottom", "20px");


        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button cancelButton = new Button("Nein");
        cancelButton.getStyle().set("background", "#0FFF50");
        cancelButton.getStyle().set("color", "black");

        Button deleteButton = new Button("Ja");
        deleteButton.getStyle().set("background", "red");
        deleteButton.getStyle().set("color", "black");


        cancelButton.addClickListener(e -> {
            deleteTableDialog.close();
        });
        deleteButton.addClickListener(e -> {
            deleteTableDialog.close();
        });

        buttonLayout.setWidth("100%");
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        buttonLayout.add(cancelButton, deleteButton);

        deleteTableDialog.add(header, buttonLayout);
        deleteTableDialog.open();
        return deleteTableDialog;
    }
}
