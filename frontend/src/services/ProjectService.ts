import axios, { AxiosResponse } from 'axios';

class ProjectService {
	public backendURL = process.env.REACT_APP_BACKEND_URL || '';
	public projectsEndpoint =
		process.env.REACT_APP_BACKEND_PROJECTS_ENDPOINT || '';

	public endpoint = this.backendURL + this.projectsEndpoint;

	constructor() {}

	public getAllProjects(): Promise<AxiosResponse<any, any>> {
		return axios({ url: this.endpoint, method: 'get' });
	}

	public createProject() {}

	public deleteProject() {}
	public updateProject() {}
	public getProject() {}
}
export { ProjectService };
