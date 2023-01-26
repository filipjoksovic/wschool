import axios, {AxiosResponse} from 'axios';
import {Project} from "../models/ProjectModel";

class ProjectService {
    public backendURL = process.env.REACT_APP_BACKEND_URL || '';
    public projectsEndpoint =
        process.env.REACT_APP_BACKEND_PROJECTS_ENDPOINT || '';

    public endpoint = this.backendURL + this.projectsEndpoint;

    public getAllProjects(): Promise<AxiosResponse<any, any>> {
        return axios({url: this.endpoint, method: 'get'});
    }

    public createProject(project: Project) {
        return axios({url: this.endpoint, method: 'post', data: project})

    }

    public deleteProject(id: number) {
        return axios({url: `${this.endpoint}/${id}`, method: "delete"})
    }

    public updateProject(project: Project) {
        return axios({url: this.endpoint, method: 'put', data: project})
    }

    public getProject() {
    }
}

export {ProjectService};
