package sco.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sco.model.entities.Historiacab;
import sco.model.entities.Medico;
import sco.model.entities.Paciente;
import sco.model.manager.ManagerSCO;

@ManagedBean
@SessionScoped
public class BeanHistoria {
	private ManagerSCO managersco;
	private List<Paciente> listapacientes;
	private List<Medico> listamedicos;
	private Integer idPacientes;
	private Integer idMedicos;
	private String sintomasHistoriadet;
	private BigDecimal pagounitarioHistoriadet;
	private Historiacab historiacab;
	private boolean historiacabTmpGuardada;
	
	public List<Paciente> getListapacientes() {
		listapacientes=managersco.findAllPacientes();
		return listapacientes;
	}
	public void setListapacientes(List<Paciente> listapacientes) {
		this.listapacientes = listapacientes;
	}
	public List<Medico> getListamedicos() {
		listamedicos=managersco.findAllMedicos();
		return listamedicos;
	}
	public void setListamedicos(List<Medico> listamedicos) {
		this.listamedicos = listamedicos;
	}
	public String getSintomasHistoriadet() {
		return sintomasHistoriadet;
	}
	public void setSintomasHistoriadet(String sintomasHistoriadet) {
		this.sintomasHistoriadet = sintomasHistoriadet;
	}
	public BigDecimal getPagounitarioHistoriadet() {
		return pagounitarioHistoriadet;
	}
	public void setPagounitarioHistoriadet(BigDecimal pagounitarioHistoriadet) {
		this.pagounitarioHistoriadet = pagounitarioHistoriadet;
	}
	
	public boolean isHistoriacabTmpGuardada() {
		return historiacabTmpGuardada;
	}
	public void setHistoriacabTmpGuardada(boolean historiacabTmpGuardada) {
		this.historiacabTmpGuardada = historiacabTmpGuardada;
	}
	
	public Historiacab getHistoriacab() {
		return historiacab;
	}
	public void setHistoriacab(Historiacab historiacab) {
		this.historiacab = historiacab;
	}
	public Integer getIdPacientes() {
		return idPacientes;
	}
	public void setIdPacientes(Integer idPacientes) {
		this.idPacientes = idPacientes;
	}
	public Integer getIdMedicos() {
		return idMedicos;
	}
	public void setIdMedicos(Integer idMedicos) {
		this.idMedicos = idMedicos;
	}
	@PostConstruct
	public void iniciar(){
		managersco=new ManagerSCO();
	}
	
	public String crearNuevaHistoria(){
		try {
			historiacab=managersco.crearHistoriaCabTmp();
			idPacientes=null;
			idMedicos=null;
			sintomasHistoriadet=null;
			pagounitarioHistoriadet=null;
			historiacabTmpGuardada=false;
			JSFUtil.crearMensajeINFO("Se ha creado una nueva HISTORIA CLÍNICA", null);
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeERROR("ERROR, Algo falló", null);
		}
		return "";
	}
	
	public String guardarHistoria(){
		if(historiacabTmpGuardada==true){
			JSFUtil.crearMensajeWARN("La Historia clinica ya ha sido creada",null);
			idPacientes=null;
			idMedicos=null;
			sintomasHistoriadet=null;
			pagounitarioHistoriadet=null;
			return "";
		}
		try {
			managersco.guardarHistoriaCab(historiacab, idPacientes, idMedicos);
			historiacabTmpGuardada=true;
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage(), null);
		}
		
		return "";
	}
	
	public String insertarDetalle(){
		if(historiacabTmpGuardada==true){
			JSFUtil.crearMensajeWARN("La factura ya fue guardada.",null);
			return "";
		}
		try {
			managersco.agregarHistoriadet(historiacab, sintomasHistoriadet, pagounitarioHistoriadet);
			JSFUtil.crearMensajeINFO("Detalle Ingresado", null);
			pagounitarioHistoriadet=null;
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage(),null);
		}		
		return "";
	}
}
