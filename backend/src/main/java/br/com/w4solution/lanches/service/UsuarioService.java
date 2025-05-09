package br.com.w4solution.lanches.service;

import br.com.w4solution.lanches.domain.usuario.DadosAutenticao;
import br.com.w4solution.lanches.domain.usuario.Status;
import br.com.w4solution.lanches.domain.usuario.Usuario;
import br.com.w4solution.lanches.dto.CadastrarUsuarioDto;
import br.com.w4solution.lanches.infra.exceptions.ValidacaoAutenticacaoException;
import br.com.w4solution.lanches.infra.exceptions.ValidacaoCadastroUsuarioException;
import br.com.w4solution.lanches.infra.security.TokenService;
import br.com.w4solution.lanches.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private TokenService service;

    @Autowired
    private AuthenticationManager manager;

    public Usuario cadastrarUsuario(CadastrarUsuarioDto dados, BCryptPasswordEncoder encoder) {
        var checkUser = repository.existsByUsuario(dados.usuario());
        if(!checkUser){
            var usuario = new Usuario(dados.usuario(), encoder.encode(dados.senha()));
            repository.save(usuario);
            return usuario;
        }
        throw new ValidacaoCadastroUsuarioException("Usuario ja cadastrado!");
    }

    public String efeutarLogin(DadosAutenticao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.usuario(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var user = (Usuario) authentication.getPrincipal();
        if(user.getStatus() != Status.ATIVO){
            throw new ValidacaoAutenticacaoException("Usuario não está ativo");
        }
        return service.gerarToken(user);
    }
}
