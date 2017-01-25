package sco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import sco.model.entities.Rol;
import sco.model.manager.ManagerSCO;

@ManagedBean
@SessionScoped
public class BeanRoles {
	private List<Rol> listaroles;
	private Integer idRoles;
	private String nombreRoles;
	private String descripcionRoles;
	private Boolean estadoRoles;
	private ManagerSCO managersco;

	
	public Integer getIdRoles() {
		return idRoles;
	}
	public void setIdRoles(Integer idRoles) {
		this.idRoles = idRoles;
	}
	public String getNombreRoles() {
		return nombreRoles;
	}
	public void setNombreRoles(String nombreRoles) {
		this.nombreRoles = nombreRoles;
	}
	public String getDescripcionRoles() {
		return descripcionRoles;
	}
	public void setDescripcionRoles(String descripcionRoles) {
		this.descripcionRoles = descripcionRoles;
	}
	public Boolean getEstadoRoles() {
		return estadoRoles;
	}
	public void setEstadoRoles(Boolean estadoRoles) {
		this.estadoRoles = estadoRoles;
	}
	
	public List<Rol> getListaroles() {
		listaroles=managersco.findAllRoles();
		return listaroles;
	}
	
	public void setListaroles(List<Rol> listaroles) {
		this.listaroles = listaroles;
	}
	@PostConstruct
	public void iniciar(){
		managersco=new ManagerSCO();
		estadoRoles=true;
	}
	
	public String actionCargarRol(Rol rol){
		idRoles=rol.getIdRoles();
		nombreRoles=rol.getNombreRoles();
		descripcionRoles=rol.getDescripcionRoles();
		return "roles_update";
	}
	
	public String actionInsertarRoles(){
		try {
			managersco.insertarRol(nombreRoles, descripcionRoles, estadoRoles);
			JSFUtil.crearMensajeINFO("Se ha creado un nuevo ROL", null);
			nombreRoles="";
			descripcionRoles="";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.crearMensajeERROR("Ha ocurrido un error", null);
			e.printStackTrace();
		}
		return "";
	}
	public String actionEliminarRol(Rol rol){
		try {
			managersco.eliminarRol(rol.getIdRoles());
			JSFUtil.crearMensajeINFO("Se ha eliminado el ROL", null);
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
		}
		return "";
	}
	public String actionActualizarRol(){
		Rol r=new Rol();
		r.setIdRoles(idRoles);
		r.setNombreRoles(nombreRoles);
		r.setDescripcionRoles(descripcionRoles);
		r.setEstadoRoles(estadoRoles);
		try {
			managersco.actualizaRol(r);
			JSFUtil.crearMensajeINFO("Se ha actualizado el ROL", null);
			nombreRoles="";
			descripcionRoles="";
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
			e.printStackTrace();
		}
		return "roles";
	}
}
