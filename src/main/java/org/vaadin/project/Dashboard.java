package org.vaadin.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@PageTitle("Dashboard")
@Route
public class Dashboard extends VerticalLayout {

    public Dashboard() {
        // Create Main View Layouts
        VerticalLayout viewLayout = new VerticalLayout();
        viewLayout.setAlignItems(Alignment.CENTER);
        viewLayout.getElement().getThemeList().add(Lumo.DARK);
        viewLayout.setSizeFull();

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setAlignItems(Alignment.CENTER);
        mainLayout.setWidth("60%");
        viewLayout.add(mainLayout);

       // Header
        H1 header = new H1("Dashboard");
        mainLayout.add(header);

        // Create Top Buttons
        HorizontalLayout topButtonsLayout = new HorizontalLayout();
        Button addTeamButton = new Button("Mannschaft hinzufügen");
        Button deleteTable = new Button("Tabelle löschen");

        addTeamButton.addClickListener(e -> {
            AddTeamDialog addTeamDialog = new AddTeamDialog();
            Dialog dialog = addTeamDialog.openTeamDialog();
        });

        deleteTable.addClickListener(e -> {
            DeleteTableDialog deleteTableDialog = new DeleteTableDialog();
            Dialog dialog = deleteTableDialog.openDeleteTableDialog();
        });



        topButtonsLayout.setWidth("96%");
        topButtonsLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);

        topButtonsLayout.add(addTeamButton, deleteTable);
        mainLayout.add(topButtonsLayout);

        // Create Table
        VerticalLayout gridLayout = new VerticalLayout();

        H2 tableHeader = new H2("Tabelle");
        Grid<Team> table = new Grid<>();
        table.addColumn(Team::name).setHeader("Name");
        table.addColumn(Team::wins).setHeader("Siege");
        table.addColumn(Team::ties).setHeader("Unentschieden");
        table.addColumn(Team::losses).setHeader("Niederlagen");
        table.addColumn(Team::goals).setHeader("Goals");
        table.addColumn(Team::goalDifference).setHeader("Goal Differenz");
        table.addColumn(Team::points).setHeader("Punkte");

        table.setItems(
                new Team("Fc Basel", 10, 2, 3, 30, 20, 33),
                new Team("Fc Zürich", 9, 3, 3, 25, 15, 30),
                new Team("Fc Luzern", 8, 4, 3, 20, 10, 28),
                new Team("Fc Sion", 7, 5, 3, 15, 5, 26),
                new Team("Fc Thun", 6, 6, 3, 10, 0, 24),
                new Team("BSC Young Boys", 5, 7, 3, 5, -5, 22)
        );

        table.setHeight("300px");
        gridLayout.add(tableHeader, table);
        table.getStyle().set("border-radius", "10px");
        mainLayout.add(gridLayout);

        // Create Low Buttons
        HorizontalLayout lowButtonsLayout = new HorizontalLayout();
        Button addGameButton = new Button("Spiel hinzufügen");
        Button modifyGameButton = new Button("Spiel bearbeiten");

        lowButtonsLayout.setWidth("96%");
        lowButtonsLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);

        lowButtonsLayout.add(addGameButton, modifyGameButton);
        mainLayout.add(lowButtonsLayout);

        // Create game results & upcoming games
        HorizontalLayout gamesLayout = new HorizontalLayout();
        VerticalLayout gameResultsLayout = new VerticalLayout();
        VerticalLayout upcomingGamesLayout = new VerticalLayout();

        // Results
        H2 resultsHeader = new H2("Ergebnisse");
        Paragraph gameResult1 = new Paragraph("Fc Basel - Fc Zürich - 3:2");
        Paragraph gameResult2 = new Paragraph("Fc Luzern - Fc Sion - 1:3");
        Paragraph gameResult3 = new Paragraph("BSC Young Boys - Fc Thun - 1:1");
        gameResultsLayout.add(resultsHeader, gameResult1, gameResult2, gameResult3);

        // Upcoming Games
        H2 upcomingGamesHeader = new H2("Bevorstehende Spiele");
        Paragraph upcomingGame1 = new Paragraph("Fc Basel - Fc Sion");
        Paragraph upcomingGame2 = new Paragraph("Fc Luzern - Fc Thun");
        Paragraph upcomingGame3 = new Paragraph("BSC Young Boys - Fc Zürich");
        upcomingGamesLayout.add(upcomingGamesHeader, upcomingGame1, upcomingGame2, upcomingGame3);

        gamesLayout.setWidth("100%");
        gamesLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
        gamesLayout.add(gameResultsLayout, upcomingGamesLayout);

        mainLayout.add(gamesLayout);

        // Create News

        VerticalLayout newsLayout = new VerticalLayout();
        H2 newsHeader = new H2("News");
        Paragraph news1 = new Paragraph("Fc Basel: Valentin Stocker trifft 3 mal gegen Zürich und bringt den Hattrick nach Hause!");
        Paragraph news2 = new Paragraph("Fc Zürich: Zürich schiesst 2 Tore gegen Basel und verliert knapp mit 2:3!");


        newsLayout.add(newsHeader, news1, news2);

        mainLayout.add(newsLayout);
        // Add to View
        add(viewLayout);
    }

    public static record Team(
            String name,
            int wins,
            int ties,
            int losses,
            int goals,
            int goalDifference,
            int points
    ) {
    }
}
