import axios from "axios";
import {Task} from "../models/TaskModel";

export class TaskService {
    public backendURL = process.env.REACT_APP_BACKEND_URL || '';
    public tasksEndpoint =
        process.env.REACT_APP_BACKEND_TASKS_ENDPOINT || '';
    public endpoint = this.backendURL + this.tasksEndpoint;

    public getAllTasks() {
        return axios({url: this.endpoint, method: 'get'})
    }

    public getTasksForProject(project_id: number) {
        return axios({url: `${this.endpoint}/${project_id}`, method: 'get'})
    }

    public updateTask(task: Task) {
        console.log(task)
        return axios({url: this.endpoint, method: "put", data: task})
    }

    public deleteTask(task: Task) {
        return axios({url: this.endpoint, method: "delete"})
    }

    public getTask(task: Task) {
        return axios({url: `${this.endpoint}/${task.id}`, method: 'get'})
    }

    saveTask(task: Task) {
        console.log(task);
        return axios({url: this.endpoint, method: "post", data: task})
    }
}

export {};