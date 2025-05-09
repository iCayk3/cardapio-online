package br.com.w4solution.lanches.controller;


import br.com.w4solution.lanches.domain.usuario.DadosAutenticao;
import br.com.w4solution.lanches.domain.usuario.DadosToken;
import br.com.w4solution.lanches.dto.CadastrarUsuarioDto;
import br.com.w4solution.lanches.dto.UsuarioDTO;
import br.com.w4solution.lanches.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    @Autowired
//    MailService mailService;

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticao dados){
        var token = service.efeutarLogin(dados);
        return ResponseEntity.ok(new DadosToken(token));
    }

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid CadastrarUsuarioDto dados, UriComponentsBuilder uri){

        var usuario = service.cadastrarUsuario(dados, encoder);
        var uriB = uri.path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uriB).body(new UsuarioDTO(usuario));

    }
}