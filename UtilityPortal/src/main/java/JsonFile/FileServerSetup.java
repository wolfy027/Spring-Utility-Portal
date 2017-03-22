/**
 * 
 */
package JsonFile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileServerSetup {
	@JsonProperty("moduleId")
	private List<String> moduleId;
	@JsonProperty("browserId")
	private List<String> browserId;
	@JsonProperty("messageTypeId")
	private List<String> messageTypeId;
	@JsonProperty("deviceTypeId")
	private List<String> deviceTypeId;

	public List<String> getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(List<String> deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public List<String> getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(List<String> messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public FileServerSetup() {
	}

	public List<String> getModuleId() {
		return moduleId;
	}

	public void setModuleId(List<String> moduleId) {
		this.moduleId = moduleId;
	}

	public List<String> getBrowserId() {
		return browserId;
	}

	public void setBrowserId(List<String> browserId) {
		this.browserId = browserId;
	}

}
