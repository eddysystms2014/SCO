package sco.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicos database table.
 * 
 */
@Entity
@Table(name="medicos")
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEDICOS_IDMEDICOS_GENERATOR", sequenceName="SEQ_MEDICOS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICOS_IDMEDICOS_GENERATOR")
	@Column(name="id_medicos", unique=true, nullable=false)
	private Integer idMedicos;

	@Column(name="apellidos_medicos", length=100)
	private String apellidosMedicos;

	@Column(name="cedula_medicos", length=15)
	private String cedulaMedicos;

	@Column(name="celular_medicos", length=10)
	private String celularMedicos;

	@Column(name="domicilio_medicos", length=100)
	private String domicilioMedicos;

	@Column(name="estado_medicos")
	private Boolean estadoMedicos;

	@Column(name="imagen_medicos", length=254)
	private String imagenMedicos;

	@Column(name="nombres_medicos", length=100)
	private String nombresMedicos;

	@Column(name="telefono_medicos", length=10)
	private String telefonoMedicos;

	//bi-directional many-to-one association to Historiacab
	@OneToMany(mappedBy="medico")
	private List<Historiacab> historiacabs;

	public Medico() {
	}

	public Integer getIdMedicos() {
		return this.idMedicos;
	}

	public void setIdMedicos(Integer idMedicos) {
		this.idMedicos = idMedicos;
	}

	public String getApellidosMedicos() {
		return this.apellidosMedicos;
	}

	public void setApellidosMedicos(String apellidosMedicos) {
		this.apellidosMedicos = apellidosMedicos;
	}

	public String getCedulaMedicos() {
		return this.cedulaMedicos;
	}

	public void setCedulaMedicos(String cedulaMedicos) {
		this.cedulaMedicos = cedulaMedicos;
	}

	public String getCelularMedicos() {
		return this.celularMedicos;
	}

	public void setCelularMedicos(String celularMedicos) {
		this.celularMedicos = celularMedicos;
	}

	public String getDomicilioMedicos() {
		return this.domicilioMedicos;
	}

	public void setDomicilioMedicos(String domicilioMedicos) {
		this.domicilioMedicos = domicilioMedicos;
	}

	public Boolean getEstadoMedicos() {
		return this.estadoMedicos;
	}

	public void setEstadoMedicos(Boolean estadoMedicos) {
		this.estadoMedicos = estadoMedicos;
	}

	public String getImagenMedicos() {
		return this.imagenMedicos;
	}

	public void setImagenMedicos(String imagenMedicos) {
		this.imagenMedicos = imagenMedicos;
	}

	public String getNombresMedicos() {
		return this.nombresMedicos;
	}

	public void setNombresMedicos(String nombresMedicos) {
		this.nombresMedicos = nombresMedicos;
	}

	public String getTelefonoMedicos() {
		return this.telefonoMedicos;
	}

	public void setTelefonoMedicos(String telefonoMedicos) {
		this.telefonoMedicos = telefonoMedicos;
	}

	public List<Historiacab> getHistoriacabs() {
		return this.historiacabs;
	}

	public void setHistoriacabs(List<Historiacab> historiacabs) {
		this.historiacabs = historiacabs;
	}

	public Historiacab addHistoriacab(Historiacab historiacab) {
		getHistoriacabs().add(historiacab);
		historiacab.setMedico(this);

		return historiacab;
	}

	public Historiacab removeHistoriacab(Historiacab historiacab) {
		getHistoriacabs().remove(historiacab);
		historiacab.setMedico(null);

		return historiacab;
	}

}