package sco.model.manager;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sco.controller.JSFUtil;
import sco.model.entities.Historiacab;
import sco.model.entities.Historiadet;
import sco.model.entities.Medico;
import sco.model.entities.Paciente;
import sco.model.entities.Rol;
import sco.model.entities.Usuario;

public class ManagerSCO {
	
	private ManagerDAO managerdao;
	
	public ManagerSCO() {
		// TODO Auto-generated constructor stub
		managerdao=new ManagerDAO();
	}
	
	
	/*CRUD ROLES*/
	//MÉTODO INSERTAR ROLES
	public void insertarRol(String nombreRoles, String descripcionRoles, Boolean estadoRoles) throws Exception{
		Rol r=new Rol();
		r.setNombreRoles(nombreRoles);
		r.setDescripcionRoles(descripcionRoles);
		r.setEstadoRoles(estadoRoles);
		managerdao.insertar(r); 
	}
	//METODO ELIMINAR ROLES
	public void eliminarRol(Integer idRoles) throws Exception{
		managerdao.eliminar(Rol.class, idRoles);
	}
	//METODO BUSCAR ROLES POR CODIGO
	public Rol findRolById(Integer idRoles) throws Exception{
		return (Rol) managerdao.findById(Rol.class, idRoles);
	}
	//METODO BUSCAR ROLES
	@SuppressWarnings("unchecked")
	public List<Rol> findAllRoles(){
		return managerdao.findAll(Rol.class, "o.nombreRoles");
	}
	//METODO ACTUALIZAR ROLES
	public void actualizaRol(Rol rol){
		Rol r=null;
		try {
			r=findRolById(rol.getIdRoles());
			r.setNombreRoles(rol.getNombreRoles());
			r.setDescripcionRoles(rol.getDescripcionRoles());
			r.setEstadoRoles(rol.getEstadoRoles());
			managerdao.actualizar(r);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	
	/*CRUD PACIENTES*/
	//MÉTODO INSERTAR PACIENTE
	public void insertarPaciente(String cedulaPacientes, String apellidosPacientes, String nombresPacientes, 
			String domicilioPacientes, String telefonoPacientes, String celularPacientes, Boolean estadoPacientes) throws Exception{
		Paciente p=new Paciente();
		p.setCedulaPacientes(cedulaPacientes);
		p.setApellidosPacientes(apellidosPacientes);
		p.setNombresPacientes(nombresPacientes);
		p.setDomicilioPacientes(domicilioPacientes);
		p.setTelefonoPacientes(telefonoPacientes);
		p.setCelularPacientes(celularPacientes);
		p.setEstadoPacientes(estadoPacientes);
		managerdao.insertar(p);
	}
	//METODO ELIMINAR PACIENTES
	public void eliminarPaciente(Integer idPacientes) throws Exception{
		managerdao.eliminar(Paciente.class, idPacientes);
	}
	//METODO BUSCAR PACIENTES POR CODIGO
	public Paciente findPacienteById(Integer idPacientes) throws Exception{
		return (Paciente) managerdao.findById(Paciente.class, idPacientes);
	}
	//METODO BUSCAR PACIENTES
	@SuppressWarnings("unchecked")
	public List<Paciente> findAllPacientes(){
		return managerdao.findAll(Paciente.class, "o.nombresPacientes");
	}
	//METODO ACTUALIZAR PACIENTES
	public void actualizaPaciente(Paciente paciente){
		Paciente p=null;
		try {
			p=findPacienteById(paciente.getIdPacientes());
			p.setCedulaPacientes(paciente.getCedulaPacientes());
			p.setApellidosPacientes(paciente.getApellidosPacientes());
			p.setNombresPacientes(paciente.getNombresPacientes());
			p.setDomicilioPacientes(paciente.getDomicilioPacientes());
			p.setTelefonoPacientes(paciente.getTelefonoPacientes());
			p.setCelularPacientes(paciente.getCelularPacientes());
			p.setEstadoPacientes(paciente.getEstadoPacientes());
			managerdao.actualizar(p);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/*CRUD MÉDICOS*/
	//MÉTODO INSERTAR MEDICOS
	public void insertarMedico(String cedulaMedicos, String apellidosMedicos, String nombresMedicos, 
			String domicilioMedicos, String telefonoMedicos, String celularMedicos, Boolean estadoMedicos) throws Exception{
		Medico m=new Medico();
		m.setCedulaMedicos(cedulaMedicos);
		m.setApellidosMedicos(apellidosMedicos);
		m.setNombresMedicos(nombresMedicos);
		m.setDomicilioMedicos(domicilioMedicos);
		m.setTelefonoMedicos(telefonoMedicos);
		m.setCelularMedicos(celularMedicos);
		m.setEstadoMedicos(estadoMedicos);
		managerdao.insertar(m);
	}
	//METODO ELIMINAR MEDICOS
	public void eliminarMedico(Integer idMedicos) throws Exception{
		managerdao.eliminar(Medico.class, idMedicos);
	}
	//METODO BUSCAR MEDICOS POR CODIGO
	public Medico findMedicoById(Integer idMedicos) throws Exception{
		return (Medico) managerdao.findById(Medico.class, idMedicos);
	}
	//METODO BUSCAR MEDICOS
	@SuppressWarnings("unchecked")
	public List<Medico> findAllMedicos(){
		return managerdao.findAll(Medico.class, "o.nombresMedicos");
	}
	//METODO ACTUALIZAR MEDICOS
	public void actualizaMedico(Medico medico){
		Medico m=null;
		try {
			m=findMedicoById(medico.getIdMedicos());
			m.setCedulaMedicos(medico.getCedulaMedicos());
			m.setApellidosMedicos(medico.getApellidosMedicos());
			m.setNombresMedicos(medico.getNombresMedicos());
			m.setDomicilioMedicos(medico.getDomicilioMedicos());
			m.setTelefonoMedicos(medico.getTelefonoMedicos());
			m.setCelularMedicos(medico.getCelularMedicos());
			//m.setEstadoMedicos(medico.getEstadoMedicos());
			managerdao.actualizar(m);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/*CRUD USUARIOS*/
	//MÉTODO INSERTAR USUARIO
	public void insertarUsuario(Integer idRoles, String nombreUsuarios, String contrasenaUsuarios, Boolean estadoUsuarios) throws Exception{
		Usuario u= new Usuario();
		Rol rol=(Rol) managerdao.findById(Rol.class, idRoles);
		u.setRole(rol);
		u.setNombreUsuarios(nombreUsuarios);
		u.setContrasenaUsuarios(contrasenaUsuarios);
		u.setEstadoUsuarios(estadoUsuarios);
		managerdao.insertar(u);
	}
	//METODO ELIMINAR USUARIOS
	public void eliminarUsuario(Integer idUsuarios)throws Exception{
		managerdao.eliminar(Usuario.class, idUsuarios);
	}
	//METODO BUSCAR USUARIOS POR CODIGO
	public Usuario findUsuarioById(Integer idUsuarios) throws Exception{
		return (Usuario) managerdao.findById(Usuario.class, idUsuarios);
	}
	//METODO BUSCAR USUARIOS
	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios(){
		return managerdao.findAll(Usuario.class);
	}
	//METODO ACTUALIZAR USUARIOS
	public void actualizarUsuario(Usuario usuario){
		Usuario u=null;
		try {
			u=findUsuarioById(usuario.getIdUsuarios());
			u.setRole(usuario.getRole());
			u.setNombreUsuarios(usuario.getNombreUsuarios());
			u.setContrasenaUsuarios(usuario.getContrasenaUsuarios());
			u.setEstadoUsuarios(usuario.getEstadoUsuarios());
			managerdao.actualizar(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	//CONTROL DE ACCESO AL SISTEMA
	public Integer accederSistema(Integer idUsuarios,String contrasenaUsuarios) throws Exception{
		Usuario usuario=(Usuario) managerdao.findById(Usuario.class, idUsuarios);		
		if(usuario==null)
			throw new Exception("Usuario no existe");
		if(!usuario.getContrasenaUsuarios().equals(contrasenaUsuarios))
			throw new Exception("No coincide la contraseña");
		return usuario.getIdUsuarios();
	}
	
	
	//HISTORIAS CLINICAS
	public Historiacab crearHistoriaCabTmp(){
		
		Historiacab historiacabtmp= new Historiacab();
		historiacabtmp.setFechaHistoriacab(new Date());
		historiacabtmp.setHistoriadets(new ArrayList<Historiadet>());
		return historiacabtmp;
	}
	
	private void calcularvalorHistoriaTmp(Historiacab historiacab){
		double totalFactura=0.0;
		//verificamos los campos calculados:
		for(Historiadet det:historiacab.getHistoriadets()){
			totalFactura=totalFactura + det.getPagounitarioHistoriadet().doubleValue();
		}
		historiacab.setTotalHistoriacab(new BigDecimal(totalFactura));
	}
	
	public void guardarHistoriaCab(Historiacab historiacab, Integer idPacientes, Integer idMedicos) throws Exception{
		if(historiacab==null)
			throw new Exception("ERROR Debe crear una nueva Historia Clínica");
		if(historiacab.getHistoriadets()==null || historiacab.getHistoriadets().size()==0)
			throw new Exception("ERROR Debe Ingresar alguna actividad");
		
		this.calcularvalorHistoriaTmp(historiacab);
		
		Paciente paciente=(Paciente) managerdao.findById(Paciente.class, idPacientes);
		historiacab.setPaciente(paciente);
		Medico medico=(Medico) managerdao.findById(Medico.class, idMedicos);
		historiacab.setMedico(medico);
		historiacab.setFechaHistoriacab(new Date());
		for(Historiadet det:historiacab.getHistoriadets()){
			det.setHistoriacab(historiacab);
		}
		managerdao.insertar(historiacab);
		historiacab=null;
		JSFUtil.crearMensajeINFO("Se ha ingresado con Exito",null);
	}
	
	public void agregarHistoriadet(Historiacab historiacab, String sintomasHistoriadet, BigDecimal pagounitarioHistoriadet) throws Exception{
		if(historiacab==null)
			throw new Exception("ERROR Debe crear una nueva Historia Clínica");
		if(sintomasHistoriadet==null)
			throw new Exception("ERROR Debe ingresar los sintomas que presenta el paciente");
		if(pagounitarioHistoriadet==null||pagounitarioHistoriadet.intValue()<=0)
			throw new Exception("ERROR Debe especificar el pago por la Atención");
		
		this.calcularvalorHistoriaTmp(historiacab);
		Historiadet historiadet=new Historiadet();
		historiadet.setSintomasHistoriadet(sintomasHistoriadet);
		historiadet.setFechaHistoriadet(new Date());
		historiadet.setPagounitarioHistoriadet(pagounitarioHistoriadet);
		historiacab.getHistoriadets().add(historiadet);
		JSFUtil.crearMensajeINFO("Se ha agregado correctamente",null);
	}
}
