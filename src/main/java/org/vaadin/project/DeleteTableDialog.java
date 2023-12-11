package org.vaadin.project;


import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.theme.lumo.Lumo;

public class DeleteTableDialog {
    public void openDeleteTableDialog(int theme) {
        ConfirmDialog confirmDeleteDialog = new ConfirmDialog();
        confirmDeleteDialog.setHeader("Tabelle wirklich löschen?");
        confirmDeleteDialog.setConfirmButton("Ja", event -> confirmDeleteDialog.close());
        confirmDeleteDialog.setCancelButton("Nein", event -> confirmDeleteDialog.close());

        // Dark Mode
        if (theme == 1) {
            confirmDeleteDialog.getElement().getThemeList().add(Lumo.DARK);
        } else {
            confirmDeleteDialog.getElement().getThemeList().remove(Lumo.DARK);
        }

        confirmDeleteDialog.open();
    }
}
