import React from 'react';
import CreateProject from '../components/CreateProject';
import ProjectsList from '../components/ProjectsList';

const ProjectsPage = () => {
	return (
		<>
			<CreateProject></CreateProject>
			<ProjectsList></ProjectsList>
		</>
	);
};

export default ProjectsPage;
