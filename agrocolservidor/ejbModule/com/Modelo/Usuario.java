package com.Modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	@SequenceGenerator(name = "SEQ_ID_USUARIO", sequenceName = "SEQ_ID_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_USUARIO")
	private Integer idUsuario;

	private String apellido;

	private String clave;

	private String direccion;

	private String documento;

	@Enumerated(EnumType.STRING)
	private EnumEstado estado;

	private String mail;

	private String nombre;
	
	private String profesion;
	
	private String instituto;
	
	@Column(name="NOMBRE_USUARIO",unique=true)	
	private String nombreUsuario;

	@Column(name="TIPO_DOC")
	@Enumerated(EnumType.STRING)
	private EnumTipoDoc tipoDoc;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_ROL")
	private Rol rol;
	
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	private List<Formulario> formularios;
	

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public EnumEstado getEstado() {
		return this.estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public EnumTipoDoc getTipoDoc() {
		return this.tipoDoc;
	}

	public void setTipoDoc(EnumTipoDoc tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol role) {
		this.rol = role;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

	@Override
	public String toString() {
		return  nombre + " - "+   apellido;
	}
}