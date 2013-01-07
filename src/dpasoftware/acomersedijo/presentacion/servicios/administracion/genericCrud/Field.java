package dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud;

/**
*
* @author Alejandro
*/
public class Field {
	
	private String type;
	private String label;
	private String name;
	private String value;
	private String property;
	private boolean hidden;
	private String sortable;
	private String escapeXml;
	private String disabled;
	private String readOnly;
	private String required;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public boolean getHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public String getSortable() {
		return sortable;
	}
	public void setSortable(String sortable) {
		this.sortable = sortable;
	}
	public String getEscapeXml() {
		return escapeXml;
	}
	public void setEscapeXml(String escapeXml) {
		this.escapeXml = escapeXml;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getReadOnly() {
		return readOnly;
	}
	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}

}
