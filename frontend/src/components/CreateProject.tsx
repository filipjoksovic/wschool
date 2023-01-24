import React, { useState } from 'react';
import { Project } from '../models/ProjectModel';

const CreateProject = () => {
	const [projectName, setProjectName] = useState('');
	const [dueDate, setDueDate] = useState('');
	const [projectDescription, setProjectDescription] = useState('');

	const handleSubmit = () => {
		const projectObject: Project = {
			name: projectName,
			dueDate: new Date(dueDate),
			description: projectDescription,
		};
		console.log(projectObject);
	};
	return (
		<>
			<div className="d-flex">
				<div className="form-group">
					<label htmlFor="projectName">Project Name</label>
					<input
						type="text"
						name="projectName"
						className="form-control"
						id="projectName"
						value={projectName}
						onChange={(e) => setProjectName(e.target.value)}
					/>
				</div>
				<div className="form-group">
					<label htmlFor="dueDate">Due date</label>
					<input
						type="date"
						id="dueDate"
						name="dueDate"
						className="form-control"
						onChange={(e) => setDueDate(e.target.value)}
					/>
				</div>
			</div>
			<div className="form-group">
				<label htmlFor="projectDescription">Project description</label>
				<textarea
					name="projectDescription"
					id="projectDescription"
					className="form-control"
					onChange={(e) => setProjectDescription(e.target.value)}
				></textarea>
			</div>
			<button
				className="btn btn-primary d-block mx-auto"
				onClick={handleSubmit}
			>
				Create project
			</button>
		</>
	);
};

export default CreateProject;
