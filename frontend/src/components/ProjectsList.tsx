import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Project} from '../models/ProjectModel';
import {ProjectService} from '../services/ProjectService';
import ProjectRow from './ProjectRow';

interface IProjectsListProps {
    projects: Project[],
}

const ProjectsList = (props: IProjectsListProps) => {

    const projects = props.projects;
    console.log(projects);

    return (
        <div className='container'>
            {projects ? (
                <>
                    <h2>Projects</h2>
                    <div className="projects-wrapper">
                        {projects.map((project: Project) => {
                            return <ProjectRow key={project.id} project={project}></ProjectRow>
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
