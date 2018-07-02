package com.nacre.formbean;
/**
 * @author DasineniMohan
 */
import java.io.Serializable;

import com.nacre.dto.ClientContactPerson;
import com.nacre.dto.ClientDto;
import com.nacre.dto.ClientLocationDto;
import com.nacre.dto.ProjectDto;
import com.nacre.dto.ProjectManagerProjectDto;
import com.nacre.dto.UserDto;

public class ProjectInfoBeanMohan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectDto pdto;
	private ClientLocationDto cldto;
	private ClientContactPerson cpdto;
	private ClientDto cdto;
	private UserDto udto;
	private ProjectManagerProjectDto pmdto;
	private String pmImage;
	private String clientLogo;

	public ProjectDto getPdto() {
		return pdto;
	}

	public void setPdto(ProjectDto pdto) {
		this.pdto = pdto;
	}

	public ClientLocationDto getCldto() {
		return cldto;
	}

	public void setCldto(ClientLocationDto cldto) {
		this.cldto = cldto;
	}

	public ClientContactPerson getCpdto() {
		return cpdto;
	}

	public void setCpdto(ClientContactPerson cpdto) {
		this.cpdto = cpdto;
	}

	public ClientDto getCdto() {
		return cdto;
	}

	public void setCdto(ClientDto cdto) {
		this.cdto = cdto;
	}

	public ProjectManagerProjectDto getPmdto() {
		return pmdto;
	}

	public void setPmdto(ProjectManagerProjectDto pmdto) {
		this.pmdto = pmdto;
	}

	public String getPmImage() {
		return pmImage;
	}

	public void setPmImage(String pmImage) {
		this.pmImage = pmImage;
	}

	public String getClientLogo() {
		return clientLogo;
	}

	public void setClientLogo(String clientLogo) {
		this.clientLogo = clientLogo;
	}

	@Override
	public String toString() {
		return "ProjectInfoBeanMohan [pdto=" + pdto + ", cldto=" + cldto + ", cpdto=" + cpdto + ", cdto=" + cdto
				+ ", udto=" + udto + ", pmdto=" + pmdto + ", pmImage=" + pmImage + ", clientLogo=" + clientLogo + "]";
	}

}
