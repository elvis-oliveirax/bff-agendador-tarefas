package com.javaeo.bffagendadortarefas.bunisess;


import com.javaeo.bffagendadortarefas.bunisess.dto.in.EnderecoDTORequest;
import com.javaeo.bffagendadortarefas.bunisess.dto.in.LoginRequestDTO;
import com.javaeo.bffagendadortarefas.bunisess.dto.in.TelefoneDTORequest;
import com.javaeo.bffagendadortarefas.bunisess.dto.in.UsuarioDTORequest;
import com.javaeo.bffagendadortarefas.bunisess.dto.out.EnderecoDTOResponse;
import com.javaeo.bffagendadortarefas.bunisess.dto.out.TelefoneDTOResponse;
import com.javaeo.bffagendadortarefas.bunisess.dto.out.UsuarioDTOResponse;
import com.javaeo.bffagendadortarefas.bunisess.dto.out.ViaCepDTOResponse;
import com.javaeo.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){

		return client.salvaUsuario(usuarioDTO);
	}

	public String loginUsuario(LoginRequestDTO usuarioDTO) {
		return client.login(usuarioDTO);
	}

	public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
		return client.buscaUsuarioPorEmail(email, token);

	}

	public void deletaUsuarioPorEmail(String email, String token) {
		client.deletaUsuarioPorEmail(email, token);
	}


	public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
		return client.atualizaDadoUsuario(dto, token);
	}

	public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
		return client.atualizaEndereco(enderecoDTO, idEndereco, token);
	}

	public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){

		return client.atualizaTelefone(dto, idTelefone, token);
	}

	public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){

		return client.cadastraEndereco(dto, token);

	}

	public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {

		return  client.cadastraTelefone(dto, token);
	}

	public ViaCepDTOResponse buscarEnderecoPorCep(String cep){
		return client.buscarDadosCep(cep);

	}
}
