package net.ausiasmarch.wildcart.repository;

import net.ausiasmarch.wildcart.entity.UsuarioEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByLoginAndPassword(String login, String password);
    
    //Long countByLogin(String login);   
    
    boolean existsByLogin(String login);    

    @Query(value = "select * from usuario where id_tipousuario = ?1 and (dni like %?2% or nombre like %?3% or or apellido1 like %?4% or apellido2 like %?5%)", nativeQuery = true)
    Page<UsuarioEntity> findByTipousuarioIdAndDniIgnoreCaseContainingOrNombreIgnoreCaseContainingOrApellido1IgnoreCaseContainingOrApellido2IgnoreCaseContaining(
           Long filtertype, String dni, String nombre, String apellido1, String apellido2, Pageable oPageable);

    Page<UsuarioEntity> findByDniIgnoreCaseContainingOrNombreIgnoreCaseContainingOrApellido1IgnoreCaseContainingOrApellido2IgnoreCaseContaining(
           String dni, String nombre, String apellido1, String apellido2, Pageable oPageable);

    Page<UsuarioEntity> findByTipousuarioId(Long tipoproducto, Pageable oPageable);
}
