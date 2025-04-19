package Task_Manager.Objects;

import Task_Manager.Enums.Priority;
import Task_Manager.Enums.Type;

public class Task {
    private final String task_name;
    private final Priority task_priority;
    private final Type task_type;
    private boolean check;
    private final String creationDate;

    public Task(String task_name, Priority task_priority, Type type) {
        if (task_name == null || task_name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        if (task_priority == null) {
            throw new IllegalArgumentException("Task priority cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("Task type cannot be null");
        }
        
        this.task_name = task_name.trim();
        this.task_priority = task_priority;
        this.task_type = type;
        this.check = false;
        this.creationDate = java.time.LocalDateTime.now().toString();
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

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | Criado em: %s [%s]", 
            task_name, 
            task_priority, 
            task_type,
            creationDate,
            (check ? "✅" : "❌"));
    }
}
