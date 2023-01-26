import React, {useEffect, useState} from 'react';
import CreateProject from '../components/CreateProject';
import ProjectsList from '../components/ProjectsList';
import {ProjectService} from "../services/ProjectService";
import {AxiosResponse} from "axios";
import { Project } from '../models/ProjectModel';
import CreateTask from "../components/tasks/CreateTask";

const ProjectsPage = () => {

    const projectService = new ProjectService();
    const [projects, setProjects] = useState<Project[]>([]);
    const [projectToEdit, setProjectToEdit] = useState<Project | null>(null);

    useEffect(() => {
        console.log("use effect called")
        projectService
            .getAllProjects()
            .then((response: AxiosResponse<any, any>) => {
                setProjects(response.data);
            });
    }, []);

    const handleProjectCreated = (project: Project) => {
        console.log("Project created")
        console.log(project);
        setProjects([...projects, project])
        console.log(projects);
    }
    const handleProjectUpdated = (project: Project) => {
        const updatedProjects = projects.map((p: Project) => {
            if (p.id === project.id) {
                return project;
            }
            return p;
        })

        setProjects([...updatedProjects]);
        setProjectToEdit(null);
    }

    function selectProjectForEdit(project: Project) {
        console.log("Received project on page component", project);
        setProjectToEdit({...project} as Project);
        console.log(projectToEdit);
    }

    const deleteProject = (project: Project) => {
        projectService.deleteProject(project?.id as number).then((response: any) => {
            console.log("project deleted");
            const updatedProjects = projects.filter((p: Project) =>
                p.id !== project.id
            )
            setProjects([...updatedProjects]);
            setProjectToEdit(null);
        })
    }

    return (
        <>
            {console.log(projectToEdit)}
            {projects ?
                <>
                    <CreateTask></CreateTask>
                    <CreateProject onProjectCreated={handleProjectCreated}
                                   onProjectUpdated={handleProjectUpdated}
                                   projectToEdit={projectToEdit}></CreateProject>
                    <ProjectsList projects={projects} onProjectSelected={selectProjectForEdit}
                                  onProjectDelete={deleteProject}></ProjectsList>
                </>
                : <>Loading</>}

        </>
    );
};

export default ProjectsPage;
