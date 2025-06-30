package io.sanctusfides.todojavafx.Model;

import io.sanctusfides.todojavafx.Database.DatabaseHandler;
import io.sanctusfides.todojavafx.Views.ViewFactory;

public class Model {
    private static Model model;
    private final DatabaseHandler databaseHandler;
    private final ViewFactory viewFactory;

    private Model() {
        this.databaseHandler = new DatabaseHandler();
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }

}
