package name.admitriev.jhelper.parsing;

import net.egork.chelper.parser.JSONParser;
import net.egork.chelper.task.StreamConfiguration;
import net.egork.chelper.task.Task;
import net.egork.chelper.task.TestType;

import java.util.ArrayList;
import java.util.Collection;

public class MyJsonParser extends JSONParser {
    @Override
    public Collection<Task> parseTaskFromHTML(String html) {
        Collection<Task> tasks = super.parseTaskFromHTML(html);
        ArrayList<Task> patchedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.contestName.contains("Facebook Hacker Cup")) {
                patchedTasks.add(new Task(task.name, TestType.SINGLE, new StreamConfiguration(StreamConfiguration.StreamType.CUSTOM, "in.txt"), task.output, task.tests, task.location, task.vmArgs, task.mainClass, task.taskClass, task.checkerClass, task.checkerParameters, task.testClasses, task.date, task.contestName, task.truncate, task.inputClass, task.outputClass, task.includeLocale, task.failOnOverflow, task.interactive, task.interactor));
            } else {
                patchedTasks.add(task);
            }
        }
        return patchedTasks;
    }
}
