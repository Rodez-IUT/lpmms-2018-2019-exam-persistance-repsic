package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public Project saveProjectForEnterprise(Project project, Enterprise enterprise) {
    	// Partie 2 //////////////////////////////////////////////////////////////////////
    	if (project.getEnterprise() != null && project.getEnterprise() != enterprise) {
    		Enterprise currentEnterpriseOfProject = project.getEnterprise();
    		currentEnterpriseOfProject.removeProject(project);
    		saveEnterprise(currentEnterpriseOfProject);
    	}
    	//////////////////////////////////////////////////////////////////////////////////
        Enterprise mergedEnterprise = saveEnterprise(enterprise);
        project.setEnterprise(mergedEnterprise);
        project.setVersionUp(); // Partie 3
        Project mergedProject = entityManager.merge(project);
        mergedEnterprise.addProject(mergedProject);
        entityManager.persist(mergedProject);
        entityManager.flush();
        return mergedProject;
    }

    public Enterprise saveEnterprise(Enterprise enterprise) {
    	Enterprise mergedEnterprise = entityManager.merge(enterprise); // Partie 1
        entityManager.persist(mergedEnterprise);
        entityManager.flush();
        return mergedEnterprise;
    }

    public Project findProjectById(Long id) {
        return entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id) {
        return entityManager.find(Enterprise.class, id);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Project> findAllProjects() {
        TypedQuery<Project> query = entityManager.createQuery("select p from Project p join fetch p.enterprise order by p.title", Project.class);
        return query.getResultList();
    }
}
