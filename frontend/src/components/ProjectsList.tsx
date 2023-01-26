import { Project } from '../models/ProjectModel';
import ProjectRow from './ProjectRow';

interface IProjectsListProps {
    projects: Project[];
    onProjectSelected: any;
    onProjectDelete: any;
}

const ProjectsList = (props: IProjectsListProps) => {
    const projects = props.projects;
    console.log(projects);

    function onProjectSelected(project: Project): void {
        console.log('Received proiject from parent', project);
        props.onProjectSelected(project);
    }

    function onProjectDelete(project: Project): void {
        console.log('Received proiject from parent', project);
        props.onProjectDelete(project);
    }
    return (
        <div className="container">
            {projects ? (
                <>
                    <h2>Projects</h2>
                    <div className="projects-wrapper">
                        {projects.map((project: Project) => {
                            return (
                                <ProjectRow
                                    key={project.id}
                                    project={project}
                                    onProjectSelected={onProjectSelected}
                                    onProjectDelete={onProjectDelete}></ProjectRow>
                            );
                        })}
                    </div>
                </>
            ) : (
                <>
                    <p>No projects yet</p>
                </>
            )}
        </div>
    );
};

export default ProjectsList;
