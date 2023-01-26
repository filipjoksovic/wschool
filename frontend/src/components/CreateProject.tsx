import React, {useEffect, useState} from 'react';
import {Project} from '../models/ProjectModel';
import { ProjectService } from '../services/ProjectService';

interface ICreateProjectProps {
    onProjectCreated: any;
    onProjectUpdated: any;
    projectToEdit: Project | null;
}

const CreateProject = (props: ICreateProjectProps) => {
    const projectService = new ProjectService();
    const [projectId, setProjectId] = useState<number | undefined>(-1);
    const [projectName, setProjectName] = useState<string>('');
    const [dueDate, setDueDate] = useState<string>('');
    const [projectDescription, setProjectDescription] = useState<string>('');
    const projectToEdit = props.projectToEdit;

    useEffect(() => {
        if (projectToEdit) {
            setProjectName(projectToEdit.name);
            setProjectDescription(projectToEdit.description);
            setDueDate(projectToEdit.dueDate);
            setProjectId(projectToEdit.id);

        }
    }, [projectToEdit])

    const handleSubmit = () => {
        const projectObject: Project = {
            id: projectId || undefined,
            name: projectName,
            dueDate: new Date(dueDate).toISOString(),
            description: projectDescription,
        };
        if (!projectToEdit) {
            projectService.createProject(projectObject).then((response: any) => {
                const project: Project = response.data as Project;
                props.onProjectCreated(project);
            });
        } else {
            projectService.updateProject(projectObject).then((response: any) => {
                const project: Project = response.data as Project;
                props.onProjectUpdated(project);
            })
            setProjectId(-1);
            setProjectName("");
            setProjectDescription("");
            setDueDate("");
        }
    };
    return (
        <>
            {!projectToEdit ? <h2>Create project</h2> : <h2>Edit project</h2>}
            <input
                hidden
                name="id"
                type="number"
                value={projectId}
                onChange={(e: any) => {
                    setProjectId(Number(e.target.value));
                }}
            />
            <div className="d-flex">
                <div className="form-group">
                    <label htmlFor="projectName">Project Name</label>
                    <input
                        type="text"
                        name="projectName"
                        className="form-control"
                        id="projectName"
                        value={projectName}
                        onChange={e => setProjectName(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="dueDate">Due date</label>
                    <input
                        type="date"
                        id="dueDate"
                        name="dueDate"
                        className="form-control"
                        onChange={e => setDueDate(e.target.value)}
                        value={dueDate ? new Date(dueDate).toISOString().split('T')[0] : ''}
                    />
                </div>
            </div>
            <div className="form-group">
                <label htmlFor="projectDescription">Project description</label>
                <textarea
                    name="projectDescription"
                    id="projectDescription"
                    className="form-control"
                    onChange={e => setProjectDescription(e.target.value)}
                    value={projectDescription}></textarea>
            </div>
            <button className="btn btn-primary d-block mx-auto" onClick={handleSubmit}>
                {(projectToEdit ? 'Edit' : 'Create') + ' project'}
            </button>
        </>
    );
};

export default CreateProject;
