package sco.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_IDUSUARIOS_GENERATOR", sequenceName="SEQ_USUARIOS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_IDUSUARIOS_GENERATOR")
	@Column(name="id_usuarios", unique=true, nullable=false)
	private Integer idUsuarios;

	@Column(name="contrasena_usuarios", length=20)
	private String contrasenaUsuarios;

	@Column(name="estado_usuarios")
	private Boolean estadoUsuarios;

	@Column(name="nombre_usuarios", length=20)
	private String nombreUsuarios;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_roles")
	private Rol role;

	public Usuario() {
	}

	public Integer getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(Integer idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getContrasenaUsuarios() {
		return this.contrasenaUsuarios;
	}

	public void setContrasenaUsuarios(String contrasenaUsuarios) {
		this.contrasenaUsuarios = contrasenaUsuarios;
	}

	public Boolean getEstadoUsuarios() {
		return this.estadoUsuarios;
	}

	public void setEstadoUsuarios(Boolean estadoUsuarios) {
		this.estadoUsuarios = estadoUsuarios;
	}

	public String getNombreUsuarios() {
		return this.nombreUsuarios;
	}

	public void setNombreUsuarios(String nombreUsuarios) {
		this.nombreUsuarios = nombreUsuarios;
	}

	public Rol getRole() {
		return this.role;
	}

	public void setRole(Rol role) {
		this.role = role;
	}

}