package alex.app.myQuizzApp.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthTokenRepository extends JpaRepository<AuthToken,Long> {
    List<AuthToken> findByUser_Id(Long id);
}
