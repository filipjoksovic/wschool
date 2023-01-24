import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Project} from '../models/ProjectModel';
import {ProjectService} from '../services/ProjectService';
import ProjectRow from './ProjectRow';

const ProjectsList = () => {
    const projectService = new ProjectService();
    const [projects, setProjects] = useState<Project[]>([]);

    useEffect(() => {
        projectService
            .getAllProjects()
            .then((response: AxiosResponse<any, any>) => {
                console.log(response.data);
                setProjects(response.data);
            });
    }, []);


    return (
        <div className='container'>
            {projects ? (
                <>
                    <h2>Projects</h2>
                    <div className="projects-wrapper">
                        {projects.map((project: Project) => {
                            return <ProjectRow project={project}></ProjectRow>
                        })}
                    </div>
                </>
            ) : (
                <><p>No projects yet</p></>
            )}
        </div>
    );
};

export default ProjectsList;
