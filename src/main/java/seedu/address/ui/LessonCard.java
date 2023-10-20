package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.lessons.Lesson;
import seedu.address.model.person.Person;

/**
 * A UI component that displays information of a {@code Person}.
 */
public class LessonCard extends UiPart<Region> {

    private static final String FXML = "LessonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

//    public final Person person;
//    @FXML
//    private VBox fields;
//
//    @FXML
//    private HBox cardPane;
//    @FXML
//    private Label name;
//    @FXML
//    private Label id;
//    @FXML
//    private FlowPane tags;

    public final Lesson lesson;
    @FXML
    private VBox fields;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    // @FXML
    // private FlowPane tags;

    /**
     * Creates a {@code LessonCard} with the given {@code Lesson} and index to display.
     */
    public LessonCard(Lesson lesson, int displayedIndex, String[] displayFields) {
        super(FXML);
        this.lesson = lesson;
        id.setText(displayedIndex + ". ");
        name.setText(lesson.getLessonOverview());
        for (String field : displayFields) {
            // TODO: Implement the schedule detail
            LessonCardFieldBuilder.build(field, lesson, fields);
        }
    }


}
