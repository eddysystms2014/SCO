package sco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import sco.model.entities.Rol;
import sco.model.entities.Usuario;
import sco.model.manager.ManagerSCO;

@ManagedBean
@SessionScoped
public class BeanUsuario {
	private ManagerSCO managersco;
	private List<Rol> listaroles;
	private Integer idUsuarios;
	private Integer idRoles;
	private String nombreUsuarios;
	private String contrasenaUsuarios;
	private Boolean estadoUsuarios;
	private List<Usuario> listausuarios;

	public Integer getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(Integer idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	
	public Integer getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(Integer idRoles) {
		this.idRoles = idRoles;
	}
	
	public String getNombreUsuarios() {
		return nombreUsuarios;
	}

	public void setNombreUsuarios(String nombreUsuarios) {
		this.nombreUsuarios = nombreUsuarios;
	}

	public String getContrasenaUsuarios() {
		return contrasenaUsuarios;
	}

	public void setContrasenaUsuarios(String contrasenaUsuarios) {
		this.contrasenaUsuarios = contrasenaUsuarios;
	}

	public Boolean getEstadoUsuarios() {
		return estadoUsuarios;
	}

	public void setEstadoUsuarios(Boolean estadoUsuarios) {
		this.estadoUsuarios = estadoUsuarios;
	}

	public List<Usuario> getListausuarios() {
		listausuarios=managersco.findAllUsuarios();
		return listausuarios;
	}

	public void setListausuarios(List<Usuario> listausuarios) {
		this.listausuarios = listausuarios;
	}

	public List<Rol> getListaroles() {
		return listaroles;
	}

	public void setListaroles(List<Rol> listaroles) {
		this.listaroles = listaroles;
	}
	
	@PostConstruct
	public void iniciar(){
		managersco=new ManagerSCO();
		listaroles=managersco.findAllRoles();
		estadoUsuarios=true;
	}
	
	public String actioncargarUsuarios(Usuario usuario){
		idUsuarios=usuario.getIdUsuarios();
		idRoles=usuario.getRole().getIdRoles();
		nombreUsuarios=usuario.getNombreUsuarios();
		contrasenaUsuarios=usuario.getContrasenaUsuarios();
		//estadoUsuarios=usuario.getEstadoUsuarios();
		return "usuario_update";
	}
	
	public String actioninsertarUsuarios(){
		try {
			managersco.insertarUsuario(idRoles, nombreUsuarios, contrasenaUsuarios, estadoUsuarios);
			JSFUtil.crearMensajeINFO("Se ha ingresado un nuevo USUARIO", null);
			idUsuarios=null;
			idRoles=null;
			nombreUsuarios="";
			contrasenaUsuarios="";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.crearMensajeERROR("Ha ocurrido un error", "");
		}
		return "";
	}
	public String actionActualizarUsuario(){
		
		Usuario u=new Usuario();
		try {
			u.setIdUsuarios(idUsuarios);
			Rol rol=(Rol) managersco.findRolById(idRoles);
			u.setRole(rol);
			u.setNombreUsuarios(nombreUsuarios);
			u.setContrasenaUsuarios(contrasenaUsuarios);
			u.setEstadoUsuarios(estadoUsuarios);
			managersco.actualizarUsuario(u);
			JSFUtil.crearMensajeINFO("Se ha actualizado la informacion del Médico", null);
			idUsuarios=null;
			idRoles=null;
			nombreUsuarios="";
			contrasenaUsuarios="";
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
			e.printStackTrace();
		}
		return "usuario";
	}
	public String actioneliminarUsuario(Usuario usuario){
		try {
			managersco.eliminarUsuario(usuario.getIdUsuarios());
			JSFUtil.crearMensajeINFO("Se ha eliminado la informacion del usuario", null);
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage(), "");
		}
		return "usuario";
	}
	
	public String accederSistema(){
		try {
			idUsuarios=managersco.accederSistema(idUsuarios, contrasenaUsuarios);
			contrasenaUsuarios="";
			if(idUsuarios==1){
				return "administrador/index";
			}
			if(idUsuarios==2){
				return "superusuario/index";
			}
			if(idUsuarios==3){
				return "secretaria/index";
			}
			JSFUtil.crearMensajeERROR("Error al acceder (tipo de usuario)",null);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
		}
		return "";
	}
	
	
	public String salirSistema(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login";
	}
}
