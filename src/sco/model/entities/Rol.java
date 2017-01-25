package sco.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLES_IDROLES_GENERATOR", sequenceName="SEQ_ROLES", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_IDROLES_GENERATOR")
	@Column(name="id_roles", unique=true, nullable=false)
	private Integer idRoles;

	@Column(name="descripcion_roles", length=100)
	private String descripcionRoles;

	@Column(name="estado_roles")
	private Boolean estadoRoles;

	@Column(name="nombre_roles", length=20)
	private String nombreRoles;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="role")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public Integer getIdRoles() {
		return this.idRoles;
	}

	public void setIdRoles(Integer idRoles) {
		this.idRoles = idRoles;
	}

	public String getDescripcionRoles() {
		return this.descripcionRoles;
	}

	public void setDescripcionRoles(String descripcionRoles) {
		this.descripcionRoles = descripcionRoles;
	}

	public Boolean getEstadoRoles() {
		return this.estadoRoles;
	}

	public void setEstadoRoles(Boolean estadoRoles) {
		this.estadoRoles = estadoRoles;
	}

	public String getNombreRoles() {
		return this.nombreRoles;
	}

	public void setNombreRoles(String nombreRoles) {
		this.nombreRoles = nombreRoles;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRole(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRole(null);

		return usuario;
	}

}