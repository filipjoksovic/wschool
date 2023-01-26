import {useEffect, useState} from "react";
import {TaskService} from "../../services/TaskService";
import {Project} from "../../models/ProjectModel";
import {Task} from "../../models/TaskModel";

interface IProjectTasksProps {
    project: Project;
    taskSelected?: any;
}

const ProjectTasks = (props: IProjectTasksProps) => {

    const taskService = new TaskService();
    const [tasks, setTasks] = useState<Task[]>([]);

    useEffect(() => {
        console.log(props.project.id);
        taskService.getTasksForProject(props.project.id as number).then((response: any) => {
            setTasks(response.data);
            console.log(response.data)
        });
    }, [])

    return <>
        {tasks.length > 0 ?
            <div className="tasks-wrapper">
                {tasks.map((task: Task) => {
                        return <div className="task-wrapper">
                            <div className="task-name">{task.name}</div>
                            <div className="task-description">{task.description}</div>
                            <div
                                className="task-due-date">{task.dueDate ? new Date(task.dueDate as string).toLocaleDateString() : "No due date"}</div>

                        </div>
                    }
                )
                }
            </div> :
            <></>

        }
    </>
}
export default ProjectTasks;