package pessoas.attornautus.api.enderecos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {
    Page<Enderecos> findAllByAtivoTrue(Pageable paginacao);
}
