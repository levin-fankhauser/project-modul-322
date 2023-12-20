package org.vaadin.project;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

@PageTitle("Testing")
@Route("testing")
public class Testing extends VerticalLayout {

    public Testing() {
        add(new H1("Testing"));

        FullCalendar calendar = FullCalendarBuilder.create().build();
        calendar.setWidth("100%");
        calendar.setHeight("600px");

        add(calendar);
    }
}
