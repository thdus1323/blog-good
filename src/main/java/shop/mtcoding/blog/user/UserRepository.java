package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

    private EntityManager em;

    public UserRepository(EntityManager em){
        this.em = em;
    }
@Transactional
    public void save(UserRequest.JoinDTO requestDTO){
    Query query = em.createNativeQuery("insert into user_tb(username, password, email, created_at) values(?,?,?, now())");
    query.setParameter(1, requestDTO.getUsername());
    query.setParameter(2, requestDTO.getPassword());
    query.setParameter(3, requestDTO.getEmail());
    query.executeUpdate();
}
}
