import React, {useEffect, useState} from 'react';
import CreateProject from '../components/CreateProject';
import ProjectsList from '../components/ProjectsList';
import {ProjectService} from "../services/ProjectService";
import {AxiosResponse} from "axios";
import {Project} from "../models/ProjectModel";

const ProjectsPage = () => {

    const projectService = new ProjectService();
    const [projects, setProjects] = useState<Project[]>([]);

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

    return (
        <>
            {projects ?
                <>
                    <CreateProject onProjectCreated={handleProjectCreated}></CreateProject>
                    <ProjectsList projects={projects}></ProjectsList>
                </>
                : <>Loading</>}

        </>
    );
};

export default ProjectsPage;
