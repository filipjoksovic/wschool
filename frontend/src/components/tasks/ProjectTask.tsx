import {Task} from "../../models/TaskModel";
import {useEffect, useState} from "react";
import {TaskService} from "../../services/TaskService";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTimes} from "@fortawesome/free-solid-svg-icons";

interface IProjectTaskProps {
    task: Task;
    onTaskDelete:any;
}

const ProjectTask = (props: IProjectTaskProps) => {

    const [task, setTask] = useState<Task>(props.task);
    const taskService: TaskService = new TaskService();
    const updateTask = () => {
        console.log(task);
        taskService.updateTask(task);
    }
    useEffect(() => {
        console.log(task);
    })

    const deleteTask = ()=>{
        console.log("deleting task")
        props.onTaskDelete(task);
    }

    return <div className="task-wrapper">
        <input className="task-name invisInput" value={task.name} onChange={(e) =>
            setTask({...task, name: e.target.value} as Task)
        }
               onBlur={updateTask}

        />
        <textarea draggable={false} className="task-description invisInput" value={task.description}
                  onChange={(e) =>
                      setTask({...task, description: e.target.value} as Task)
                  }
                  onBlur={updateTask}

        ></textarea>
        <input
            className="task-due-date invisInput" type="date" value={task.dueDate ? task.dueDate.split("T")[0] : ""}
            onChange={(e) =>
                setTask({...task, dueDate: e.target.value} as Task)
            }
            onBlur={updateTask}
        />
        <div className="delete-task">
            <FontAwesomeIcon icon={faTimes} onClick={deleteTask}></FontAwesomeIcon>
        </div>

    </div>

}

export default ProjectTask