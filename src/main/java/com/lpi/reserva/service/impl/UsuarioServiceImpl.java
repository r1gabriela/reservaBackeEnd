
package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Exception.ExceptionResponse;
import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.dto.UsuarioDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.entity.Usuario;
import com.lpi.reserva.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
		
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;
		
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioDto salvar(UsuarioDto usuarioDto) throws Exception, ExceptionResponse {
		try	{
			Usuario usuario = new Usuario();
			
			usuario = usuarioRepository.pesquisarUsuarioPorLogin(usuarioDto.getLogin());

			if (usuario == null || usuario.getPessoa().getIdPessoa() == usuarioDto.getPessoa().getIdPessoa()) {
				usuario = new ModelMapper().map(usuarioDto, Usuario.class);
				usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
				usuario = usuarioRepository.save(usuario);
			} else 
				throw new ExceptionResponse("Login já Cadastrado.");
			
			return new ModelMapper().map(usuario, UsuarioDto.class);
		} catch(ExceptionResponse ex) {
			throw new ExceptionResponse(ex.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unused")
	@Override
	public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
		try {
			Pessoa pessoa = pessoaRepository.pesquisarPorCpf(usuarioDto.getPessoa().getCpf());
			
			if(pessoa == null) {
				Cliente cliente = new ModelMapper().map(usuarioDto.getPessoa(), Cliente.class);
				pessoa = clienteRepository.save(cliente);	
			}
			
			usuarioDto.setPessoa(new ModelMapper().map(pessoa, PessoaDto.class));
			salvar(usuarioDto);
			
			if(usuarioDto == null)
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
	public UsuarioDto pesquisar(String login) {	
		return new ModelMapper().map(usuarioRepository.pesquisarUsuarioPorLogin(login).getLogin(), UsuarioDto.class);
	}

	@Override
	public ArrayList<UsuarioDto> listarTodos() {
		ArrayList<UsuarioDto> usuarios = new ArrayList<>();
		Iterable<Usuario> iterable = usuarioRepository.findAll();
		
		if (iterable != null)
			usuarios = new ModelMapper().map(iterable, new TypeToken<ArrayList<UsuarioDto>>() {}.getType());
		
		return usuarios;
	}
	

		
}