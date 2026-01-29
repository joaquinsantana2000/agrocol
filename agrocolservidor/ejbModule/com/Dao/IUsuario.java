package com.Dao;

import java.util.List;

import javax.ejb.Remote;

import com.Modelo.EnumEstado;
import com.Modelo.EnumTipoDoc;
import com.Modelo.Usuario;

@Remote
public interface IUsuario {
	
	public int altaUsuario(Usuario usuario);
	
	public boolean bajaUsuario(Integer xIdUsuario);

	public boolean modificarUsuario(Usuario usuario);
	
	public boolean actualizarEstado(Integer xIdUsuario,EnumEstado estado);
	
	public List<Usuario> listarTodos();
	
	public Usuario buscarPorId(Integer xIdUsuario);
	
	public Usuario buscarPorDocTipoDoc(EnumTipoDoc tipoDocumento,String Documento);
	
	public Usuario autenticar(String nombreUsuari,String clave);
	
	public List<Usuario> listarExpertos();
	
}
