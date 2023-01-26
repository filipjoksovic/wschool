import React, {useEffect, useState} from "react";
import {TaskService} from "../../services/TaskService";
import {Project} from "../../models/ProjectModel";
import {Task} from "../../models/TaskModel";
import ProjectTask from "./ProjectTask";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";


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

    const deleteTask = (task: Task) => {
        taskService.deleteTask(task).then((response: any) => {
            console.log(response.data);
        })
    }

    return <>
        {tasks.length > 0 ?
            <div className="tasks-wrapper">
                {tasks.map((task: Task) => {
                        return <ProjectTask key={task.id} task={task} onTaskDelete={deleteTask}></ProjectTask>
                    }
                )
                }
            </div> :
            <></>

        }
    </>
}
export default ProjectTasks;