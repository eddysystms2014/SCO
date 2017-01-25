package sco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;






import sco.model.entities.Paciente;
import sco.model.manager.ManagerSCO;

@ManagedBean
@SessionScoped
public class BeanPaciente {
	private ManagerSCO managersco;
	private Integer idPacientes;
	private String cedulaPacientes; 
	private String apellidosPacientes; 
	private String nombresPacientes;
	private String domicilioPacientes; 
	private String telefonoPacientes; 
	private String celularPacientes; 
	private Boolean estadoPacientes;
	private List<Paciente> listapacientes;
	
	public List<Paciente> getListapacientes() {
		listapacientes=managersco.findAllPacientes();
		return listapacientes;
	}

	public void setListapacientes(List<Paciente> listapacientes) {
		this.listapacientes = listapacientes;
	}

	public Integer getIdPacientes() {
		return idPacientes;
	}

	public void setIdPacientes(Integer idPacientes) {
		this.idPacientes = idPacientes;
	}

	public String getCedulaPacientes() {
		return cedulaPacientes;
	}

	public void setCedulaPacientes(String cedulaPacientes) {
		this.cedulaPacientes = cedulaPacientes;
	}

	public String getApellidosPacientes() {
		return apellidosPacientes;
	}

	public void setApellidosPacientes(String apellidosPacientes) {
		this.apellidosPacientes = apellidosPacientes;
	}

	public String getNombresPacientes() {
		return nombresPacientes;
	}

	public void setNombresPacientes(String nombresPacientes) {
		this.nombresPacientes = nombresPacientes;
	}

	public String getDomicilioPacientes() {
		return domicilioPacientes;
	}

	public void setDomicilioPacientes(String domicilioPacientes) {
		this.domicilioPacientes = domicilioPacientes;
	}

	public String getTelefonoPacientes() {
		return telefonoPacientes;
	}

	public void setTelefonoPacientes(String telefonoPacientes) {
		this.telefonoPacientes = telefonoPacientes;
	}

	public String getCelularPacientes() {
		return celularPacientes;
	}

	public void setCelularPacientes(String celularPacientes) {
		this.celularPacientes = celularPacientes;
	}

	public Boolean getEstadoPacientes() {
		return estadoPacientes;
	}

	public void setEstadoPacientes(Boolean estadoPacientes) {
		this.estadoPacientes = estadoPacientes;
	}
	
	@PostConstruct
	public void iniciar(){
		managersco=new ManagerSCO();
		estadoPacientes=true;
	}
	
	public String actionCargarPaciente(Paciente paciente){
		idPacientes=paciente.getIdPacientes();
		cedulaPacientes=paciente.getCedulaPacientes();
		apellidosPacientes=paciente.getApellidosPacientes();
		nombresPacientes=paciente.getNombresPacientes();
		domicilioPacientes=paciente.getDomicilioPacientes();
		telefonoPacientes=paciente.getTelefonoPacientes();
		celularPacientes=paciente.getCelularPacientes();
		return "paciente_update";
	}
	
	public String actionInsertarPaciente(){
		try {
			managersco.insertarPaciente(cedulaPacientes, apellidosPacientes, nombresPacientes, domicilioPacientes, telefonoPacientes, celularPacientes, estadoPacientes);
			JSFUtil.crearMensajeINFO("Se ha ingresado un nuevo PACIENTE", null);
			cedulaPacientes="";
			apellidosPacientes=""; 
			nombresPacientes="";
			domicilioPacientes="";
			telefonoPacientes="";
			celularPacientes="";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.crearMensajeERROR("Ha ocurrido un error", null);
			e.printStackTrace();
		}
		return "";
	}
	
	public String actionEliminarPaciente(Paciente paciente){
		try {
			managersco.eliminarPaciente(paciente.getIdPacientes());
			JSFUtil.crearMensajeINFO("Se ha eliminado la informacion del paciente", null);
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
		}
		return "";
	}
	
	public String actionActualizarPaciente(){
		Paciente p=new Paciente();
		p.setIdPacientes(idPacientes);
		p.setCedulaPacientes(cedulaPacientes);
		p.setApellidosPacientes(apellidosPacientes);
		p.setNombresPacientes(nombresPacientes);
		p.setDomicilioPacientes(domicilioPacientes);
		p.setTelefonoPacientes(telefonoPacientes);
		p.setCelularPacientes(celularPacientes);
		p.setEstadoPacientes(estadoPacientes);
		try {
			managersco.actualizaPaciente(p);
			JSFUtil.crearMensajeINFO("Se ha actualizado la informacion del Paciente", null);
			idPacientes=null;
			cedulaPacientes="";
			apellidosPacientes="";
			nombresPacientes="";
			domicilioPacientes="";
			telefonoPacientes="";
			celularPacientes="";
			estadoPacientes=true;
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
			e.printStackTrace();
		}
		return "paciente";
	}
	
}
