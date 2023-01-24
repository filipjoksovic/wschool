import React from 'react';
import {Project} from '../models/ProjectModel';

interface IProjectRow {
    project: Project;
}

const ProjectRow = (props: IProjectRow) => {
    const project = props.project;
    return <div className="project-wrapper">
        <div className="project-name">{project.name}</div>
        <div className="project-date">{project.dueDate.toString()}</div>
        <div className="project-description">{project.description}</div>

    </div>;
};

export default ProjectRow;
