package org.vaadin.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@PageTitle("Dashboard")
@Route("")
public class Dashboard extends VerticalLayout {

    public Dashboard() {
        // Create Main View Layouts
        VerticalLayout viewLayout = new VerticalLayout();
        viewLayout.setAlignItems(Alignment.CENTER);
        //this.getElement().getThemeList().add(Lumo.DARK);
        viewLayout.setSizeFull();
        this.setClassName("viewStyle");

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setAlignItems(Alignment.CENTER);
        mainLayout.setWidth("60%");
        viewLayout.add(mainLayout);

        // Dark Mode Button with logic
        Button themeButton = new Button(new Icon("vaadin", "moon-o"));
        themeButton.addClassName("buttonStyle");
        themeButton.addClickListener(e -> {
            if (getTheme() == 1) {
                this.getElement().getThemeList().remove(Lumo.DARK);
                themeButton.setIcon(new Icon("vaadin", "moon-o"));
            } else {
                this.getElement().getThemeList().add(Lumo.DARK);
                themeButton.setIcon(new Icon("vaadin", "moon"));
            }
        });

        // Header
        H1 header = new H1("Dashboard");
        header.getStyle().set("margin-bottom", "30px");
        header.getStyle().set("font-size", "50px");
        mainLayout.add(header);

        // Create Top Buttons
        HorizontalLayout topButtonsLayout = new HorizontalLayout();
        Button addTeamButton = new Button("Mannschaft hinzufügen");
        Button deleteTable = new Button("Tabelle löschen");

        addTeamButton.addClassName("buttonStyle");
        deleteTable.addClassName("buttonStyle");

        addTeamButton.addClickListener(e -> {
            AddTeamDialog addTeamDialog = new AddTeamDialog();
            int theme = getTheme();
            addTeamDialog.openTeamDialog(theme);
        });

        deleteTable.addClickListener(e -> {
            DeleteTableDialog deleteTableDialog = new DeleteTableDialog();
            int theme = getTheme();
            deleteTableDialog.openDeleteTableDialog(theme);
        });


        topButtonsLayout.setWidth("100%");
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
        table.addClassName("tableStyle");
        gridLayout.getStyle().set("margin", "30px 0");
        gridLayout.setPadding(false);
        gridLayout.add(tableHeader, table);
        mainLayout.add(gridLayout);

        // Create Low Buttons
        HorizontalLayout lowButtonsLayout = new HorizontalLayout();
        Button addGameButton = new Button("Spiel hinzufügen");
        Button modifyGameButton = new Button("Spiel bearbeiten");

        addGameButton.addClassName("buttonStyle");
        modifyGameButton.addClassName("buttonStyle");

        addGameButton.addClickListener(e -> {
            AddGameDialog addGameDialog = new AddGameDialog();
            int theme = getTheme();
            addGameDialog.openAddGameDialog(theme);
        });

        modifyGameButton.addClickListener(e -> {
            ModifyGameDialog modifyGameDialog = new ModifyGameDialog();
            int theme = getTheme();
            modifyGameDialog.openModifyGameDialog(theme);
        });

        lowButtonsLayout.setWidth("100%");
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
        gameResultsLayout.addClassName("gameLayout");
        gameResultsLayout.add(resultsHeader, gameResult1, gameResult2, gameResult3);

        // Upcoming Games
        H2 upcomingGamesHeader = new H2("Bevorstehende Spiele");
        Paragraph upcomingGame1 = new Paragraph("Fc Basel - Fc Sion");
        Paragraph upcomingGame2 = new Paragraph("Fc Luzern - Fc Thun");
        Paragraph upcomingGame3 = new Paragraph("BSC Young Boys - Fc Zürich");
        upcomingGamesLayout.addClassName("gameLayout");
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
        newsLayout.addClassName("gameLayout");

        newsLayout.add(newsHeader, news1, news2);

        mainLayout.add(newsLayout);
        // Add to View
        add(themeButton);
        add(viewLayout);
    }

    public record Team(
            String name,
            int wins,
            int ties,
            int losses,
            int goals,
            int goalDifference,
            int points
    ) {
    }


    /**
     * Returns the current theme of the dashboard
     * 0 = Light Mode
     * 1 = Dark Mode
     */
    public int getTheme() {
        return this.getElement().getThemeList().contains(Lumo.DARK) ? 1 : 0;
    }
}
