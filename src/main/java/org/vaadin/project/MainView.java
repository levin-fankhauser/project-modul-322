package org.vaadin.project;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Dashboard")
@Route
public class MainView extends VerticalLayout {

    public MainView() {
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setAlignItems(Alignment.CENTER);
        mainLayout.add(new H1("Dashboard"));

        // Create Grid
        VerticalLayout gridLayout = new VerticalLayout();

        Grid<Team> grid = new Grid<>();
        grid.addColumn(Team::name).setHeader("Name");
        grid.addColumn(Team::wins).setHeader("Siege");
        grid.addColumn(Team::ties).setHeader("Unentschieden");
        grid.addColumn(Team::losses).setHeader("Niederlagen");
        grid.addColumn(Team::goals).setHeader("Goals");
        grid.addColumn(Team::goalDifference).setHeader("Goal Differenz");
        grid.addColumn(Team::points).setHeader("Punkte");

        grid.setItems(
                new Team("Fc Basel", 10, 2, 3, 30, 20, 33),
                new Team("Fc Zürich", 9, 3, 3, 25, 15, 30),
                new Team("Fc Luzern", 8, 4, 3, 20, 10, 28),
                new Team("Fc Sion", 7, 5, 3, 15, 5, 26),
                new Team("Fc Thun", 6, 6, 3, 10, 0, 24)
        );

        gridLayout.add(grid);
        gridLayout.setWidth("60%");
        grid.getStyle().set("border-radius", "10px");
        mainLayout.add(gridLayout);

        // Add to View
        add(mainLayout);
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
