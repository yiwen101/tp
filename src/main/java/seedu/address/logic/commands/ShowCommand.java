package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.lessons.Lesson;
import seedu.address.model.person.Person;

/**
 * Shows the details of an existing person in the address book.
 */
public class ShowCommand extends Command {

    public static final String COMMAND_WORD = "show";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Shows the details of the person identified "
            + "by the index number used in the last person listing.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_SHOW_PERSON_SUCCESS = "Showing Person: %1$s";
    public static final String MESSAGE_SHOW_LESSON_SUCCESS = "Showing Lesson: %1$s";

    private final Index targetIndex;

    public ShowCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        List<Lesson> lastShownSchedule = model.getFilteredScheduleList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }


        // Handle different cases of show command based on app state
        switch (model.getState()) {
        case "STUDENTS":
            // Show student details
            Person personToShow = lastShownList.get(targetIndex.getZeroBased());
            model.showPerson(personToShow);
            return new CommandResult(String.format(MESSAGE_SHOW_PERSON_SUCCESS, Messages.format(personToShow)));
        case "SCHEDULE":
            // Show lesson details
            // Just a placeholder for now
            Lesson lessonToShow = lastShownSchedule.get(targetIndex.getZeroBased());
            model.showLesson(lessonToShow);
            // return new CommandResult(String.format(MESSAGE_SHOW_LESSON_SUCCESS, Messages.format(lessonToShow)));
            return new CommandResult("Show Lesson");

        default:
            // System.out.println("Unknown state");
            // Message can be changed, just a placeholder for now
            throw new CommandException(Messages.MESSAGE_UNKNOWN_COMMAND);
        }

    }
}

