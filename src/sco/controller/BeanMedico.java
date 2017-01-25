package sco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sco.model.entities.Medico;
import sco.model.manager.ManagerSCO;

@ManagedBean
@SessionScoped
public class BeanMedico {
	private List<Medico> listamedicos;
	private ManagerSCO managersco;
	private Integer idMedicos;
	private String cedulaMedicos;
	private String apellidosMedicos;
	private String nombresMedicos;
	private String domicilioMedicos;
	private String telefonoMedicos;
	private String celularMedicos; 
	private Boolean estadoMedicos;
	
	public String getCedulaMedicos() {
		return cedulaMedicos;
	}
	public void setCedulaMedicos(String cedulaMedicos) {
		this.cedulaMedicos = cedulaMedicos;
	}
	public String getApellidosMedicos() {
		return apellidosMedicos;
	}
	public void setApellidosMedicos(String apellidosMedicos) {
		this.apellidosMedicos = apellidosMedicos;
	}
	public String getNombresMedicos() {
		return nombresMedicos;
	}
	public void setNombresMedicos(String nombresMedicos) {
		this.nombresMedicos = nombresMedicos;
	}
	public String getDomicilioMedicos() {
		return domicilioMedicos;
	}
	public void setDomicilioMedicos(String domicilioMedicos) {
		this.domicilioMedicos = domicilioMedicos;
	}
	public String getTelefonoMedicos() {
		return telefonoMedicos;
	}
	public void setTelefonoMedicos(String telefonoMedicos) {
		this.telefonoMedicos = telefonoMedicos;
	}
	public String getCelularMedicos() {
		return celularMedicos;
	}
	public void setCelularMedicos(String celularMedicos) {
		this.celularMedicos = celularMedicos;
	}
	public Boolean getEstadoMedicos() {
		return estadoMedicos;
	}
	public void setEstadoMedicos(Boolean estadoMedicos) {
		this.estadoMedicos = estadoMedicos;
	}
	
	public Integer getIdMedicos() {
		return idMedicos;
	}
	public void setIdMedicos(Integer idMedicos) {
		this.idMedicos = idMedicos;
	}
	public List<Medico> getListamedicos() {
		listamedicos=managersco.findAllMedicos();
		return listamedicos;
	}
	public void setListamedicos(List<Medico> listamedicos) {
		this.listamedicos = listamedicos;
	}
	@PostConstruct
	public void iniciar(){
		managersco=new ManagerSCO();
		estadoMedicos=true;
	}
	
	public String actionCargarMedico(Medico medico){
		idMedicos=medico.getIdMedicos();
		cedulaMedicos=medico.getCedulaMedicos();
		apellidosMedicos=medico.getApellidosMedicos();
		nombresMedicos=medico.getNombresMedicos();
		domicilioMedicos=medico.getDomicilioMedicos();
		telefonoMedicos=medico.getTelefonoMedicos();
		celularMedicos=medico.getCelularMedicos();
		return "medico_update";
	}
	
	public String actionInsertarMedico(){
		try {
			managersco.insertarMedico(cedulaMedicos, apellidosMedicos, nombresMedicos, domicilioMedicos, telefonoMedicos, celularMedicos, estadoMedicos);
			JSFUtil.crearMensajeINFO("Se ha ingresado un nuevo MÉDICO", null);
			cedulaMedicos="";
			apellidosMedicos="";
			nombresMedicos="";
			domicilioMedicos="";
			telefonoMedicos="";
			celularMedicos="";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.crearMensajeERROR("Ha ocurrido un error", null);
			e.printStackTrace();
		}
		return "medico";
	}
	
	public String actionActualizarMedico(){
		Medico m=new Medico();
		m.setIdMedicos(idMedicos);
		m.setCedulaMedicos(cedulaMedicos);
		m.setApellidosMedicos(apellidosMedicos);
		m.setNombresMedicos(nombresMedicos);
		m.setDomicilioMedicos(domicilioMedicos);
		m.setTelefonoMedicos(telefonoMedicos);
		m.setCelularMedicos(celularMedicos);
		m.setEstadoMedicos(estadoMedicos);
		try {
			managersco.actualizaMedico(m);
			JSFUtil.crearMensajeINFO("Se ha actualizado la informacion del Médico", null);
			idMedicos=null;
			cedulaMedicos="";
			apellidosMedicos="";
			nombresMedicos="";
			domicilioMedicos="";
			telefonoMedicos="";
			celularMedicos="";
			estadoMedicos=true;
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
			e.printStackTrace();
		}
		return "medico";
	}
	
	public String actionEliminarMedico(Medico medico){
		try {
			managersco.eliminarMedico(medico.getIdMedicos());
			JSFUtil.crearMensajeINFO("Se ha eliminado la informacion del medico", null);
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
		}
		return "medico";
	}
	
}
