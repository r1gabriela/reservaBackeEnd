
package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.Repository.RoleRepository;
import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.dto.UsuarioDto;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.entity.Role;
import com.lpi.reserva.entity.Usuario;
import com.lpi.reserva.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
		
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ClienteServiceImpl clienteService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;
	
	@Autowired
	private RoleRepository roleRepository;
		
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioDto salvar(UsuarioDto usuarioDto) {
		try	{
			Usuario usuario = new Usuario();
			
			usuario = usuarioRepository.pesquisarUsuarioPorLogin(usuarioDto.getLogin());
			
			if (usuario == null || usuario.getPessoa().getIdPessoa() == usuarioDto.getIdPessoa())
				usuarioRepository.save(preencherUsuario(usuarioDto));
			else 
				throw new IllegalArgumentException("Login já Cadastrado.");
			
			return usuarioDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
		try {
			Pessoa pessoa = pessoaRepository.pesquisarPorCpf(usuarioDto.getCpf());
			
			if(pessoa == null) {
				clienteService.salvar(usuarioDto);
				pessoa = pessoaRepository.pesquisarPorCpf(usuarioDto.getCpf());
			}
			
			usuarioDto.setIdPessoa(pessoa.getIdPessoa());
			usuarioDto.setRole("cliente");
			
			if(salvar(usuarioDto) == null)
				throw new Exception("Erro ao cadastrar usuário");
			else 
				securityServiceImpl.autoLogin(usuarioDto.getLogin(), usuarioDto.getSenha());
			
			return usuarioDto;
				
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
		
	@Override
	public Usuario preencherUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioDto.getIdUsuario());
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(usuarioDto.getIdPessoa());
		usuario.setPessoa(pessoa);
		usuario.setAtivo(usuarioDto.getAtivo());
		usuario.setLogin(usuarioDto.getLogin());
		Role role = roleRepository.pesquisarPorNome(usuarioDto.getRole());
		usuario.setRole(role);
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioDto.getSenha()));
		return usuario;
	}

	@Override
	public boolean excluir(Integer idUsuario) {
		try {
			Usuario usuario = usuarioRepository.findById(idUsuario).get();
			usuario.setAtivo(false);
			usuarioRepository.save(usuario);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public UsuarioDto pesquisarPorId(int idUsuario) {	
		return preencherUsuarioDto(usuarioRepository.findById(idUsuario).get());
	}

	@Override
	public UsuarioDto preencherUsuarioDto(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setIdUsuario(usuario.getIdUsuario());
		usuarioDto.setIdPessoa(usuario.getPessoa().getIdPessoa());
		usuarioDto.setLogin(usuario.getLogin());
		usuarioDto.setSenha(usuario.getSenha());
		usuarioDto.setAtivo(usuario.getAtivo());
		return usuarioDto;		
	}
	
	@Override
	public ArrayList<UsuarioDto> listarTodos() {
		return listaDto(usuarioRepository.findAll());
	}
	
	@Override
	public ArrayList<UsuarioDto> listaDto(Iterable<Usuario> usuarios){
		ArrayList<UsuarioDto> listaDto = new ArrayList<>();
        for(Usuario usuario: usuarios) 
            listaDto.add(preencherUsuarioDto(usuario));
    
        return listaDto;		
	}

		
}