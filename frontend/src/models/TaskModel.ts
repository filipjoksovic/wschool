export interface Task {
    id: number | undefined;
    name: string;
    description: string | undefined;
    dueDate: string | undefined;
    project_id: number | undefined;

}

export {};