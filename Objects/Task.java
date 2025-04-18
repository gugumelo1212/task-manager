package Task_Manager.Objects;

import Task_Manager.Enums.Priority;
import Task_Manager.Enums.Type;

public class Task {
    String task_name;
    Priority task_priority;
    Type task_type;

    public Task(String task_name, Priority task_priority, Type type) {
        this.task_name = task_name;
        this.task_priority = task_priority;
        this.task_type = type;
    }

    public String getTask_name() {
        return task_name;
    }

    public Priority getTask_priority() {
        return task_priority;
    }

    public Type getType() {
        return task_type;
    }
}
