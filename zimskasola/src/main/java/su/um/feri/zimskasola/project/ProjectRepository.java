package su.um.feri.zimskasola.project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

    public Optional<Project> findProjectByName(String name);

}
