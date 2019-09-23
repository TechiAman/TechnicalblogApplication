package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public List<Post> getAllPosts(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p",Post.class);
        List<Post> posts= query.getResultList();

        return posts;
    }

    public Post getLatestPost() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(Post.class, 3);
    }

}
