import React from 'react';
import {Project} from '../models/ProjectModel';
import ProjectTasks from "./tasks/ProjectTasks";

interface IProjectRow {
    project: Project;
    onProjectSelected: any;
    onProjectDelete: any;
}

const ProjectRow = (props: IProjectRow) => {
    const project = props.project;

    const setupEdit = () => {
        console.log("setting project to edit")
        props.onProjectSelected(project);
    }
    const deleteProject = () => {
        props.onProjectDelete(project);
    }

    return <>
        <div className="project-wrapper">
            <div className="project-name">{project.name}</div>
            <div
                className="project-date">{project.dueDate ? new Date(project.dueDate).toLocaleDateString() : "No due date"}</div>
            <div className="project-description">{project.description}</div>
            <button className="btn btn-secondary project-edit" onClick={setupEdit}>Edit</button>
            <button className="btn btn-danger project-delete" onClick={deleteProject}>Delete</button>
        </div>
        <ProjectTasks project={project}></ProjectTasks>
    </>
        ;
};

export default ProjectRow;
