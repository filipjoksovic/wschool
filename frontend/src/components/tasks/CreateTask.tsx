import {useState} from "react";
import {Task} from "../../models/TaskModel";
import {TaskService} from "../../services/TaskService";

interface ICreateTaskProps {
    project_id?: number;
}

const CreateTask = () => {
    const defaultTaskState: Task = {
        id: -1,
        name: "",
        description: "",
        dueDate: "",
        project_id: -1

    }
    const [task, setTask] = useState<Task>(defaultTaskState);
    const projectID = 1;
    const taskService = new TaskService();
    const createTask = () => {
        setTask({...task, project_id: projectID} as Task)
        console.log(task);
        taskService.saveTask(task).then((response: any) => {
            setTask({...response.data})
        })
    }

    return <>
        <div className="form-group">
            <label htmlFor="task-name">Task name</label>
            <input type="text" className="form-control" name="task-name" id="task-name"
                   onChange={(e) => setTask({...task, name: e.target.value} as Task)} value={task?.name}/>
        </div>
        <div className="form-group">
            <label htmlFor="task-date">Due date</label>
            <input type="date" className="form-control" name="task-date" id="task-date" value={task?.dueDate}
                   onChange={(e) => setTask({...task, dueDate: e.target.value} as Task)}/>
        </div>
        <div className="form-group">
            <label htmlFor="task-description">Task description</label>
            <textarea className="form-control" name="task-description" id="task-description"
                      value={task?.description}
                      onChange={(e) => setTask({...task, description: e.target.value} as Task)}></textarea>
        </div>

        <button className="btn btn-primary" onClick={createTask}>Create task</button>
    </>
}
export default CreateTask;